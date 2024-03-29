package br.com.ifba.ipss.feature.equipamento.domain.factory;

import br.com.ifba.ipss.common.infrastructure.interfaces.IEquipamentoService;
import br.com.ifba.ipss.feature.equipamento.domain.model.Equipamento;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Giovane Neves
 * @since V0.0.1
 */
public class EquipamentoFactory {
    
    private final Map<String, IEquipamentoService> serviceMap;
    
    
    public EquipamentoFactory(Map<String, IEquipamentoService> serviceMap){
    
        this.serviceMap = serviceMap;
    
    }
    
    public List<? extends Equipamento> pegarFerramentas(String nomeFerramenta){
        
        IEquipamentoService equipamentoService = serviceMap.get(nomeFerramenta);
        
        if(equipamentoService != null)
            return equipamentoService.pegarEquipamentos();
        else
            return null;
        
        
    }
    
    
    
}
