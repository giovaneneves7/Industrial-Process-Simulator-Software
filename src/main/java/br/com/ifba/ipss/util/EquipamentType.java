package br.com.ifba.ipss.util;

/**
 *
 * @author Giovane Neves
 */
public enum EquipamentType {
    
    BOMBA_CENTRIFUGA("tubulacao"),
    CONEXAO("conexao"),    
    REATOR("reator"),
    TUBULACAO("tubulacao"),
    UNKNOWN("unknown");
    
    private final String _equipament;
    
    private EquipamentType(final String equipament){
        
        this._equipament = equipament;
    
    }
    
    public String getString(){
        
        return _equipament;
        
    }
}
