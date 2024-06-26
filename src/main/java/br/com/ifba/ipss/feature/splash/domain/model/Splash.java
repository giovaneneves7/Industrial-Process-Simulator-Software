package br.com.ifba.ipss.feature.splash.domain.model;

import br.com.ifba.ipss.feature.tela.domain.model.Tela;
import lombok.Data;

/**
 *
 * @author Giovane Neves
 * @since V0.0.1
 */
@Data
public class Splash extends Tela{
    
    private int tempoCarregamento;
    private javax.swing.ImageIcon imagem;
    private javax.swing.JProgressBar barraProgresso;
    
}
