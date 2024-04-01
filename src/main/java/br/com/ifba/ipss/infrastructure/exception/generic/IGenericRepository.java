package br.com.ifba.ipss.infrastructure.exception.generic;

import br.com.ifba.ipss.feature.equipamento.domain.model.Equipamento;
import java.util.List;

/**
 *
 * @author Giovane Neves
 * @since V0.0.1
 */
public interface IGenericRepository<Equipamento> {
    
    <E extends Equipamento> List<E> pegarListaEquipamentos(String tipoEquipamento);
    
}
