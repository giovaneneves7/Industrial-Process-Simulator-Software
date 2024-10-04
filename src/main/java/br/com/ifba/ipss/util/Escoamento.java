// *************************************************//
// *************** { COMEÇO - Package } ************//
// *************************************************//
package br.com.ifba.ipss.util;
// *************************************************//
// *************** { FIM - Package } ***************//
// *************************************************//

/**
 *
 * @author Giovane Neves
 * @since V0.0.1
 */
public enum Escoamento {
    
    ESCOAMENTO_LAMINAR("Laminar"),
    ESCOAMENTO_TRANSITORIO("Transitório"),
    ESCOAMENTO_TURBULENTO("Turubulento");
    
    private final String escoamento;

    private Escoamento(final String escoamento) {
        this.escoamento = escoamento;
    }
    
    public String getString(){
        return escoamento;
    }
    
}
