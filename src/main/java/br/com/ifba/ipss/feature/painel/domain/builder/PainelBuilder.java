package br.com.ifba.ipss.feature.painel.domain.builder;

import br.com.ifba.ipss.feature.painel.domain.model.Painel;
import java.awt.LayoutManager;

/**
 *
 * @author Giovane Neves
 * @since V0.0.1
 */
public class PainelBuilder {
    
    private int altura;
    private int largura;
    private int x; 
    private int y;
    private LayoutManager layout;
    
    public PainelBuilder setAltura(int altura){
        
        this.altura = altura;
        return this;
        
    }
    
    public PainelBuilder setLargura(int largura){
        
        this.largura = largura;
        return this;
        
    }
    
    public PainelBuilder setX(int x){
        
        this.x = x;
        return this;
        
    }
    
    public PainelBuilder setY(int y){
        
        this.y = y;
        return this;
        
    }
    
    public PainelBuilder setLayout(LayoutManager layout){
        
        this.layout = layout;
        return this;
    }
    
    public Painel build(){
        
        Painel p = new Painel(this.x, this.altura, this.largura, this.altura);
        p.setLayout(layout);
        return p;
        
    }
}
