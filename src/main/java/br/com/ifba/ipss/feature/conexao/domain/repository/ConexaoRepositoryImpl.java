package br.com.ifba.ipss.feature.conexao.domain.repository;

import br.com.ifba.ipss.feature.conexao.domain.model.Conexao;
import br.com.ifba.ipss.helper.PathHelper;
import br.com.ifba.ipss.singleton.GsonSingleton;
import br.com.ifba.ipss.util.Constantes;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import br.com.ifba.ipss.infrastructure.interfaces.ServiceImpl;

/**
 *
 * @author Giovane Neves
 * @since V0.0.1
 */
public class ConexaoRepositoryImpl implements IConexaoRepository, ServiceImpl{

    private final Gson gson = GsonSingleton.getInstance();
    
    @Override
    public List<Conexao> pegarConexoes() {

        List<Conexao> conexoes = new ArrayList<>();

        try(FileReader leitor = new FileReader(PathHelper.FERRAMENTAS_JSON)){
            
            JsonObject jsonObject = gson.fromJson(leitor, JsonObject.class);
            JsonArray tubulacoesArray = jsonObject.getAsJsonArray("conexoes");
            
            for (JsonElement je : tubulacoesArray) {
            
                JsonObject obj = je.getAsJsonObject();
                Conexao conexao = new Conexao();

                for(Map.Entry<String, JsonElement> entry : obj.entrySet()){

                    String chave = entry.getKey();
                    JsonElement valor = entry.getValue();

                    switch (chave) {
                        case Constantes.ATRIBUTO_NOME -> conexao.set_nome(valor.getAsString());
                        case Constantes.ATRIBUTO_CAMINHO_IMAGEM -> conexao.set_caminhoImagem(String.valueOf(valor.getAsString()));
                        case Constantes.ATRIBUTO_POS_X -> conexao.set_x(valor.getAsInt());
                        case Constantes.ATRIBUTO_POS_Y -> conexao.set_y(valor.getAsInt());
                        case Constantes.ATRIBUTO_LARGURA -> conexao.set_larguraPx(valor.getAsInt());
                        case Constantes.ATRIBUTO_ALTURA -> conexao.set_alturaPx(valor.getAsInt());
                        default -> {}
                    }


                }
                conexoes.add(conexao);
            }
            
        } catch(IOException ex){
            
            ex.printStackTrace();
        
        }
        
        return conexoes;
    }
    
}
