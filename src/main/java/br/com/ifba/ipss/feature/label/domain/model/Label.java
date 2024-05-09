// *************************************************//
// *************** { COMEÇO - Package } ************//
// *************************************************//
package br.com.ifba.ipss.feature.label.domain.model;
// *************************************************//
// *************** { FIM - Package } ***************//
// *************************************************//

// *************************************************//
// ************ { COMEÇO - Imports } ***************//
// *************************************************//
import br.com.ifba.ipss.feature.equipamento.domain.model.Equipamento;
import java.util.Map;

import lombok.Data;
// *************************************************//
// ************** { FIM - Imports } ****************//
// *************************************************//

/**
 *
 * @author Giovane Neves
 * @since V0.0.1
 */
@Data
public class Label<E extends Equipamento> extends javax.swing.JLabel {
    
    private String id;
    private String orientacao;
    private String tipo;
    private E equipamento;
    private Map<String, Label> conexoes; // up -> Cima, right -> Direita, down -> Baixo, 3 -> left

}
