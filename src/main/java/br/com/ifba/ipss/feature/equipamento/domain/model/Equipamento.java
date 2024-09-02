// *************************************************//
// *************** { COMEÇO - Package } ************//
// *************************************************//
package br.com.ifba.ipss.feature.equipamento.domain.model;
// *************************************************//
// *************** { FIM - Package } ***************//
// *************************************************//

// *************************************************//
// ************ { COMEÇO - Imports } ***************//
// *************************************************//
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import br.com.ifba.ipss.util.EquipamentType;
// *************************************************//
// ************** { FIM - Imports } ****************//
// *************************************************//

/**
 *
 * @author Giovane Neves
 * @since V0.0.1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Equipamento {
   
    // *************************************************//
    // ***************** { Atributos } *****************//
    // *************************************************//
    
    private String _nome;          // O nome do equipamento.
    private String thumbnail;      // A thumbnail do equipamento.
    private String _caminhoImagem; // O caminho para a imagem do equipamento.
    private double _x;             // A posição 'X' do equipamento.
    private double _y;             // A posição 'Y' do equipamento.
    private double _larguraPx;     // A largura do equipamento em pixels.
    private double _alturaPx;      // A altura do equipamento em pixels.
    private double _comprimentoM;  // O comprimento do equipamento em metros.
    private Map<String, Boolean> entradas; 
    private boolean canMirroring; // Valor booleano. Pode ou não espelhar.
    private EquipamentType type; // O tipo do equipamento.
    private String axios; // Se horizontal ou vertical.
    
} // class Equipamento
