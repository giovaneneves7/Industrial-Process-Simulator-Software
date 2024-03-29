package br.com.ifba.ipss.feature.conexao.domain.service;

import br.com.ifba.ipss.common.infrastructure.interfaces.IEquipamentoService;
import br.com.ifba.ipss.feature.conexao.domain.model.Conexao;
import java.util.List;

/**
 *
 * @author Giovane Neves
 * @since V0.0.1
 */
public interface IConexaoService extends IEquipamentoService{
    
    List<Conexao> pegarEquipamentos();
    
}
