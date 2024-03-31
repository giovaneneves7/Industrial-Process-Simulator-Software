package br.com.ifba.ipss.common.controller;

import br.com.ifba.ipss.feature.label.domain.model.Label;
import br.com.ifba.ipss.util.Constantes;

/**
 *
 * @author Giovane Neves
 */
public class BotaoConectarController {
    
    public void conectarEquipamentos(Label origem, Label alvo){
        
        if(alvo.getOrientacao().equals(Constantes.HORIZONTAL)){
            
            origem.setLocation((alvo.getX() - origem.getWidth()), alvo.getY());
            
        } else if(alvo.getOrientacao().equals(Constantes.VERTICAL)){
            
            origem.setLocation(alvo.getX(), (alvo.getY() - origem.getHeight()));
            
        }
        
    }
    
    
    
}
