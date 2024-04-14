package br.com.ifba.ipss.feature.espacotrabalho.domain.service;

import br.com.ifba.ipss.feature.label.domain.model.Label;
import br.com.ifba.ipss.infrastructure.interfaces.Interface;

import java.util.Map;

/**
 *
 * @author Giovane Neves
 * @since V0.0.1
 */
public interface IEspacoTrabalhoService extends Interface{
    
    Map<String, Label> pegarEspacoTrabalho();
    boolean salvarEspacoTrabalho(Map<String, Label> mapa);
    boolean deletarEspacoTrabalho();
    
}
