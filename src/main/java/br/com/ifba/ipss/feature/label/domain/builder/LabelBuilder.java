// *************************************************//
// *************** { COME�O - Package } ************//
// *************************************************//
package br.com.ifba.ipss.feature.label.domain.builder;
// *************************************************//
// *************** { FIM - Package } ***************//
// *************************************************//

// *************************************************//
// ************ { COME�O - Imports } ***************//
// *************************************************//
import br.com.ifba.ipss.feature.label.domain.model.Label;
import br.com.ifba.ipss.util.Constantes;
import java.awt.Color;
import java.awt.Font;
// *************************************************//
// ************** { FIM - Imports } ****************//
// *************************************************//

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
    private Font fonte;
    private int largura;
    private int altura;
    private String orientacao = Constantes.VERTICAL;
    
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
    
    public LabelBuilder setFonte(Font fonte){
        
        this.fonte = fonte;
        
        return this;
    }
    
    public LabelBuilder setLargura(int largura){
        
        this.largura = largura;
        return this;
    }
    
    public LabelBuilder setAltura(int altura){
        
        this.altura = altura;
        return this;
    }
    
    public LabelBuilder setOrientacao(String orientacao){
        
        this.orientacao = orientacao;
        return this;
    }
            
    public Label build(){
        
        Label label = new Label();
        
        label.setText(_titulo);
        label.setForeground(_foreground);
        label.setBackground(_background);
        label.setIcon(_imagem);
        label.setBounds(0, 0, largura, altura);
        label.setFont(fonte);
        label.setOrientacao(orientacao);
        
        return label;
    }
    
    
}
