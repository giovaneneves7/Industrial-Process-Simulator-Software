package br.com.ifba.ipss.common.infrastructure.interfaces;

import br.com.ifba.ipss.feature.equipamento.domain.model.Equipamento;
import java.util.List;

/**
 *
 * @author Giovane Neves
 * @since V0.0.1
 */
public interface IEquipamentoService {
    
    List<? extends Equipamento> pegarEquipamentos();
    
}
