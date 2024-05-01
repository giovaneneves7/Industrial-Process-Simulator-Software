package br.com.ifba.ipss.infrastructure.manager;

import br.com.ifba.ipss.feature.conexao.domain.repository.ConexaoRepositoryImpl;
import br.com.ifba.ipss.feature.conexao.domain.repository.IConexaoRepository;
import br.com.ifba.ipss.feature.equipamento.domain.repository.EquipamentoRepositoryImpl;
import br.com.ifba.ipss.feature.equipamento.domain.repository.IEquipamentoRepository;
import br.com.ifba.ipss.feature.espacotrabalho.domain.repository.EspacoTrabalhoRepositoryImpl;
import br.com.ifba.ipss.feature.espacotrabalho.domain.repository.IEspacoTrabalhoRepository;
import br.com.ifba.ipss.feature.tubulacao.domain.repository.ITubulacaoRepository;
import br.com.ifba.ipss.feature.tubulacao.domain.repository.TubulacaoRepositoryImpl;
import br.com.ifba.ipss.feature.valvula.domain.repository.IValvulaRepository;
import br.com.ifba.ipss.feature.valvula.domain.repository.ValvulaRepositoryImpl;
import br.com.ifba.ipss.infrastructure.interfaces.ServiceImpl;

import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author Giovane Neves
 * @since V0.0.1
 */
public class RepositoryManager {
    
    private static final Map<Class<?>, ServiceImpl> repositoryMap;
    
    static {
        
        repositoryMap = new HashMap<>(){{
        
            put(IEspacoTrabalhoRepository.class, new EspacoTrabalhoRepositoryImpl());
            put(ITubulacaoRepository.class, new TubulacaoRepositoryImpl());
            put(IConexaoRepository.class, new ConexaoRepositoryImpl());
            put(IEquipamentoRepository.class, new EquipamentoRepositoryImpl());
            put(IValvulaRepository.class, new ValvulaRepositoryImpl());
            
        }};
        
    }
    
    public static ServiceImpl find(Class<?> i){
        
        if(repositoryMap.containsKey(i)){
            
            return repositoryMap.get(i);
            
        }
        
        return null;
        
    } 
    
}
