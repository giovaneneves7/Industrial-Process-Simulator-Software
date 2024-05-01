package br.com.ifba.ipss.infrastructure.generic;

import br.com.ifba.ipss.feature.espacotrabalho.domain.repository.EspacoTrabalhoRepositoryImpl;
import br.com.ifba.ipss.feature.espacotrabalho.domain.repository.IEspacoTrabalhoRepository;
import br.com.ifba.ipss.infrastructure.interfaces.Implementacao;
import br.com.ifba.ipss.infrastructure.interfaces.Interface;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Giovane Neves
 * @since V0.0.1
 */
public class RepositoryManager {
    
    public static final Map<Class<?>, Implementacao> repositoryMap;
    
    static {
        
        repositoryMap = new HashMap<>(){{
        
            put(IEspacoTrabalhoRepository.class, new EspacoTrabalhoRepositoryImpl());
            
        }};
        
    }
    
    public static Implementacao pegarRepositorio(Class<?> i){
        
        if(repositoryMap.containsKey(i)){
            
            return repositoryMap.get(i);
            
        }
        
        return null;
        
    } 
    
}
