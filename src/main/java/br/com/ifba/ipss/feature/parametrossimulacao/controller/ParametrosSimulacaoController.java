package br.com.ifba.ipss.feature.parametrossimulacao.controller;

import br.com.ifba.ipss.feature.parametrossimulacao.widget.ParametrosDaSimulacao;
import br.com.ifba.ipss.feature.resultado.widget.Resultados;
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
    
    public Resultados criarWidgetDeResultados(int pontoCarga, int escoamento, int numeroDeRe){
        
        Resultados resultadosWidget = new Resultados();
        
        resultadosWidget.setBounds(SizeHelper.LARGURA_WIDGET_PARAMETROS_SIMULACAO + 200, SizeHelper.ALTURA_WIDGET_PARAMETROS_SIMULACAO, 170, 150);
        
        return resultadosWidget;
    }
    
}
