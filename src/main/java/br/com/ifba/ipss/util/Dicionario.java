package br.com.ifba.ipss.util;

import java.util.HashMap;

/**
 *
 * @author Giovane Neves
 * @since V0.0.1
 */
public class Dicionario {
    
    public static final HashMap<String, String> DICIONARIO = new HashMap<>();
    
    static {
        
        DICIONARIO.put("modo_remocao_ativado", "Modo Remoção: Ativado");
        DICIONARIO.put("modo_remocao_desativado", "Modo Remoção: Desativado");
    }
    
    public static String tr(String chave){
        
        if(DICIONARIO.containsKey(chave))
            return DICIONARIO.get(chave);
        
        return chave;
        
    }
    
}
