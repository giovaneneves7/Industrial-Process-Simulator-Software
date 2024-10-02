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
import static br.com.ifba.ipss.util.Dicionario.tr;
import br.com.ifba.ipss.feature.equipamento.domain.model.Equipamento;
import br.com.ifba.ipss.feature.equipamento.domain.service.IEquipamentoService;
import br.com.ifba.ipss.feature.equipamento.widget.InvalidConnectionWidget;
import br.com.ifba.ipss.feature.label.domain.model.Label;
import br.com.ifba.ipss.helper.GapHelper;
import br.com.ifba.ipss.infrastructure.interfaces.ApplicationController;
import br.com.ifba.ipss.util.Constantes;
import br.com.ifba.ipss.util.EquipamentType;
import br.com.ifba.ipss.util.Util;

import java.awt.Container;
import java.awt.image.BufferedImage;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

// *************************************************//
// ************** { FIM - Imports } ****************//
// *************************************************//

/**
 * Controller do escopo 'equipamento'
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
        
        return    (target == EquipamentType.REATOR && movedEquipament == EquipamentType.BOMBA_CENTRIFUGA) ? false 
                : (target == EquipamentType.REATOR && movedEquipament == EquipamentType.TANQUE) ? false
                : (target == EquipamentType.REATOR && movedEquipament == EquipamentType.TORRE_DESTILACAO) ? false
                : (target == EquipamentType.REATOR && movedEquipament == EquipamentType.TROCADOR_CALOR) ? false
                : (target == EquipamentType.REATOR && movedEquipament == EquipamentType.REATOR) ? false
                
                : (target == EquipamentType.BOMBA_CENTRIFUGA && movedEquipament == EquipamentType.REATOR) ? false
                : (target == EquipamentType.BOMBA_CENTRIFUGA && movedEquipament == EquipamentType.BOMBA_CENTRIFUGA) ? false
                : (target == EquipamentType.BOMBA_CENTRIFUGA && movedEquipament == EquipamentType.TANQUE) ? false
                : (target == EquipamentType.TORRE_DESTILACAO && movedEquipament == EquipamentType.BOMBA_CENTRIFUGA) ? false
                : (target == EquipamentType.TORRE_DESTILACAO && movedEquipament == EquipamentType.TROCADOR_CALOR) ? false
                : (target == EquipamentType.TORRE_DESTILACAO && movedEquipament == EquipamentType.REATOR) ? false
                : (target == EquipamentType.TORRE_DESTILACAO && movedEquipament == EquipamentType.TORRE_DESTILACAO) ? false
                
                : (target == EquipamentType.TROCADOR_CALOR && movedEquipament == EquipamentType.TROCADOR_CALOR) ? false
                : (target == EquipamentType.TROCADOR_CALOR && movedEquipament == EquipamentType.BOMBA_CENTRIFUGA) ? false
                : (target == EquipamentType.TROCADOR_CALOR && movedEquipament == EquipamentType.REATOR) ? false
                : (target == EquipamentType.TROCADOR_CALOR && movedEquipament == EquipamentType.TORRE_DESTILACAO) ? false
                : (target == EquipamentType.TROCADOR_CALOR && movedEquipament == EquipamentType.TANQUE) ? false
                
                : (target == EquipamentType.TANQUE && movedEquipament == EquipamentType.TANQUE) ? false
                : (target == EquipamentType.TANQUE && movedEquipament == EquipamentType.BOMBA_CENTRIFUGA) ? false
                : (target == EquipamentType.TANQUE && movedEquipament == EquipamentType.TROCADOR_CALOR) ? false
                : (target == EquipamentType.TANQUE && movedEquipament == EquipamentType.TORRE_DESTILACAO) ? false
                : true;
        
    } // canConnect
    
    /**
     * Retorna o gap que deve haver entre a coonexão 03 e a tubulação passada
     * por parâmetro.
     * 
     * @author Giovane Neves
     * @since V0.0.1
     * @param tub A tubulação a ser verificada
     * @return O gap que deve haver entre a tubulação e a conexã 03
     */
    private int getTubToCon3Gap(Equipamento tub){
        
        return tub.getId().equals(Constantes.TUBULACAO_1_ID) ? 10 :
               tub.getId().equals(Constantes.TUBULACAO_2_ID) ? -8 :
               tub.getId().equals(Constantes.TUBULACAO_3_ID) ? -28 :
               tub.getId().equals(Constantes.TUBULACAO_4_ID) ? -48 :
               -58;
        
    } // getTubToCon3Gap
    
    /**
     * Conecta dois equipamentos
     * 
     * @author Giovane Neves
     * @param movedLabel O equipamento que será movido e conectado ao alvo
     * @param target O alvo fixo que receberá um equipamento conectado
     */
    public void connectEquipament(Label movedLabel, Label target){
        
        // INFO: Verifica se o tipo dos equipamentos é compatível para a conexão
        if(!canConnect(target.getEquipamento().getType(), movedLabel.getEquipamento().getType())){
            
            InvalidConnectionWidget.notifyInvalidConnection(tr("this_connection_is_invalid"), tr("invalid_connection"));
            return;
            
        }
        
        if(target.getEquipamento().getAxios().equals(Constantes.HORIZONTAL) && movedLabel.getEquipamento().getAxios().equals(Constantes.HORIZONTAL)){ // Ambos os equipamentos estão na horizontal
        
            int diferencaX = movedLabel.getX() - target.getX();
            int xOrigem = 0;
            int yOrigem = 0;
            
            if(diferencaX <= 0) { // movedLabel está à esquerda do alvo
                
                if(target.getEquipamento().getType() == EquipamentType.TROCADOR_CALOR){
                    
                    xOrigem = target.getX() - movedLabel.getWidth();
                    yOrigem = (target.getY() + GapHelper.TROCADOR_CALOR_Y_GAP);
                    
                } else{
                    
                    xOrigem = target.getX() - movedLabel.getWidth(); 
                    yOrigem = target.getY();
                
                }
                
            } else { // movedLabel está à direita do alvo
                
                if(target.getEquipamento().getType() == EquipamentType.TROCADOR_CALOR){
                    
                    xOrigem = (target.getX() + movedLabel.getWidth() + GapHelper.TROCADOR_CALOR_RIGHT_X_GAP);
                    yOrigem = (target.getY() + GapHelper.TROCADOR_CALOR_Y_GAP);
                    
                } else{
                    
                    xOrigem = target.getX() + target.getWidth();
                    yOrigem = target.getY();
                
                }
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
                    
                } else if(target.getEquipamento().getType() == EquipamentType.REATOR){
                    
                    if(target.getEquipamento().isTopAlreadyConnected()){ // INFO: Verifica se já há uma conexão no topo do reator. 
                    
                        xOrigem = target.getX() + GapHelper.REATOR_DOUBLE_TOP_CONNECTION_X_GAP;
                        
                    } else {
                       
                        xOrigem = target.getX() + GapHelper.REATOR_TOP_CONNECTION_X_GAP;
                        
                        target.getEquipamento().setTopAlreadyConnected(true);

                    }
                    
                    yOrigem = (target.getY() - movedLabel.getHeight() + GapHelper.REATOR_TOP_CONNECTION_GAP);
                    
                            
                } else if(target.getEquipamento().getType() == EquipamentType.TORRE_DESTILACAO){
                
                    xOrigem = target.getX() + (target.getWidth() / 2) - (movedLabel.getWidth() / 2) + GapHelper.TORRE_DESTILACAO_TOP_X_GAP;
                    yOrigem = target.getY() - movedLabel.getHeight();
                
                } else{
                    
                    xOrigem = target.getX() + (target.getWidth() / 2) - (movedLabel.getWidth() / 2);
                    yOrigem = target.getY() - movedLabel.getHeight();
                
                }
                
                if(movedLabel.getEquipamento().getId().equals(Constantes.CONEXAO_3_ID)){

                    xOrigem = xOrigem - GapHelper.CONEXAO_3_X_GAP;

                }
                 
                
                movedLabel.setLocation(xOrigem, yOrigem); 
                
            } else { // lblMovido está abaixo do alvo
                
                int xOrigem = 0;
                int yOrigem = 0;
                
                if(!target.getEquipamento().isCanBottomConnect()) return;
                
                if(target.getEquipamento().getType() == EquipamentType.TORRE_DESTILACAO){
                    xOrigem = target.getX() + (target.getWidth() / 2) - (movedLabel.getWidth() / 2) + GapHelper.TORRE_DESTILACAO_BOTTOM_X_GAP;
                    yOrigem = (diferencaY < 0) ? target.getY() - movedLabel.getHeight() : target.getY() + target.getHeight();
                
                } else{
                
                    xOrigem = target.getX() + (target.getWidth() / 2) - (movedLabel.getWidth() / 2);
                    yOrigem = (diferencaY < 0) ? target.getY() - movedLabel.getHeight() : target.getY() + target.getHeight();
 
                }
                
                movedLabel.setLocation(xOrigem, yOrigem);
                
            }
            
        } else if(target.getEquipamento().getAxios().equals(Constantes.HORIZONTAL) && movedLabel.getEquipamento().getAxios().equals(Constantes.VERTICAL)){
            
            int diferencaY = movedLabel.getY() - target.getY(); 
   
            if (diferencaY <= 0) { // lblMovido está acima do alvo
                
                int xOrigem = 0;
                int yOrigem = 0;
                if(!target.getEquipamento().isCanTopConnect()) return;
                
                if(target.getEquipamento().getType() == EquipamentType.TROCADOR_CALOR){
                
                    xOrigem = (target.getX() + (target.getWidth() / 2) - (movedLabel.getWidth() / 2)) - GapHelper.TROCADOR_CALOR_TOP_X_GAP;
                    yOrigem = target.getY() - movedLabel.getHeight(); 
                    
                } else{
                    
                    xOrigem = target.getX() + (target.getWidth() / 2) - (movedLabel.getWidth() / 2);
                    yOrigem = target.getY() - movedLabel.getHeight(); 
                
                }
                
                movedLabel.setLocation(xOrigem, yOrigem); // junta as labels.
                
            } else { // lblMovido está abaixo do alvo
                
                int xOrigem = 0;
                int yOrigem = 0;
                if(!target.getEquipamento().isCanBottomConnect()) return; // retorna se não for permitida a conexão embaixo do alvo.
                
                if(target.getEquipamento().getType() == EquipamentType.TROCADOR_CALOR){
                    
                    xOrigem = (target.getX() + (target.getWidth() / 2) - (movedLabel.getWidth() / 2)) + GapHelper.TROCADOR_CALOR_BOTTOM_X_GAP;
                    yOrigem = (diferencaY < 0) ? target.getY() - movedLabel.getHeight() : target.getY() + target.getHeight();
                    
                } else {
                    
                    xOrigem = target.getX() + (target.getWidth() / 2) - (movedLabel.getWidth() / 2);
                    yOrigem = (diferencaY < 0) ? target.getY() - movedLabel.getHeight() : target.getY() + target.getHeight();
                
                }
               
                movedLabel.setLocation(xOrigem, yOrigem);
                
            }
            
        } else{ // O alvo está na vertical e o equipamento a se conectar está na horizontal
            
            if(!target.getEquipamento().isCanLeftConnect() && !target.getEquipamento().isCanRightConnect()) return;
            
            int diferencaX = movedLabel.getX() - target.getX();
            int xOrigem = 0;
            int yOrigem = 0;
            
            if(diferencaX <= 0) { // movedLabel está à direita do alvo
                
                if(!target.getEquipamento().isCanRightConnect()){

                    InvalidConnectionWidget.notifyInvalidConnection(tr("this_connection_is_invalid"), tr("invalid_connection"));
                    return;
                    
                };
                
                if(target.getEquipamento().getType() == EquipamentType.TANQUE){
                
                    xOrigem = target.getX() - movedLabel.getWidth(); 
                    yOrigem = (target.getY() + 33);
                
                } else if(target.getEquipamento().getId().equals(Constantes.CONEXAO_3_ID)){
                
                    xOrigem = target.getX() - movedLabel.getWidth();
                    yOrigem = target.getY() - movedLabel.getHeight() + GapHelper.CONEXAO_3_Y_GAP;
                
                }else if(target.getEquipamento().getType() == EquipamentType.TORRE_DESTILACAO){

                    xOrigem = target.getX() - movedLabel.getWidth() + GapHelper.TORRE_DESTILACAO_RIGHT_X_GAP;

                    if(target.getEquipamento().isTopAlreadyConnected()){// INFO: Verifica se já há uma conexão no topo direito da torre de destilação. 
                        
                        yOrigem = target.getY() + movedLabel.getHeight() + GapHelper.TORRE_DESTILACAO_RIGHT_BOTTOM_Y_GAP;
                    
                    } else {
                        
                        yOrigem = target.getY() + movedLabel.getHeight() + GapHelper.TORRE_DESTILACAO_RIGHT_TOP_Y_GAP;
                        target.getEquipamento().setTopAlreadyConnected(true);
                        
                    }
                    
                }else{
                    
                    xOrigem = target.getX() - movedLabel.getWidth();
                    yOrigem = target.getY() - movedLabel.getHeight(); 
                    
                }
                
            } else { // movedLabel está à esquerda do alvo
                
                if(!target.getEquipamento().isCanLeftConnect()){
                    
                    InvalidConnectionWidget.notifyInvalidConnection(tr("this_connection_is_invalid"), tr("invalid_connection"));
                    return;
                    
                }
                
                if(target.getEquipamento().getType() == EquipamentType.TANQUE){
                    
                    xOrigem = target.getX() + target.getWidth() - 2;
                    yOrigem = (target.getY() + 163);
                    
                } else if(target.getEquipamento().getId().equals(Constantes.CONEXAO_3_ID)){
                
                    xOrigem = target.getX() + movedLabel.getWidth();
                    
                    if(movedLabel.getEquipamento().getType() == EquipamentType.TUBULACAO){
                        
                        xOrigem = xOrigem + this.getTubToCon3Gap(movedLabel.getEquipamento());
                    
                    }
                    
                    yOrigem = target.getY() - movedLabel.getHeight() + GapHelper.CONEXAO_3_Y_GAP;
                    
                
                } else{
                    
                    xOrigem = target.getX() + (target.getWidth() / 2) - (movedLabel.getWidth() / 2);
                    yOrigem = target.getY() - movedLabel.getHeight(); 
                    
                }
                
            }
            
            movedLabel.setLocation(xOrigem, yOrigem);
            
            
        }
    } // connectEquipament
    
    /**
     * Espelha o equipamento passado por parâmetro
     * 
     * @author Giovane Neves
     * @since V0.0.1
     * @param lbl O equipamento a ser espelhado 
     */
    public void mirrorEquipament(Label lbl){
        
         if(!lbl.getEquipamento().isCanMirroring()){
            return;
        }
        
        String currentImagePath = lbl.getEquipamento().get_caminhoImagem();
        
        String newImagePath = "";
        
        if(!lbl.getEquipamento().isMirrored()){
                
            newImagePath = Constantes.getMirroredEquipament(currentImagePath);
            lbl.getEquipamento().setMirrored(true);

        } else{
            
            newImagePath = Constantes.getNormalEquipament(currentImagePath);
            lbl.getEquipamento().setMirrored(false);
            
        }
        
        lbl.setIcon(new ImageIcon(getClass().getResource(newImagePath)));

        // Lógica para equipamentos especiais
        if(lbl.getEquipamento().getId().equals(Constantes.CONEXAO_3_ID)){
            
            if(!lbl.getEquipamento().isMirrored()){
                
                lbl.setLocation((lbl.getX() - GapHelper.CONEXAO_3_MIRROR_X_GAP), lbl.getY());
                
            } else{
                
                lbl.setLocation((lbl.getX() + GapHelper.CONEXAO_3_MIRROR_X_GAP), lbl.getY());
                
            }
        } 
        
        lbl.getEquipamento().setCanLeftConnect(!lbl.getEquipamento().isCanLeftConnect());
        lbl.getEquipamento().setCanRightConnect(!lbl.getEquipamento().isCanRightConnect());
        
    } // mirrorEquipament
    
    public static void removeEquipament(String lblId, JPanel workspacePanel, Map<String, Label> workspaceMap){
    
        workspacePanel.remove(workspaceMap.get(lblId));
        workspaceMap.remove(lblId);
        workspacePanel.revalidate();
        workspacePanel.repaint();
        
    } // removeEquipament
    
    /**
     * Rotaciona o equipamento passado por parâmetro
     * 
     * @author Giovane Neves
     * @since V0.0.1
     * @param lbl O equipamento a ser rotacionado
     */
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
