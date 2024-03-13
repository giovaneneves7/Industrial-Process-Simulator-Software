// *************************************************//
// *************** { COMEÇO - Package } ************//
// *************************************************//
package br.com.ifba.ipss.model;
// *************************************************//
// *************** { FIM - Package } ***************//
// *************************************************//

// *************************************************//
// ************ { COMEÇO - Imports } ***************//
// *************************************************//
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
public class Reator extends Equipamento{
    
    // *************************************************//
    // ***************** { Atributos } *****************//
    // *************************************************//
    
    private double _agitacao;    // A agitação do reator.
    private double _temperatura; // A temperatura do reator.
    private double _pressao;     // A pressão do reator.
    
} // class Reator
