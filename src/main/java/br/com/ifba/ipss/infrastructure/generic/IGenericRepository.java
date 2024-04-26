package br.com.ifba.ipss.infrastructure.generic;

import br.com.ifba.ipss.feature.conexao.domain.model.Conexao;
import br.com.ifba.ipss.feature.equipamento.domain.model.Equipamento;
import br.com.ifba.ipss.feature.tubulacao.domain.model.Tubulacao;
import br.com.ifba.ipss.feature.valvula.domain.model.Valvula;
import br.com.ifba.ipss.helper.PathHelper;
import br.com.ifba.ipss.singleton.GsonSingleton;
import br.com.ifba.ipss.util.Constantes;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Giovane Neves
 * @since V0.0.1
 */
public interface IGenericRepository<E extends Equipamento> {
    
    default List<E> pegarListaEquipamentos(String tipoEquipamento){
        
        Gson gson = GsonSingleton.getInstance();
        
        List<E> equipamentos = new ArrayList<>();

        try(InputStream is = PathHelper.pegarFerramentasInputStream(); InputStreamReader isr = new InputStreamReader(is)){
    
            JsonObject jsonObject = gson.fromJson(isr, JsonObject.class);
            JsonArray tubulacoesArray = jsonObject.getAsJsonArray(tipoEquipamento);

            for (JsonElement je : tubulacoesArray) {
                JsonObject obj = je.getAsJsonObject();
                E eq = pegarInstancia(tipoEquipamento);

                for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
                    String chave = entry.getKey();
                    JsonElement valor = entry.getValue();

                    switch (chave) {
                        case Constantes.ATRIBUTO_NOME:
                            eq.set_nome(valor.getAsString());
                            break;
                        case Constantes.ATRIBUTO_CAMINHO_IMAGEM:
                            eq.set_caminhoImagem(String.valueOf(valor.getAsString()));
                            break;
                        case Constantes.ATRIBUTO_POS_X:
                            eq.set_x(valor.getAsInt());
                            break;
                        case Constantes.ATRIBUTO_POS_Y:
                            eq.set_y(valor.getAsInt());
                            break;
                        case Constantes.ATRIBUTO_LARGURA:
                            eq.set_larguraPx(valor.getAsInt());
                            break;
                        case Constantes.ATRIBUTO_ALTURA:
                            eq.set_alturaPx(valor.getAsInt());
                            break;
                        default:
                            if (eq instanceof Tubulacao tub) {
                                switch (chave) {
                                    case Constantes.ATRIBUTO_DIAMETRO_INTERNO:
                                        tub.set_diametroInterno(valor.getAsString());
                                        break;
                                    case Constantes.ATRIBUTO_COMPRIMENTO:
                                        tub.setComprimento(valor.getAsDouble());
                                        break;
                                    default:
                                        break;
                                }
                            }
                            break;
                    }
                }
                equipamentos.add(eq);
            }
            
        } catch(IOException ex){
            
            ex.printStackTrace();
        
        }
        
        return equipamentos;
        
    }
    
    private E pegarInstancia(String tipoEquipamento){
        
        return (tipoEquipamento.equals("conexoes")) ?
                (E) new Conexao() : 
               (tipoEquipamento.equals("tubulacoes")) ?
                (E) new Tubulacao() :
               (tipoEquipamento.equals("valvulas")) ?
                (E) new Valvula() :
                null;
        
    }
    
}
