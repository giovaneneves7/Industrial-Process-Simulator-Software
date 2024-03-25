// *************************************************//
// *************** { COMEÇO - Package } ************//
// *************************************************//
package br.com.ifba.ipss.model.entity;
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
public class Valvula extends Equipamento{
    
    // *************************************************//
    // ***************** { Atributos } *****************//
    // *************************************************//
    
    private double _perdaDeCarga;    // A perda de carga da valvula.
    private double _diametroInterno; // O diametro interno da válvula.
    
} // class Valvula
