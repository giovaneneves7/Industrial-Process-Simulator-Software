// *************************************************//
// *************** { COMEÇO - Package } ************//
// *************************************************//

package br.com.ifba.ipss.feature.parametrossimulacao.controller;

// *************************************************//
// *************** { FIM - Package } ***************//
// *************************************************//

// *************************************************//
// ************ { COMEÇO - Imports } ***************//
// *************************************************//

import br.com.ifba.ipss.feature.parametrossimulacao.widget.ParametrosDaSimulacao;
import br.com.ifba.ipss.feature.resultado.widget.Resultados;
import br.com.ifba.ipss.helper.FormulaHelper;
import br.com.ifba.ipss.helper.SizeHelper;
import br.com.ifba.ipss.infrastructure.interfaces.ApplicationController;
import br.com.ifba.ipss.util.Constantes;
import br.com.ifba.ipss.util.Escoamento;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.Timer;

import lombok.Data;

// *************************************************//
// ************** { FIM - Imports } ****************//
// *************************************************//

/**
 * Controlador do Parâmetros de Simulação
 * 
 * @author Giovane Neves
 * @since V0.0.1
 */
@Data
public class ParametrosSimulacaoController implements ApplicationController{
    
    // INFO: Atributos
    private double velocidade;
    private double viscosidade;
    private double diametroInterno;
    private double perdaCarga;
    private double numeroReynold;
    private String escoamento;
    
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
        
    } // criarWidgetDeParametros
    
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

        
    } // adicionarListenerDeClique
    
   
    public Resultados createResultsWidget(){
        
        Resultados resultadosWidget = new Resultados(this.numeroReynold, this.escoamento, this.perdaCarga);
        
        resultadosWidget.setBounds(SizeHelper.LARGURA_ESPACO_TRABALHO / 30, 
                SizeHelper.ALTURA_ESPACO_TRABALHO - 300, 
                SizeHelper.RESULTADOS_WIDTH, 
                SizeHelper.RESULTADOS_HEIGH
        );
        
        return resultadosWidget;
        
    } // createResultsWidget
    
    public void setPerdaCarga(){
        
        if(this.escoamento.equals(Escoamento.ESCOAMENTO_LAMINAR)){
            
            /**
             * l = Soma do comprimento de todas as tubulações.
             */
            this.perdaCarga = FormulaHelper.EQUACAO_DE_POISEULLE(30, this.velocidade, this.viscosidade, this.diametroInterno);
            
        } else{
            
            this.perdaCarga = FormulaHelper.EQUACAO_DE_DARCY_WEISBACH(30, this.diametroInterno, this.velocidade);
            
        }
        
    } // setPerdaCarga
    
}
