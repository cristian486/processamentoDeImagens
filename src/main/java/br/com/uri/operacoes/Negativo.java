package br.com.uri.operacoes;

import java.awt.image.BufferedImage;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Negativo implements Operacao {
    @Override
    public BufferedImage executar(BufferedImage primeiraImagem, BufferedImage none) {
        BufferedImage imagemResultante = new BufferedImage(primeiraImagem.getWidth(), primeiraImagem.getHeight(), BufferedImage.TYPE_INT_RGB);


        IntStream.range(0, primeiraImagem.getWidth()).forEach(linha -> {
            IntStream.range(0, primeiraImagem.getHeight()).forEach(coluna -> {
                int rgb = primeiraImagem.getRGB(linha, coluna);
                int r = 255 - ((rgb >> 16) & 0xFF);
                int g = 255 - ((rgb >> 8) & 0xFF);
                int b = 255 - (rgb & 0xFF);
                int negativeRGB = (r << 16) | (g << 8) | b;
                imagemResultante.setRGB(linha, coluna, negativeRGB);
            });
        });

        return imagemResultante;
    }
}
