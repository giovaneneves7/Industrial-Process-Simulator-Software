package br.com.ifba.ipss.singleton;

import br.com.ifba.ipss.infrastructure.exception.generic.GenericRepositoryImpl;
import br.com.ifba.ipss.infrastructure.exception.generic.IGenericRepository;

/**
 * @author Giovane Neves
 * @since V0.0.1
 */
public class GenericRepositorySingleton {
    
    private static IGenericRepository instance;
    
    
    private GenericRepositorySingleton(){};
    
    public static synchronized IGenericRepository getInstance(){
        
        if(instance == null)
            return new GenericRepositoryImpl();
        
        return instance;
        
    }
}
