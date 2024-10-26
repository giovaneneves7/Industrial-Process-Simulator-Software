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
import br.com.ifba.ipss.feature.equipamento.widget.WarningModal;
import br.com.ifba.ipss.feature.label.domain.model.Label;
import br.com.ifba.ipss.feature.tubulacao.domain.model.Tubulacao;
import br.com.ifba.ipss.helper.GapHelper;
import br.com.ifba.ipss.infrastructure.interfaces.ApplicationController;
import br.com.ifba.ipss.util.Constantes;
import br.com.ifba.ipss.util.EquipamentType;
import br.com.ifba.ipss.util.Util;

import java.awt.Container;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.List;
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

    private List<Label> equipamentosLinkedList = new LinkedList<>();
    private final IEquipamentoService equipamentoService;
    
    /**
     * Adiciona o equipamento na lista encadeada de equipamentos
     * 
     * @author Giovane Neves
     * @since V0.0.1
     * @param equipamento O equipamento a ser adicionado na lista encadeada. 
     */
    private void addEquipamentoToTheLinkedList(Label equipamento){
        
        this.equipamentosLinkedList.add(equipamento);
        
    } // addEquipamentoToTheLinkedList
    
    public double calculateTubulacaoLength(){
        
        return this.equipamentosLinkedList.stream()
            .filter(label -> label.getEquipamento().getType() == EquipamentType.TUBULACAO)
            .mapToDouble(label -> ((Tubulacao) label.getEquipamento()).getLength())  
            .sum();

    } // calculateTubulacaoLength
    
    /**
     * Construtor da Classe
     * 
     * @author Giovane Neves
     * @since V0.0.1
     * @param equipamentoService O service do equipamento
     */
    public EquipamentoController(IEquipamentoService equipamentoService){
        
       this.equipamentoService = equipamentoService;
        
    } // EquipamentoController
    
    /**
     * Verifica se os tipos de equipamentos são compatíveis para a conexão
     * 
     * @author Giovane Neves
     * @since V0.0.1
     * @param target O alvo que receberá a conexão
     * @param movedEquipament O equipamento movido que fará a conexão
     * @return 'true' caso a conexão seja permitida, 'false' caso contrário
    */
    private static boolean canConnect(EquipamentType target, EquipamentType movedEquipament){
                
        return  (target == EquipamentType.CONEXAO && movedEquipament == EquipamentType.REATOR) ? false
                : (target == EquipamentType.CONEXAO && movedEquipament == EquipamentType.CONEXAO) ? false
                
                : (target == EquipamentType.REATOR && movedEquipament == EquipamentType.BOMBA_CENTRIFUGA) ? false 
                : (target == EquipamentType.REATOR && movedEquipament == EquipamentType.CONEXAO) ? false
                : (target == EquipamentType.REATOR && movedEquipament == EquipamentType.TANQUE) ? false
                : (target == EquipamentType.REATOR && movedEquipament == EquipamentType.TORRE_DESTILACAO) ? false
                : (target == EquipamentType.REATOR && movedEquipament == EquipamentType.TROCADOR_CALOR) ? false
                : (target == EquipamentType.REATOR && movedEquipament == EquipamentType.VALVULA) ? false
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
                
                : (target == EquipamentType.VALVULA && movedEquipament == EquipamentType.VALVULA) ? false
        
                : true;
        
    } // canConnect
    
    public boolean emptyLinkedList(){
    
        return this.equipamentosLinkedList.isEmpty();
        
    }
    
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
        
        System.out.println("Target Axios");
        System.out.println(target.getEquipamento().getAxios());
        System.out.println("MovedLabel Axios");
        System.out.println(movedLabel.getEquipamento().getAxios());
        
        // INFO: Verifica se o tipo dos equipamentos é compatível para a conexão
        if(!canConnect(target.getEquipamento().getType(), movedLabel.getEquipamento().getType())){
            
            WarningModal.createWarningModal(tr("this_connection_is_invalid"), tr("invalid_connection"));
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
            
            if(movedLabel.getEquipamento().getId().equals(Constantes.VALVULA_GLOBO_ID)){
                    
                yOrigem = yOrigem - GapHelper.VALVULA_GLOBO_Y_GAP;
                    
            }

            
            movedLabel.setLocation(xOrigem, yOrigem);
            
        } else if(target.getEquipamento().getAxios().equals(Constantes.VERTICAL) && movedLabel.getEquipamento().getAxios().equals(Constantes.VERTICAL)){ // Ambos os equipamentos na vertical
            
            int diferencaY = movedLabel.getY() - target.getY(); 
   
            if (diferencaY <= 0) { // lblMovido está acima do alvo
                
                if(!target.getEquipamento().isCanTopConnect()){
                 
                    WarningModal.createWarningModal(tr("this_connection_is_invalid"), tr("invalid_connection"));
                    return;
                    
                }
                
                int xOrigem = 0, yOrigem = 0;
                
                if(target.getEquipamento().getType() == EquipamentType.BOMBA_CENTRIFUGA){
                    
                    xOrigem = target.getX();
                    yOrigem = (target.getY() - movedLabel.getHeight());
                    
                } else if(target.getEquipamento().getId().equals(Constantes.CONEXAO_1_ID)){
                
                    xOrigem = target.getX() + (target.getWidth() / 2) - (movedLabel.getWidth() / 2) + GapHelper.CONEXAO_1_TOP_X_GAP;
                    yOrigem = target.getY() - movedLabel.getHeight();
                
                } else if(target.getEquipamento().getId().equals(Constantes.CONEXAO_2_ID)){
                
                    xOrigem = (target.getX() + (target.getWidth() / 2) - (movedLabel.getWidth() / 2) - GapHelper.CONEXAO_2_TOP_X_GAP);
                    yOrigem = (target.getY() - movedLabel.getHeight() + GapHelper.CONEXAO_2_TOP_Y_GAP);
                
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
                
                } else if(target.getEquipamento().getType() == EquipamentType.TUBULACAO && movedLabel.getEquipamento().getId().equals(Constantes.CONEXAO_3_ID)){
                
                    xOrigem = target.getX() + (target.getWidth() / 2) - (movedLabel.getWidth() / 2);
                    yOrigem = target.getY() - movedLabel.getHeight();
                
                
                }else{
                    
                    xOrigem = target.getX() + (target.getWidth() / 2) - (movedLabel.getWidth() / 2);
                    yOrigem = target.getY() - movedLabel.getHeight();
                
                }
                
                if(movedLabel.getEquipamento().getId().equals(Constantes.CONEXAO_1_ID)){

                    xOrigem = (xOrigem - GapHelper.CONEXAO_1_X_GAP);

                } else if(movedLabel.getEquipamento().getId().equals(Constantes.CONEXAO_3_ID)){

                    xOrigem = (xOrigem - GapHelper.CONEXAO_3_X_GAP);

                } else if(movedLabel.getEquipamento().getType() == EquipamentType.TUBULACAO && target.getEquipamento().getType() == EquipamentType.VALVULA){
                
                    xOrigem = (xOrigem - GapHelper.VALVULAS_TUBULACAO_X_GAP);
                
                }else if(movedLabel.getEquipamento().getId().equals(Constantes.VALVULA_ESFERA_ID)){
                    
                    xOrigem = (xOrigem + GapHelper.VALVULA_ESFERA_X_GAP);
                    
                } else if(movedLabel.getEquipamento().getId().equals(Constantes.VALVULA_GAVETA_ID)){
                    
                    xOrigem = (xOrigem + GapHelper.VALVULA_GAVETA_X_GAP);
                    
                } else if(movedLabel.getEquipamento().getId().equals(Constantes.VALVULA_GLOBO_ID)){
                    
                    xOrigem = (xOrigem + GapHelper.VALVULA_GLOBO_X_GAP);
                    
                }
                
                movedLabel.setLocation(xOrigem, yOrigem); 
                
            } else { // lblMovido está abaixo do alvo
                
                if(!target.getEquipamento().isCanBottomConnect()){
                 
                    WarningModal.createWarningModal(tr("this_connection_is_invalid"), tr("invalid_connection"));
                    return;
                    
                }
                
                int xOrigem = 0;
                int yOrigem = 0;
                
                if(target.getEquipamento().getType() == EquipamentType.TORRE_DESTILACAO){
                
                    xOrigem = target.getX() + (target.getWidth() / 2) - (movedLabel.getWidth() / 2) + GapHelper.TORRE_DESTILACAO_BOTTOM_X_GAP;
                    yOrigem = (diferencaY < 0) ? target.getY() - movedLabel.getHeight() : target.getY() + target.getHeight();
                
                } else if(target.getEquipamento().getId().equals(Constantes.CONEXAO_1_ID)){
                
                    xOrigem = (target.getX() + (target.getWidth() / 2) - (movedLabel.getWidth() / 2) + GapHelper.CONEXAO_1_BOTTOM_X_GAP);
                    yOrigem = (diferencaY < 0) ? (target.getY() - movedLabel.getHeight()) : (target.getY() + target.getHeight());
                
                } else if(target.getEquipamento().getId().equals(Constantes.CONEXAO_2_ID)){
                
                    xOrigem = (target.getX() + (target.getWidth() / 2) - (movedLabel.getWidth() / 2) - GapHelper.CONEXAO_2_BOTTOM_X_GAP);
                    yOrigem = (diferencaY < 0) ? target.getY() - movedLabel.getHeight() : target.getY() + target.getHeight();
 
                
                }else if(target.getEquipamento().getId().equals(Constantes.CONEXAO_3_ID)){
                
                    if(!target.getEquipamento().isMirrored()){
                        
                        xOrigem = target.getX() + (target.getWidth() / 2) - (movedLabel.getWidth() / 2) + GapHelper.CONEXAO_3_BOTTOM_X_GAP;
                        
                    } else{
                        
                        xOrigem = target.getX() + (target.getWidth() / 2) - (movedLabel.getWidth() / 2) - GapHelper.TUBULACAO_CONEXAO_3_MIRRORED_X_GAP;
                    
                    }
                  
                    yOrigem = (diferencaY < 0) ? target.getY() - movedLabel.getHeight() : target.getY() + target.getHeight();
                
                } else{
                
                    xOrigem = target.getX() + (target.getWidth() / 2) - (movedLabel.getWidth() / 2);
                    yOrigem = (diferencaY < 0) ? target.getY() - movedLabel.getHeight() : target.getY() + target.getHeight();
 
                }
                
                if(movedLabel.getEquipamento().getId().equals(Constantes.CONEXAO_1_ID)){
                
                    xOrigem = (xOrigem - GapHelper.CONEXAO_1_X_GAP);
                
                } else if(movedLabel.getEquipamento().getType() == EquipamentType.REATOR){
                
                    xOrigem = (xOrigem + GapHelper.REATOR_TUBULACAO_X_GAP);
                    yOrigem = (yOrigem - GapHelper.REATOR_TUBULACAO_Y_GAP);
                    
                } else if(movedLabel.getEquipamento().getType() == EquipamentType.TORRE_DESTILACAO){
                    
                    xOrigem = (xOrigem - GapHelper.TORRE_DE_DESTILACAO_X_GAP);
                    
                } else if(movedLabel.getEquipamento().getType() == EquipamentType.BOMBA_CENTRIFUGA){
                    
                    xOrigem = (xOrigem + GapHelper.BOMBA_CENTRIFUGA_TUBULACAO_X_GAP);
                    
                }
                
                movedLabel.setLocation(xOrigem, yOrigem);
                
            }
            
        } else if (target.getEquipamento().getAxios().equals(Constantes.HORIZONTAL) && movedLabel.getEquipamento().getAxios().equals(Constantes.VERTICAL)) {

            int diferencaX = movedLabel.getX() - target.getX();
            int diferencaY = movedLabel.getY() - target.getY();
            int xOrigem = 0;
            int yOrigem = 0;

            // Conexão à esquerda
            if (diferencaX <= 0) {
                if (!target.getEquipamento().isCanLeftConnect()) {
                    WarningModal.createWarningModal(tr("this_connection_is_invalid"), tr("invalid_connection"));
                    return;
                }
                xOrigem = target.getX() - movedLabel.getWidth();
                yOrigem = target.getY();
            }
            // Conexão à direita
            else {
                if (!target.getEquipamento().isCanRightConnect()) {
                    WarningModal.createWarningModal(tr("this_connection_is_invalid"), tr("invalid_connection"));
                    return;
                }
                xOrigem = target.getX() + target.getWidth();
                yOrigem = target.getY();
            }

            movedLabel.setLocation(xOrigem, yOrigem);

            // Conexão acima
            if (diferencaY <= 0) {
                if (!target.getEquipamento().isCanTopConnect()) {
                    WarningModal.createWarningModal(tr("this_connection_is_invalid"), tr("invalid_connection"));
                    return;
                }

                if (target.getEquipamento().getType() == EquipamentType.TROCADOR_CALOR) {
                    xOrigem = (target.getX() + (target.getWidth() / 2) - (movedLabel.getWidth() / 2)) - GapHelper.TROCADOR_CALOR_TOP_X_GAP;
                } else {
                    xOrigem = target.getX() + (target.getWidth() / 2) - (movedLabel.getWidth() / 2);
                }
                yOrigem = target.getY() - movedLabel.getHeight();

                movedLabel.setLocation(xOrigem, yOrigem);
            }
            // Conexão abaixo
            else {
                if (!target.getEquipamento().isCanBottomConnect()) {
                    WarningModal.createWarningModal(tr("this_connection_is_invalid"), tr("invalid_connection"));
                    return;
                }

                if (target.getEquipamento().getType() == EquipamentType.TROCADOR_CALOR) {
                    xOrigem = (target.getX() + (target.getWidth() / 2) - (movedLabel.getWidth() / 2)) + GapHelper.TROCADOR_CALOR_BOTTOM_X_GAP;
                } else {
                    xOrigem = target.getX() + (target.getWidth() / 2) - (movedLabel.getWidth() / 2);
                }
                yOrigem = target.getY() + target.getHeight();

                movedLabel.setLocation(xOrigem, yOrigem);
            }
        //}

            
        } else{ // O alvo está na vertical e o equipamento a se conectar está na horizontal
            
            if(!target.getEquipamento().isCanLeftConnect() && !target.getEquipamento().isCanRightConnect()){
                
                WarningModal.createWarningModal(tr("this_connection_is_invalid"), tr("invalid_connection"));
                return;
                
            }
            
            int diferencaX = movedLabel.getX() - target.getX();
            int xOrigem = 0;
            int yOrigem = 0;
            
            if(diferencaX <= 0) { // movedLabel está à direita do alvo
                if(!target.getEquipamento().isCanRightConnect()){

                    WarningModal.createWarningModal(tr("this_connection_is_invalid"), tr("invalid_connection"));
                    return;
                    
                }
                
                if(target.getEquipamento().getType() == EquipamentType.TANQUE){
                
                    xOrigem = target.getX() - movedLabel.getWidth(); 
                    yOrigem = (target.getY() + 33);
                
                } else if(target.getEquipamento().getId().equals(Constantes.CONEXAO_2_ID)){
                    
                    xOrigem = target.getX() - movedLabel.getWidth(); 
                    yOrigem = (target.getY() + GapHelper.CONEXAO_2_RIGHT_Y_GAP);
                    
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
                    
                    WarningModal.createWarningModal(tr("this_connection_is_invalid"), tr("invalid_connection"));
                    return;
                    
                }
                
                if(target.getEquipamento().getType() == EquipamentType.TANQUE){
                    
                    xOrigem = target.getX() + target.getWidth() - 2;
                    yOrigem = (target.getY() + 163);
                    
                } else if(target.getEquipamento().getId().equals(Constantes.CONEXAO_2_ID)){
                
                    xOrigem = target.getX() + target.getWidth() - GapHelper.CONEXAO_2_LEFT_X_GAP;
                    yOrigem = (target.getY() + GapHelper.CONEXAO_2_LEFT_Y_GAP);
                
                }else if(target.getEquipamento().getId().equals(Constantes.CONEXAO_3_ID)){
                
                    xOrigem = target.getX() + movedLabel.getWidth();
                    
                    if(movedLabel.getEquipamento().getType() == EquipamentType.TUBULACAO){
                        
                        xOrigem = xOrigem + this.getTubToCon3Gap(movedLabel.getEquipamento());
                    
                    }
                    
                    yOrigem = target.getY() - movedLabel.getHeight() + GapHelper.CONEXAO_3_Y_GAP;
                    
                
                } else if(target.getEquipamento().getType() == EquipamentType.BOMBA_CENTRIFUGA){
                
                    xOrigem = target.getX() + (target.getWidth() / 2) - (movedLabel.getWidth() / 2) + GapHelper.TUBULACAO_BOMBA_CENTRIFUGA_X_GAP;
                    yOrigem = target.getY() - movedLabel.getHeight() + GapHelper.TUBULACAO_BOMBA_CENTRIFUGA_Y_GAP;
                
                }else{
                    
                    xOrigem = target.getX() + (target.getWidth() / 2) - (movedLabel.getWidth() / 2);
                    yOrigem = target.getY() - movedLabel.getHeight(); 
                    
                }
                
            }
            
            movedLabel.setLocation(xOrigem, yOrigem);
            movedLabel.getEquipamento().setConnected(true);
            target.getEquipamento().setConnected(true);
            
            this.addEquipamentoToTheLinkedList(movedLabel);
            
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
            
            WarningModal.createWarningModal(tr("equipamento_nao_pode_ser_espelhado"), tr("espelhar_equipamento"));
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
        
        boolean canLeftConnect = lbl.getEquipamento().isCanLeftConnect();
        boolean canRightConnect = lbl.getEquipamento().isCanRightConnect();
        
        lbl.getEquipamento().setCanLeftConnect(canRightConnect);
        lbl.getEquipamento().setCanRightConnect(canLeftConnect);
        
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
        
        System.out.println("Axios: ");
        System.out.println(lbl.getEquipamento().getAxios());
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
        
        boolean canRightConnect = lbl.getEquipamento().isCanRightConnect();
        boolean canBottomConnect = lbl.getEquipamento().isCanBottomConnect();
        boolean canLeftConnect = lbl.getEquipamento().isCanLeftConnect();
        
        lbl.getEquipamento().setCanRightConnect(lbl.getEquipamento().isCanTopConnect());
        lbl.getEquipamento().setCanBottomConnect(canRightConnect);
        lbl.getEquipamento().setCanLeftConnect(canBottomConnect);
        lbl.getEquipamento().setCanTopConnect(canLeftConnect);
        
        // Lógica de rotacionar personalizada para a tubulação
        if(lbl.getEquipamento().getType() == EquipamentType.CONEXAO){
            
            lbl.getEquipamento().setCanTopConnect(lbl.getEquipamento().getAxios().equals(Constantes.VERTICAL));
            
        }
    } // rotateEquipament
    
    
    
    
}
