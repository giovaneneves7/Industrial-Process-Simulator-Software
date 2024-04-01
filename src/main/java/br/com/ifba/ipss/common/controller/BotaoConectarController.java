package br.com.ifba.ipss.common.controller;

import br.com.ifba.ipss.feature.label.domain.model.Label;
import br.com.ifba.ipss.util.Constantes;

/**
 *
 * @author Giovane Neves
 * @since V0.01
 */
public class BotaoConectarController {
    
    public void conectarEquipamentos(Label origem, Label alvo){
        
        if(alvo.getOrientacao().equals(Constantes.HORIZONTAL)){
            
            int xOrigem = alvo.getX() + alvo.getWidth();
            int yOrigem = alvo.getY() + (alvo.getHeight() / 2) - (origem.getHeight() / 2);
            origem.setLocation(xOrigem, yOrigem);
            
        } else if(alvo.getOrientacao().equals(Constantes.VERTICAL)){
            
            int xOrigem = alvo.getX() + (alvo.getWidth() / 2) - (origem.getWidth() / 2);
            int yOrigem = alvo.getY() + alvo.getHeight();
            origem.setLocation(xOrigem, yOrigem);
            
        }
        
    }
    
    
    
}
