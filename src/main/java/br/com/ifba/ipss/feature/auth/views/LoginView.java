package br.com.ifba.ipss.feature.auth.views;

import br.com.ifba.ipss.theme.ThemeManager;
import static br.com.ifba.ipss.util.Dicionario.tr;

/**
 *
 * @author Giovane Neves
 * @since V0.0.1
 */
public class LoginView extends javax.swing.JPanel {

    /**
     * Creates new form Login
     */
    public LoginView() {
        initComponents();
        customIntl();
    }
    
    public void customIntl(){
        
        this.btnLogin.setBackground(ThemeManager.getColor("secondary"));
        this.btnLogin.setForeground(ThemeManager.getColor("primary"));
        this.btnLogin.setText(tr(this.btnLogin.getText()));
        
        this.lblViewTitle.setText(tr(this.lblViewTitle.getText()));
        this.lblViewTitle.setForeground(ThemeManager.getColor("secondary"));
        
        this.txtUsername.setText(tr(this.txtUsername.getText()));
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblViewIcon = new javax.swing.JLabel();
        lblViewTitle = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 153, 102));
        setLayout(null);

        lblViewIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/scientist.png"))); // NOI18N
        add(lblViewIcon);
        lblViewIcon.setBounds(220, 30, 32, 32);

        lblViewTitle.setText("acesso_orientador");
        add(lblViewTitle);
        lblViewTitle.setBounds(260, 40, 160, 16);

        txtUsername.setText("nome_usuario");
        add(txtUsername);
        txtUsername.setBounds(90, 80, 420, 40);

        txtPassword.setText("jPasswordField1");
        add(txtPassword);
        txtPassword.setBounds(90, 140, 420, 40);

        btnLogin.setText("entrar");
        add(btnLogin);
        btnLogin.setBounds(200, 190, 210, 50);

        jButton1.setBackground(new java.awt.Color(255, 51, 51));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("X");
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(540, 0, 60, 40);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        this.setVisible(false);
        
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lblViewIcon;
    private javax.swing.JLabel lblViewTitle;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
