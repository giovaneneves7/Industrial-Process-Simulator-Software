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
import br.com.ifba.ipss.infrastructure.interfaces.ApplicationController;
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
public class ViewController implements ApplicationController{
    
    public static void defineScreenTitle(JFrame f){
        
        f.setTitle(tr("titulo_aplicacao"));
        
    }
    
    public void defineScreenTitle(JFrame f, String name){
        
        f.setTitle(name);
    
    }
    
    public static void definirLogoAplicacao(JFrame f, Image img){
        
        f.setIconImage(
                img
        );
        
    }
    
}
