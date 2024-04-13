package br.com.ifba.ipss.feature.espacotrabalho.domain.service;

import br.com.ifba.ipss.feature.espacotrabalho.domain.repository.IEspacoTrabalhoRepository;
import br.com.ifba.ipss.feature.label.domain.model.Label;
import br.com.ifba.ipss.infrastructure.interfaces.Implementacao;
import java.util.Map;

/**
 *
 * @author Giovane Neves
 * @since V0.0.1
 */
public class EspacoTrabalhoServiceImpl implements IEspacoTrabalhoService, Implementacao{

    private final IEspacoTrabalhoRepository espacoTrabalhoRepository;
    
    public EspacoTrabalhoServiceImpl(IEspacoTrabalhoRepository espacoTrabalhoRepository){
        
        this.espacoTrabalhoRepository = espacoTrabalhoRepository;
        
    }
    
    @Override
    public boolean salvarEspacoTrabalho(Map<String, Label> mapa) {

        /*if(mapa.isEmpty()){
            return false;
        }*/
        
        return this.espacoTrabalhoRepository.salvarEspacoTrabalho(mapa);
        
    }
    
}
