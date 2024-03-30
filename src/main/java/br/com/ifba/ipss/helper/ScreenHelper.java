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
import br.com.ifba.ipss.view.AreaDeTrabalho;
import br.com.ifba.ipss.view.TelaSplash;
import javax.swing.JFrame;
// *************************************************//
// ************** { FIM - Imports } ****************//
// *************************************************//

/**
 *
 * @author Giovane Neves
 * @since V0.0.1
 */
public class ScreenHelper {
    
    // *************************************************//
    // ****************** { Atributos } ****************//
    // *************************************************//
    public final static String TELA_SPLASH = "tela_splash";
    public final static String AREA_TRABALHO = "area_de_trabalho";
        
    public static JFrame pegarTela(String nome){
    
        return switch(nome){
            case TELA_SPLASH -> new TelaSplash();
            case AREA_TRABALHO -> new AreaDeTrabalho();
            default -> null;    
        };
            
    } // pegarTela
}
