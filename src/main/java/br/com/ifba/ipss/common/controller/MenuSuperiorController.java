package br.com.ifba.ipss.common.controller;

import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

/**
 *
 * @author giovane
 */
public class MenuSuperiorController {
 
    public static ImageIcon rotate(BufferedImage image, double angle) {
        final double rads = Math.toRadians(angle);
        final double sin = Math.abs(Math.sin(rads));
        final double cos = Math.abs(Math.cos(rads));
        final int w = (int) Math.floor(image.getWidth() * cos + image.getHeight() * sin);
        final int h = (int) Math.floor(image.getHeight() * cos + image.getWidth() * sin);
        final BufferedImage rotatedImage = new BufferedImage(w, h, image.getType());
        final AffineTransform at = new AffineTransform();
        at.translate(w / 2, h / 2);
        at.rotate(rads, 0, 0);
        at.translate(-image.getWidth() / 2, -image.getHeight() / 2);
        final AffineTransformOp rotateOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
        rotateOp.filter(image, rotatedImage);

        return new ImageIcon(rotatedImage);
    }

    public static BufferedImage toBufferedImage(Image image) {
        if (image instanceof BufferedImage) {
            return (BufferedImage) image;
        }
        BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = bufferedImage.createGraphics();
        g2d.drawImage(image, 0, 0, null);
        g2d.dispose();
        return bufferedImage;
    }
    
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
