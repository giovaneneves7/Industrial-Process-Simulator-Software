// *************************************************//
// *************** { COMEÇO - Package } ************//
// *************************************************//
package br.com.ifba.ipss.common.controller;
// *************************************************//
// *************** { FIM - Package } ***************//
// *************************************************//

// *************************************************//
// ************ { COMEÇO - Imports } ***************//
// *************************************************//
import static br.com.ifba.ipss.util.Dicionario.tr;

import java.awt.Image;
import javax.swing.JFrame;
// *************************************************//
// ************** { FIM - Imports } ****************//
// *************************************************//

/**
 *
 * @author Giovane Neves
 * @since V0.0.1
 */
public class ViewController {
    
    public static void definirTituloAplicacao(JFrame f){
        
        f.setTitle(tr("titulo_aplicacao"));
        
    }
    
    public static void definirLogoAplicacao(JFrame f, Image img){
        
        f.setIconImage(
                img
        );
        
    }
    
}
