package br.com.ifba.ipss.feature.conexao.domain.repository;

import br.com.ifba.ipss.feature.conexao.domain.model.Conexao;
import java.util.List;

/**
 *
 * @author Giovane Neves
 * @since V0.0.1
 */
public interface IConexaoRepository {
    
    List<Conexao> pegarConexoes();
    
}
