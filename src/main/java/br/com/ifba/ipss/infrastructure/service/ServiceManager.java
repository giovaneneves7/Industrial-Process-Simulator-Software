package br.com.ifba.ipss.infrastructure.service;

import br.com.ifba.ipss.feature.espacotrabalho.domain.repository.EspacoTrabalhoRepositoryImpl;
import br.com.ifba.ipss.feature.espacotrabalho.domain.repository.IEspacoTrabalhoRepository;
import br.com.ifba.ipss.feature.espacotrabalho.domain.service.EspacoTrabalhoServiceImpl;
import br.com.ifba.ipss.feature.espacotrabalho.domain.service.IEspacoTrabalhoService;
import br.com.ifba.ipss.infrastructure.generic.RepositoryManager;
import br.com.ifba.ipss.infrastructure.interfaces.Implementacao;
import br.com.ifba.ipss.infrastructure.interfaces.Interface;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Giovane Neves
 * @since V0.0.1
 */
public class ServiceManager {
    
    public static final Map<Class<?>, Implementacao> serviceMap;
    
    static {
        
        serviceMap = new HashMap<>() {{
        
            put(
                    IEspacoTrabalhoService.class, 
                    new EspacoTrabalhoServiceImpl(
                            (EspacoTrabalhoRepositoryImpl)
                                    RepositoryManager.pegarRepositorio(IEspacoTrabalhoRepository.class)
                    )
            );
            
        }};
        

        
    }
    
    public static <T>T pegarService(Class<T> i){
        
        if(serviceMap.containsKey(i)){
            
            return (T) serviceMap.get(i);
            
        }
        
        return null;
    }
    
}
