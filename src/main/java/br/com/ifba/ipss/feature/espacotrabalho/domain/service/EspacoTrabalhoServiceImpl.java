package br.com.ifba.ipss.feature.espacotrabalho.domain.service;

import br.com.ifba.ipss.feature.espacotrabalho.domain.repository.IEspacoTrabalhoRepository;
import br.com.ifba.ipss.feature.label.domain.model.Label;
import java.util.Map;
import br.com.ifba.ipss.infrastructure.interfaces.ServiceImpl;

/**
 *
 * @author Giovane Neves
 * @since V0.0.1
 */
public class EspacoTrabalhoServiceImpl implements IEspacoTrabalhoService, ServiceImpl{

    private final IEspacoTrabalhoRepository espacoTrabalhoRepository;
    
    public EspacoTrabalhoServiceImpl(IEspacoTrabalhoRepository espacoTrabalhoRepository){
        
        this.espacoTrabalhoRepository = espacoTrabalhoRepository;
        
    }
    
    @Override
    public boolean salvarEspacoTrabalho(Map<String, Label> mapa, String workspacePath) {

        return this.espacoTrabalhoRepository.salvarEspacoTrabalho(mapa, workspacePath);
        
    }

    @Override
    public boolean deletarEspacoTrabalho(String workspacePath) {

        return this.espacoTrabalhoRepository.deletarEspacoTrabalho(workspacePath);
        
    }

    @Override
    public Map<String, Label> pegarEspacoTrabalho(String workspacePath) {

        return this.espacoTrabalhoRepository.pegarEspacoTrabalho(workspacePath);
        
    }
    
}
