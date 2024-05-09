package br.com.ifba.ipss.feature.equipamento.domain.factory;

import static br.com.ifba.ipss.util.Dicionario.tr;
import br.com.ifba.ipss.common.infrastructure.interfaces.IEquipamentoService;
import br.com.ifba.ipss.feature.equipamento.domain.model.Equipamento;
import br.com.ifba.ipss.infrastructure.exception.ServiceNotFound;
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
    
    public List<? extends Equipamento> pegarFerramentas(String nomeFerramenta) throws ServiceNotFound{
        
        IEquipamentoService equipamentoService = serviceMap.get(nomeFerramenta);
        
        if(equipamentoService != null)
            
            return equipamentoService.pegarEquipamentos();
        else 
            throw new ServiceNotFound(tr("service_nao_encontrado"));
        
        
    }
    
    
    
}
