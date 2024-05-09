package br.com.ifba.ipss.feature.equipamento.domain.service;

import br.com.ifba.ipss.feature.equipamento.domain.model.Equipamento;
import br.com.ifba.ipss.feature.equipamento.domain.repository.IEquipamentoRepository;
import java.util.List;
import br.com.ifba.ipss.infrastructure.interfaces.ServiceImpl;

/**
 *
 * @author Giovane Neves
 * @since V0.0.1
 */
public class EquipamentoServiceImpl implements IEquipamentoService, ServiceImpl{

    private final IEquipamentoRepository equipamentoRepository;
    
    public EquipamentoServiceImpl(IEquipamentoRepository equipamentoRepository){
        
        this.equipamentoRepository = equipamentoRepository;
        
    }
    @Override
    public List<Equipamento> pegarEquipamentos() {
        return this.equipamentoRepository.pegarListaEquipamentos("equipamentos");
        
    }
    
}
