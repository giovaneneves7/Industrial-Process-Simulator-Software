package br.com.ifba.ipss.infrastructure.manager;

import br.com.ifba.ipss.feature.equipamento.controller.EquipamentoController;
import br.com.ifba.ipss.feature.equipamento.domain.service.IEquipamentoService;
import br.com.ifba.ipss.infrastructure.interfaces.ApplicationController;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Giovane Neves
 * @since V0.0.1
 */
public class ControllerManager {
    
    private static Map<String, ApplicationController> controllerMap;
    
    static {
        
        controllerMap = new HashMap<>(){{
        
            put("equipamento", new EquipamentoController(ServiceManager.find(IEquipamentoService.class)));
            
        }};
        
    }
    
    public static <T>T find(String controller){
        
        if(controllerMap.containsKey(controller)){
            
            return (T) controllerMap.get(controller);
        }
       
        return null;
        
    }
    
}
