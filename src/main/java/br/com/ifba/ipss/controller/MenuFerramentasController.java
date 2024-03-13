package br.com.ifba.ipss.controller;

import br.com.ifba.ipss.model.Equipamento;
import br.com.ifba.ipss.view.AreaDeTrabalho2;

/**
 *
 * @author Giovane Neves
 */
public class MenuFerramentasController {

    // *************************************************//
    // ****************** { Métodos } ******************//
    // *************************************************//
    
    /**
     * Abre o menu de ferramentas quando um botão é clicado.
     */
    public void abrirMenuFerramentas(){
        
        new AreaDeTrabalho2().setVisible(true);
        
    }
    
    public void fecharMenuFerramentas(){
        
        /* TODO: Adicionar lógica */
        
    }
    
    public void selecionarFerramenta(){
        /* TODO: Adicionar lógica */
    }
    
    public void adicionarFerramentaAAAreaDeTrabalho(){
        /* TODO: Adicionar lógica */
    }
    
    public void removerFerramentaDaAreaDeTrabalho(){
        /* TODO: Adicionar lógica */
    }
    
    public void conectarFerramentas(Equipamento origem, Equipamento destino){
        /* TODO: Adicionar lógica */
    }
}
