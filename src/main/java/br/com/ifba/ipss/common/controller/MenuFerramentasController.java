// *************************************************//
// *************** { COME�O - Package } ************//
// *************************************************//
package br.com.ifba.ipss.common.controller;
// *************************************************//
// *************** { FIM - Package } ***************//
// *************************************************//

// *************************************************//
// ************ { COME�O - Imports } ***************//
// *************************************************//
import br.com.ifba.ipss.common.infrastructure.interfaces.IEquipamentoService;
import br.com.ifba.ipss.feature.conexao.domain.model.Conexao;
import br.com.ifba.ipss.feature.conexao.domain.service.ConexaoServiceImpl;
import br.com.ifba.ipss.feature.label.domain.builder.LabelBuilder;
import br.com.ifba.ipss.helper.SizeHelper;
import br.com.ifba.ipss.feature.equipamento.controller.FerramentaContainerController;
import br.com.ifba.ipss.feature.equipamento.domain.factory.EquipamentoFactory;
import br.com.ifba.ipss.feature.equipamento.domain.model.Equipamento;
import br.com.ifba.ipss.feature.tubulacao.domain.model.Tubulacao;
import br.com.ifba.ipss.feature.tubulacao.domain.service.ITubulacaoService;
import br.com.ifba.ipss.feature.tubulacao.domain.service.TubulacaoServiceImpl;
import br.com.ifba.ipss.feature.equipamento.widget.FerramentaContainer;
import br.com.ifba.ipss.feature.label.domain.model.Label;
import br.com.ifba.ipss.util.Constantes;
import br.com.ifba.ipss.util.NomeEquipamento;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
public class MenuFerramentasController {

    // *************************************************//
    // ***************** { Atributos } *****************//
    // *************************************************//
    
    private Map<String, IEquipamentoService> equipamentoServiceMap = new HashMap<>();
    
    private ITubulacaoService tubulacaoService = new TubulacaoServiceImpl();
    private FerramentaContainerController ferramentaContainerController = new FerramentaContainerController<>();
    
    private boolean _menuAberto = false;
    private String _nomeMenuAberto;
    private JPanel _ferramentasContainer;
    private Map<String, List<?>> equipamentos = new HashMap<>();
    
    private JLabel lblFerramentaSelecionada;
    private JLabel lblFerramentaSelecionadaParaInteracao;
    private boolean ferramentaEstaSelecionada = false;
    
    private Stack<Label> pilhaConexaoEquipamento = new Stack();
    
    // *************************************************//
    // ***************** { Construtor } ****************//
    // *************************************************//
    public MenuFerramentasController(Map<String, List<?>> equipamentos){
        
        this.equipamentos = equipamentos;
        
        equipamentoServiceMap.put(NomeEquipamento.TUBULACAO.getString(), new TubulacaoServiceImpl());
        equipamentoServiceMap.put(NomeEquipamento.CONEXAO.getString(), new ConexaoServiceImpl());
        
    }
    // *************************************************//
    // ****************** { M�todos } ******************//
    // *************************************************//
    
    /**
     * Abre o menu de ferramentas quando um bot�o � clicado.
     */
    public void abrirMenuFerramentas(JPanel p, JFrame f, final String nome){      
        
        if(this._menuAberto)
            this.fecharMenuFerramentas(p);
        
        int larguraF = p.getWidth();
        int alturaF = p.getHeight();
        int x = (larguraF - 280);
        int y = (alturaF - 820) / 2;
        
        
        // Inst�ncia do painel
        this._ferramentasContainer = new JPanel();        
        this._ferramentasContainer.setLayout(null);
        
        // Customiza��o do painel
        _ferramentasContainer.setBounds(x, y, 280, 820);
        _ferramentasContainer.setBackground(Constantes.COR_BACKGROUND_HOVER);
        
        // T�tulo do painel 
        JLabel tituloMenu = new LabelBuilder()
                .setTitulo(nome)
                .setForeground(Color.white)
                .setFonte(new Font(Constantes.FONTE, Font.PLAIN, Constantes.TAMANHO_FONTE))
                .build();
        
        Font fonteNegrito = new Font(tituloMenu.getFont().getName(), Font.BOLD, tituloMenu.getFont().getSize());
        tituloMenu.setFont(fonteNegrito);
        
        int larguraC = _ferramentasContainer.getWidth();
        int alturaC = _ferramentasContainer.getHeight(); 
        int tituloX = (larguraC - 60) / 2;
        int tituloY = alturaC - 740;
       
        tituloMenu.setBounds(tituloX, tituloY, 120, 20);
        _ferramentasContainer.add(tituloMenu);

        p.add(_ferramentasContainer);
        
        p.setComponentZOrder(_ferramentasContainer, 0);
        p.revalidate();
        p.repaint();
        
        this._menuAberto = true;
        this._nomeMenuAberto = nome;
        
        this.adicionarFerramentasAoMenu(_ferramentasContainer, p, f, nome);
        
        
    } // abrirMenuFerramentas
    
    public void fecharMenuFerramentas(JPanel p){
        
        p.remove(this._ferramentasContainer);
        p.revalidate();
        p.repaint();
        this._menuAberto = false;
        this._nomeMenuAberto = null;
        
    } // fecharMenuFerramentas
    
    public void adicionarFerramentasAoMenu(JPanel p, JPanel pnlEspacoTrabalho, JFrame f, String nome){
        
        
        EquipamentoFactory equipamentoFactory = new EquipamentoFactory(equipamentoServiceMap);
        List<? extends Equipamento> equipamentosList = equipamentoFactory.pegarFerramentas(nome);
            
        int x = 20;
        int y = p.getHeight() / 8;
        int cont = 0; 

        for(int i = 0; i < equipamentosList.size(); i++) {
                
            Equipamento eq = equipamentosList.get(i);

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
                    selecionarFerramenta(pnlEspacoTrabalho, nome, eq.get_nome(), f, me);
                } 
            });
                
            p.add(ferramentaContainer);

            cont++;

            if(cont == 2) {
                x = 20; 
                y += SizeHelper.ALTURA_FERRAMENTA_CONTAINER + 10; // Avança para a próxima linha
                cont = 0; // Reseta o contador
            } else {
                x += SizeHelper.LARGURA_FERRAMENTA_CONTAINER + 10;
            }
        }
            
        p.revalidate();
        p.repaint();
    } // adicionarFerramentasAoMenu
    
    
    public void selecionarFerramenta(JPanel pnlEspacoTrabalho, String tipo, String nome, JFrame f,MouseEvent me){
        
        Equipamento eq = pegarEquipamentoSelecionado(tipo, nome);
        
        if(eq instanceof Tubulacao tub){
            
            ImageIcon imgTub = new ImageIcon(this.getClass().getResource(eq.get_caminhoImagem()));
            Label lblTub = new LabelBuilder()
                    .setImagem(imgTub)
                    .setTitulo("")
                    .build();
            
           lblTub.setBounds((pnlEspacoTrabalho.getWidth() / 2), 0, (int ) tub.get_alturaPx(), (int) tub.get_larguraPx());
           pnlEspacoTrabalho.add(lblTub);
           adicionarListenerDeCliqueAAFerramenta(lblTub);
           adicionarListenerDeMovimentoAAFerramenta(lblTub);
           f.revalidate();
           f.repaint();
        }
        
        if(eq instanceof Conexao con){
            
            ImageIcon imgTub = new ImageIcon(this.getClass().getResource(eq.get_caminhoImagem()));
            Label lblTub = new LabelBuilder()
                    .setImagem(imgTub)
                    .setTitulo("")
                    .build();
           lblTub.setBounds((pnlEspacoTrabalho.getWidth() / 2), 0, 150, 150);
           pnlEspacoTrabalho.add(lblTub);
           adicionarListenerDeCliqueAAFerramenta(lblTub);
           adicionarListenerDeMovimentoAAFerramenta(lblTub);
           f.revalidate();
           f.repaint();
        }
        
    } // selecionarFerramenta
    
    public <T extends Equipamento>T pegarEquipamentoSelecionado(String tipo, String nome){

            
        try {
            
            return equipamentos.get(tipo)
                    .stream()
                    .map(obj -> (T) obj)
                    .filter(tub -> tub.get_nome().equals(nome))
                    .findFirst().orElseThrow(() -> new FileNotFoundException("erro"));
            
        } catch (FileNotFoundException ex) {
            
           ex.printStackTrace();
           return null;
           
        }
               
    } // pegarEquipamentoSelecionado
    
    public void adicionarListenerDeCliqueAAFerramenta(Label lbl){
        
        lbl.addMouseListener(new MouseAdapter(){
            
            @Override
            public void mouseClicked(MouseEvent me){
            
                if(lblFerramentaSelecionada == lbl){
                    
                    ferramentaEstaSelecionada = false;
                    return;

                }
                
                if(pilhaConexaoEquipamento.size() < 2){
                    
                    if(pilhaConexaoEquipamento.isEmpty()){
                        
                        lbl.setBorder(BorderFactory.createLineBorder(Constantes.COR_PRIMARIA));
                        pilhaConexaoEquipamento.push(lbl);
                        
                    } else if(pilhaConexaoEquipamento.get(0) == lbl){
                        
                        lbl.setBorder(null);
                        pilhaConexaoEquipamento.pop();
                        
                    } else{
                        
                        lbl.setBorder(BorderFactory.createLineBorder(Constantes.COR_PRIMARIA));
                        pilhaConexaoEquipamento.push(lbl);
                    } 
                }
                
                lblFerramentaSelecionada = lbl;
                lblFerramentaSelecionadaParaInteracao = lbl;
                ferramentaEstaSelecionada = true;
            }
        });
        
        
    } 
    
    int mouseX, mouseY;
    double suavizacao = 1.01;
    
    public void adicionarListenerDeMovimentoAAFerramenta(Label lbl) {
    
        Timer timer = new Timer(100, e -> {
            int deltaX = lbl.getX() + mouseX;
            int deltaY = lbl.getY() + mouseY;
            lbl.setLocation(deltaX, deltaY);

        });

        lbl.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                
                if(me.getClickCount() == 1) return; // evita que o label seja movido com apenas um clique.

                if (!timer.isRunning()) {
                    timer.start();
                }
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                timer.stop();
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
            
            @Override
            public void mouseDragged(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
            }
            
         
        });
        
        
        
    } // adicionarListenerDeMovimentoAAFerramenta
    
        
    public void adicionarFerramentaAAAreaDeTrabalho(){
        /* TODO: Adicionar l�gica */
    }
    
    public void removerFerramentaDaAreaDeTrabalho(){
        /* TODO: Adicionar l�gica */
    }
    
    public void conectarFerramentas(Equipamento origem, Equipamento destino){
        /* TODO: Adicionar l�gica */
    }
} // class MenuFerramentasController
