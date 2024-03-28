package br.com.ifba.ipss.common.controller;

import br.com.ifba.ipss.helper.PathHelper;
import br.com.ifba.ipss.util.Constantes;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author Giovane Neves
 * @since V0.0.1
 */
public class ViewController {
    
    public static void definirTituloAplicacao(JFrame f){
        
        f.setTitle(Constantes.NOME_APLICACAO);
        
    }
    
    public static void definirLogoAplicacao(JFrame f, Image img){
        
        f.setIconImage(
                img
        );
        
    }
    
}
