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
import br.com.ifba.ipss.view.Instructions;
import br.com.ifba.ipss.view.ListaSimulacoes;
import br.com.ifba.ipss.view.TelaInicial;
import br.com.ifba.ipss.view.TelaSplash;
import java.util.Stack;

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
    public final static String TELA_INICIAL = "tela_inicial";
    public final static String LISTA_SIMULACOES = "lista_simulacoes";
    public final static String TELA_INSTRUCOES = "instrucoes";
    
    public final static Stack<JFrame> SCREEN_STACK = new Stack<>();
    
    // *************************************************//
    // ****************** { Métodos } ******************//
    // *************************************************//

    public static String getTelaDeTrabalho(){
        
        return AREA_TRABALHO;
        
    }
    
    public static String getTelaDeTrabalho(String query){
        
        return AREA_TRABALHO.concat(query);
        
    }
    /**
     * Pega a tela com o nome passado por parâmetro.
     * @author Giovane Neves
     * @param nome O nome da tela.
     * @return a tela com o nome passado por parâmetro, ou 'null' caso a tela não exista.
     */
    public static JFrame getScreen(String nome){
    
        return switch(nome){
            case TELA_SPLASH -> new TelaSplash();
            //case AREA_TRABALHO -> new AreaDeTrabalho();
            case TELA_INICIAL  -> new TelaInicial();
            case LISTA_SIMULACOES -> new ListaSimulacoes();
            case TELA_INSTRUCOES -> new Instructions();
            default -> null;    
        };
            
    } // getScreen
    
    public static JFrame pegarTela(String nome, String query){
    
        return switch(nome){
            case TELA_SPLASH -> new TelaSplash();
            case AREA_TRABALHO -> new AreaDeTrabalho(query);
            case TELA_INICIAL  -> new TelaInicial();
            case LISTA_SIMULACOES -> new ListaSimulacoes();
            default -> null;    
        };
            
    } // getScreen
    
    public static void addToScreenStack(JFrame currentScreen){
        
        SCREEN_STACK.add(currentScreen);
        
    }
    
    
} // ScreenHelper
