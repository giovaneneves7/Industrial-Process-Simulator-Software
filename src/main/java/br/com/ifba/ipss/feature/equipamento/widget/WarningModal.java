package br.com.ifba.ipss.feature.equipamento.widget;

import br.com.ifba.ipss.util.Constantes;
import javax.swing.JOptionPane;

/**
 * Modal com aviso de conexão de equipamento inválida
 * 
 * @author Giovane Neves
 * @since V0.0.1
 */
public class WarningModal {
    
    public static int createWarningSelectionModal(String message, String title){
    
        return JOptionPane.showOptionDialog(null, message, title, JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, Constantes.SIM_NAO, Constantes.SIM_NAO[0]);
        
    } // createWarningSelectionModal
    
    /**
     * 
     * @param message A mensagem do modal 
     * @param title O título do modal
     */
    public static void createWarningModal(String message, String title){
        
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
        
    } // createWarningModal
    
}
