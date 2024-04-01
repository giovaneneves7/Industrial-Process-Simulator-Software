package br.com.ifba.ipss.common.controller;

import br.com.ifba.ipss.feature.label.domain.model.Label;
import javax.swing.JPanel;

/**
 *
 * @author Giovane Neves
 * @since V0.0.1
 */
public class BotaoRemoverEquipamentoController {
    
    public void removerEquipamento(JPanel p, Label lbl){
        
        p.remove(lbl);
        
    }
    
}
