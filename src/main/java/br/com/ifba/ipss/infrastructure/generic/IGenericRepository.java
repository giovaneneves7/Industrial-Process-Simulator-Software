// *************************************************//
// *************** { COMEÇO - Package } ************//
// *************************************************//

package br.com.ifba.ipss.infrastructure.generic;

// *************************************************//
// *************** { FIM - Package } ***************//
// *************************************************//

// *************************************************//
// ************ { COMEÇO - Imports } ***************//
// *************************************************//

import br.com.ifba.ipss.feature.conexao.domain.model.Conexao;
import br.com.ifba.ipss.feature.equipamento.domain.model.Equipamento;
import br.com.ifba.ipss.feature.tubulacao.domain.model.Tubulacao;
import br.com.ifba.ipss.feature.valvula.domain.model.Valvula;
import br.com.ifba.ipss.helper.PathHelper;
import br.com.ifba.ipss.singleton.GsonSingleton;
import br.com.ifba.ipss.util.Constantes;
import br.com.ifba.ipss.util.EquipamentType;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
public interface IGenericRepository<E extends Equipamento> {
    
    default List<E> pegarListaEquipamentos(String tipoEquipamento){
        
        Gson gson = GsonSingleton.getInstance();
        
        List<E> equipaments = new ArrayList<>();

        try(InputStream is = PathHelper.pegarFerramentasInputStream(); InputStreamReader isr = new InputStreamReader(is)){
    
            JsonObject jsonObject = gson.fromJson(isr, JsonObject.class);
            JsonArray tubulacoesArray = jsonObject.getAsJsonArray(tipoEquipamento);

            for (JsonElement je : tubulacoesArray) {
                JsonObject obj = je.getAsJsonObject();
                E eq = pegarInstancia(tipoEquipamento);
                boolean up = false, right = false, down = false, left = false;
                
                for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
                    String chave = entry.getKey();
                    JsonElement valor = entry.getValue();

                    switch (chave) {
                        case Constantes.ATRIBUTO_NOME:
                            eq.set_nome(valor.getAsString());
                            break;
                        case Constantes.ATRIBUTO_THUMBNAIL:
                            eq.setThumbnail(String.valueOf(valor.getAsString()));
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
                        case Constantes.ATRIBUTO_UP:
                            up = (valor.getAsInt() == 1);
                            break;
                        case Constantes.ATRIBUTO_RIGHT:
                            right = (valor.getAsInt() == 1);
                            break;
                        case Constantes.ATRIBUTO_DOWN:
                            down = (valor.getAsInt() == 1);
                            break;
                        case Constantes.ATRIBUTO_LEFT:
                            left = (valor.getAsInt() == 1);
                            break;    
                        case Constantes.CAN_MIRRORING_ATTRIBUTE:
                            eq.setCanMirroring(valor.getAsInt() == 1);
                            break;
                        case Constantes.TOP_ALREADY_CONNECTED:
                            eq.setTopAlreadyConnected(valor.getAsInt() == 1);
                            break;
                        case Constantes.TYPE_ATTRIBUTE:
                            eq.setType(getEquipamentType(valor.getAsString()));
                            break;
                        case Constantes.AXIOS_ATTRIBUTE:
                            eq.setAxios(valor.getAsString());
                            break;
                        case Constantes.CAN_TOP_CONNECT_ATTRIBUTE:
                            eq.setCanTopConnect(valor.getAsInt() == 1);
                            break;
                        case Constantes.CAN_BOTTOM_CONNECT_ATTRIBUTE:
                            eq.setCanBottomConnect(valor.getAsInt() == 1);
                            break;
                        case Constantes.CAN_ROTATE_ATTRIBUTE:
                            eq.setCanRotate(valor.getAsInt() == 1);
                            break;
                        default:
                            if (eq instanceof Tubulacao tub) {
                                switch (chave) {
                                    case Constantes.ATRIBUTO_DIAMETRO_INTERNO -> tub.set_diametroInterno(valor.getAsString());
                                    case Constantes.ATRIBUTO_COMPRIMENTO -> tub.setComprimento(valor.getAsDouble());
                                    default -> {
                            }
                                }
                            }
                            break;
                    }

                }
                
                Map<String, Boolean> entradas = new HashMap<>();
                entradas.put(Constantes.CIMA, up);
                entradas.put(Constantes.DIREITA, right);
                entradas.put(Constantes.BAIXO, down);
                entradas.put(Constantes.ESQUERDA, left);
                
                eq.setEntradas(entradas);
                
                equipaments.add(eq);
            }
            
        } catch(IOException ex){
            
            ex.printStackTrace();
        
        }
        
        return equipaments;
        
    }
    
    private E pegarInstancia(String tipoEquipamento){
        
        return (tipoEquipamento.equals("conexoes")) ?
                (E) new Conexao() : 
               (tipoEquipamento.equals("tubulacoes")) ?
                (E) new Tubulacao() :
               (tipoEquipamento.equals("valvulas")) ?
                (E) new Valvula() :
                (E) new Equipamento();
                
        
    }
    
    private EquipamentType getEquipamentType(String type){
    
        switch(type){
            case Constantes.CONEXAO_TYPE -> {
                return EquipamentType.CONEXAO;
            }
            case Constantes.REATOR_TYPE -> {
                return EquipamentType.REATOR;
            }
            case Constantes.TANQUE_TYPE -> {
                return EquipamentType.TANQUE;
            }
            case Constantes.TUBULACAO_TYPE -> {
                return EquipamentType.TUBULACAO;
            }
            case Constantes.VALVULA_TYPE -> {
                return EquipamentType.VALVULA;
            }
            case Constantes.BOMBA_CENTRIFUGA_TYPE -> {
                return EquipamentType.BOMBA_CENTRIFUGA;
            }
            default -> { 
                return EquipamentType.UNKNOWN;
            }
           
        }
    }
    
}
