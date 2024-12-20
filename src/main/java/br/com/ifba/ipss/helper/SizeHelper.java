// *************************************************//
// *************** { COMEÇO - Package } ************//
// *************************************************//
package br.com.ifba.ipss.helper;
// *************************************************//
// *************** { FIM - Package } ***************//
// *************************************************//

// *************************************************//
// ************ { COMEÇO - Imports } ***************//
// *************************************************//

import java.awt.Dimension;
import java.awt.Toolkit;

// *************************************************//
// ************** { FIM - Imports } ****************//
// *************************************************//


/**
 * Helper para guardar tamanhos padrões dos elementos que estarão na interface gráfica.
 * 
 * @author Giovane Neves
 * @since V0.0.1
 */
public class SizeHelper {
    
    // *************************************************//
    // ***************** { Atributos } *****************//
    // *************************************************//
    
    public static final Dimension TAMANHO_TELA                  = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int LARGURA_TELA                        = TAMANHO_TELA.width;
    public static final int ALTURA_TELA                         = TAMANHO_TELA.height;
    public static final int LARGURA_TELA_SPLASH                 = 840;
    public static final int ALTURA_TELA_SPLASH                  = 700;  
    public static final int LARGURA_MENU_LATERAL                = 150;
    public static final int ALTURA_MENU_LATERAL                 = 820;
    public static final int LARGURA_FERRAMENTA_CONTAINER        = 100;
    public static final int ALTURA_FERRAMENTA_CONTAINER         = 100; 
    public static final int LARGURA_WIDGET_PARAMETROS_SIMULACAO = 320;
    public static final int ALTURA_WIDGET_PARAMETROS_SIMULACAO  = 220;
    public static final int LARGURA_ESPACO_TRABALHO             = 1250;
    public static final int ALTURA_ESPACO_TRABALHO              = 710;
    
    public static final int RESULTADOS_HEIGH                    = 150;
    public static final int RESULTADOS_WIDTH                    = 175;
}
