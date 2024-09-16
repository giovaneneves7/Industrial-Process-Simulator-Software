package br.com.ifba.ipss.feature.espacotrabalho.domain.repository;

import br.com.ifba.ipss.feature.label.domain.model.Label;
import br.com.ifba.ipss.singleton.GsonSingleton;
import br.com.ifba.ipss.util.Constantes;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import br.com.ifba.ipss.infrastructure.interfaces.ServiceImpl;

/**
 *
 * @author Giovane Neves
 * @since V0.0.1
 */
public class EspacoTrabalhoRepositoryImpl implements IEspacoTrabalhoRepository, ServiceImpl{

    @Override
    public boolean salvarEspacoTrabalho(Map<String, Label> mapa, String workspacePath) {

        try(OutputStream os = Constantes.pegarEspacoTrabalhoJsonOutputStream(workspacePath); 
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, StandardCharsets.UTF_8));){
            int cont = 0;
            writer.write("{\n\t equipamentos: [");
            writer.newLine();
            
            for(Map.Entry<String, Label> entry : mapa.entrySet()){
                
                cont++;
                
                String chave = entry.getKey();
                Label valor = entry.getValue();
                int largura = valor.getWidth();
                int altura = valor.getHeight();
                int x = valor.getX();
                int y = valor.getY();
                String orientacao = valor.getOrientacao();
                String caminhoImagem = null;
                
                if(valor.getIcon() instanceof ImageIcon img){
                    
                    caminhoImagem = img.getDescription();
                    int indice = caminhoImagem.indexOf(Constantes.DIRETORIO_IMAGENS);
                    
                    if(indice != -1){
                        caminhoImagem = caminhoImagem.substring(indice);
                    } else{
                        caminhoImagem = "/images/T1.png";
                    }
                    
                }
                
                writer.write(
                        "\t{\n\t\t\"id\" : \"%s\",\n \t\t\"caminho_imagem\" : \"%s\",\n \t\t\"largura\" : %d,\n \t\t\"altura\" : %d,\n \t\t\"x\" : %d,\n \t\t\"y\" : %d,\n \t\t\"orientacao\" : \"%s\"\n\t}"
                                .formatted(chave, caminhoImagem, largura, altura, x, y, orientacao)
                                .concat((mapa.size()) == cont ? "" : ",")
                );
                writer.newLine();

            }
            
            writer.write("]\n}");
           
            return true;

        } catch(IOException ex){
            
            ex.printStackTrace();
            return false;
        
        }
        
    }

    @Override
    public boolean deletarEspacoTrabalho(String workspacePath) {
        
        try(OutputStream os = Constantes.pegarEspacoTrabalhoJsonOutputStream(workspacePath); 
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, StandardCharsets.UTF_8));){
        
            writer.write("{equipamentos:[]}");
            return true;

        } catch(IOException ex){
        
            ex.printStackTrace();
            return false;
            
        }
        
        
    }

    @Override
    public Map<String, Label> pegarEspacoTrabalho(String workspacePath) {
        
        Map<String, Label> mapa = new HashMap<>();
        Gson gson = GsonSingleton.getInstance();
        
        try(InputStream is = Constantes.pegarEspacoTrabalhoJsonInputStream(workspacePath); 
            InputStreamReader isr = new InputStreamReader(is);){
        
            if(is.available() <= 0){
                System.out.println("Arquivo vazio");
                return mapa;
            }
            
            JsonObject jsonObject = gson.fromJson(isr, JsonObject.class);
            JsonArray jsonArray = jsonObject.getAsJsonArray("equipamentos");
            
            for(JsonElement je : jsonArray){
                
                JsonObject obj = je.getAsJsonObject();
                Label lbl = new Label();
                int altura = 0, largura = 0;
                int x = 0, y = 0;
                String caminhoImage = "";

                for(Map.Entry<String, JsonElement> entry : obj.entrySet()){
                    
                    String chave = entry.getKey();
                    JsonElement valor = entry.getValue();
                   

                    switch(chave){
                        
                        case Constantes.ATRIBUTO_ID:
                            lbl.setId(valor.getAsString());
                            break;
                        case Constantes.ATRIBUTO_ORIENTACAO:
                            lbl.setOrientacao(valor.getAsString());
                            break;
                        case Constantes.ATRIBUTO_LARGURA_LABEL:
                            largura = valor.getAsInt();
                        case Constantes.ATRIBUTO_ALTURA_LABEL:
                            altura = valor.getAsInt();
                            break;
                        case Constantes.ATRIBUTO_X_LABEL:
                            x = valor.getAsInt();
                            break;
                        case Constantes.ATRIBUTO_Y_LABEL:
                            y = valor.getAsInt();
                            break;
                        case Constantes.ATRIBUTO_CAMINHO_IMAGEM_LABEL:
                            caminhoImage = valor.getAsString();
                            break;
                          
                    }
                   
                }
                
                lbl.setSize(largura, altura);
                lbl.setLocation(x, y);
                ImageIcon icon = new ImageIcon(this.getClass().getResource(caminhoImage));
                lbl.setIcon(icon);
                mapa.put(lbl.getId(), lbl);
            }
            
        } catch(IOException ex){
            
            ex.printStackTrace();
            return mapa;
            
        }
        
        
        return mapa;
        
    }
    
}
