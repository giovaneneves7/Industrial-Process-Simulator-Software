// *************************************************//
// *************** { COMEÇO - Package } ************//
// *************************************************//
package br.com.ifba.ipss.model.entity;
// *************************************************//
// *************** { FIM - Package } ***************//
// *************************************************//

// *************************************************//
// ************ { COMEÇO - Imports } ***************//
// *************************************************//
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
// *************************************************//
// ************** { FIM - Imports } ****************//
// *************************************************//

/**
 *
 * @author Giovane Neves
 * @since V0.0.1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Equipamento {
   
    /* TODO: Adicionar dependência do lomnok quando a internet voltar. */

    // *************************************************//
    // ***************** { Atributos } *****************//
    // *************************************************//
    
    private String _nome;          // O nome do equipamento.
    private String _caminhoImagem; // O caminho para a imagem do equipamento.
    private double _x;             // A posição 'X' do equipamento.
    private double _y;             // A posição 'Y' do equipamento.
    private double _largura;       // A largura do equipamento.
    private double _altura;        // A altura do equipamento.
    
} // class Equipamento
