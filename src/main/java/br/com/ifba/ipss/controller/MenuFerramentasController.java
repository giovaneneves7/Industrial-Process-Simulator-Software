// *************************************************//
// *************** { COMEÇO - Package } ************//
// *************************************************//
package br.com.ifba.ipss.controller;
// *************************************************//
// *************** { FIM - Package } ***************//
// *************************************************//

// *************************************************//
// ************ { COMEÇO - Imports } ***************//
// *************************************************//
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
    // ****************** { Métodos } ******************//
    // *************************************************//
    
    /**
     * Abre o menu de ferramentas quando um botão é clicado.
     */
    public void abrirMenuFerramentas(JPanel p, final String nome){      
        
        if(this.is_menuAberto())
            this.fecharMenuFerramentas(p);
        
        int larguraF = p.getWidth();
        int alturaF = p.getHeight();
        int x = (larguraF - 280);
        int y = (alturaF - 820) / 2;
        
        
        // Instância do painel
        this._ferramentasContainer = new JPanel();        
        this._ferramentasContainer.setLayout(null);
        
        // Customização do painel
        _ferramentasContainer.setBounds(x, y, 280, 820);
        _ferramentasContainer.setBackground(Color.decode("#5E5E5E"));
        
        // Título do painel 
        JLabel tituloMenu = new JLabel();
        tituloMenu.setText(nome);
        Font fonteNegrito = new Font(tituloMenu.getFont().getName(), Font.BOLD, tituloMenu.getFont().getSize());
        tituloMenu.setFont(fonteNegrito);
        tituloMenu.setForeground(Color.white);
        
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
        
        this.set_menuAberto(true);
        this.set_nomeMenuAberto(nome);
        
        this.adicionarFerramentasAoMenu(_ferramentasContainer, nome);
        
    } // abrirMenuFerramentas
    
    public void fecharMenuFerramentas(JPanel p){
        
        p.remove(this._ferramentasContainer);
        p.revalidate();
        p.repaint();
        this.set_menuAberto(false);
        this.set_nomeMenuAberto(null);
        
    } // fecharMenuFerramentas
    
    public void adicionarFerramentasAoMenu(JPanel p, String nome){
        
        List<?> listaEquipamentos = _equipamentos.get(nome);
                
        if (listaEquipamentos != null && !listaEquipamentos.isEmpty()) {
            
            Object primeiroEquipamento = listaEquipamentos.get(0);

            if(primeiroEquipamento instanceof Tubulacao) {
                
                Tubulacao tubulacao = (Tubulacao) primeiroEquipamento;
                FerramentaContainer<Tubulacao> ferramentaContainer = new FerramentaContainer<>(tubulacao, 100, 100, (p.getWidth() / 2),(p.getHeight() / 8));
                p.add(ferramentaContainer);
                
            } else if (primeiroEquipamento instanceof List) {
                List<?> listaTubulacoes = (List<?>) primeiroEquipamento;
                
                if (!listaTubulacoes.isEmpty() && listaTubulacoes.get(0) instanceof Tubulacao) {
                    Tubulacao tubulacao = (Tubulacao) listaTubulacoes.get(0);
                    
                    FerramentaContainer<Tubulacao> ferramentaContainer = new FerramentaContainer<>(tubulacao, 280, 350, 0, 0);
                    p.add(ferramentaContainer);
                }
                
            }
        }   
    
        
        p.revalidate();
        p.repaint();
    }
    public void selecionarFerramenta(){
        /* TODO: Adicionar lógica */
    }
    
    public void adicionarFerramentaAAAreaDeTrabalho(){
        /* TODO: Adicionar lógica */
    }
    
    public void removerFerramentaDaAreaDeTrabalho(){
        /* TODO: Adicionar lógica */
    }
    
    public void conectarFerramentas(Equipamento origem, Equipamento destino){
        /* TODO: Adicionar lógica */
    }
} // class MenuFerramentasController
