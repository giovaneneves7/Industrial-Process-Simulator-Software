package br.com.ifba.ipss.feature.tubulacao.domain.repository;

import br.com.ifba.ipss.feature.tubulacao.domain.model.Tubulacao;
import br.com.ifba.ipss.helper.PathHelper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

/**
 *
 * @author Giovane Neves
 * @since V0.0.1
 */
public class TubulacaoRepositoryImpl implements ITubulacaoRepository{

    private final Gson gson = new Gson();

    @Override
    public String pegarDiametroInterno(final String nomeTubulacao) {
                
        try(InputStream is = PathHelper.pegarFerramentasInputStream(); InputStreamReader isr = new InputStreamReader(is)){
            
            JsonObject jsonObject = gson.fromJson(isr, JsonObject.class);
            JsonArray tubulacoesArray = jsonObject.getAsJsonArray("tubulacoes");
            
            for (JsonElement je : tubulacoesArray) {
            
                JsonObject obj = je.getAsJsonObject();
                Tubulacao tubulacao = new Tubulacao();

                for(Map.Entry<String, JsonElement> entry : obj.entrySet()){

                    String chave = entry.getKey();
                    JsonElement valor = entry.getValue();

                    switch (chave) {
                        case "_nome" -> tubulacao.set_nome(valor.getAsString());
                        case "_caminhoImagem" -> tubulacao.set_caminhoImagem(String.valueOf(valor.getAsString()));
                        case "_x" -> tubulacao.set_x(valor.getAsInt());
                        case "_y" -> tubulacao.set_y(valor.getAsInt());
                        case "_largura" -> tubulacao.set_larguraPx(valor.getAsInt());
                        case "_altura" -> tubulacao.set_alturaPx(valor.getAsInt());
                        case "_diametroInterno" -> tubulacao.set_diametroInterno(valor.getAsString());
                        case "comprimento" -> tubulacao.setComprimento(valor.getAsDouble());
                        default -> {}
                    }
                }
                
                if(tubulacao.get_nome().equals(nomeTubulacao)){
                        return tubulacao.get_diametroInterno();
                }
            }
                        
        } catch(IOException ex){
            
            ex.printStackTrace();
        
        }
        
        return null;

    }

    @Override
    public double pegarComprimento(String nomeTubulacao) {
         
    
        try(InputStream is = PathHelper.pegarFerramentasInputStream(); InputStreamReader isr = new InputStreamReader(is)){
            
            JsonObject jsonObject = gson.fromJson(isr, JsonObject.class);
            JsonArray tubulacoesArray = jsonObject.getAsJsonArray("tubulacoes");
            
            for (JsonElement je : tubulacoesArray) {
            
                JsonObject obj = je.getAsJsonObject();
                Tubulacao tubulacao = new Tubulacao();

                for(Map.Entry<String, JsonElement> entry : obj.entrySet()){

                    String chave = entry.getKey();
                    JsonElement valor = entry.getValue();

                    switch (chave) {
                        case "_nome" -> tubulacao.set_nome(valor.getAsString());
                        case "_caminhoImagem" -> tubulacao.set_caminhoImagem(String.valueOf(valor.getAsString()));
                        case "_x" -> tubulacao.set_x(valor.getAsInt());
                        case "_y" -> tubulacao.set_y(valor.getAsInt());
                        case "_largura" -> tubulacao.set_larguraPx(valor.getAsInt());
                        case "_altura" -> tubulacao.set_alturaPx(valor.getAsInt());
                        case "_diametroInterno" -> tubulacao.set_diametroInterno(valor.getAsString());
                        case "comprimento" -> tubulacao.setComprimento(valor.getAsDouble());
                        default -> {}
                    }
                }
                
                if(tubulacao.get_nome().equals(nomeTubulacao)){
                        return tubulacao.getComprimento();
                }
            }
                        
        } catch(IOException ex){
            
            ex.printStackTrace();
        
        }
        
        return 0;
        
    }
    
}
