// *************************************************//
// *************** { COME�O - Package } ************//
// *************************************************//
package br.com.ifba.ipss.controller;
// *************************************************//
// *************** { FIM - Package } ***************//
// *************************************************//

// *************************************************//
// ************ { COME�O - Imports } ***************//
// *************************************************//
import br.com.ifba.ipss.builder.LabelBuilder;
import br.com.ifba.ipss.helper.SizeHelper;
import br.com.ifba.ipss.model.entity.Equipamento;
import br.com.ifba.ipss.model.entity.Tubulacao;
import br.com.ifba.ipss.model.widget.FerramentaContainer;
import java.awt.Color;
import java.awt.Font;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
    
    private boolean _menuAberto = false;
    private String _nomeMenuAberto;
    private JPanel _ferramentasContainer;
    private Map<String, List<?>> _equipamentos = new HashMap<>();
    
    
    // *************************************************//
    // ***************** { Construtor } ****************//
    // *************************************************//
    public MenuFerramentasController(Map<String, List<?>> equipamentos){
        
        this._equipamentos = equipamentos;
        
    }
    // *************************************************//
    // ****************** { M�todos } ******************//
    // *************************************************//
    
    /**
     * Abre o menu de ferramentas quando um bot�o � clicado.
     */
    public void abrirMenuFerramentas(JPanel p, final String nome){      
        
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
        int tituloY = alturaC - 780;
       
        tituloMenu.setBounds(tituloX, tituloY, 120, 20);
        _ferramentasContainer.add(tituloMenu);

        p.add(_ferramentasContainer);
        
        p.setComponentZOrder(_ferramentasContainer, 0);
        p.revalidate();
        p.repaint();
        
        this._menuAberto = true;
        this._nomeMenuAberto = nome;
        
        this.adicionarFerramentasAoMenu(_ferramentasContainer, nome);
        
    } // abrirMenuFerramentas
    
    public void fecharMenuFerramentas(JPanel p){
        
        p.remove(this._ferramentasContainer);
        p.revalidate();
        p.repaint();
        this._menuAberto = false;
        this._nomeMenuAberto = null;
        
    } // fecharMenuFerramentas
    
    public void adicionarFerramentasAoMenu(JPanel p, String nome){
        
        List<?> listaEquipamentos = _equipamentos.get(nome);
                
        if (listaEquipamentos != null && !listaEquipamentos.isEmpty()) {
            
            Object primeiroEquipamento = listaEquipamentos.get(0);

            if(primeiroEquipamento instanceof Tubulacao) {
                
                int cont = 0;
                                
                for(int i = 0; i < listaEquipamentos.size(); i+=2){

                        boolean segundaIteracao = listaEquipamentos.size() < (i + 1);
                                                
                        for(int j = 0; j < ((segundaIteracao) ? 2 : 1); j++){
                            
                            Tubulacao tub = (Tubulacao) listaEquipamentos.get(cont);
                            FerramentaContainer<Tubulacao> ferramentaContainer = new FerramentaContainer<>(tub,SizeHelper.ALTURA_FERRAMENTA_CONTAINER, SizeHelper.LARGURA_FERRAMENTA_CONTAINER, (p.getWidth() / 2), (p.getHeight() / 8));
                            p.add(ferramentaContainer);
                            cont++;
                            
                        } 
  
                }
                 
              
            } 
        }   

        p.revalidate();
        p.repaint();
    }
    
    
    public void selecionarFerramenta(){
        /* TODO: Adicionar l�gica */
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
