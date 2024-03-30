package br.com.ifba.ipss.feature.parametrossimulacao.controller;

import br.com.ifba.ipss.feature.parametrossimulacao.widget.ParametrosDaSimulacao;
import br.com.ifba.ipss.helper.SizeHelper;
import javax.swing.JPanel;

/**
 *
 * @author Giovane Neves
 * @since V0.0.1
 */
public class ParametrosSimulacaoController {
    
    public ParametrosDaSimulacao criarWidgetDeParametros(int x, int y){
        
        ParametrosDaSimulacao pnlParametrosSimulacao = new ParametrosDaSimulacao();
        pnlParametrosSimulacao.setBounds(
                x, 
                y, 
                SizeHelper.LARGURA_WIDGET_PARAMETROS_SIMULACAO,
                SizeHelper.ALTURA_WIDGET_PARAMETROS_SIMULACAO
        );
        
        return pnlParametrosSimulacao;
        
        
        
    }
    
}
