package br.com.ifba.ipss.infrastructure.exception;

/**
 *
 * @author Giovane Neves
 * @since V0.0.1
 */
public class ServiceNotFound extends Exception{
    
    public ServiceNotFound(String mensagem){
        
        super(mensagem);
        
    }
    
}
