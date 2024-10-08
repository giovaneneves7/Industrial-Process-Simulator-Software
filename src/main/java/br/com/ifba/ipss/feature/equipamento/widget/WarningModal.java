package br.com.ifba.ipss.feature.equipamento.widget;

import javax.swing.JOptionPane;

/**
 * Modal com aviso de conexão de equipamento inválida
 * 
 * @author Giovane Neves
 * @since V0.0.1
 */
public class WarningModal {
    
    /**
     * 
     * @param message A mensagem da conexão inválida 
     */
    public static void createWarningModal(String message, String title){
        
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
        
    }
    
}
