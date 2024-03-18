package br.com.ifba.ipss.view;

import java.awt.Dimension;
import javax.swing.SwingWorker;

/**
 *
 * @author Giovane Neves
 */
public class TelaSplash extends javax.swing.JFrame {

    /**
     * Creates new form TelaSplash
     */
    public TelaSplash() {
        initComponents();
        this.gerenciarTelaSplash();
        
    }
    
    public void gerenciarTelaSplash(){
        prgBarCarregando.setStringPainted(true);
        prgBarCarregando.setValue(0);
        prgBarCarregando.setSize(new Dimension(300, 23));
        
        SwingWorker<Void, Integer> worker = new SwingWorker<Void, Integer>() {
            @Override
            protected Void doInBackground() throws Exception {
                for (int i = 0; i <= 100; i++) {
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    publish(i); // Atualiza a barra de progresso
                }
                return null;
            }

            @Override
            protected void process(java.util.List<Integer> chunks) {
                int latestValue = chunks.get(chunks.size() - 1);
                prgBarCarregando.setValue(latestValue);
                prgBarCarregando.setString(latestValue + "%");
                if(latestValue == 100){
                    new AreaDeTrabalho().setVisible(true);
                    dispose();
                }
            }
        };

        worker.execute(); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBackground = new javax.swing.JPanel();
        prgBarCarregando = new javax.swing.JProgressBar();
        lblLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        pnlBackground.setLayout(null);

        prgBarCarregando.setForeground(new java.awt.Color(255, 255, 255));
        pnlBackground.add(prgBarCarregando);
        prgBarCarregando.setBounds(270, 450, 270, 10);

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.jpg"))); // NOI18N
        lblLogo.setText("jLabel1");
        pnlBackground.add(lblLogo);
        lblLogo.setBounds(0, -140, 841, 700);

        getContentPane().add(pnlBackground);
        pnlBackground.setBounds(0, 0, 790, 650);

        setSize(new java.awt.Dimension(801, 566));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(TelaSplash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaSplash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaSplash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaSplash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaSplash().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblLogo;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JProgressBar prgBarCarregando;
    // End of variables declaration//GEN-END:variables
}
