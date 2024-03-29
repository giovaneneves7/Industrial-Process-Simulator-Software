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
    
    ESCOAMENTO_LAMINAR("Escoamento Laminar"),
    ESCOAMENTO_TRANSITORIO("Escoamento Transitório"),
    ESCOAMENTO_TURBULENTO("Escoamento Turubulento");
    
    private final String escoamento;

    private Escoamento(final String escoamento) {
        this.escoamento = escoamento;
    }
    
    public String getString(){
        return escoamento;
    }
    
}
