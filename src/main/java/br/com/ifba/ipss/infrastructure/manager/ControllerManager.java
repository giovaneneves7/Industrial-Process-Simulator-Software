// *************************************************//
// *************** { COMEÇO - Package } ************//
// *************************************************//

package br.com.ifba.ipss.infrastructure.manager;

// *************************************************//
// *************** { FIM - Package } ***************//
// *************************************************//

// *************************************************//
// ************ { COMEÇO - Imports } ***************//
// *************************************************//

import br.com.ifba.ipss.common.controller.ViewController;
import br.com.ifba.ipss.feature.equipamento.controller.EquipamentoController;
import br.com.ifba.ipss.feature.equipamento.domain.service.IEquipamentoService;
import br.com.ifba.ipss.feature.parametrossimulacao.controller.ParametrosSimulacaoController;
import br.com.ifba.ipss.feature.parametrossimulacao.widget.ParametrosDaSimulacao;
import br.com.ifba.ipss.infrastructure.interfaces.ApplicationController;
import br.com.ifba.ipss.util.Constantes;
import java.util.HashMap;
import java.util.Map;

// *************************************************//
// ************** { FIM - Imports } ****************//
// *************************************************//

/**
 *
 * @author Giovane Neves
 * @since V0.0.1
 */
public class ControllerManager {
    
    private static Map<String, ApplicationController> controllerMap;
    
    static {
        
        EquipamentoController equipamentoController = new EquipamentoController(ServiceManager.find(IEquipamentoService.class));
        ParametrosSimulacaoController parametrosSimulacaoController = new ParametrosSimulacaoController();
        ViewController viewController = new ViewController();
        
        controllerMap = new HashMap<>(){{
            put("equipamento", equipamentoController);
            put(Constantes.PARAMETROS_SIMULACAO_CONTROLLER, parametrosSimulacaoController);
            put(Constantes.VIEW_CONTROLLER, viewController);
            
        }};
        
    }
    
    public static <T>T find(String controller){
        
        if(controllerMap.containsKey(controller)){
            
            return (T) controllerMap.get(controller);
        }
       
        return null;
        
    }
    
}
