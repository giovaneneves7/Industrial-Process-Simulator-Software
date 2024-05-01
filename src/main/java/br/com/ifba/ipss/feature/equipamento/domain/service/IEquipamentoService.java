package br.com.ifba.ipss.feature.equipamento.domain.service;

import br.com.ifba.ipss.feature.equipamento.domain.model.Equipamento;
import java.util.List;

/**
 *
 * @author Giovane Neves
 * @since V0.0.1
 */
public interface IEquipamentoService extends br.com.ifba.ipss.common.infrastructure.interfaces.IEquipamentoService{

    List<Equipamento> pegarEquipamentos();
    
}
