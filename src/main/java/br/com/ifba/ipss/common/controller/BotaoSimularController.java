package br.com.ifba.ipss.common.controller;

import br.com.ifba.ipss.feature.parametrossimulacao.controller.ParametrosSimulacaoController;
import br.com.ifba.ipss.feature.parametrossimulacao.widget.ParametrosDaSimulacao;
import br.com.ifba.ipss.helper.SizeHelper;
import javax.swing.JPanel;

/**
 *
 * @author Giovane Neves
 * @since V0.0.1
 */
public class BotaoSimularController {
    
    private final ParametrosSimulacaoController parametrosSimulacaoController;
    
    public BotaoSimularController(){
        
        this.parametrosSimulacaoController = new ParametrosSimulacaoController();
        
    }
    
    public void exibirWidgetDeParametrosSimulacao(JPanel p){
        
        ParametrosDaSimulacao parametrosDaSimulacaoWidget = this.parametrosSimulacaoController.criarWidgetDeParametros(
                0,
                0

        );
        
        p.add(parametrosDaSimulacaoWidget);
        
        p.revalidate();
        p.repaint();
        
    }
    
}
