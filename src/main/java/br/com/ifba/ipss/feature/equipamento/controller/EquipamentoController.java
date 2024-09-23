// *************************************************//
// *************** { COMEÇO - Package } ************//
// *************************************************//

package br.com.ifba.ipss.feature.equipamento.controller;

// *************************************************//
// *************** { FIM - Package } ***************//
// *************************************************//

// *************************************************//
// ************ { COMEÇO - Imports } ***************//
// *************************************************//

import br.com.ifba.ipss.feature.equipamento.domain.service.IEquipamentoService;
import br.com.ifba.ipss.feature.label.domain.model.Label;
import br.com.ifba.ipss.infrastructure.interfaces.ApplicationController;
import br.com.ifba.ipss.util.Constantes;
import br.com.ifba.ipss.util.EquipamentType;
import br.com.ifba.ipss.util.Util;

import java.awt.Container;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

// *************************************************//
// ************** { FIM - Imports } ****************//
// *************************************************//

/**
 *
 * @author Giovane Neves
 * @since V0.0.1
 */
public class EquipamentoController implements ApplicationController{
    
    private final IEquipamentoService equipamentoService;
    
    public EquipamentoController(IEquipamentoService equipamentoService){
        
        this.equipamentoService = equipamentoService;
        
    } // EquipamentoController
    
    /**
     * Verifica se os tipos de equipamentos são compatíveis para a conexão
     * 
     * @author Giovane Neves
     * @param target O alvo que receberá a conexão
     * @param movedEquipament O equipamento movido que fará a conexão
     * @return 'true' caso a conexão seja permitida, 'false' caso contrário
     */
    private static boolean canConnect(EquipamentType target, EquipamentType movedEquipament){
        
        return (target == EquipamentType.REATOR && movedEquipament == EquipamentType.BOMBA_CENTRIFUGA) ? false 
                : (target == EquipamentType.BOMBA_CENTRIFUGA && movedEquipament == EquipamentType.REATOR) ? false
                : true;
        
    } // canConnect
    
    /**
     * Conecta dois equipamentos
     * 
     * @author Giovane Neves
     * @param movedLabel O equipamento que será movido e conectado ao alvo
     * @param target O alvo fixo que receberá um equipamento conectado
     */
    public static void connectEquipament(Label movedLabel, Label target){
        
        // INFO: Verifica se o tipo dos equipamentos é compatível para a conexão
        if(!canConnect(target.getEquipamento().getType(), movedLabel.getEquipamento().getType())) return;
        
        if(target.getEquipamento().getAxios().equals(Constantes.HORIZONTAL) && movedLabel.getEquipamento().getAxios().equals(Constantes.HORIZONTAL)){ // Ambos os equipamentos estão na horizontal
        
            int diferencaX = movedLabel.getX() - target.getX();
            int xOrigem = 0;
            int yOrigem = 0;
            
            if(diferencaX <= 0) { // movedLabel está à esquerda do alvo
                
                xOrigem = target.getX() - movedLabel.getWidth(); 
                yOrigem = target.getY();
            } else { // movedLabel está à direita do alvo
                
                xOrigem = target.getX() + target.getWidth();
                yOrigem = target.getY();
                
            }

            
            movedLabel.setLocation(xOrigem, yOrigem);
            
        } else if(target.getEquipamento().getAxios().equals(Constantes.VERTICAL) && movedLabel.getEquipamento().getAxios().equals(Constantes.VERTICAL)){ // Ambos os equipamentos na vertical
            
            int diferencaY = movedLabel.getY() - target.getY(); 
   
            if (diferencaY <= 0) { // lblMovido está acima do alvo
                
                if(!target.getEquipamento().isCanTopConnect()) return;
                
                int xOrigem = 0, yOrigem = 0;
                
                if(target.getEquipamento().getType() == EquipamentType.BOMBA_CENTRIFUGA){
                    
                    xOrigem = target.getX();
                    yOrigem = target.getY() - movedLabel.getHeight();
                    
                } else {
                    
                    xOrigem = target.getX() + (target.getWidth() / 2) - (movedLabel.getWidth() / 2);
                    yOrigem = target.getY() - movedLabel.getHeight();
                
                }
                 
                
                movedLabel.setLocation(xOrigem, yOrigem); 
                
            } else { // lblMovido está abaixo do alvo
                
                if(!target.getEquipamento().isCanBottomConnect()) return;
                
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
            
        } else{ // O alvo está na vertical e o equipamento a se conectar está na horizontal
            
            if(!target.getEquipamento().isCanLeftConnect() && target.getEquipamento().isCanRightConnect()) return;
            
            int diferencaX = movedLabel.getX() - target.getX();
            int xOrigem = 0;
            int yOrigem = 0;
            
            if(diferencaX <= 0) { // movedLabel está à esquerda do alvo
                
                if(target.getEquipamento().getType() == EquipamentType.TANQUE){
                    xOrigem = target.getX() - movedLabel.getWidth(); 
                    yOrigem = (target.getY() + 33);
                }
                
            } else { // movedLabel está à direita do alvo
                
                if(target.getEquipamento().getType() == EquipamentType.TANQUE){
                    xOrigem = target.getX() + target.getWidth() - 2;
                    yOrigem = (target.getY() + 163);
                }
                
            }

            
            movedLabel.setLocation(xOrigem, yOrigem);
            
            
        }
    } // connectEquipament
    
    public static void rotateEquipament(Label lbl){
        
        if(!lbl.getEquipamento().isCanRotate()) return;
        
        ImageIcon iconAntigo = (ImageIcon) lbl.getIcon();
        BufferedImage bufferedImage = Util.toBufferedImage(iconAntigo.getImage());
        ImageIcon iconGirado = Util.rotate(bufferedImage, 90);
        
        lbl.setIcon(iconGirado);
       
        int newWidth = lbl.getHeight();  
        int newHeight = lbl.getWidth();  
        lbl.setSize(newWidth, newHeight);  

        int currentX = lbl.getX();  
        int currentY = lbl.getY();  
        int centerX = currentX + ( newHeight/ 2);  
        int centerY = currentY + (newWidth / 2);  

        lbl.setLocation(centerX - (newWidth / 2), centerY - (newHeight / 2));
        
        Container parent = lbl.getParent();
        parent.revalidate();
        parent.repaint();
        
        lbl.setOrientacao(lbl.getOrientacao().equals(Constantes.VERTICAL) ? Constantes.HORIZONTAL : Constantes.VERTICAL);
        lbl.getEquipamento().setAxios(lbl.getEquipamento().getAxios().equals(Constantes.VERTICAL) ? Constantes.HORIZONTAL : Constantes.VERTICAL);
        
        // Lógica de rotacionar personalizada para a tubulação
        if(lbl.getEquipamento().getType() == EquipamentType.CONEXAO){
            
            lbl.getEquipamento().setCanTopConnect(lbl.getEquipamento().getAxios().equals(Constantes.VERTICAL));
            
        }
    } // rotateEquipament
    
    
    
    
}
