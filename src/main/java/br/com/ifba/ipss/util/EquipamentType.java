package br.com.ifba.ipss.util;

/**
 *
 * @author Giovane Neves
 */
public enum EquipamentType {
    
    BOMBA_CENTRIFUGA("bomba_centrifuga"),
    CONEXAO("conexao"),    
    REATOR("reator"),
    TANQUE("tanque"),
    TORRE_DESTILACAO("torre_destilacao"),
    TUBULACAO("tubulacao"),
    UNKNOWN("unknown"),
    VALVULA("valvula");
    
    private final String _equipament;
    
    private EquipamentType(final String equipament){
        
        this._equipament = equipament;
    
    }
    
    public String getString(){
        
        return _equipament;
        
    }
}
