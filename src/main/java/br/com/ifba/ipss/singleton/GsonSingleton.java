package br.com.ifba.ipss.singleton;

import com.google.gson.Gson;

/**
 *
 * @author Giovane Neves
 * @since V0.0.1
 */
public class GsonSingleton {
    
    private static Gson instance;
    
    private GsonSingleton(){}
    
    public static synchronized Gson getInstance(){
        
        if(instance == null)
            return new Gson();
        
        return instance;
        
    }
}
