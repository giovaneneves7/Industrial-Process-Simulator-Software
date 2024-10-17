// *************************************************//
// *************** { COMEÇO - Package } ************//
// *************************************************//

package br.com.ifba.ipss.feature.equipamento.domain.model;

// *************************************************//
// *************** { FIM - Package } ***************//
// *************************************************//

// *************************************************//
// ************ { COMEÇO - Imports } ***************//
// *************************************************//

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import br.com.ifba.ipss.util.EquipamentType;

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
   
    // *************************************************//
    // ***************** { Atributos } *****************//
    // *************************************************//
    
    private String id;             // O ID do equipamento.
    private String _nome;          // O nome do equipamento.
    private String thumbnail;      // A thumbnail do equipamento.
    private String _caminhoImagem; // O caminho para a imagem do equipamento.
    private double _x;             // A posição 'X' do equipamento.
    private double _y;             // A posição 'Y' do equipamento.
    private double _larguraPx;     // A largura do equipamento em pixels.
    private double _alturaPx;      // A altura do equipamento em pixels.
    private double _comprimentoM;  // O comprimento do equipamento em metros.
    private Map<String, Boolean> entradas; 
    private boolean canMirroring;  // Valor booleano. Pode ou não espelhar.
    private EquipamentType type;   // O tipo do equipamento.
    private String axios;          // Se horizontal ou vertical.
    private boolean canBottomConnect; // Se é permitida a conexão na parte inferior.
    private boolean canLeftConnect;// Se é permitida a conexão na esquerda;
    private boolean canRightConnect; // Se é permitida a conexão na direita.
    private boolean canTopConnect; // Se é permitida a conexão no topo.
    private boolean canRotate;     // Se é permitida a rotação do equipamento.
    private boolean topAlreadyConnected; // Se já há uma conexão no topo (exclusivo para reator).
    private boolean mirrored;     // Se o equipamento está espelhado.
    private double perdaCarga;    // A perda de carga do equipamento.
    
} // class Equipamento
