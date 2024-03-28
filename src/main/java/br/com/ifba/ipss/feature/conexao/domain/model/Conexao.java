// *************************************************//
// *************** { COMEÇO - Package } ************//
// *************************************************//
package br.com.ifba.ipss.feature.conexao.domain.model;
// *************************************************//
// *************** { FIM - Package } ***************//
// *************************************************//

// *************************************************//
// ************ { COMEÇO - Imports } ***************//
// *************************************************//
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
public class Conexao extends Equipamento{
    
    // *************************************************//
    // ***************** { Atributos } *****************//
    // *************************************************//
    
    private double perdaDeCarga;    // A perda de carga da conexao.
    private double diametroInterno; // O diâmetro interno da conexão.
    
} // class Conexao
