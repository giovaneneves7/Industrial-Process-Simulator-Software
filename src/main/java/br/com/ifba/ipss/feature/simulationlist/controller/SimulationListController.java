// *************************************************//
// *************** { COMEÇO - Package } ************//
// *************************************************//

package br.com.ifba.ipss.feature.simulationlist.controller;

// *************************************************//
// *************** { FIM - Package } ***************//
// *************************************************//

// *************************************************//
// ************ { COMEÇO - Imports } ***************//
// *************************************************//

import br.com.ifba.ipss.common.controller.ViewController;
import br.com.ifba.ipss.infrastructure.interfaces.ApplicationController;
import br.com.ifba.ipss.infrastructure.manager.ControllerManager;
import br.com.ifba.ipss.util.Constantes;
import br.com.ifba.ipss.feature.simulationlist.view.ListaSimulacoes;
import static br.com.ifba.ipss.util.Dicionario.tr;

import java.awt.Image;

// *************************************************//
// ************** { FIM - Imports } ****************//
// *************************************************//

/**
 *
 * @author Giovane Neves
 */
public class SimulationListController implements ApplicationController{

    private ListaSimulacoes simulationList;
    private final ViewController viewController;
    
    public SimulationListController(final ListaSimulacoes simulationList){
    
        this.simulationList = simulationList;
        viewController = ControllerManager.find(Constantes.VIEW_CONTROLLER);
        
    } // SimulationListController
    
    public void defineScreenTitle(){
        
        viewController.defineScreenTitle(simulationList, tr("lista_simulacao"));
    
    } // defineScreenTitle
    
    public void defineScreenFavicon(final Image img){
        
        viewController.definirLogoAplicacao(simulationList, img);
        
    } // defineScreenFavicon
    
}
