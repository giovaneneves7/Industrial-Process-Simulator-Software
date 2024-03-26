// *************************************************//
// *************** { COMEÇO - Package } ************//
// *************************************************//
package br.com.ifba.ipss.feature.widget.model;
// *************************************************//
// *************** { FIM - Package } ***************//
// *************************************************//

// *************************************************//
// ************ { COMEÇO - Imports } ***************//
// *************************************************//
import br.com.ifba.ipss.feature.label.builder.LabelBuilder;
import br.com.ifba.ipss.feature.equipamento.model.Equipamento;
import br.com.ifba.ipss.feature.equipamento.model.Tubulacao;
import br.com.ifba.ipss.util.Constantes;
import java.awt.Color;
import javax.swing.JLabel;
// *************************************************//
// ************** { FIM - Imports } ****************//
// *************************************************//


/**
 *
 * @author Giovane Neves
 * @since V0.0.1
 */
public class FerramentaContainer<E extends Equipamento> extends javax.swing.JPanel {

    /**
     * Creates new form FerramentaContainer
     */
    public FerramentaContainer(E equipamento, final int altura, final int largura, final int x, final int y, int qtdInserida) {
        initComponents();
        inicializadorPersonalizado(equipamento, altura, largura, x, y, qtdInserida);
        
    }

    public void inicializadorPersonalizado(E equipamento, int altura, int largura, int x, int y, int qtdInserida){
        
        this.setBackground(Constantes.COR_BACKGROUND);
        this.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        this.setForeground(Constantes.COR_BACKGROUND);
        
        this.setBounds(
                (qtdInserida == 0) ? x : (qtdInserida % 2 == 0) ? x * 2 + largura : x, 
                (qtdInserida == 0) ? y : (qtdInserida % 2 != 0) ? y * 2 + altura : y, 
                altura, 
                largura
        );
        this.setLayout(null);
        
        JLabel titulo = new LabelBuilder()
                .setTitulo(equipamento.get_nome())
                .setForeground(Constantes.COR_TEXTO)
                .build();
        

        if(equipamento instanceof Tubulacao tubulacao){
            
            JLabel lblDi = pegarDi(tubulacao);
        
            JLabel lblM = pegarM(tubulacao);
            
            JLabel imagem = new JLabel(new javax.swing.ImageIcon(getClass().getResource(equipamento.get_caminhoImagem())));
            imagem.setBounds(60, 40, 10, 30);

            int tituloX = (largura - 50) / 2;
            titulo.setBounds(tituloX, 10, 84, 16);
            lblDi.setBounds(5, ((this.getHeight() / 2) - 14), 60, 20);
            lblM.setBounds(5, ((this.getHeight() / 2) - 14) + lblDi.getHeight(), 60, 20);
 
            this.add(titulo);
            this.add(lblDi);
            this.add(lblM);
            this.add(imagem);
        
        }        
        
        
    }
    
    
    public JLabel pegarDi(Tubulacao tub){
        
        return new LabelBuilder()
                .setTitulo("Di=".concat(tub.get_diametroInterno().concat("in")))
                .setForeground(Constantes.COR_TEXTO)
                .build();
        
    }
    
    public JLabel pegarM(Tubulacao tub){
        
        return new LabelBuilder()
                    .setTitulo("L=".concat(String.valueOf(tub.getComprimento()).concat("m")))
                    .setForeground(Constantes.COR_TEXTO)
                    .build();
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 297, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
