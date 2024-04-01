package br.com.ifba.ipss.infrastructure.exception.generic;

import br.com.ifba.ipss.feature.conexao.domain.model.Conexao;
import br.com.ifba.ipss.feature.equipamento.domain.model.Equipamento;
import br.com.ifba.ipss.feature.tubulacao.domain.model.Tubulacao;
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

/**
 *
 * @author Giovane Neves
 * @since V0.0.1
 */
public class GenericRepositoryImpl implements IGenericRepository<Equipamento>{

    private final Gson gson = GsonSingleton.getInstance();
    
    @Override
    public <E extends Equipamento> List<E> pegarListaEquipamentos(String tipoEquipamento) {
        
        List<E> equipamentos = new ArrayList<>();

        try(FileReader leitor = new FileReader(PathHelper.FERRAMENTAS_JSON)){
            
            JsonObject jsonObject = gson.fromJson(leitor, JsonObject.class);
            JsonArray tubulacoesArray = jsonObject.getAsJsonArray(tipoEquipamento);
            
            for (JsonElement je : tubulacoesArray) {
            
                JsonObject obj = je.getAsJsonObject();
                E eq = pegarInstancia(tipoEquipamento);

                for(Map.Entry<String, JsonElement> entry : obj.entrySet()){

                    String chave = entry.getKey();
                    JsonElement valor = entry.getValue();

                    switch (chave) {
                        case Constantes.ATRIBUTO_NOME -> eq.set_nome(valor.getAsString());
                        case Constantes.ATRIBUTO_CAMINHO_IMAGEM -> eq.set_caminhoImagem(String.valueOf(valor.getAsString()));
                        case Constantes.ATRIBUTO_POS_X -> eq.set_x(valor.getAsInt());
                        case Constantes.ATRIBUTO_POS_Y -> eq.set_y(valor.getAsInt());
                        case Constantes.ATRIBUTO_LARGURA -> eq.set_larguraPx(valor.getAsInt());
                        case Constantes.ATRIBUTO_ALTURA -> eq.set_alturaPx(valor.getAsInt());
                        default -> {
                        
                            if(eq instanceof Tubulacao tub){
                                
                                switch (chave) {
                                    case "_diametroInterno" -> tub.set_diametroInterno(valor.getAsString());
                                    case "comprimento" -> tub.setComprimento(valor.getAsDouble());
                                    default -> {}
                                }
                                
                            }
                        
                        }
                    }


                }
                equipamentos.add(eq);
            }
            
        } catch(IOException ex){
            
            ex.printStackTrace();
        
        }
        
        return equipamentos;
        
    }
    
    private <E extends Equipamento>E pegarInstancia(String tipoEquipamento){
        
        return (tipoEquipamento.equals("conexoes")) ?
                (E) new Conexao() : 
               (tipoEquipamento.equals("tubulacoes")) ?
                (E) new Tubulacao() :
                null;
        
    }
    
}
