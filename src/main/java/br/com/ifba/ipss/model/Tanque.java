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
public class Tanque extends Equipamento{
    
    // *************************************************//
    // ***************** { Atributos } *****************//
    // *************************************************//
    
    private double _volume;      // O volume do tanque. 
    private double _temperatura; // A teperatura do tanque.
    private double _pressao;     // A pressão do tanque.
    
} // class Tanque
