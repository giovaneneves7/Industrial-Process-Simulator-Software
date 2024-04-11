package br.com.ifba.ipss.common.controller;

import static br.com.ifba.ipss.util.Dicionario.tr;
import static br.com.ifba.ipss.util.Dicionario.trToPlural;

import br.com.ifba.ipss.common.infrastructure.interfaces.IEquipamentoService;
import br.com.ifba.ipss.feature.conexao.domain.service.ConexaoServiceImpl;
import br.com.ifba.ipss.feature.equipamento.controller.FerramentaContainerController;
import br.com.ifba.ipss.feature.equipamento.domain.factory.EquipamentoFactory;
import br.com.ifba.ipss.feature.equipamento.domain.model.Equipamento;
import br.com.ifba.ipss.feature.equipamento.widget.FerramentaContainer;
import br.com.ifba.ipss.feature.label.domain.builder.LabelBuilder;
import br.com.ifba.ipss.feature.label.domain.model.Label;
import br.com.ifba.ipss.feature.tubulacao.domain.model.Tubulacao;
import br.com.ifba.ipss.feature.tubulacao.domain.service.TubulacaoServiceImpl;
import br.com.ifba.ipss.helper.SizeHelper;
import br.com.ifba.ipss.util.Constantes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import lombok.Data;

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
    
    private JFrame areaDeTrabalho;
    private JPanel pnlMenuLateral;
    private JPanel pnlEspacoTrabalho;
    
    private static boolean emModoRemocao = false;
    private static boolean emModoConexao = false;
    
    private boolean menuLateralAberto = false;
    private String nomeTipoMenuLateralAberto;
    
    // *************************************************//
    // ****************** { Construtor } ***************//
    // *************************************************//
    
    public AreaDeTrabalhoController(JFrame areaDeTrabalho){
        
        this.areaDeTrabalho = areaDeTrabalho;
        
        equipamentoServiceMap.put(trToPlural("tubulacao"), new TubulacaoServiceImpl());
        equipamentoServiceMap.put(trToPlural("conexao"), new ConexaoServiceImpl());
        
    } // AreaDeTrabalhoController
    
    // *************************************************//
    // ************** { Getters e Setters } ************//
    // *************************************************//
    
    public void setPnlEspacoTrabalho(JPanel pnlEspacaoTrabalho){
        
        this.pnlEspacoTrabalho = pnlEspacaoTrabalho;
    
    }
    // *************************************************//
    // ******************* { Métodos } *****************//
    // *************************************************//
    
    public void definirTituloAplicacao(){
        
        ViewController.definirTituloAplicacao(this.areaDeTrabalho);
        
    } // definirTituloAplicacao
    
    public void definirLogoAplicacao(Image img){
    
        ViewController.definirLogoAplicacao(this.areaDeTrabalho, img);
        
    } // definirLogoAplicacao
    
    // >>> Métodos do Menu Superior <<<
    
    public void mudarStatusModoRemocao(final boolean status){
        
        this.emModoRemocao = status;
        
    } // mudarStatusModoRemocao
    
    public void exibirMensagemEstadoModoDeRemocao(JLabel lbl, final int tempo){
        
        String msg = (emModoRemocao) ? "modo_remocao_ativado" : "modo_remocao_desativado";
        
        this.exibirMensagemTemporaria(lbl, msg, tempo);
        
    } // exibirMensagemEstadoModoDeRemocao 
    
    public void exibirMensagemTemporaria(JLabel lbl, String mensagem, int tempo){
        
        lbl.setText(tr(mensagem));
        
        Timer timer = new Timer(tempo, (ActionEvent e) -> {
            lbl.setText("");
        });
        timer.setRepeats(false); 
        timer.start();
        
    } // exibirMensagemTemporaria
    
    public void atualizarImagemBotaoRemover(JButton btn){
        
        ImageIcon img = new ImageIcon(this.getClass().getResource((emModoRemocao) ? Constantes.CAMINHO_BOTAO_REMOVER_SELECIONADO : Constantes.CAMINHO_BOTAO_REMOVER));
        
        this.mudarImagemBotao(
                img,
                btn
        );
        
        
    } // atualizarImagemBotaoRemover
    
    public void mudarImagemBotao(ImageIcon img, JButton btn){
        
        btn.setIcon(img);
        
    } // mudarImagemBotao
    
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
        int tituloY = alturaC - 740;
       
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
        List<? extends Equipamento> listaEquipamentos = equipamentoFactory.pegarFerramentas(trToPlural(tipoEquipamento));
        
        int x = 20;
        int y = this.pnlMenuLateral.getHeight() / 8;
        int cont = 0; 
        
        for(int i = 0; i < listaEquipamentos.size(); i++) {
        
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
                    
                        adicionarEquipamento(eq);
                
                    } 
                });
            
            this.pnlMenuLateral.add(ferramentaContainer);
            
            cont++;

            if(cont == 2) {
                x = 20; 
                y += SizeHelper.ALTURA_FERRAMENTA_CONTAINER + 10; // Avança para a próxima linha
                cont = 0; // Reseta o contador
            } else {
                x += SizeHelper.LARGURA_FERRAMENTA_CONTAINER + 10;
            }

        }
        
        this.pnlMenuLateral.revalidate();
        this.pnlMenuLateral.repaint();
        
    } // adicionarFerramentasAoMenu
    
    public void adicionarEquipamento(Equipamento eq){
        
        this.pnlEspacoTrabalho.add(criarLabelDeEquipamento(eq));
        this.pnlEspacoTrabalho.revalidate();
        this.pnlEspacoTrabalho.repaint();

        
    } // selecionarEquipamento

    public Label criarLabelDeEquipamento(Equipamento eq){
        
        ImageIcon img = new ImageIcon(this.getClass().getResource(eq.get_caminhoImagem()));
        Label lbl = new LabelBuilder()
                .setImagem(img)
                .setTitulo("")
                .build();
        
        lbl.setBounds((pnlEspacoTrabalho.getWidth() / 2), 0, (int) eq.get_alturaPx(), (int) eq.get_larguraPx());
        
        return lbl;
        
    } // criarLabelDeEquipamento
    
}
