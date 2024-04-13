package br.com.ifba.ipss.feature.espacotrabalho.domain.repository;

import br.com.ifba.ipss.feature.label.domain.model.Label;
import br.com.ifba.ipss.infrastructure.interfaces.Implementacao;
import br.com.ifba.ipss.util.Constantes;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import javax.swing.ImageIcon;

/**
 *
 * @author Giovane Neves
 * @since V0.0.1
 */
public class EspacoTrabalhoRepositoryImpl implements IEspacoTrabalhoRepository, Implementacao{

    @Override
    public boolean salvarEspacoTrabalho(Map<String, Label> mapa) {

        try(OutputStream os = Constantes.pegarEspacoTrabalhoJsonOutputStream(); 
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, StandardCharsets.UTF_8));){
            
            int cont = 0;
            writer.write("[");
            writer.newLine();
            
            for(Map.Entry<String, Label> entry : mapa.entrySet()){
                
                cont++;
                
                String chave = entry.getKey();
                Label valor = entry.getValue();
                int largura = valor.getWidth();
                int altura = valor.getHeight();
                String orientacao = valor.getOrientacao();
                String caminhoImagem = null;
                
                if(valor.getIcon() instanceof ImageIcon img){
                    
                    caminhoImagem = img.getDescription();
                    int indice = caminhoImagem.indexOf(Constantes.DIRETORIO_IMAGENS);
                    
                    if(indice != -1){
                        caminhoImagem = caminhoImagem.substring(indice);
                    }
                    
                }
                
                writer.write(
                        "\t{\n\t\t\"id\" : \"%s\",\n \t\t\"caminho_imagem\" : \"%s\",\n \t\t\"largura\" : %d,\n \t\t\"altura\" : %d,\n \t\t\"orientacao\" : \"%s\"\n\t}"
                                .formatted(chave, caminhoImagem, largura, altura, orientacao)
                                .concat((mapa.size()) == cont ? "" : ",")
                );
                writer.newLine();

            }
            
            writer.write("]");
           
            return true;

        } catch(IOException ex){
            
            ex.printStackTrace();
            return false;
        
        }
        
    }

    @Override
    public boolean deletarEspacoTrabalho() {
        
        try(OutputStream os = Constantes.pegarEspacoTrabalhoJsonOutputStream(); 
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, StandardCharsets.UTF_8));){
        
            writer.write("");
            return true;

        } catch(IOException ex){
        
            ex.printStackTrace();
            return false;
            
        }
        
        
    }
    
}
