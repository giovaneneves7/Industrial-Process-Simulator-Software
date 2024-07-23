// *************************************************//
// *************** { COMEÇO - Package } ************//
// *************************************************//

package br.com.ifba.ipss.view;


// *************************************************//
// *************** { FIM - Package } ***************//
// *************************************************//

// *************************************************//
// ************ { COMEÇO - Imports } ***************//
// *************************************************//

import br.com.ifba.ipss.helper.PathHelper;
import br.com.ifba.ipss.helper.ScreenHelper;
import br.com.ifba.ipss.theme.ThemeManager;
import static br.com.ifba.ipss.util.Dicionario.tr;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

// *************************************************//
// ************** { FIM - Imports } ****************//
// *************************************************//

/**
 *
 * @author Giovane Neves
 * @since V0.0.1
 */
public class TelaInicial extends javax.swing.JFrame {

    public TelaInicial() {
        initComponents();
        customIntl();
        
    } // TelaInicial
    
    /**
     * Faz a incialização personalizada da tela.
     */
    public void customIntl(){
        
        this.btnLoadProject.setBackground(ThemeManager.getColor("primary"));
        this.btnLoadProject.setForeground(ThemeManager.getColor("secondary"));
        this.btnLoadProject.setText(tr(this.btnLoadProject.getText()));
        
        this.btnNewProject.setBackground(ThemeManager.getColor("primary"));
        this.btnNewProject.setForeground(ThemeManager.getColor("secondary"));
        this.btnNewProject.setText(tr(this.btnNewProject.getText()));
        
        this.btnInstructions.setBackground(ThemeManager.getColor("primary"));
        this.btnInstructions.setForeground(ThemeManager.getColor("secondary"));
        this.btnInstructions.setText(tr(this.btnInstructions.getText()));
    } // CustomIntl

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnConfig = new javax.swing.JButton();
        btnLoadProject = new javax.swing.JButton();
        btnNewProject = new javax.swing.JButton();
        btnInstructions = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        btnConfig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/settings.png"))); // NOI18N
        btnConfig.setBorderPainted(false);
        btnConfig.setContentAreaFilled(false);
        jPanel2.add(btnConfig);
        btnConfig.setBounds(600, 370, 110, 100);

        btnLoadProject.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        btnLoadProject.setText("carregar_simulacao");
        btnLoadProject.setBorder(null);
        btnLoadProject.setBorderPainted(false);
        btnLoadProject.setFocusPainted(false);
        btnLoadProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadProjectActionPerformed(evt);
            }
        });
        jPanel2.add(btnLoadProject);
        btnLoadProject.setBounds(240, 120, 310, 60);

        btnNewProject.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        btnNewProject.setText("nova_simulacao");
        btnNewProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewProjectActionPerformed(evt);
            }
        });
        jPanel2.add(btnNewProject);
        btnNewProject.setBounds(240, 190, 310, 60);

        btnInstructions.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        btnInstructions.setText("instrucoes");
        btnInstructions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInstructionsActionPerformed(evt);
            }
        });
        jPanel2.add(btnInstructions);
        btnInstructions.setBounds(240, 260, 310, 60);

        jLabel1.setFont(new java.awt.Font("Kalimati", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 0));
        jLabel1.setText("EduSimLab - v0.0.1");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(280, 60, 250, 70);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 0, 740, 467);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 740, 530);

        setSize(new java.awt.Dimension(742, 499));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnInstructionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInstructionsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInstructionsActionPerformed

    private void btnLoadProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadProjectActionPerformed
        
        dispose();
        ScreenHelper.getScreen(ScreenHelper.LISTA_SIMULACOES).setVisible(true);
        
    }//GEN-LAST:event_btnLoadProjectActionPerformed

    private void btnNewProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewProjectActionPerformed
        
        String input = JOptionPane.showInputDialog(null, tr("insira_o_nome_da_simulacao"), tr("nova_simulacao"), JOptionPane.QUESTION_MESSAGE);
     
        if(input != null && !input.trim().isEmpty()){
            
            String fileName = PathHelper.FILES_PATH.concat(input).concat(".json");
            File file = new File(fileName);
            
            try {
                
                if(file.createNewFile()){
                    
                    ScreenHelper.pegarTela(ScreenHelper.AREA_TRABALHO, fileName);
                    
                } else{
                    
                    JOptionPane.showMessageDialog(null, tr("arquivo_ja_existe"));
                    
                }
                
            } catch (IOException ex) {
                
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, tr("erro_criacao_arquivo"));
                
            }
            
        }
        
    }//GEN-LAST:event_btnNewProjectActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInicial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfig;
    private javax.swing.JButton btnInstructions;
    private javax.swing.JButton btnLoadProject;
    private javax.swing.JButton btnNewProject;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
} // TelaInicial
