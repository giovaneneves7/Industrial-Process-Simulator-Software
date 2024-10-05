// *************************************************//
// *************** { COMEÇO - Package } ************//
//// *************************************************//
package br.com.ifba.ipss.common.controller;
// *************************************************//
// *************** { FIM - Package } ***************//
// *************************************************//

// *************************************************//
// ************ { COMEÇO - Imports } ***************//
// *************************************************//
import static br.com.ifba.ipss.util.Dicionario.tr;
import static br.com.ifba.ipss.util.Dicionario.trToPlural;

import br.com.ifba.ipss.common.infrastructure.interfaces.IEquipamentoService;
import br.com.ifba.ipss.feature.conexao.domain.service.IConexaoService;
import br.com.ifba.ipss.feature.equipamento.controller.EquipamentoController;
import br.com.ifba.ipss.feature.equipamento.controller.FerramentaContainerController;
import br.com.ifba.ipss.feature.equipamento.domain.factory.EquipamentoFactory;
import br.com.ifba.ipss.feature.equipamento.domain.model.Equipamento;
import br.com.ifba.ipss.feature.equipamento.widget.FerramentaContainer;
import br.com.ifba.ipss.feature.workspace.controller.EspacoTrabalhoController;
import br.com.ifba.ipss.feature.label.domain.builder.LabelBuilder;
import br.com.ifba.ipss.feature.label.domain.model.Label;
import br.com.ifba.ipss.feature.parametrossimulacao.controller.ParametrosSimulacaoController;
import br.com.ifba.ipss.feature.parametrossimulacao.widget.ParametrosDaSimulacao;
import br.com.ifba.ipss.feature.tubulacao.domain.service.ITubulacaoService;
import br.com.ifba.ipss.feature.valvula.domain.service.IValvulaService;
import br.com.ifba.ipss.helper.SizeHelper;
import br.com.ifba.ipss.infrastructure.exception.ServiceNotFound;
import br.com.ifba.ipss.infrastructure.manager.ControllerManager;
import br.com.ifba.ipss.infrastructure.manager.ServiceManager;
import br.com.ifba.ipss.util.Constantes;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Stack;
import javax.swing.BorderFactory;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import lombok.Data;
// *************************************************//
// ************** { FIM - Imports } ****************//
// *************************************************//

/**
 *
 * @author Giovane Neves
 * @since V0.0.1
 */
@Data
public class AreaDeTrabalhoController {
    
    // *************************************************//
    // ****************** { Atributos } ****************//
    // *************************************************//
    
    private Map<String, IEquipamentoService> equipamentoServiceMap = new HashMap<>();
    private final FerramentaContainerController ferramentaContainerController = new FerramentaContainerController<>();
    private final EquipamentoController equipamentoController = ControllerManager.find("equipamento");
    private final EspacoTrabalhoController espacoTrabalhoController = new EspacoTrabalhoController();
    private final ParametrosSimulacaoController parametrosSimulacaoController = new ParametrosSimulacaoController();
    
    private JFrame areaDeTrabalho;
    private JPanel pnlMenuLateral;
    private JPanel pnlEspacoTrabalho;
    
    private boolean emModoRotacao = false;
    private boolean emModoRemocao = false;
    private boolean emModoConexao = false;
    private boolean inMirroringMode = false;
    private boolean algumBotaoSelecionado = false;
    
    private boolean menuLateralAberto = false;
    
    private String nomeTipoMenuLateralAberto;
    private String workspacePath;
    private Stack<Label> pilhaDeConexao = new Stack<>(); 
    
    private Map<String, Label> espacoTrabalhoMap = new HashMap<>();
    
    private Label selectEquipament;
    
    
    // *************************************************//
    // ****************** { Construtor } ***************//
    // *************************************************//
    
    public AreaDeTrabalhoController(JFrame areaDeTrabalho){
        
        this.areaDeTrabalho = areaDeTrabalho;
        
        equipamentoServiceMap.put(trToPlural("tubulacao"), ServiceManager.find(ITubulacaoService.class));
        equipamentoServiceMap.put(trToPlural("conexao"), ServiceManager.find(IConexaoService.class));
        equipamentoServiceMap.put(trToPlural("valvula"), ServiceManager.find(IValvulaService.class));
        equipamentoServiceMap.put(trToPlural("equipamento"), ServiceManager.find(br.com.ifba.ipss.feature.equipamento.domain.service.IEquipamentoService.class));
                
    } // AreaDeTrabalhoController
    
    // *************************************************//
    // ************** { Getters e Setters } ************//
    // *************************************************//
    
    public void setPnlEspacoTrabalho(JPanel pnlEspacaoTrabalho){
        
        this.pnlEspacoTrabalho = pnlEspacaoTrabalho;
        
        this.pnlEspacoTrabalho.repaint();

    
    } // setPnlEspacoTrabalho
    
    
    public void setWorkspacePath(String workspacePath){
        
        this.workspacePath = workspacePath;
        
    } // setWorkspacePath
    
    // *************************************************//
    // ******************* { Métodos } *****************//
    // *************************************************//
    
    public void atualizarImagemBotaoConectar(JButton btn){
        
        this.mudarImagemBotao(btn, emModoConexao);
        
    } // atualizarImagemBotaoConectar
    
    public void atualizarImagemBotaoGirar(JButton btn){
        
        this.mudarImagemBotao(btn, emModoRotacao);
        
    } // atualizarImagemBotaoGirar
    
    public void atualizarImagemBotaoRemover(JButton btn){

        this.mudarImagemBotao(
                btn,
      emModoRemocao
        );

        } // atualizarImagemBotaoRemover
        
    public void carregarEquipamentos(String workspacePath){
        
        this.espacoTrabalhoMap = this.espacoTrabalhoController.pegarEspacoTrabalho(workspacePath);
        
        if(this.espacoTrabalhoMap == null || this.espacoTrabalhoMap.isEmpty()){
            return;
        }
       
        for(Map.Entry<String, Label> entry : this.espacoTrabalhoMap.entrySet()){
        
            this.adicionarListenerDeCliqueAoEquipamento(entry.getValue());
            this.adicionarListenerDeMovimentoAoEquipamento(entry.getValue());
            this.pnlEspacoTrabalho.add(entry.getValue());
            this.pnlEspacoTrabalho.revalidate();
            this.pnlEspacoTrabalho.repaint();
        }
        
    } // carregarEquipamentos
    
    public void definirLogoAplicacao(Image img){
    
        ViewController.definirLogoAplicacao(this.areaDeTrabalho, img);
        
    } // definirLogoAplicacao
    
    public void definirTituloAplicacao(){
        
        ViewController.defineScreenTitle(this.areaDeTrabalho);
        
    } // defineScreenTitle
    
    public void mudarEfeitoHoverNoBotao(List<JButton> botoes){
        
        for(JButton btn : botoes){
            
            btn.addMouseMotionListener(new MouseAdapter() {
              
                @Override
                public void mouseMoved(MouseEvent me) {
                   
                    final int x = me.getX();
                    final int y = me.getY();
                    final int width = btn.getWidth();
                    final int height = btn.getHeight();
                    
                    
                    if (x >= 0 && x <= width && y >= 0 && y <= height) {
                        
                        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        
                    } else {
                        
                        btn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    }                      
                }                
            });
            
            btn.addMouseListener(new MouseAdapter(){
        
                @Override
                public void mouseEntered(MouseEvent me){

                    if(algumBotaoSelecionado) return;
                    
                    ImageIcon img = new ImageIcon(this.getClass().getResource(Constantes.pegarImagemBotaoSelecionado(btn.getName())));
                    
                    if(img.getImage() != null)
                        btn.setIcon(img);

                }

                @Override
                public void mouseExited(MouseEvent me){

                    if(algumBotaoSelecionado) return;
                    
                    ImageIcon img = new ImageIcon(this.getClass().getResource(Constantes.pegarImagemBotao(btn.getName())));
                    
                    if(img.getImage() != null)
                        btn.setIcon(img);
                }
            });
        }
        
    } // mudarEfeitoHoverNoBotao
    
    public void mudarStatusModoRemocao(final boolean status){
        
        algumBotaoSelecionado = status;
        this.emModoRemocao = status;
       
        if(this.emModoRemocao){
            this.emModoConexao = false;
            this.emModoRotacao = false;
            this.inMirroringMode = false;
        }
        
    } // mudarStatusModoRemocao
    
    public void mudarStatusModoRotacao(final boolean status){
    
        algumBotaoSelecionado = status;
        this.emModoRotacao = status;
       
        if(this.emModoRotacao){
            this.emModoConexao = false;
            this.emModoRemocao = false;
            this.inMirroringMode = false;
        }
    } // mudarStatusModoRotacao
    
    public void changeMirroringModeStatus(final boolean status){
        
        this.inMirroringMode = status;
        
        if(this.inMirroringMode){
            
            this.emModoRotacao = false;
            this.emModoConexao = false;
            this.emModoRemocao = false;
            
        }
        
    } // changeMirroringModeStatus
    
    public void mudarStatusModoConexao(final boolean status){
        
        algumBotaoSelecionado = status;
        this.emModoConexao = status;
        
        if(this.emModoConexao){
            this.emModoRotacao = false;
            this.emModoRemocao = false;
            this.inMirroringMode = false;
        }
        
    } // mudarStatusModoConexao
    
    public void exibirMensagemEstadoModoDeRemocao(JLabel lbl, final int tempo){
        
        String msg = (emModoRemocao) ? "modo_remocao_ativado" : "modo_remocao_desativado";
        
        this.exibirMensagemTemporaria(lbl, msg, tempo);
        
    } // exibirMensagemEstadoModoDeRemocao 
    
    public void exibirMensagemEstadoDeRotacao(JLabel lbl, final int tempo){
        
        String msg = (emModoRotacao) ? "modo_rotacao_ativado" :  "modo_rotacao_desativado";
        
        this.exibirMensagemTemporaria(lbl, msg, tempo);
        
    } // exibirMensagemEstadoDeRotacao
    
    public void exibirMensagemEstadoDeConexao(JLabel lbl, final int tempo){
        
        String msg = (emModoConexao) ? "modo_conexao_ativado" : "modo_conexao_desativado";
        
        this.exibirMensagemTemporaria(lbl, msg, tempo);
        
    } // exibirMensagemEstadoDeConexao
    
    public void showMirroringStatusMessage(JLabel lbl, final int time){
        
        String msg = (inMirroringMode) ? "modo_espelhamento_ativado" : "modo_espelhamento_desativado";
        
        this.exibirMensagemTemporaria(lbl, msg, time);
        
    } // showMirroringStatusMessage
    
    public void exibirMensagemTemporaria(JLabel lbl, String mensagem, final int tempo){
        
        lbl.setText(tr(mensagem));
        
        Timer timer = new Timer(tempo, (ActionEvent e) -> {
            lbl.setText("");
        });
        timer.setRepeats(false); 
        timer.start();
        
    } // exibirMensagemTemporaria
    
    public void mudarImagemBotao(JButton btn, boolean selecionado){
        
        ImageIcon icon = new ImageIcon(this.getClass().getResource((selecionado) ? Constantes.pegarImagemBotaoSelecionado(btn.getName()) : Constantes.pegarImagemBotao(btn.getName())));
        
        btn.setIcon(icon);
        
    } // mudarImagemBotao
    
    private void mirrorEquipament(Label lbl){
        
        this.equipamentoController.mirrorEquipament(lbl);
        
    } // mirrorEquipament
    
    /**
     * Remove o quipamento passado por parâmetro
     * 
     * @author Giovane Neves
     * @since V0.0.1
     * @param lblId O id do equipamento a ser removido
     */
    public void removeEquipament(String lblId){
    
        EquipamentoController.removeEquipament(lblId, pnlEspacoTrabalho, espacoTrabalhoMap);
       
    } // removeEquipament
    
    
    public void rotacionarEquipamento(Label lbl){
        
        EquipamentoController.rotateEquipament(lbl);
     
    } // rotacionarEquipamento
    
    
    
    public void updateMirroringButtonImage(JButton btn){
        
        this.mudarImagemBotao(btn, inMirroringMode);
        
    }
    
    public void adicionarNaPilhaDeConexao(Label lbl){
        
        if(this.pilhaDeConexao.isEmpty()){
            
            this.pilhaDeConexao.push(lbl);
            
        } else if(this.pilhaDeConexao.firstElement() == lbl){
            
            this.pilhaDeConexao.pop();
            
        } else{
            
            this.pilhaDeConexao.push(lbl);
            
        }
        
        if(this.pilhaDeConexao.size() == 2){
            
            this.conectarEquipamentos(
                    this.pilhaDeConexao.firstElement(), 
                    this.pilhaDeConexao.lastElement()
            );
            this.pilhaDeConexao.clear();
            
        }
    } // adicionarNaPilhaDeConexao
    
    public void conectarEquipamentos(Label lblMovido, Label alvo){
        
        this.equipamentoController.connectEquipament(lblMovido, alvo);
        
    } // conectarEquipamentos
    
    public void exibirWidgetDeParametrosSimulacao(JPanel p){
        
        ParametrosDaSimulacao ps = parametrosSimulacaoController.criarWidgetDeParametros(
                SizeHelper.LARGURA_ESPACO_TRABALHO / 30, 
                SizeHelper.ALTURA_ESPACO_TRABALHO / 4
        );
        
        p.add(ps);
        p.revalidate();
        p.repaint();
        
    }
    
    public void salvarEspacoTrabalho(){
        
        if(JOptionPane.showOptionDialog(null, tr("deseja_salvar_a_area_de_trabalho"), tr("salvar_area_trabalho"), JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, Constantes.SIM_NAO, Constantes.SIM_NAO[0]) == 0){
            
            if(this.espacoTrabalhoController.salvarEspacoTrabalho(espacoTrabalhoMap, workspacePath)){
                
                JOptionPane.showOptionDialog(null, tr("area_de_trabalho_salva_com_sucesso"), tr("salvar_area_trabalho"), JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null, Constantes.OK, Constantes.OK[0]);
                
            } else{
                
                JOptionPane.showOptionDialog(null, tr("erro_ao_salvar_area_trabalho"), tr("salvar_area_trabalho"), JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE, null, Constantes.OK, Constantes.OK[0]);
                
            }
            
        }
        
        
    }// salvarEspacoTrabalho
    
    public void deletarEspacoTrabalho(){
        
        if(JOptionPane.showOptionDialog(null, tr("deseja_limpar_a_area_de_trabalho"), tr("limpar_area_trabalho"), JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, Constantes.SIM_NAO, Constantes.SIM_NAO[0]) == 0){
        
            if(this.espacoTrabalhoController.deletarEspacoTrabalho(workspacePath)){
                
                this.limparPainel(this.pnlEspacoTrabalho);
                
                JOptionPane.showOptionDialog(null, tr("area_de_trabalho_deletada_com_sucesso"), tr("limpar_area_trabalho"), JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null, Constantes.OK, Constantes.OK[0]);
                
            } else{
                
                JOptionPane.showOptionDialog(null, tr("erro_ao_deletar_area_trabalho"), tr("limpar_area_trabalho"), JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE, null, Constantes.OK, Constantes.OK[0]);
                
            }
            
        }
        
        
    }// deletarEspacoTrabalho
    
    private void limparPainel(final JPanel p){
    
        p.removeAll();
        p.revalidate();
        p.repaint();
        
    }
    
    // >>> Métodos do Menu Lateral <<<
    
    public void gerenciarMenuLateral(JPanel p, final String tipoEquipamento){
        
        if(!menuLateralAberto){
            
            abrirMenuLateral(p, tipoEquipamento);
            this.setMenuLateralAberto(true);
            this.setNomeTipoMenuLateralAberto(tipoEquipamento);

        } else if(menuLateralAberto && this.getNomeTipoMenuLateralAberto().equals(tipoEquipamento)){
            
            this.fecharMenuLateral(p);
            this.setMenuLateralAberto(false);
            this.setNomeTipoMenuLateralAberto(null);

        } else {
            
            this.fecharMenuLateral(p);
            abrirMenuLateral(p, tipoEquipamento);
            this.setMenuLateralAberto(true);
            this.setNomeTipoMenuLateralAberto(tipoEquipamento);
        }
    } // gerenciarMenuLateral
    
    public void abrirMenuLateral(JPanel p, String tipoEquipamento){
        
        int larguraP = p.getWidth();
        int alturaP = p.getHeight();
        int x = (larguraP - SizeHelper.LARGURA_MENU_LATERAL);
        int y = (alturaP - SizeHelper.ALTURA_MENU_LATERAL) / 2;
        
        this.pnlMenuLateral = new JPanel();        
        this.pnlMenuLateral.setLayout(null);
        
        pnlMenuLateral.setBounds(x, y, SizeHelper.LARGURA_MENU_LATERAL, SizeHelper.ALTURA_MENU_LATERAL);
        pnlMenuLateral.setBackground(Constantes.COR_BACKGROUND_HOVER);
        
        JLabel tituloMenu = new LabelBuilder()
                .setTitulo(trToPlural(tipoEquipamento))
                .setForeground(Color.white)
                .setFonte(new Font(Constantes.FONTE, Font.PLAIN, Constantes.TAMANHO_FONTE))
                .build();
        
        Font fonteNegrito = new Font(tituloMenu.getFont().getName(), Font.BOLD, tituloMenu.getFont().getSize());
        tituloMenu.setFont(fonteNegrito);
        
        int larguraC = pnlMenuLateral.getWidth();
        int alturaC = pnlMenuLateral.getHeight(); 
        int tituloX = (larguraC - 60) / 2;
        int tituloY = alturaC - 760;
       
        tituloMenu.setBounds(tituloX, tituloY, 120, 20);
        
        pnlMenuLateral.add(tituloMenu);
        p.add(pnlMenuLateral);
        p.revalidate();
        p.repaint();
        
        this.adicionarFerramentasAoMenu(tipoEquipamento);
        
    } // abrirMenuLateral
    
    public void fecharMenuLateral(JPanel p){
        
        p.remove(this.pnlMenuLateral);
        p.revalidate();
        p.repaint();
        
    } // fecharMenuLateral
    
    public void adicionarFerramentasAoMenu(final String tipoEquipamento){
        
        EquipamentoFactory equipamentoFactory = new EquipamentoFactory(equipamentoServiceMap);

        try{
            
            List<? extends Equipamento> listaEquipamentos = equipamentoFactory.pegarFerramentas(trToPlural(tipoEquipamento));
            int x = 20;
            int y = this.pnlMenuLateral.getHeight() / 8;
            int cont = 0; 

            for(int i = 0; i < listaEquipamentos.size(); i++) {

                int index = i;

                Equipamento eq = listaEquipamentos.get(i);

                FerramentaContainer ferramentaContainer = ferramentaContainerController.criarContainer(
                    eq,
                    SizeHelper.ALTURA_FERRAMENTA_CONTAINER,
                    SizeHelper.LARGURA_FERRAMENTA_CONTAINER,
                    x,
                    y,
                    i,
                    false 
                );

                ferramentaContainer.addMouseListener(new MouseAdapter() {

                    @Override
                    public void mouseClicked(MouseEvent me) {

                            adicionarEquipamento(ferramentaContainer.getEquipamento(), index);
                        } 
                    });

                this.pnlMenuLateral.add(ferramentaContainer);

                cont++;

                if(cont == 1) {
                    x = 20; 
                    y += SizeHelper.ALTURA_FERRAMENTA_CONTAINER + 10; // Avança para a próxima linha
                    cont = 0; // Reseta o contador
                } else {
                    x += SizeHelper.LARGURA_FERRAMENTA_CONTAINER + 10;
                }

            }

            this.pnlMenuLateral.revalidate();
            this.pnlMenuLateral.repaint();
            
        } catch(ServiceNotFound ex){
            
            JOptionPane.showOptionDialog(null, tr(ex.getMessage()), tr("erro"), JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE, null, Constantes.OK, Constantes.OK[0]);
            
        }
        
        
        
    } // adicionarFerramentasAoMenu
    
    public void adicionarEquipamento(Equipamento eq, int i){
        
        Label lbl = criarLabelDeEquipamento(eq, i);
        this.pnlEspacoTrabalho.add(lbl);
        this.espacoTrabalhoMap.put(lbl.getId(), lbl);
        this.pnlEspacoTrabalho.revalidate();
        this.pnlEspacoTrabalho.repaint();
        
    } // selecionarEquipamento
    
     public void adicionarEquipamento(Label lbl){
        
        this.pnlEspacoTrabalho.add(lbl);
        this.espacoTrabalhoMap.put(lbl.getId(), lbl);
        this.pnlEspacoTrabalho.revalidate();
        this.pnlEspacoTrabalho.repaint();

        
    } 

    public Label criarLabelDeEquipamento(Equipamento eq, int i){
        
        ImageIcon img = new ImageIcon(this.getClass().getResource(eq.get_caminhoImagem()));
        Label lbl = new LabelBuilder()
                .setImagem(img)
                .setTitulo("")
                .build();
        
        lbl.setBounds(
                (this.pnlEspacoTrabalho.getWidth() / 2), 
                (this.pnlEspacoTrabalho.getHeight() / 2), 
                (int) eq.get_alturaPx(), 
                (int) eq.get_larguraPx()
        );
        
        lbl.setId("eq".concat(eq.get_nome()).concat(String.valueOf(i)).concat(String.valueOf(new Random().nextLong(900))));
        lbl.setEquipamento(eq);
        
        this.adicionarListenerDeCliqueAoEquipamento(lbl);
        this.adicionarListenerDeMovimentoAoEquipamento(lbl);
        
        return lbl;       
    } // criarLabelDeEquipamento
    
    public void adicionarListenerDeCliqueAoEquipamento(Label lbl){

        lbl.addMouseListener(new MouseAdapter(){
            
            @Override
            public void mouseClicked(MouseEvent me){
                
                if(emModoRemocao){
                    
                    removeEquipament(lbl.getId());
                    
                }
                
                if(emModoRotacao){
                
                    rotacionarEquipamento(lbl);
                    
                }
                
                if(emModoConexao){
                    
                    adicionarNaPilhaDeConexao(lbl);
                    
                }
                
                if(inMirroringMode){
                    
                    mirrorEquipament(lbl);
                    
                }
                
            }
        });        
    }
    
    
    private void desconectar(Map<String, Label> conexoes, Label anterior){
        
        for(Map.Entry<String, Label> entry : conexoes.entrySet()){
            
            if(!entry.getValue().getConexoes().isEmpty()){
                
                if(entry.getValue() == anterior) continue;
                
                desconectar(entry.getValue().getConexoes(), null);
                
            }
            
            entry.getValue().getConexoes().clear();
            
        }
        
    }
    
    int mouseX, mouseY;
    double suavizacao = 1.01;
    
    public void adicionarListenerDeMovimentoAoEquipamento(Label lbl){

        lbl.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                mouseX = me.getX();
                mouseY = me.getY();
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                desconectar(lbl.getConexoes(), null); 
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                lbl.setBorder(BorderFactory.createLineBorder(Constantes.COR_PRIMARIA));
            }

            @Override
            public void mouseExited(MouseEvent me){
                lbl.setBorder(null);
            }
        });

        lbl.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int deltaX = e.getXOnScreen() - lbl.getLocationOnScreen().x - mouseX;
                int deltaY = e.getYOnScreen() - lbl.getLocationOnScreen().y - mouseY;
                lbl.setLocation(lbl.getX() + deltaX, lbl.getY() + deltaY);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                final int x = e.getX();
                final int y = e.getY();

                final int width = lbl.getWidth();
                final int height = lbl.getHeight();

                if (x >= 0 && x <= width && y >= 0 && y <= height) {
                    lbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
                } else {
                    lbl.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                }
            }
        });
    }

    
    
    
}
