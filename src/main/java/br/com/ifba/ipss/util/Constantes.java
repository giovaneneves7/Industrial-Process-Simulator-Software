// *************************************************//
// *************** { COMEÇO - Package } ************//
// *************************************************//

package br.com.ifba.ipss.util;

// *************************************************//
// *************** { FIM - Package } ***************//
// *************************************************//

// *************************************************//
// ************ { COMEÇO - Imports } ***************//
// *************************************************//

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// *************************************************//
// ************** { FIM - Imports } ****************//
// *************************************************//

/**
 *
 * @author Giovane Neves
 * @since V0.0.1
 */
public class Constantes {
    
    // Informações da Aplicação
    public static final String NOME_APLICACAO = "EduSimLab - Laboratório Virtual de Simulação de Processos";
    public static final String VERSAO = "0.0.1";
    
    // Tamanhos e Fontes
    public static final String FONTE = "SansSerif";
    public static final int TAMANHO_FONTE = 12;
    
    // Paleta de Cores
    public static final Color COR_PRIMARIA = Color.decode("#006633");
    public static final Color COR_PRIMARIA_SELECIONADA = Color.decode("#034A26");
    public static final Color COR_SEGUNDARIA = Color.white;
    public static final Color COR_DARK = Color.decode("#9C9C9C");
    public static final Color COR_BACKGROUND = Color.decode("#CCCCCC");
    public static final Color COR_BACKGROUND_HOVER = Color.decode("#9C9898"); 
    public static final Color COR_TEXTO = Color.black;
    
    // Tempos
    public static final int DELAY_CARREGAMENTO = 20;
    
    // Orientações
    public static final String HORIZONTAL = "horizontal";
    public static final String VERTICAL = "vertical";
    public static final String CIMA = "up";
    public static final String DIREITA = "right";
    public static final String BAIXO = "down";
    public static final String ESQUERDA = "left";
    
    // Opções
    public static final Object[] SIM_NAO = {"Sim", "Não"};
    public static final Object[] OK = {"Ok"};
    
    // Nome de Atributos de Equipamentos
    public static final String ATRIBUTO_ID = "id";
    public static final String ATRIBUTO_NOME = "_nome";
    public static final String ATRIBUTO_THUMBNAIL = "thumbnail";
    public static final String ATRIBUTO_CAMINHO_IMAGEM = "_caminhoImagem";
    public static final String ATRIBUTO_POS_X = "_x";
    public static final String ATRIBUTO_POS_Y = "_y";
    public static final String ATRIBUTO_LARGURA = "_larguraPx";
    public static final String ATRIBUTO_ALTURA = "_alturaPx";
    public static final String ATRIBUTO_DIAMETRO_INTERNO  = "_diametroInterno";
    public static final String ATRIBUTO_COMPRIMENTO = "comprimento";
    public static final String ATRIBUTO_LARGURA_LABEL = "largura";
    public static final String ATRIBUTO_ALTURA_LABEL = "altura";
    public static final String ATRIBUTO_X_LABEL = "x";
    public static final String ATRIBUTO_Y_LABEL = "y";
    public static final String ATRIBUTO_ORIENTACAO = "orientacao";
    public static final String ATRIBUTO_CAMINHO_IMAGEM_LABEL = "caminho_imagem";
    public static final String ATRIBUTO_UP = "up";
    public static final String ATRIBUTO_RIGHT = "right";
    public static final String ATRIBUTO_DOWN = "down";
    public static final String ATRIBUTO_LEFT = "left";
    public static final String CAN_MIRRORING_ATTRIBUTE = "can_mirroring";
    public static final String TYPE_ATTRIBUTE = "type";
    public static final String AXIOS_ATTRIBUTE = "axios";
    public static final String CAN_BOTTOM_CONNECT_ATTRIBUTE = "can_bottom_connect";
    public static final String CAN_TOP_CONNECT_ATTRIBUTE = "can_top_connect";
    
    public static final String TUBULACAO_TYPE = "tubulacao";
    
    // Caminhos de Imagens
    public static final String CAMINHO_BOTAO_REMOVER = "/images/trash.png";
    public static final String CAMINHO_BOTAO_REMOVER_SELECIONADO = "/images/trash_selected.png"; 
    public static final String CAMINHO_BOTAO_GIRAR = "/images/spin.png";
    public static final String CAMINHO_BOTAO_GIRAR_SELECIONADO = "/images/spin_selected.png";
    public static final String CAMINHO_BOTAO_CONECTAR = "/images/connection.png";
    public static final String CAMINHO_BOTAO_CONECTAR_SELECIONADO = "/images/connection_selected.png";
    public static final String CAMINHO_BOTAO_LIMPAR = "/images/delete_file.png";
    public static final String CAMINHO_BOTAO_LIMPAR_SELECIONADO = "/images/delete_file_selected.png";
    public static final String CAMINHO_BOTAO_SALVAR = "/images/save.png";
    public static final String CAMINHO_BOTAO_SALVAR_SELECIONADO = "/images/save_selected.png";
    public static final String CAMINHO_BOTAO_SIMULAR = "/images/play.png";
    public static final String CAMINHO_BOTAO_SIMULAR_SELECIONADO = "/images/play_selected.png";
    public static final String CAMINHO_BOTAO_CONEXOES = "/images/botao_conexoes.png";
    public static final String CAMINHO_BOTAO_CONEXOES_SELECIONADO = "/images/botao_conexoes_selecionado.png";
    public static final String CAMINHO_BOTAO_TUBULACOES = "/images/botao_tubulacoes.png";
    public static final String CAMINHO_BOTAO_TUBULACOES_SELECIONADO = "/images/botao_tubulacoes_selecionado.png";
    public static final String CAMINHO_BOTAO_VALVULAS = "/images/botao_valvulas.png";
    public static final String CAMINHO_BOTAO_VALVULAS_SELECIONADO = "/images/botao_valvulas_selecionado.png";
    public static final String CAMINHO_BOTAO_EQUIPAMENTOS = "/images/botao_equipamentos.png";
    public static final String CAMINHO_BOTAO_EQUIPAMENTOS_SELECIONADO = "/images/botao_equipamentos_selecionado.png";
    public static final String CAMINHO_LOGO = "/images/logo.jpg";
    public static final String MIRROR_BUTTON_PATH = "/images/mirror.png";
    public static final String SELECTED_MIRROR_BUTTON_PATH = "/images/mirror_selected.png";
    
    public static final String CONEXAO_3 = "/images/conexao_3.png";
    public static final String CONEXAO_3_MIRRORED = "/images/connection_3_mirrored.png";
    public static final String BOMBA_CENTRIFUGA = "/images/bomba_centrifuga.png";
    public static final String BOMBA_CENTRIFUGA_MIRRORED = "/images/bomba_centrifuga_mirrored.png";
    
    private static final  Map<String, List<String>> imagensBotoes;
    public static final Map<String, List<String>> mirroredEquipaments;
    
    static{
    
        imagensBotoes = new HashMap<>() {{
        
            put("btnTubulacoes", List.of(CAMINHO_BOTAO_TUBULACOES, CAMINHO_BOTAO_TUBULACOES_SELECIONADO));
            put("btnConexoes", List.of(CAMINHO_BOTAO_CONEXOES, CAMINHO_BOTAO_CONEXOES_SELECIONADO));
            put("btnValvulas", List.of(CAMINHO_BOTAO_VALVULAS, CAMINHO_BOTAO_VALVULAS_SELECIONADO));
            put("btnEquipamentos", List.of(CAMINHO_BOTAO_EQUIPAMENTOS, CAMINHO_BOTAO_EQUIPAMENTOS_SELECIONADO));
            put("btnRemover", List.of(CAMINHO_BOTAO_REMOVER, CAMINHO_BOTAO_REMOVER_SELECIONADO));
            put("btnGirar", List.of(CAMINHO_BOTAO_GIRAR, CAMINHO_BOTAO_GIRAR_SELECIONADO));
            put("btnConectar", List.of(CAMINHO_BOTAO_CONECTAR, CAMINHO_BOTAO_CONECTAR_SELECIONADO));
            put("btnLimpar", List.of(CAMINHO_BOTAO_LIMPAR, CAMINHO_BOTAO_LIMPAR_SELECIONADO));
            put("btnSalvar", List.of(CAMINHO_BOTAO_SALVAR, CAMINHO_BOTAO_SALVAR_SELECIONADO));
            put("btnSimular", List.of(CAMINHO_BOTAO_SIMULAR, CAMINHO_BOTAO_SIMULAR_SELECIONADO));
            put("btnMirror", List.of(MIRROR_BUTTON_PATH, SELECTED_MIRROR_BUTTON_PATH));
            
        }};
        
        mirroredEquipaments = new HashMap<>() {{
        
            put(BOMBA_CENTRIFUGA, List.of(BOMBA_CENTRIFUGA, BOMBA_CENTRIFUGA_MIRRORED));
            put(BOMBA_CENTRIFUGA_MIRRORED, List.of(BOMBA_CENTRIFUGA_MIRRORED, BOMBA_CENTRIFUGA));
            put(CONEXAO_3, List.of(CONEXAO_3, CONEXAO_3_MIRRORED));
            put(CONEXAO_3_MIRRORED, List.of(CONEXAO_3_MIRRORED, CONEXAO_3));
            
        }};
        
    }
    
    public static String getMirroredEquipament(String key){
        
        return mirroredEquipaments.get(key).get(1);
        
    }
    
    public static String getNormalEquipament(String key){
    
        return mirroredEquipaments.get(key).get(0);
        
    }
    
    public static String pegarImagemBotao(String chave){
        
        return (imagensBotoes.containsKey(chave)) ?
                imagensBotoes.get(chave).get(0) :
                chave;
        
    }
            
    public static String pegarImagemBotaoSelecionado(String chave){
        return (imagensBotoes.containsKey(chave)) ?
                imagensBotoes.get(chave).get(imagensBotoes.get(chave).size()-1) :
                chave;
        
    }
    
    // arquivos e diretórios
    public static final String DIRETORIO_IMAGENS = "/images";
    public static final String ESPACO_TRABALHO_JSON = "/files/workspace.json";
    
    // resources/streams
    public static InputStream pegarEspacoTrabalhoJsonInputStream(String workspacePath) throws FileNotFoundException{
        
        return Constantes.class.getResourceAsStream("/files/".concat(workspacePath));
        
    }
    
    public static OutputStream pegarEspacoTrabalhoJsonOutputStream(String workspacePath) throws IOException{
        
        
        
        //if (is == null) {
          //  throw new FileNotFoundException("Arquivo não encontrado: " + ESPACO_TRABALHO_JSON);
        //}
    
        Path diretorioDestino = Paths.get("src", "main", "resources", "files");
        Path caminhoAbsolutoArquivo = diretorioDestino.resolve(workspacePath);
        
        if (!Files.exists(diretorioDestino)) {
            Files.createDirectories(diretorioDestino);
        }
        
        if (!Files.exists(caminhoAbsolutoArquivo)) {
            Files.createFile(caminhoAbsolutoArquivo);
        }
        
        InputStream is = pegarEspacoTrabalhoJsonInputStream(workspacePath);
        
        if (is == null) {
            throw new FileNotFoundException("Arquivo não encontrado: " + ESPACO_TRABALHO_JSON);
        }
                
        OutputStream outputStream = Files.newOutputStream(caminhoAbsolutoArquivo);
        
        return outputStream;
    }
}
