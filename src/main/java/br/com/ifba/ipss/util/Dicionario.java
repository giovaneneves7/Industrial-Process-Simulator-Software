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
 * Dicionário útil com todos os textos da aplicação
 * 
 * @author Giovane Neves
 * @since V0.0.1
 */
public class Dicionario {
    
    public static final HashMap<String, List<String>> DICIONARIO = new HashMap<>();
    
    static {
        
        DICIONARIO.put("a_area_trabalho_esta_vazia", List.of("A Área de Trabalho Está Vazia!"));
        DICIONARIO.put("acesso_orientador", List.of("Acesso Orientador"));
        DICIONARIO.put("area_de_trabalho_deletada_com_sucesso", List.of("Área de Trabalho deletada com sucesso!"));
        DICIONARIO.put("area_de_trabalho_salva_com_sucesso", List.of("Área de Trabalho salva com sucesso!"));
        DICIONARIO.put("area_de_trabalho_vazia", List.of("Área de Trabalho Vazia"));
        DICIONARIO.put("area_do_orientador", List.of("Área do Orientador"));
        DICIONARIO.put("arquivo_ja_existe", List.of("O Nome de Arquivo Informado Já Está em Uso!"));
        DICIONARIO.put("aviso", List.of("Aviso!"));
        DICIONARIO.put("buscar", List.of("Buscar"));
        DICIONARIO.put("carregar_simulacao", List.of("Carregar Simulação"));
        DICIONARIO.put("coeficiente_atrito", List.of("Coeficiente de Atrito"));
        DICIONARIO.put("conectar_equipamento", List.of("Conectar Equipamento"));
        DICIONARIO.put("conexao", List.of("Conexão", "Conexões"));
        DICIONARIO.put("deseja_desconectar_equipamento_conectado", List.of("O Equipamento Selecionado Está Conectado. Deseja Desconectar?"));
        DICIONARIO.put("deseja_limpar_a_area_de_trabalho", List.of("Deseja limpar a Área de Trabalho?"));
        DICIONARIO.put("deseja_retornar_ao_inicio", List.of("Deseja Retornar à Tela Inicial?"));
        DICIONARIO.put("deseja_salvar_a_area_de_trabalho", List.of("Deseja salvar a Área de Trabalho?"));
        DICIONARIO.put("di", List.of("Di"));
        DICIONARIO.put("entrar", List.of("Entrar"));
        DICIONARIO.put("espelhar", List.of("Espelhar"));
        DICIONARIO.put("equipamento", List.of("Equipamento", "Equipamentos"));
        DICIONARIO.put("equipamento_nao_pode_ser_espelhado", List.of("Este Equipamento Não Pode Ser Espelhado!"));
        DICIONARIO.put("erro", List.of("Erro", "Erros"));
        DICIONARIO.put("erro_criacao_arquivo", List.of("Ocorreu um erro ao criar o arquivo"));
        DICIONARIO.put("erro_ao_deletar_area_trabalho", List.of("Ocorreu um erro ao deletar a área de trabalho!"));
        DICIONARIO.put("erro_ao_salvar_area_trabalho", List.of("Ocorreu um erro ao salvar a área de trabalho!"));
        DICIONARIO.put("espelhar_equipamento", List.of("Espelhar Equipamento"));
        DICIONARIO.put("girar_equipamento", List.of("Girar Equipamento"));
        DICIONARIO.put("insira_o_coeficiente_atrito", List.of("Insira o Coeficiente de Atrito"));
        DICIONARIO.put("insira_o_nome_da_simulacao", List.of("Insira o Nome da Simulação"));
        DICIONARIO.put("instrucoes", List.of("Instruções"));
        DICIONARIO.put("invalid_connection", List.of("Conexão Inválida"));
        DICIONARIO.put("l", List.of("L"));
        DICIONARIO.put("limpar_area_trabalho", List.of("Limpar Área de Trabalho"));
        DICIONARIO.put("lista_simulacao", List.of("Lista de Simulações"));
        DICIONARIO.put("modo_conexao_ativado", List.of("Modo Conexão: Ativado"));
        DICIONARIO.put("modo_conexao_desativado", List.of("Modo Conexão: Desativado"));
        DICIONARIO.put("modo_espelhamento_ativado", List.of("Modo Espelhamento: Ativado"));
        DICIONARIO.put("modo_espelhamento_desativado", List.of("Modo Espelhamento: Desativado"));
        DICIONARIO.put("modo_remocao_ativado", List.of("Modo Remoção: Ativado"));
        DICIONARIO.put("modo_remocao_desativado", List.of("Modo Remoção: Desativado"));
        DICIONARIO.put("modo_rotacao_ativado", List.of("Modo Rotação: Ativado"));
        DICIONARIO.put("modo_rotacao_desativado", List.of("Modo Rotação: Desativado"));
        DICIONARIO.put("nome_usuario", List.of("Nome de Usuário"));
        DICIONARIO.put("nova_simulacao", List.of("Nova Simulação"));
        DICIONARIO.put("nova_simulacao_criada_com_sucesso", List.of("Nova Simulação Criada com Sucesso!"));
        DICIONARIO.put("remover_equipamento", List.of("Remover Equipamento"));
        DICIONARIO.put("retornar_ao_inicio", List.of("Retornar à Tela Inicial"));
        DICIONARIO.put("salvar_area_trabalho", List.of("Salvar Área de Trabalho"));
        DICIONARIO.put("service_nao_encontrado", List.of("O serviço requerido não foi encontrado"));
        DICIONARIO.put("simular", List.of("Simular"));
        DICIONARIO.put("this_connection_is_invalid", List.of("Esta Conexão É Inválida!"));
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
