package br.com.uri;

import java.awt.image.BufferedImage;

public class ValidarImagens {

    public static boolean validarDimensaoImagens(BufferedImage imagemUm, BufferedImage imagemDois) {
        if (imagemUm.getWidth() != imagemDois.getWidth() || imagemUm.getHeight() != imagemDois.getHeight())
            return false;

        return true;
    }
}
