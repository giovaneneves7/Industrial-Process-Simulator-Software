// *************************************************//
// *************** { COMEÇO - Package } ************//
// *************************************************//
package br.com.ifba.ipss.feature.valvula.domain.model;
// *************************************************//
// *************** { FIM - Package } ***************//
// *************************************************//

// *************************************************//
// ************ { COMEÇO - Imports } ***************//
// *************************************************//
import br.com.ifba.ipss.common.infrastructure.interfaces.Ferramenta;
import br.com.ifba.ipss.feature.equipamento.domain.model.Equipamento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
public class Valvula extends Equipamento implements Ferramenta{
    
    // *************************************************//
    // ***************** { Atributos } *****************//
    // *************************************************//
    
    private double _perdaDeCarga;    // A perda de carga da valvula.
    private double _diametroInterno; // O diametro interno da válvula.
    
} // class Valvula
