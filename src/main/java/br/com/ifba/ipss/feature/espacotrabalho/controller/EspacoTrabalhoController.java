package br.com.ifba.ipss.feature.espacotrabalho.controller;

import br.com.ifba.ipss.feature.espacotrabalho.domain.service.IEspacoTrabalhoService;
import br.com.ifba.ipss.feature.label.domain.model.Label;

import static br.com.ifba.ipss.infrastructure.service.ServiceManager.pegarService;
import java.util.Map;

/**
 *
 * @author Giovane Neves
 * @since V0.0.1
 */
public class EspacoTrabalhoController {
    
    private IEspacoTrabalhoService espacoTrabalhoService;
    
    public EspacoTrabalhoController(){
        
        espacoTrabalhoService = pegarService(IEspacoTrabalhoService.class);
        
    }
    
    public boolean salvarEspacoTrabalho(Map<String, Label> mapa){
        
        return this.espacoTrabalhoService.salvarEspacoTrabalho(mapa);
        
    }
    
    
}
