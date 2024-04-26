package br.com.ifba.ipss.feature.valvula.domain.service;

import br.com.ifba.ipss.common.infrastructure.interfaces.IEquipamentoService;
import br.com.ifba.ipss.feature.valvula.domain.model.Valvula;
import java.util.List;

/**
 *
 * @author Giovane Neves
 * @since V0.0.1
 */
public interface IValvulaService extends IEquipamentoService{
    
    List<Valvula> pegarEquipamentos();
    
}
