package br.com.ifba.ipss.feature.equipamento.controller;

import br.com.ifba.ipss.feature.equipamento.domain.service.IEquipamentoService;
import br.com.ifba.ipss.feature.label.domain.model.Label;
import br.com.ifba.ipss.infrastructure.interfaces.ApplicationController;
import br.com.ifba.ipss.util.Constantes;

/**
 *
 * @author Giovane Neves
 * @since V0.0.1
 */
public class EquipamentoController implements ApplicationController{
    
    private final IEquipamentoService equipamentoService;
    
    public EquipamentoController(IEquipamentoService equipamentoService){
        
        this.equipamentoService = equipamentoService;
        
    }
    
    public static void connectEquipament(Label movedLabel, Label target){
        
        if(target.getEquipamento().getAxios().equals(Constantes.HORIZONTAL) && movedLabel.getEquipamento().getAxios().equals(Constantes.HORIZONTAL)){ // Ambos os equipamentos estão na horizontal
        
            int diferencaX = movedLabel.getX() - target.getX();
            int xOrigem = 0;
            int yOrigem = 0;
            
            if(diferencaX <= 0) { //lblMovido está à esquerda do alvo
                
                //if(target.getConexoes().containsKey(Constantes.ESQUERDA)) return;
                
                xOrigem = target.getX() - target.getWidth();
                yOrigem = target.getY();
                
                //target.getConexoes().put(Constantes.ESQUERDA, lblMovido);
            } else{ // lblMovido está à direita do alvo
                
                //if(alvo.getConexoes().containsKey(Constantes.DIREITA)) return;
                
                xOrigem = target.getX() + target.getWidth();
                yOrigem = target.getY();
                
                //alvo.getConexoes().put(Constantes.DIREITA, lblMovido);
            }
            
            movedLabel.setLocation(xOrigem, yOrigem);
        } else if(target.getEquipamento().getAxios().equals(Constantes.VERTICAL) && movedLabel.getEquipamento().getAxios().equals(Constantes.VERTICAL)){
            
            
            int diferencaY = movedLabel.getY() - target.getY(); 
   
            if (diferencaY <= 0) { // lblMovido está acima do alvo
                
                int xOrigem = target.getX() + (target.getWidth() / 2) - (movedLabel.getWidth() / 2);
                int yOrigem = target.getY() - movedLabel.getHeight(); 
                
                movedLabel.setLocation(xOrigem, yOrigem); // junta as labels.
                
            } else { // lblMovido está abaixo do alvo
                
                int xOrigem = target.getX() + (target.getWidth() / 2) - (movedLabel.getWidth() / 2);
                int yOrigem = (diferencaY < 0) ? target.getY() - movedLabel.getHeight() : target.getY() + target.getHeight();
 
               movedLabel.setLocation(xOrigem, yOrigem);
                
            }
            
        } else if(target.getEquipamento().getAxios().equals(Constantes.HORIZONTAL) && movedLabel.getEquipamento().getAxios().equals(Constantes.VERTICAL)){
            
            int diferencaY = movedLabel.getY() - target.getY(); 
   
            if (diferencaY <= 0) { // lblMovido está acima do alvo
                
                if(!target.getEquipamento().isCanTopConnect()) return;
                
                int xOrigem = target.getX() + (target.getWidth() / 2) - (movedLabel.getWidth() / 2);
                int yOrigem = target.getY() - movedLabel.getHeight(); 
                
                movedLabel.setLocation(xOrigem, yOrigem); // junta as labels.
                
            } else { // lblMovido está abaixo do alvo
                
                int xOrigem = target.getX() + (target.getWidth() / 2) - (movedLabel.getWidth() / 2);
                int yOrigem = (diferencaY < 0) ? target.getY() - movedLabel.getHeight() : target.getY() + target.getHeight();
 
               movedLabel.setLocation(xOrigem, yOrigem);
                
            }
            
        }
    }
    
    
    
    
}
