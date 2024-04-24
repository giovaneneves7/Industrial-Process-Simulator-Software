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
import java.util.HashMap;
import java.util.Map;
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
    private String tipo = "";
    private Map<String, Label> conexoes = new HashMap<>();
    
    public LabelBuilder setTitulo(String titulo){
        
        this._titulo = titulo;
        
        return this;
    } // setTitulo
    
    public LabelBuilder setImagem(javax.swing.ImageIcon imagem){
        
        this._imagem = imagem;
        
        return this;
    } // setImagem
    
    public LabelBuilder setBackground(Color background){
        
        this._background = background;
        
        return this;
    } // setBackground
    
    public LabelBuilder setForeground(Color foreground){
        
        this._foreground = foreground;
        
        return this;
    } // setForeground
    
    public LabelBuilder setFonte(Font fonte){
        
        this.fonte = fonte;
        
        return this;
    } // setFonte
    
    public LabelBuilder setLargura(int largura){
        
        this.largura = largura;
        return this;
    } // setLargura
    
    public LabelBuilder setAltura(int altura){
        
        this.altura = altura;
        return this;
    } // setAltura
    
    public LabelBuilder setOrientacao(String orientacao){
        
        this.orientacao = orientacao;
        return this;
    } // setOrientacao
    
    public LabelBuilder setTipo(String tipo){
        
        this.tipo = tipo;
        return this;
    }
    
    public LabelBuilder setConexoes(Map<String, Label> conexoes){
        
        this.conexoes = conexoes;
        return this;
        
    } // setConexoes
            
    public Label build(){
        
        Label label = new Label();
        
        label.setText(this._titulo);
        label.setForeground(this._foreground);
        label.setBackground(this._background);
        label.setIcon(this._imagem);
        label.setBounds(0, 0, this.largura, this.altura);
        label.setFont(this.fonte);
        label.setOrientacao(this.orientacao);
        label.setTipo(this.tipo);
        label.setConexoes(this.conexoes);
        
        return label;
        
    } // build
    
}
