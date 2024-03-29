package br.com.ifba.ipss.feature.conexao.domain.service;

import br.com.ifba.ipss.feature.conexao.domain.model.Conexao;
import br.com.ifba.ipss.feature.conexao.domain.repository.ConexaoRepositoryImpl;
import br.com.ifba.ipss.feature.conexao.domain.repository.IConexaoRepository;
import java.util.List;

/**
 *
 * @author Giovane Neves
 * @since V0.0.1
 */
public class ConexaoServiceImpl implements IConexaoService{

    private final IConexaoRepository conexaoRepository = new ConexaoRepositoryImpl();
    
    @Override
    public List<Conexao> pegarEquipamentos() {

        return conexaoRepository.pegarConexoes();

    }
    
}
