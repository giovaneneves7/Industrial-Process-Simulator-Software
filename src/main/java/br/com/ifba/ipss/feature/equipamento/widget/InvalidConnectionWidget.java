package br.com.ifba.ipss.feature.equipamento.widget;

import javax.swing.JOptionPane;

/**
 * Modal com aviso de conexão de equipamento inválida
 * 
 * @author Giovane Neves
 * @since V0.0.1
 */
public class InvalidConnectionWidget {
    
    /**
     * 
     * @param message A mensagem da conexão inválida 
     */
    public static void notifyInvalidConnection(String message, String title){
        
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
        
    }
    
}
