package br.com.ifba.ipss.view;

import br.com.ifba.ipss.controller.MenuFerramentasController;
import br.com.ifba.ipss.helper.PathHelper;
import br.com.ifba.ipss.feature.equipamento.model.Tubulacao;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.ImageIcon;

/**
 *
 * @author Giovane Neves
 */
public class AreaDeTrabalho extends javax.swing.JFrame {

    
    // *************************************************//
    // ************** { Variáveis Globais } ************//
    // *************************************************//
    private final MenuFerramentasController _menuFerramentasController;
    
    /**
     * Cria a interface com os componentes iniciais
     */
    public AreaDeTrabalho() {
        
        _menuFerramentasController = new MenuFerramentasController(pegarListaEquipamentos(PathHelper.FERRAMENTAS_JSON));
        
        inicializadorPersonalizado();
        initComponents();
    }

    public Map<String, List<?>> pegarListaEquipamentos(String caminho){
        
        Map<String, List<?>> equipamentos = new HashMap<>();
        
        try(FileReader leitor = new FileReader(caminho)){
            
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(leitor, JsonObject.class);

            JsonObject tubulacoesJson = jsonObject.getAsJsonArray("tubulacoes").get(0).getAsJsonObject();
            
            equipamentos.put("Tubulações", pegarTubulacoes(tubulacoesJson));
            
        } catch(IOException ex){
            ex.printStackTrace();
        }
        
        return equipamentos;
    }
    
    public List<Tubulacao> pegarTubulacoes(JsonObject tubulacoesJson){
        
        List<Tubulacao> tubulacoes = new ArrayList<>();
        
        Tubulacao tubulacao = new Tubulacao();
          
        for (Map.Entry<String, JsonElement> entry : tubulacoesJson.entrySet()) {
            
            String chave = entry.getKey();
            JsonElement valor = entry.getValue();

            switch (chave) {
                case "_nome" -> tubulacao.set_nome(valor.getAsString());
                case "_caminhoImagem" -> tubulacao.set_caminhoImagem(valor.getAsString());
                case "_x" -> tubulacao.set_x(valor.getAsInt());
                case "_y" -> tubulacao.set_y(valor.getAsInt());
                case "_largura" -> tubulacao.set_larguraPx(valor.getAsInt());
                case "_altura" -> tubulacao.set_alturaPx(valor.getAsInt());
                case "_diametroInterno" -> tubulacao.set_diametroInterno(valor.getAsString());
                default -> {}
            }
    
                    }
        
        tubulacoes.add(tubulacao);
        
        return tubulacoes;
    }
    
    private void inicializadorPersonalizado(){
        
        ImageIcon favicon = new ImageIcon(getClass().getResource("/images/logo.jpg"));
        
        this.setIconImage(favicon.getImage());
        this.setTitle("EduSimLab - Laboratório Virtual de Simulação de Processos");
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PnlAreadeTrabalho = new javax.swing.JPanel();
        PnlFixo = new javax.swing.JPanel();
        LabTítulo = new javax.swing.JLabel();
        PnlMenu = new javax.swing.JPanel();
        pnlEspacoTrabalho = new javax.swing.JPanel();
        PnlFerramentas = new javax.swing.JPanel();
        btnTubulacoes = new javax.swing.JButton();
        btnConexoes = new javax.swing.JButton();
        btnEquipamentos = new javax.swing.JButton();
        btnVavulas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        PnlAreadeTrabalho.setBackground(new java.awt.Color(204, 204, 204));
        PnlAreadeTrabalho.setPreferredSize(new java.awt.Dimension(1300, 820));
        PnlAreadeTrabalho.setLayout(null);

        PnlFixo.setBackground(new java.awt.Color(0, 102, 51));

        LabTítulo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LabTítulo.setForeground(new java.awt.Color(255, 255, 255));
        LabTítulo.setText("EduSimLab - Laboratório Virtual de Simulação de Processos");
        PnlFixo.add(LabTítulo);

        PnlAreadeTrabalho.add(PnlFixo);
        PnlFixo.setBounds(0, 0, 1410, 30);

        PnlMenu.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout PnlMenuLayout = new javax.swing.GroupLayout(PnlMenu);
        PnlMenu.setLayout(PnlMenuLayout);
        PnlMenuLayout.setHorizontalGroup(
            PnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1370, Short.MAX_VALUE)
        );
        PnlMenuLayout.setVerticalGroup(
            PnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        PnlAreadeTrabalho.add(PnlMenu);
        PnlMenu.setBounds(0, 30, 1370, 30);

        pnlEspacoTrabalho.setBackground(new java.awt.Color(204, 204, 204));
        pnlEspacoTrabalho.setLayout(null);
        PnlAreadeTrabalho.add(pnlEspacoTrabalho);
        pnlEspacoTrabalho.setBounds(0, 60, 1300, 810);

        PnlFerramentas.setBackground(new java.awt.Color(255, 255, 255));

        btnTubulacoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Botão tubulação.png"))); // NOI18N
        btnTubulacoes.setBorder(null);
        btnTubulacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTubulacoesActionPerformed(evt);
            }
        });

        btnConexoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Botão conexões.png"))); // NOI18N
        btnConexoes.setBorder(null);
        btnConexoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConexoesActionPerformed(evt);
            }
        });

        btnEquipamentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Botão equipamentos.png"))); // NOI18N
        btnEquipamentos.setBorder(null);
        btnEquipamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEquipamentosActionPerformed(evt);
            }
        });

        btnVavulas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Botão vávulas.png"))); // NOI18N
        btnVavulas.setBorder(null);
        btnVavulas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVavulasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PnlFerramentasLayout = new javax.swing.GroupLayout(PnlFerramentas);
        PnlFerramentas.setLayout(PnlFerramentasLayout);
        PnlFerramentasLayout.setHorizontalGroup(
            PnlFerramentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlFerramentasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnlFerramentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTubulacoes)
                    .addComponent(btnConexoes)
                    .addComponent(btnEquipamentos)
                    .addComponent(btnVavulas))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        PnlFerramentasLayout.setVerticalGroup(
            PnlFerramentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlFerramentasLayout.createSequentialGroup()
                .addContainerGap(357, Short.MAX_VALUE)
                .addComponent(btnTubulacoes)
                .addGap(5, 5, 5)
                .addComponent(btnConexoes)
                .addGap(5, 5, 5)
                .addComponent(btnEquipamentos)
                .addGap(5, 5, 5)
                .addComponent(btnVavulas)
                .addGap(288, 288, 288))
        );

        PnlAreadeTrabalho.add(PnlFerramentas);
        PnlFerramentas.setBounds(1300, 20, 120, 820);

        getContentPane().add(PnlAreadeTrabalho);
        PnlAreadeTrabalho.setBounds(0, 0, 1420, 880);

        setSize(new java.awt.Dimension(1429, 889));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnConexoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConexoesActionPerformed
        
        
        if(!this._menuFerramentasController.is_menuAberto() || this._menuFerramentasController.is_menuAberto() && !this._menuFerramentasController.get_nomeMenuAberto().equals("Conexões")){
            
            this._menuFerramentasController.abrirMenuFerramentas(this.pnlEspacoTrabalho, this, "Conexões"); 
            
        } else {
            
            this._menuFerramentasController.fecharMenuFerramentas(this.pnlEspacoTrabalho);
            
        }
       
    }//GEN-LAST:event_btnConexoesActionPerformed

    private void btnVavulasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVavulasActionPerformed
      
        if(!this._menuFerramentasController.is_menuAberto() || this._menuFerramentasController.is_menuAberto() && !this._menuFerramentasController.get_nomeMenuAberto().equals("Válvulas")){
            
            this._menuFerramentasController.abrirMenuFerramentas(this.pnlEspacoTrabalho,this, "Válvulas"); 
            
        } else {
            
            this._menuFerramentasController.fecharMenuFerramentas(this.pnlEspacoTrabalho);
            
        }
    }//GEN-LAST:event_btnVavulasActionPerformed

    private void btnEquipamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEquipamentosActionPerformed
        
        if(!this._menuFerramentasController.is_menuAberto() || this._menuFerramentasController.is_menuAberto() && !this._menuFerramentasController.get_nomeMenuAberto().equals("Equipamentos")){
            
            this._menuFerramentasController.abrirMenuFerramentas(this.pnlEspacoTrabalho,this, "Equipamentos"); 
            
        } else {
            
            this._menuFerramentasController.fecharMenuFerramentas(this.pnlEspacoTrabalho);
            
        }
        
    }//GEN-LAST:event_btnEquipamentosActionPerformed

    private void btnTubulacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTubulacoesActionPerformed
        
        if(!this._menuFerramentasController.is_menuAberto() || this._menuFerramentasController.is_menuAberto() && !this._menuFerramentasController.get_nomeMenuAberto().equals("Tubulações")){
            
            this._menuFerramentasController.abrirMenuFerramentas(this.pnlEspacoTrabalho,this, "Tubulações"); 
            
        } else {
            
            this._menuFerramentasController.fecharMenuFerramentas(this.pnlEspacoTrabalho);
            
        }
        
    }//GEN-LAST:event_btnTubulacoesActionPerformed

    
    

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
            java.util.logging.Logger.getLogger(AreaDeTrabalho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AreaDeTrabalho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AreaDeTrabalho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AreaDeTrabalho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AreaDeTrabalho().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabTítulo;
    private javax.swing.JPanel PnlAreadeTrabalho;
    private javax.swing.JPanel PnlFerramentas;
    private javax.swing.JPanel PnlFixo;
    private javax.swing.JPanel PnlMenu;
    private javax.swing.JButton btnConexoes;
    private javax.swing.JButton btnEquipamentos;
    private javax.swing.JButton btnTubulacoes;
    private javax.swing.JButton btnVavulas;
    private javax.swing.JPanel pnlEspacoTrabalho;
    // End of variables declaration//GEN-END:variables
}
