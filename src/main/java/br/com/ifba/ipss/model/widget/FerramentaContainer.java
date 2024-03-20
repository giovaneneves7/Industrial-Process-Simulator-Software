package br.com.ifba.ipss.model.widget;

import br.com.ifba.ipss.model.entity.Equipamento;
import java.awt.Color;
import javax.swing.JLabel;

/**
 *
 * @author Giovane Neves
 */
public class FerramentaContainer<E extends Equipamento> extends javax.swing.JPanel {

    /**
     * Creates new form FerramentaContainer
     */
    public FerramentaContainer(E equipamento) {
        initComponents();
        inicializadorPersonalizado(equipamento);
        
    }

    public void inicializadorPersonalizado(E equipamento){
        
        this.setBackground(Color.decode("#5E5E5E"));
        this.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        this.setForeground(new java.awt.Color(255, 255, 255));
        this.setBounds(0, 0, 280, 350);
        this.setLayout(null);
        
        JLabel titulo = new JLabel(equipamento.get_nome());
        titulo.setBounds(10, 10, 64, 16);
        
        JLabel imagem = new JLabel(new javax.swing.ImageIcon(getClass().getResource(equipamento.get_caminhoImagem())));
        imagem.setBounds(40, 40, 10, 30);
        
        this.add(titulo);
        this.add(imagem);
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