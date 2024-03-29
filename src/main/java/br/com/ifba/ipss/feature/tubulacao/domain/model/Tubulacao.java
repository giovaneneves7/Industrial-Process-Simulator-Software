// *************************************************//
// *************** { COMEÇO - Package } ************//
// *************************************************//
package br.com.ifba.ipss.feature.tubulacao.domain.model;
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
public class Tubulacao extends Equipamento implements Ferramenta{
    
    // *************************************************//
    // ***************** { Atributos } *****************//
    // *************************************************//
    
    private String _diametroInterno; // O diametro interno do tubo.
    private double comprimento;      // O comprimento do tubo.
    
} // class Tubulacao
