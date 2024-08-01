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
import br.com.ifba.ipss.common.controller.AreaDeTrabalhoController;
import br.com.ifba.ipss.feature.conexao.domain.service.IConexaoService;
import br.com.ifba.ipss.feature.tubulacao.domain.service.ITubulacaoService;
import br.com.ifba.ipss.helper.ScreenHelper;
import br.com.ifba.ipss.infrastructure.manager.ServiceManager;
import br.com.ifba.ipss.util.Constantes;
import static br.com.ifba.ipss.util.Dicionario.tr;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
// *************************************************//
// ************** { FIM - Imports } ****************//
// *************************************************//

/**
 *
 * @author Giovane Neves
 * @since V0.0.1
 */
public class AreaDeTrabalho extends javax.swing.JFrame {

    
    // *************************************************//
    // ****************** { Atributos } ****************//
    // *************************************************//
    private final AreaDeTrabalhoController areaDeTrabalhoController = new AreaDeTrabalhoController(this);
    
    private final ITubulacaoService tubulacaoService = ServiceManager.find(ITubulacaoService.class);
    private final IConexaoService conexaoService = ServiceManager.find(IConexaoService.class);
    
    public static boolean emModoRemocao = false;
    public static boolean emModoConexao = false;
    
    public static String workspacePathString;
    
    private Rectangle selectionArea;
    private Point selectionInitialPoint;
    
    /**
     * Cria a interface com os componentes iniciais
     */
    public AreaDeTrabalho(String workspacePath) {
        
        workspacePathString = workspacePath;
        inicializadorPersonalizado();
        initComponents();

        this.areaDeTrabalhoController.setPnlEspacoTrabalho(pnlEspacoTrabalho);
        
        List<javax.swing.JButton> botoes = List.of(
                btnGirarEquipamento,
                btnConectarEquipamentos,
                btnRemoverEquipamento,
                btnLimparEspacoTrabalho,
                btnSalvarEspacoTrabalho,
                btnSimular,
                btnTubulacoes,
                btnConexoes,
                btnVavulas,
                btnEquipamentos,
                btnMirror
        );
        
        this.areaDeTrabalhoController.mudarEfeitoHoverNoBotao(botoes);
        this.areaDeTrabalhoController.carregarEquipamentos(workspacePath);
        this.areaDeTrabalhoController.setWorkspacePath(workspacePath);
        
        addTooltipToButtons();
        addMouseListeners();
        
    } // AreaDeTrabalho

    private void addMouseListeners() {
        pnlEspacoTrabalho.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                selectionInitialPoint = evt.getPoint();
                selectionArea = new Rectangle();
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                repaint();
            }
        });

        pnlEspacoTrabalho.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            
            @Override
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                int x = Math.min(selectionInitialPoint.x, evt.getX());
                int y = Math.min(selectionInitialPoint.y, evt.getY());
                int width = Math.abs(selectionInitialPoint.x - evt.getX());
                int height = Math.abs(selectionInitialPoint.y - evt.getY());
                width = Math.min(width, pnlEspacoTrabalho.getWidth() - x);
                height = Math.min(height, pnlEspacoTrabalho.getHeight() - y);

                selectionArea.setBounds(x, y, width, height);
                repaint();
            }
            
        });
    }
    
    private void addTooltipToButtons(){
        
        this.btnSalvarEspacoTrabalho.setToolTipText(tr("salvar_area_trabalho"));
        this.btnLimparEspacoTrabalho.setToolTipText(tr("limpar_area_trabalho"));
        this.btnGirarEquipamento.setToolTipText(tr("girar_equipamento"));
        this.btnRemoverEquipamento.setToolTipText(tr("remover_equipamento"));
        this.btnConectarEquipamentos.setToolTipText(tr("conectar_equipamento"));
        this.btnMirror.setToolTipText(tr("espelhar"));
        
    } // addTooltipToButtons

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (selectionArea != null) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.draw(selectionArea);
        }
    }
    
    private void inicializadorPersonalizado(){
        
        ImageIcon favicon = new ImageIcon(getClass().getResource(Constantes.CAMINHO_LOGO));
        this.areaDeTrabalhoController.definirLogoAplicacao(favicon.getImage());
        this.areaDeTrabalhoController.definirTituloAplicacao();
                
    } // inicializadorPersonalizado
    
 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBackgruond = new javax.swing.JPanel();
        PnlFixo = new javax.swing.JPanel();
        LabTítulo = new javax.swing.JLabel();
        PnlMenu = new javax.swing.JPanel();
        pnlSpanSpace1 = new javax.swing.JPanel();
        btnGirarEquipamento = new javax.swing.JButton();
        pnlSpanSpace4 = new javax.swing.JPanel();
        btnMirror = new javax.swing.JButton();
        pnlSpanSpace5 = new javax.swing.JPanel();
        btnConectarEquipamentos = new javax.swing.JButton();
        pnlSpanSpace3 = new javax.swing.JPanel();
        btnRemoverEquipamento = new javax.swing.JButton();
        btnSimular = new javax.swing.JButton();
        btnLimparEspacoTrabalho = new javax.swing.JButton();
        pnlSpanSpace = new javax.swing.JPanel();
        btnSalvarEspacoTrabalho = new javax.swing.JButton();
        pnlSpanSpace2 = new javax.swing.JPanel();
        pnlEspacoTrabalho = new javax.swing.JPanel();
        lblNotificacaoDeEstado = new javax.swing.JLabel();
        PnlBotoes = new javax.swing.JPanel();
        btnTubulacoes = new javax.swing.JButton();
        btnConexoes = new javax.swing.JButton();
        btnEquipamentos = new javax.swing.JButton();
        btnVavulas = new javax.swing.JButton();
        btnReturnToHome = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(null);

        pnlBackgruond.setBackground(new java.awt.Color(204, 204, 204));
        pnlBackgruond.setPreferredSize(new java.awt.Dimension(1300, 820));
        pnlBackgruond.setLayout(null);

        PnlFixo.setBackground(new java.awt.Color(0, 102, 51));

        LabTítulo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LabTítulo.setForeground(new java.awt.Color(255, 255, 255));
        LabTítulo.setText("EduSimLab - Laboratório Virtual de Simulação de Processos");
        PnlFixo.add(LabTítulo);

        pnlBackgruond.add(PnlFixo);
        PnlFixo.setBounds(0, 0, 1410, 30);

        PnlMenu.setBackground(new java.awt.Color(255, 255, 255));
        PnlMenu.setLayout(new javax.swing.BoxLayout(PnlMenu, javax.swing.BoxLayout.LINE_AXIS));

        pnlSpanSpace1.setBackground(new java.awt.Color(255, 255, 255));
        pnlSpanSpace1.setMaximumSize(new java.awt.Dimension(30, 50));

        javax.swing.GroupLayout pnlSpanSpace1Layout = new javax.swing.GroupLayout(pnlSpanSpace1);
        pnlSpanSpace1.setLayout(pnlSpanSpace1Layout);
        pnlSpanSpace1Layout.setHorizontalGroup(
            pnlSpanSpace1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        pnlSpanSpace1Layout.setVerticalGroup(
            pnlSpanSpace1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        PnlMenu.add(pnlSpanSpace1);

        btnGirarEquipamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/spin.png"))); // NOI18N
        btnGirarEquipamento.setBorderPainted(false);
        btnGirarEquipamento.setContentAreaFilled(false);
        btnGirarEquipamento.setFocusPainted(false);
        btnGirarEquipamento.setName("btnGirar"); // NOI18N
        btnGirarEquipamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGirarEquipamentoActionPerformed(evt);
            }
        });
        PnlMenu.add(btnGirarEquipamento);

        pnlSpanSpace4.setBackground(new java.awt.Color(255, 255, 255));
        pnlSpanSpace4.setMaximumSize(new java.awt.Dimension(10, 50));

        javax.swing.GroupLayout pnlSpanSpace4Layout = new javax.swing.GroupLayout(pnlSpanSpace4);
        pnlSpanSpace4.setLayout(pnlSpanSpace4Layout);
        pnlSpanSpace4Layout.setHorizontalGroup(
            pnlSpanSpace4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        pnlSpanSpace4Layout.setVerticalGroup(
            pnlSpanSpace4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        PnlMenu.add(pnlSpanSpace4);

        btnMirror.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mirror.png"))); // NOI18N
        btnMirror.setBorderPainted(false);
        btnMirror.setContentAreaFilled(false);
        PnlMenu.add(btnMirror);
        btnMirror.getAccessibleContext().setAccessibleName("btnMirror");

        pnlSpanSpace5.setBackground(new java.awt.Color(255, 255, 255));
        pnlSpanSpace5.setMaximumSize(new java.awt.Dimension(10, 50));

        javax.swing.GroupLayout pnlSpanSpace5Layout = new javax.swing.GroupLayout(pnlSpanSpace5);
        pnlSpanSpace5.setLayout(pnlSpanSpace5Layout);
        pnlSpanSpace5Layout.setHorizontalGroup(
            pnlSpanSpace5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        pnlSpanSpace5Layout.setVerticalGroup(
            pnlSpanSpace5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        PnlMenu.add(pnlSpanSpace5);

        btnConectarEquipamentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/connection.png"))); // NOI18N
        btnConectarEquipamentos.setBorderPainted(false);
        btnConectarEquipamentos.setContentAreaFilled(false);
        btnConectarEquipamentos.setName("btnConectar"); // NOI18N
        btnConectarEquipamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConectarEquipamentosActionPerformed(evt);
            }
        });
        PnlMenu.add(btnConectarEquipamentos);

        pnlSpanSpace3.setBackground(new java.awt.Color(255, 255, 255));
        pnlSpanSpace3.setMaximumSize(new java.awt.Dimension(10, 50));

        javax.swing.GroupLayout pnlSpanSpace3Layout = new javax.swing.GroupLayout(pnlSpanSpace3);
        pnlSpanSpace3.setLayout(pnlSpanSpace3Layout);
        pnlSpanSpace3Layout.setHorizontalGroup(
            pnlSpanSpace3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        pnlSpanSpace3Layout.setVerticalGroup(
            pnlSpanSpace3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        PnlMenu.add(pnlSpanSpace3);

        btnRemoverEquipamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/trash.png"))); // NOI18N
        btnRemoverEquipamento.setBorderPainted(false);
        btnRemoverEquipamento.setContentAreaFilled(false);
        btnRemoverEquipamento.setFocusPainted(false);
        btnRemoverEquipamento.setName("btnRemover"); // NOI18N
        btnRemoverEquipamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverEquipamentoActionPerformed(evt);
            }
        });
        PnlMenu.add(btnRemoverEquipamento);

        btnSimular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/play.png"))); // NOI18N
        btnSimular.setBorderPainted(false);
        btnSimular.setContentAreaFilled(false);
        btnSimular.setFocusPainted(false);
        btnSimular.setFocusable(false);
        btnSimular.setMaximumSize(new java.awt.Dimension(106, 46));
        btnSimular.setMinimumSize(new java.awt.Dimension(106, 46));
        btnSimular.setName("btnSimular"); // NOI18N
        btnSimular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimularActionPerformed(evt);
            }
        });
        PnlMenu.add(btnSimular);

        btnLimparEspacoTrabalho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete_file.png"))); // NOI18N
        btnLimparEspacoTrabalho.setBorderPainted(false);
        btnLimparEspacoTrabalho.setContentAreaFilled(false);
        btnLimparEspacoTrabalho.setFocusPainted(false);
        btnLimparEspacoTrabalho.setName("btnLimpar"); // NOI18N
        btnLimparEspacoTrabalho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparEspacoTrabalhoActionPerformed(evt);
            }
        });
        PnlMenu.add(btnLimparEspacoTrabalho);

        pnlSpanSpace.setBackground(new java.awt.Color(255, 255, 255));
        pnlSpanSpace.setMaximumSize(new java.awt.Dimension(10, 50));

        javax.swing.GroupLayout pnlSpanSpaceLayout = new javax.swing.GroupLayout(pnlSpanSpace);
        pnlSpanSpace.setLayout(pnlSpanSpaceLayout);
        pnlSpanSpaceLayout.setHorizontalGroup(
            pnlSpanSpaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        pnlSpanSpaceLayout.setVerticalGroup(
            pnlSpanSpaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        PnlMenu.add(pnlSpanSpace);

        btnSalvarEspacoTrabalho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save.png"))); // NOI18N
        btnSalvarEspacoTrabalho.setContentAreaFilled(false);
        btnSalvarEspacoTrabalho.setFocusPainted(false);
        btnSalvarEspacoTrabalho.setFocusable(false);
        btnSalvarEspacoTrabalho.setName("btnSalvar"); // NOI18N
        btnSalvarEspacoTrabalho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarEspacoTrabalhoActionPerformed(evt);
            }
        });
        PnlMenu.add(btnSalvarEspacoTrabalho);

        pnlSpanSpace2.setBackground(new java.awt.Color(255, 255, 255));
        pnlSpanSpace2.setMaximumSize(new java.awt.Dimension(30, 50));

        javax.swing.GroupLayout pnlSpanSpace2Layout = new javax.swing.GroupLayout(pnlSpanSpace2);
        pnlSpanSpace2.setLayout(pnlSpanSpace2Layout);
        pnlSpanSpace2Layout.setHorizontalGroup(
            pnlSpanSpace2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        pnlSpanSpace2Layout.setVerticalGroup(
            pnlSpanSpace2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        PnlMenu.add(pnlSpanSpace2);

        pnlBackgruond.add(PnlMenu);
        PnlMenu.setBounds(0, 30, 1370, 50);

        pnlEspacoTrabalho.setBackground(new java.awt.Color(204, 204, 204));
        pnlEspacoTrabalho.setLayout(null);

        lblNotificacaoDeEstado.setText("Nenhum modo de edição selecionado");
        pnlEspacoTrabalho.add(lblNotificacaoDeEstado);
        lblNotificacaoDeEstado.setBounds(30, 10, 320, 16);

        pnlBackgruond.add(pnlEspacoTrabalho);
        pnlEspacoTrabalho.setBounds(0, 80, 1250, 710);

        PnlBotoes.setBackground(new java.awt.Color(255, 255, 255));

        btnTubulacoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botao_tubulacoes.png"))); // NOI18N
        btnTubulacoes.setBorder(null);
        btnTubulacoes.setName("btnTubulacoes"); // NOI18N
        btnTubulacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTubulacoesActionPerformed(evt);
            }
        });

        btnConexoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botao_conexoes.png"))); // NOI18N
        btnConexoes.setBorder(null);
        btnConexoes.setName("btnConexoes"); // NOI18N
        btnConexoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConexoesActionPerformed(evt);
            }
        });

        btnEquipamentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botao_equipamentos.png"))); // NOI18N
        btnEquipamentos.setBorder(null);
        btnEquipamentos.setName("btnEquipamentos"); // NOI18N
        btnEquipamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEquipamentosActionPerformed(evt);
            }
        });

        btnVavulas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botao_valvulas.png"))); // NOI18N
        btnVavulas.setBorder(null);
        btnVavulas.setName("btnValvulas"); // NOI18N
        btnVavulas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVavulasActionPerformed(evt);
            }
        });

        btnReturnToHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home.png"))); // NOI18N
        btnReturnToHome.setText("Voltar");
        btnReturnToHome.setContentAreaFilled(false);
        btnReturnToHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnToHomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PnlBotoesLayout = new javax.swing.GroupLayout(PnlBotoes);
        PnlBotoes.setLayout(PnlBotoesLayout);
        PnlBotoesLayout.setHorizontalGroup(
            PnlBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnlBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTubulacoes)
                    .addComponent(btnConexoes)
                    .addComponent(btnEquipamentos)
                    .addComponent(btnVavulas)
                    .addComponent(btnReturnToHome))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        PnlBotoesLayout.setVerticalGroup(
            PnlBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlBotoesLayout.createSequentialGroup()
                .addContainerGap(357, Short.MAX_VALUE)
                .addComponent(btnTubulacoes)
                .addGap(5, 5, 5)
                .addComponent(btnConexoes)
                .addGap(5, 5, 5)
                .addComponent(btnEquipamentos)
                .addGap(5, 5, 5)
                .addComponent(btnVavulas)
                .addGap(74, 74, 74)
                .addComponent(btnReturnToHome, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(159, 159, 159))
        );

        pnlBackgruond.add(PnlBotoes);
        PnlBotoes.setBounds(1250, 0, 120, 820);

        getContentPane().add(pnlBackgruond);
        pnlBackgruond.setBounds(0, 0, 1370, 820);

        setSize(new java.awt.Dimension(1388, 826));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnConexoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConexoesActionPerformed
        
        
        this.gerenciarMenuLateral("conexao");
       
    }//GEN-LAST:event_btnConexoesActionPerformed

    private void btnVavulasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVavulasActionPerformed
      
        this.gerenciarMenuLateral("valvula");
        
    }//GEN-LAST:event_btnVavulasActionPerformed

    private void btnEquipamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEquipamentosActionPerformed
        
        this.gerenciarMenuLateral("equipamento");
        
    }//GEN-LAST:event_btnEquipamentosActionPerformed

    private void btnTubulacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTubulacoesActionPerformed
        
        this.gerenciarMenuLateral("tubulacao");
        
    }//GEN-LAST:event_btnTubulacoesActionPerformed

    private void btnGirarEquipamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGirarEquipamentoActionPerformed
        
        this.areaDeTrabalhoController.mudarStatusModoRotacao(
            !this.areaDeTrabalhoController.isEmModoRotacao()
        );
        this.mudarImagemDeGrupoBotoesSuperior();
        this.areaDeTrabalhoController.exibirMensagemEstadoDeRotacao(lblNotificacaoDeEstado, 4000);
        
    }//GEN-LAST:event_btnGirarEquipamentoActionPerformed

    private void btnConectarEquipamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConectarEquipamentosActionPerformed

        this.areaDeTrabalhoController.mudarStatusModoConexao(
                !this.areaDeTrabalhoController.isEmModoConexao()
        );
        this.mudarImagemDeGrupoBotoesSuperior();
        this.areaDeTrabalhoController.exibirMensagemEstadoDeConexao(lblNotificacaoDeEstado, 4000);
        
    }//GEN-LAST:event_btnConectarEquipamentosActionPerformed

    private void btnRemoverEquipamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverEquipamentoActionPerformed
              
    

        this.areaDeTrabalhoController.mudarStatusModoRemocao(
                !this.areaDeTrabalhoController.isEmModoRemocao()
        );
        this.mudarImagemDeGrupoBotoesSuperior();
        this.areaDeTrabalhoController.exibirMensagemEstadoModoDeRemocao(lblNotificacaoDeEstado, 4000);        
        
    }//GEN-LAST:event_btnRemoverEquipamentoActionPerformed

    private void btnSimularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimularActionPerformed
        
       // botaoSimularController.exibirWidgetDeParametrosSimulacao(this.pnlEspacoTrabalho);
       this.areaDeTrabalhoController.exibirWidgetDeParametrosSimulacao(this.pnlEspacoTrabalho);
       
    }//GEN-LAST:event_btnSimularActionPerformed

    private void btnLimparEspacoTrabalhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparEspacoTrabalhoActionPerformed
        
        this.areaDeTrabalhoController.deletarEspacoTrabalho();
        
    }//GEN-LAST:event_btnLimparEspacoTrabalhoActionPerformed

    private void btnSalvarEspacoTrabalhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarEspacoTrabalhoActionPerformed
      
        this.areaDeTrabalhoController.salvarEspacoTrabalho();
        
    }//GEN-LAST:event_btnSalvarEspacoTrabalhoActionPerformed

    private void btnReturnToHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnToHomeActionPerformed
        
         if(JOptionPane.showOptionDialog(null, tr("deseja_retornar_ao_inicio"), tr("retornar_ao_inicio"), JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, Constantes.SIM_NAO, Constantes.SIM_NAO[0]) == 0){
             
            dispose();
            ScreenHelper.getScreen(ScreenHelper.TELA_INICIAL).setVisible(true);

         }
        
    }//GEN-LAST:event_btnReturnToHomeActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        
    }//GEN-LAST:event_formKeyPressed

    private void gerenciarMenuLateral(String tipoEquipamento){
        
        this.areaDeTrabalhoController.gerenciarMenuLateral(pnlEspacoTrabalho, tipoEquipamento);
        
    }
    
    private void mudarImagemDeGrupoBotoesSuperior(){
           
        this.areaDeTrabalhoController.atualizarImagemBotaoRemover(btnRemoverEquipamento);
        this.areaDeTrabalhoController.atualizarImagemBotaoConectar(btnConectarEquipamentos);
        this.areaDeTrabalhoController.atualizarImagemBotaoGirar(btnGirarEquipamento);

    }
    
    

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
                new AreaDeTrabalho(workspacePathString).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabTítulo;
    private javax.swing.JPanel PnlBotoes;
    private javax.swing.JPanel PnlFixo;
    private javax.swing.JPanel PnlMenu;
    private javax.swing.JButton btnConectarEquipamentos;
    private javax.swing.JButton btnConexoes;
    private javax.swing.JButton btnEquipamentos;
    private javax.swing.JButton btnGirarEquipamento;
    private javax.swing.JButton btnLimparEspacoTrabalho;
    private javax.swing.JButton btnMirror;
    private javax.swing.JButton btnRemoverEquipamento;
    private javax.swing.JButton btnReturnToHome;
    private javax.swing.JButton btnSalvarEspacoTrabalho;
    private javax.swing.JButton btnSimular;
    private javax.swing.JButton btnTubulacoes;
    private javax.swing.JButton btnVavulas;
    private javax.swing.JLabel lblNotificacaoDeEstado;
    private javax.swing.JPanel pnlBackgruond;
    private javax.swing.JPanel pnlEspacoTrabalho;
    private javax.swing.JPanel pnlSpanSpace;
    private javax.swing.JPanel pnlSpanSpace1;
    private javax.swing.JPanel pnlSpanSpace2;
    private javax.swing.JPanel pnlSpanSpace3;
    private javax.swing.JPanel pnlSpanSpace4;
    private javax.swing.JPanel pnlSpanSpace5;
    // End of variables declaration//GEN-END:variables
}
