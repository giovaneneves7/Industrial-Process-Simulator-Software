package br.com.ifba.ipss.feature.parametrossimulacao.controller;

import br.com.ifba.ipss.feature.parametrossimulacao.widget.ParametrosDaSimulacao;
import br.com.ifba.ipss.feature.resultado.widget.Resultados;
import br.com.ifba.ipss.helper.SizeHelper;
import br.com.ifba.ipss.util.Constantes;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.Timer;

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
        this.adicionarListenerDeClique(pnlParametrosSimulacao);
        
        return pnlParametrosSimulacao;
        
        
        
    }
    
    int mouseX, mouseY;
    public void adicionarListenerDeClique(ParametrosDaSimulacao ps){
        
        Timer timer = new Timer(100, ev -> {
            
                int deltaX = ps.getX() + mouseX;
                int deltaY = ps.getY() + mouseY;
                ps.setLocation(deltaX, deltaY);

        });
        
        Timer tempoPressionado = new Timer(150, e ->{
            
            if(!timer.isRunning())
                timer.start();
            
        });
        
        
        ps.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                
                if (!tempoPressionado.isRunning()) {
                    tempoPressionado.start();
                }
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                
                timer.stop();
                tempoPressionado.stop();
            
            }
            
            @Override
            public void mouseEntered(MouseEvent me) {
                ps.setBorder(BorderFactory.createLineBorder(Constantes.COR_PRIMARIA));
            }

            @Override
            public void mouseExited(MouseEvent me){
                
                ps.setBorder(null);
                
            }
        });

        
    }
    public Resultados criarWidgetDeResultados(double perdaCarga, String escoamento, double numeroDeRe){
        
        Resultados resultadosWidget = new Resultados(numeroDeRe, escoamento, perdaCarga);
        
        resultadosWidget.setBounds(
                SizeHelper.LARGURA_ESPACO_TRABALHO / 30, 
                SizeHelper.ALTURA_ESPACO_TRABALHO - 300, 
                170, 
                150
        );
        
        return resultadosWidget;
    }
    
}
