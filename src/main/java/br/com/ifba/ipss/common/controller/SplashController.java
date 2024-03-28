// *************************************************//
// *************** { COMEÇO - Package } ************//
// *************************************************//
package br.com.ifba.ipss.common.controller;
// *************************************************//
// *************** { FIM - Package } ***************//
// *************************************************//

// *************************************************//
// ************ { COMEÇO - Imports } ***************//
// *************************************************//
import br.com.ifba.ipss.feature.label.builder.LabelBuilder;
import br.com.ifba.ipss.feature.splash.model.Splash;
import br.com.ifba.ipss.helper.SizeHelper;
import br.com.ifba.ipss.util.Constantes;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
// *************************************************//
// ************** { FIM - Imports } ****************//
// *************************************************//

/**
 *
 * @author Giovane Neves
 * @since V0.0.1
 */
public class SplashController {
    
    // *************************************************//
    // ****************** { Atributos } ****************//
    // *************************************************//
    
    private Splash s;
    
    // *************************************************//
    // ****************** { Construtor } ***************//
    // *************************************************//
    
    public SplashController(Splash s){
        
        this.s = s;
        
    } // SplashController
    
    // *************************************************//
    // ******************* { Métodos } *****************//
    // *************************************************//
    
    public void criarTelaSplash(JPanel pnlBackground){
          
        JLabel lblLogo = new LabelBuilder()
                .setTitulo("")
                .setImagem(s.getImagem())
                .setLargura(SizeHelper.LARGURA_TELA_SPLASH)
                .setAltura(SizeHelper.ALTURA_TELA_SPLASH)
                .build();
      
        
        pnlBackground.add(lblLogo);
        
        pnlBackground.revalidate();
        pnlBackground.repaint();
        
    } // criarTelaSplash
    
    public void carregar(JFrame telaAtual, JFrame novaTela){
        
        s.getBarraProgresso().setStringPainted(true);
        s.getBarraProgresso().setValue(0);
        s.getBarraProgresso().setSize(new Dimension(300, 23));
        
        SwingWorker<Void, Integer> worker = new SwingWorker<Void, Integer>() {
            @Override
            protected Void doInBackground() throws Exception {
                for (int i = 0; i <= 100; i++) {
                    try {
                        Thread.sleep(Constantes.DELAY_CARREGAMENTO);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    publish(i); // Atualiza a barra de progresso
                }
                return null;
            } // doInBackground

            @Override
            protected void process(java.util.List<Integer> chunks) {
                
                int latestValue = chunks.get(chunks.size() - 1);
                s.getBarraProgresso().setValue(latestValue);
                s.getBarraProgresso().setString(latestValue + "%");
                
                if(latestValue == 100){
                    abrirTelaInicial(telaAtual, novaTela);
                }
                
            } // process
            
        }; // SwingWorker

        worker.execute();
        
    } // carregar
    
    public void abrirTelaInicial(JFrame telaAtual, JFrame novaTela){
        
        novaTela.setVisible(true);
        telaAtual.dispose();
        
    } // abrirTelaInicial
    
} // class SplashController
