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
public class Label extends javax.swing.JLabel {
    
    private String id;
    private String orientacao;
    private String tipo;
    private Map<String, Label> conexoes; // up -> Cima, right -> Direita, down -> Baixo, 3 -> left

}
