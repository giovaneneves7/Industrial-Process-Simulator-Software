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
import br.com.ifba.ipss.model.Equipamento;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
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
    // *************************************************//
    // ****************** { Métodos } ******************//
    // *************************************************//
    
    /**
     * Abre o menu de ferramentas quando um botão é clicado.
     */
    public void abrirMenuFerramentas(JPanel p, final String nome){      
        
        int larguraF = p.getWidth();
        int alturaF = p.getHeight();
        int x = (larguraF - 280);
        int y = (alturaF - 820) / 2;
        
        p.setLayout(null);
        this._ferramentasContainer = new JPanel();        
        _ferramentasContainer.setBounds(x, y, 280, 820);
        _ferramentasContainer.setBackground(Color.decode("#5E5E5E"));
        p.add(_ferramentasContainer);
        
        p.setComponentZOrder(_ferramentasContainer, 1);
        p.revalidate();
        p.repaint();
        
        this.set_menuAberto(true);
        this.set_nomeMenuAberto(nome);
    } // abrirMenuFerramentas
    
    public void fecharMenuFerramentas(JPanel p){
        
        System.out.println("OK: " + String.valueOf(p.getComponentZOrder(this._ferramentasContainer)));
        
        p.remove(this._ferramentasContainer);
        p.revalidate();
        p.repaint();
        this.set_menuAberto(false);
        this.set_nomeMenuAberto(null);
        
    } // fecharMenuFerramentas
    
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
