package br.com.ifba.ipss.feature.conexao.domain.service;

import br.com.ifba.ipss.feature.conexao.domain.model.Conexao;
import br.com.ifba.ipss.feature.conexao.domain.repository.IConexaoRepository;
import java.util.List;
import br.com.ifba.ipss.infrastructure.interfaces.ServiceImpl;

/**
 *
 * @author Giovane Neves
 * @since V0.0.1
 */
public class ConexaoServiceImpl implements IConexaoService, ServiceImpl{

    private final IConexaoRepository conexaoRepository;
    
    public ConexaoServiceImpl(IConexaoRepository conexaoRepository){
        
        this.conexaoRepository = conexaoRepository;
        
    }
    
    @Override
    public List<Conexao> pegarEquipamentos() {

        return conexaoRepository.pegarListaEquipamentos("conexoes"); 

    }
    
}
