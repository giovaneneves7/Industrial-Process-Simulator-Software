// *************************************************//
// *************** { COMEÇO - Package } ************//
//// ***********************************************//

package br.com.ifba.ipss.util;

// *************************************************//
// *************** { FIM - Package } ***************//
// *************************************************//

// *************************************************//
// ************ { COMEÇO - Imports } ***************//
// *************************************************//

import java.util.HashMap;
import java.util.List;

// *************************************************//
// ************** { FIM - Imports } ****************//
// *************************************************//

/**
 *
 * @author Giovane Neves
 * @since V0.0.1
 */
public class Dicionario {
    
    public static final HashMap<String, List<String>> DICIONARIO = new HashMap<>();
    
    static {

        DICIONARIO.put("area_de_trabalho_deletada_com_sucesso", List.of("Área de Trabalho deletada com sucesso!"));
        DICIONARIO.put("area_de_trabalho_salva_com_sucesso", List.of("Área de Trabalho salva com sucesso!"));
        DICIONARIO.put("arquivo_ja_existe", List.of("O Nome de Arquivo Informado Já Está em Uso!"));
        DICIONARIO.put("buscar", List.of("Buscar"));
        DICIONARIO.put("carregar_simulacao", List.of("Carregar Simulação"));
        DICIONARIO.put("conexao", List.of("Conexão", "Conexões"));
        DICIONARIO.put("deseja_limpar_a_area_de_trabalho", List.of("Deseja limpar a Área de Trabalho?"));
        DICIONARIO.put("deseja_salvar_a_area_de_trabalho", List.of("Deseja salvar a Área de Trabalho?"));
        DICIONARIO.put("di", List.of("Di"));
        DICIONARIO.put("equipamento", List.of("Equipamento", "Equipamentos"));
        DICIONARIO.put("erro", List.of("Erro", "Erros"));
        DICIONARIO.put("erro_criacao_arquivo", List.of("Ocorreu um erro ao criar o arquivo"));
        DICIONARIO.put("erro_ao_deletar_area_trabalho", List.of("Ocorreu um erro ao deletar a área de trabalho!"));
        DICIONARIO.put("erro_ao_salvar_area_trabalho", List.of("Ocorreu um erro ao salvar a área de trabalho!"));
        DICIONARIO.put("insira_o_nome_da_simulacao", List.of("Insira o Nome da Simulação"));
        DICIONARIO.put("instrucoes", List.of("Instruções"));
        DICIONARIO.put("l", List.of("L"));
        DICIONARIO.put("limpar_area_trabalho", List.of("Limpar Área de Trabalho"));
        DICIONARIO.put("modo_conexao_ativado", List.of("Modo Conexão: Ativado"));
        DICIONARIO.put("modo_conexao_desativado", List.of("Modo Conexão: Desativado"));
        DICIONARIO.put("modo_remocao_ativado", List.of("Modo Remoção: Ativado"));
        DICIONARIO.put("modo_remocao_desativado", List.of("Modo Remoção: Desativado"));
        DICIONARIO.put("modo_rotacao_ativado", List.of("Modo Rotação: Ativado"));
        DICIONARIO.put("modo_rotacao_desativado", List.of("Modo Rotação: Desativado"));
        DICIONARIO.put("nova_simulacao", List.of("Nova Simulação"));
        DICIONARIO.put("salvar_area_trabalho", List.of("Salvar Área de Trabalho"));
        DICIONARIO.put("service_nao_encontrado", List.of("O serviço requerido não foi encontrado"));
        DICIONARIO.put("titulo_aplicacao", List.of(Constantes.NOME_APLICACAO));
        DICIONARIO.put("tubulacao", List.of("Tubulação", "Tubulações"));
        DICIONARIO.put("valvula", List.of("Válvula", "Válvulas"));
        
    } // static
    
    public static String tr(String chave){
        
        if(DICIONARIO.containsKey(chave))
            return DICIONARIO.get(chave).get(0);//.getFirst();
        
        return chave;
        
    } // tr
    
    public static String trToPlural(String chave){
        
        if(DICIONARIO.containsKey(chave)){
            
            return (DICIONARIO.get(chave).size() > 1) ? DICIONARIO.get(chave).get(1) : chave;
            
        }
        
        return chave;
        
    } // trToPlural
    
}
