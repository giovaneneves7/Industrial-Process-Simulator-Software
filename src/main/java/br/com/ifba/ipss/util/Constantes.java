package br.com.ifba.ipss.util;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
    public static final Color COR_PRIMARIA = new Color(0, 102, 51);
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
    
    // Nome de Atributos de Equipamentos
    public static final String ATRIBUTO_NOME = "_nome";
    public static final String ATRIBUTO_CAMINHO_IMAGEM = "_caminhoImagem";
    public static final String ATRIBUTO_POS_X = "_x";
    public static final String ATRIBUTO_POS_Y = "_y";
    public static final String ATRIBUTO_LARGURA = "_larguraPx";
    public static final String ATRIBUTO_ALTURA = "_alturaPx";
    public static final String ATRIBUTO_DIAMETRO_INTERNO  = "_diametroInterno";
    public static final String ATRIBUTO_COMPRIMENTO = "comprimento";
    
    // Caminhos de Imagens
    public static final String CAMINHO_BOTAO_REMOVER = "/images/botao_remover.png";
    public static final String CAMINHO_BOTAO_REMOVER_SELECIONADO = "/images/botao_remover_selecionado.png"; 
    public static final String CAMINHO_LOGO = "/images/logo.jpg";
    
    // arquivos e diretórios
    public static final String DIRETORIO_IMAGENS = "/images";
    public static final String ESPACO_TRABALHO_JSON = "/files/workspace.json";
    
    // resources/streams
    public static InputStream pegarEspacoTrabalhoJsonInputStream() throws FileNotFoundException{
        
        return Constantes.class.getResourceAsStream(ESPACO_TRABALHO_JSON);
        
    }
    
    public static OutputStream pegarEspacoTrabalhoJsonOutputStream() throws IOException{
        
        InputStream is = pegarEspacoTrabalhoJsonInputStream();
        
        if (is == null) {
            throw new FileNotFoundException("Arquivo não encontrado: " + ESPACO_TRABALHO_JSON);
        }
    
        Path diretorioDestino = Paths.get("src", "main", "resources", "files");
        
        if (!Files.exists(diretorioDestino)) {
            Files.createDirectories(diretorioDestino);
        }
        
        Path caminhoAbsolutoArquivo = diretorioDestino.resolve("workspace.json");
        
        OutputStream outputStream = Files.newOutputStream(caminhoAbsolutoArquivo);
        
        return outputStream;
    }
}
