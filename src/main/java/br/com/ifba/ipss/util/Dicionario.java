package br.com.ifba.ipss.util;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Giovane Neves
 * @since V0.0.1
 */
public class Dicionario {
    
    public static final HashMap<String, List<String>> DICIONARIO = new HashMap<>();
    
    static {

        DICIONARIO.put("conexao", List.of("Conexão", "Conexões"));
        DICIONARIO.put("deseja_limpar_a_area_de_trabalho", List.of("Deseja limpar a Área de Trabalho?"));
        DICIONARIO.put("deseja_salvar_a_area_de_trabalho", List.of("Deseja salvar a Área de Trabalho?"));
        DICIONARIO.put("di", List.of("Di"));
        DICIONARIO.put("equipamento", List.of("Equipamento", "Equipamentos"));
        DICIONARIO.put("l", List.of("L"));
        DICIONARIO.put("limpar_area_trabalho", List.of("Limpar Área de Trabalho"));
        DICIONARIO.put("modo_conexao_ativado", List.of("Modo Conexão: Ativado"));
        DICIONARIO.put("modo_conexao_desativado", List.of("Modo Conexão: Desativado"));
        DICIONARIO.put("modo_remocao_ativado", List.of("Modo Remoção: Ativado"));
        DICIONARIO.put("modo_remocao_desativado", List.of("Modo Remoção: Desativado"));
        DICIONARIO.put("modo_rotacao_ativado", List.of("Modo Rotação: Ativado"));
        DICIONARIO.put("modo_rotacao_desativado", List.of("Modo Rotação: Desativado"));
        DICIONARIO.put("salvar_area_trabalho", List.of("Salvar Área de Trabalho"));
        DICIONARIO.put("titulo_aplicacao", List.of(Constantes.NOME_APLICACAO));
        DICIONARIO.put("tubulacao", List.of("Tubulação", "Tubulações"));
        DICIONARIO.put("valvula", List.of("Válvula", "Válvulas"));
    }
    
    public static String tr(String chave){
        
        if(DICIONARIO.containsKey(chave))
            return DICIONARIO.get(chave).getFirst();
        
        return chave;
        
    }
    
    public static String trToPlural(String chave){
        
        if(DICIONARIO.containsKey(chave)){
            
            return (DICIONARIO.get(chave).size() > 1) ? DICIONARIO.get(chave).getLast() : chave;
            
        }
        
        return chave;
        
    }
    
}
