package br.com.ifba.ipss.helper;

import java.io.InputStream;

/**
 *
 * @author Giovane Neves
 * @since V0.0.1
 */
public class PathHelper {
    
    // *************************************************//
    // ***************** { Atributos } *****************//
    // *************************************************//
    
    // - Imagens 
    public static final String LOGO = "/images/logo.jpg";
    public static final String BOTAO_REMOVER = "/images/botao_remover.png";
    
    // - Arquivos
    public static final String FERRAMENTAS_JSON = "/files/ferramentas.json";
    
    public static InputStream pegarFerramentasInputStream() {
        
        return PathHelper.class.getResourceAsStream(FERRAMENTAS_JSON);
    
    }
    
}
