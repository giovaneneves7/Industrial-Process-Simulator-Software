package br.com.ifba.ipss.feature.valvula.domain.service;

import br.com.ifba.ipss.feature.valvula.domain.model.Valvula;
import br.com.ifba.ipss.feature.valvula.domain.repository.IValvulaRepository;
import br.com.ifba.ipss.infrastructure.interfaces.ServiceImpl;

import java.util.List;

/**
 *
 * @author Giovane Neves
 * @since V0.0.1
 */
public class ValvulaServiceImpl implements IValvulaService, ServiceImpl{

    private final IValvulaRepository valvulaRepository;
    
    public ValvulaServiceImpl(final IValvulaRepository valvulaRepository){
        
        this.valvulaRepository = valvulaRepository;
        
    }
    
    @Override
    public List<Valvula> pegarEquipamentos() {
    
        return this.valvulaRepository.pegarListaEquipamentos("valvulas");
        
    }
    
}
