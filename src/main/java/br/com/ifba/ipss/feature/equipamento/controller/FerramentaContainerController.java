// *************************************************//
// *************** { COMEÇO - Package } ************//
// *************************************************//
package br.com.ifba.ipss.feature.equipamento.controller;
// *************************************************//
// *************** { FIM - Package } ***************//
// *************************************************//

// *************************************************//
// ************ { COMEÇO - Imports } ***************//
// *************************************************//
import br.com.ifba.ipss.feature.equipamento.domain.model.Equipamento;
import br.com.ifba.ipss.feature.label.domain.builder.LabelBuilder;
import br.com.ifba.ipss.feature.tubulacao.domain.model.Tubulacao;
import br.com.ifba.ipss.feature.tubulacao.domain.service.ITubulacaoService;
import br.com.ifba.ipss.feature.tubulacao.domain.service.TubulacaoServiceImpl;
import br.com.ifba.ipss.feature.widget.model.FerramentaContainer;
import br.com.ifba.ipss.util.Constantes;
import java.awt.Font;
import javax.swing.JLabel;
// *************************************************//
// ************** { FIM - Imports } ****************//
// *************************************************//

/**
 *
 * @author Giovane Neves
 * @since V0.0.1
 */
public class FerramentaContainerController<E extends Equipamento> {
    
    private ITubulacaoService tubulacaoService = new TubulacaoServiceImpl();
    
    public FerramentaContainer criarContainer(E equipamento, final int altura, final int largura, final int x, final int y, int qtdInserida, boolean quebrarLinha){
        
        FerramentaContainer container = new FerramentaContainer();
        
        container.setBackground(Constantes.COR_BACKGROUND);
        container.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        container.setForeground(Constantes.COR_BACKGROUND);
        
        container.setBounds(
                x, 
                y,
                altura, 
                largura
        );
        
        container.setLayout(null);
        
        JLabel titulo = new LabelBuilder()
                .setTitulo(equipamento.get_nome())
                .setForeground(Constantes.COR_TEXTO)
                .setFonte(new Font(Constantes.FONTE, Font.PLAIN, Constantes.TAMANHO_FONTE))
                .build();
        
        if(equipamento instanceof Tubulacao tubulacao){
            
            JLabel lblDi = new LabelBuilder()
                .setTitulo(tubulacaoService.pegarDiametroInterno(equipamento.get_nome()))
                .setForeground(Constantes.COR_TEXTO)
                .setFonte(new Font(Constantes.FONTE, Font.PLAIN, Constantes.TAMANHO_FONTE))
                .build();
        
            JLabel lblM = new LabelBuilder()
                .setTitulo(tubulacaoService.pegarComprimento(equipamento.get_nome()))
                .setForeground(Constantes.COR_TEXTO)
                .setFonte(new Font(Constantes.FONTE, Font.PLAIN, Constantes.TAMANHO_FONTE))
                .build();
            
            JLabel imagem = new JLabel(new javax.swing.ImageIcon(getClass().getResource(equipamento.get_caminhoImagem())));
            imagem.setBounds(60, 40, 10, 30);

            int tituloX = (largura - 50) / 2;
            titulo.setBounds(tituloX, 10, 84, 16);
            lblDi.setBounds(5, ((container.getHeight() / 2) - 14), 60, 20);
            lblM.setBounds(5, ((container.getHeight() / 2) - 14) + lblDi.getHeight(), 60, 20);
 
            container.add(titulo);
            container.add(lblDi);
            container.add(lblM);
            container.add(imagem);
        
        }        
        
        return container;
        
    } // criarContainer
    
}
