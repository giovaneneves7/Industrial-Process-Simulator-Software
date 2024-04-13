package br.com.ifba.ipss.feature.espacotrabalho.domain.repository;

import br.com.ifba.ipss.feature.label.domain.model.Label;
import br.com.ifba.ipss.infrastructure.interfaces.Interface;
import java.util.Map;

/**
 *
 * @author Giovane Neves
 * @since V0.0.1
 */
public interface IEspacoTrabalhoRepository extends Interface{

    public boolean salvarEspacoTrabalho(Map<String, Label> mapa);
    
}
