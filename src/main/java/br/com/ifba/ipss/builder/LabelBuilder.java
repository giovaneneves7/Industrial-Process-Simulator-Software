package br.com.ifba.ipss.builder;

import java.awt.Color;
import javax.swing.JLabel;

/**
 *
 * @author Giovane Neves
 * @since V0.0.1
 */
public class LabelBuilder {
    
    private String _titulo;
    private javax.swing.ImageIcon _imagem;
    private Color _background;
    private Color _foreground;
    
    
    
    public LabelBuilder setTitulo(String titulo){
        
        this._titulo = titulo;
        
        return this;
    }
    
    public LabelBuilder setImagem(javax.swing.ImageIcon imagem){
        
        this._imagem = imagem;
        
        return this;
    }
    
    public LabelBuilder setBackground(Color background){
        
        this._background = background;
        
        return this;
    }
    
    public LabelBuilder setForeground(Color foreground){
        
        this._foreground = foreground;
        
        return this;
    }
            
    public JLabel build(){
        
        javax.swing.JLabel label = new JLabel();
        
        label.setText(_titulo);
        label.setForeground(_foreground);
        label.setBackground(_background);
        label.setIcon(_imagem);
        
        return label;
    }
    
}
