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
import br.com.ifba.ipss.feature.label.domain.builder.LabelBuilder;
import br.com.ifba.ipss.helper.SizeHelper;
import br.com.ifba.ipss.feature.bomba.domain.model.Bomba;
import br.com.ifba.ipss.feature.conexao.domain.model.Conexao;
import br.com.ifba.ipss.feature.equipamento.domain.model.Equipamento;
import br.com.ifba.ipss.feature.reator.domain.model.Reator;
import br.com.ifba.ipss.feature.tubulacao.domain.model.Tubulacao;
import br.com.ifba.ipss.feature.tubulacao.domain.service.ITubulacaoService;
import br.com.ifba.ipss.feature.tubulacao.domain.service.TubulacaoServiceImpl;
import br.com.ifba.ipss.feature.widget.model.FerramentaContainer;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
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
    
    private ITubulacaoService tubulacaoService = new TubulacaoServiceImpl();
    
    private boolean _menuAberto = false;
    private String _nomeMenuAberto;
    private JPanel _ferramentasContainer;
    private Map<String, List<?>> equipamentos = new HashMap<>();
    
    private JLabel lblFerramentaSelecionada;
    private boolean ferramentaEstaSelecionada = false;
    
    // *************************************************//
    // ***************** { Construtor } ****************//
    // *************************************************//
    public MenuFerramentasController(Map<String, List<?>> equipamentos){
        
        this.equipamentos = equipamentos;
        
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
        _ferramentasContainer.setBackground(Color.decode("#5E5E5E"));
        
        // T�tulo do painel 
        JLabel tituloMenu = new LabelBuilder()
                .setTitulo(nome)
                .setForeground(Color.white)
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
        
        if(nome.equals("Tubulações")){
        
            List<Tubulacao> tubulacoes = tubulacaoService.pegarTubulacoes();
            
            int cont = 0;
            
            for(int i = 0; i < tubulacoes.size();i+=2){
            
                boolean segundaIteracao = tubulacoes.size() > (i + 1);
                
                for(int j = 0; j < ((segundaIteracao) ? 2 : 1); j++){
                    
                    Tubulacao tub = tubulacoes.get(i);
                    FerramentaContainer<Tubulacao> ferramentaContainer = new FerramentaContainer<>(tub,SizeHelper.ALTURA_FERRAMENTA_CONTAINER, SizeHelper.LARGURA_FERRAMENTA_CONTAINER, 5, (p.getHeight() / 8), i);
                      
                            ferramentaContainer.addMouseListener(new MouseAdapter(){
                            
                                @Override
                                public void mouseClicked(MouseEvent me){
                                
                                    selecionarFerramenta(pnlEspacoTrabalho, nome, tub.get_nome(),f, me);
                                    
                                } 
                                
                            });
                            p.add(ferramentaContainer);
                            cont++;
                    
                }
                
                
            }
            
        }
        

        p.revalidate();
        p.repaint();
    }
    
    
    public void selecionarFerramenta(JPanel pnlEspacoTrabalho, String tipo, String nome, JFrame f,MouseEvent me){
        
        Equipamento eq = pegarEquipamentoSelecionado(tipo, nome);
        
        if(eq instanceof Tubulacao tub){
            
            ImageIcon imgTub = new ImageIcon(this.getClass().getResource(eq.get_caminhoImagem()));
            JLabel lblTub = new LabelBuilder()
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
    }
    
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
               
    }
    
    public void adicionarListenerDeCliqueAAFerramenta(JLabel lbl){
        
        lbl.addMouseListener(new MouseAdapter(){
            
            @Override
            public void mouseClicked(MouseEvent me){
            
                if(lblFerramentaSelecionada == lbl){
                    
                    ferramentaEstaSelecionada = false;
                    return;

                }
                
                lblFerramentaSelecionada = lbl;
                ferramentaEstaSelecionada = true;
            }
        });
        
    }
    
    public void adicionarListenerDeMovimentoAAFerramenta(JLabel lbl){
        
        
        lbl.addMouseMotionListener(new MouseMotionAdapter(){
            
            @Override
            public void mouseMoved(MouseEvent me){
            
                if(!ferramentaEstaSelecionada || lblFerramentaSelecionada != lbl)
                    return;
                
                int x = lbl.getLocation().x + me.getX();
                int y = lbl.getLocation().y + me.getY();
                
                lbl.setLocation(x, y);
                
                System.out.println("Movendo");
            }
        });
    }
    
        
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
