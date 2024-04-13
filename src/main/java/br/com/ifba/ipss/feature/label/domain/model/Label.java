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
import java.util.List;

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
    private List<Label> conexoes; // 0 -> Cima, 1 -> Direita, 2 -> Baixo, 3 -> Esquerda

}
