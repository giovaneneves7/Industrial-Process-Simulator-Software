package br.com.ifba.ipss.feature.espacotrabalho.controller;

import br.com.ifba.ipss.feature.espacotrabalho.domain.service.IEspacoTrabalhoService;
import br.com.ifba.ipss.feature.label.domain.model.Label;
import java.util.Map;
import static br.com.ifba.ipss.infrastructure.manager.ServiceManager.find;

/**
 *
 * @author Giovane Neves
 * @since V0.0.1
 */
public class EspacoTrabalhoController {
    
    private IEspacoTrabalhoService espacoTrabalhoService;
    
    public EspacoTrabalhoController(){
        
        espacoTrabalhoService = find(IEspacoTrabalhoService.class);
        
    }
    
    public Map<String, Label> pegarEspacoTrabalho(){
        
        return this.espacoTrabalhoService.pegarEspacoTrabalho();
        
    }
    public boolean salvarEspacoTrabalho(Map<String, Label> mapa){
        
        return this.espacoTrabalhoService.salvarEspacoTrabalho(mapa);
        
    }
    
    public boolean deletarEspacoTrabalho(){
        
        return this.espacoTrabalhoService.deletarEspacoTrabalho();
        
    }
    
    
}
