package br.com.uri.imagens;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ValidarImagens {

    public static BufferedImage validarDimensaoImagens(BufferedImage imagemUm, int largura, int altura) {
        BufferedImage resizedImage = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);
        Image resultingImage = imagemUm.getScaledInstance(largura, altura, Image.SCALE_DEFAULT);
        Graphics2D graphics2D = resizedImage.createGraphics();
        graphics2D.drawImage(resultingImage, 0, 0, null);
        graphics2D.dispose();
        return resizedImage;
    }
}
