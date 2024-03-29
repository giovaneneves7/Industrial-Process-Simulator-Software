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
public enum NomeEquipamento {
    
    BOMBA("Bombas"),
    CONEXAO("Conexões"),
    REATOR("Reatores"),
    TUBULACAO("Tubulações"),
    VALVULA("Válvulas");
    
    private final String nomeEquipamento;
    
    private NomeEquipamento(String nomeEquipamento){
    
        this.nomeEquipamento = nomeEquipamento;
        
    }
    
    public String getString(){
        
        return nomeEquipamento;
        
    }
}
