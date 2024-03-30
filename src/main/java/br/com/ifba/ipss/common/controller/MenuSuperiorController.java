package br.com.ifba.ipss.common.controller;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

/**
 *
 * @author giovane
 */
public class MenuSuperiorController {
 
    public static ImageIcon girarEquipamento(ImageIcon imgIcon, int graus) {
        Image img = imgIcon.getImage();
        int largura = img.getWidth(null);
        int altura = img.getHeight(null);

        // Cria uma nova imagem girada
        BufferedImage novaImagem = new BufferedImage(altura, largura, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = novaImagem.createGraphics();
        g2d.rotate(Math.toRadians(graus), largura / 2, altura / 2);
        g2d.drawImage(img, 0, 0, null);
        g2d.dispose();

        // Redimensiona a nova imagem para ajustar ao tamanho do JLabel
        int larguraLabel = largura; // Largura do JLabel
        int alturaLabel = altura; // Altura do JLabel
        Image imagemRedimensionada = novaImagem.getScaledInstance(larguraLabel, alturaLabel, Image.SCALE_SMOOTH);
        
        // Cria um ImageIcon com a imagem redimensionada
        ImageIcon iconRedimensionado = new ImageIcon(imagemRedimensionada);

        return iconRedimensionado;
    }
        
}
