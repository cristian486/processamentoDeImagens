package br.com.uri.operacoes.filtros;

import br.com.uri.operacoes.Operacao;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Scanner;
import java.util.stream.IntStream;

public class FiltroPorSuavizacaoConservativa implements Operacao {
    @Override
    public BufferedImage executar(BufferedImage primeiraImagem, BufferedImage segundaImagem) {
        BufferedImage imagemResultante = new BufferedImage(primeiraImagem.getWidth(), primeiraImagem.getHeight(), BufferedImage.TYPE_INT_RGB);

        IntStream.range(0, primeiraImagem.getHeight()).forEach(linha -> {
            IntStream.range(0, primeiraImagem.getWidth()).forEach(coluna -> {
                int minValue = this.getMinValue(primeiraImagem, linha, coluna);
                int maxValue = this.getMaxValue(primeiraImagem, linha, coluna);
                int currentValue = primeiraImagem.getRGB(linha, coluna);
                if(currentValue < minValue) {
                    imagemResultante.setRGB(linha, coluna, minValue << 16 | minValue << 8 | minValue);
                } else if(currentValue > maxValue) {
                    imagemResultante.setRGB(linha, coluna, maxValue << 16 | maxValue << 8 | maxValue);
                }
            });
        });


        return imagemResultante;
    }

    private int getMaxValue(BufferedImage image, int x, int y) {
        int max = 0;

        for(int i = -1; i < 2; i++) {
            for(int j = -1; j < 2; j++) {
                int posX = x + i;
                int posY = y + 1;
                if (posX >= 0 && posX < image.getWidth() && posY >= 0 && posY < image.getHeight()) {
                    int pixelValue = image.getRGB(posX, posY) & 0xFF;
                    if(pixelValue > max) max = pixelValue;
                }
            }
        }

        return max;
    }

    private int getMinValue(BufferedImage image, int x, int y) {
        int min = 255;

        for(int i = -1; i < 2; i++) {
            for(int j = -1; j < 2; j++) {
                int posX = x + i;
                int posY = y + 1;
                if (posX >= 0 && posX < image.getWidth() && posY >= 0 && posY < image.getHeight()) {
                    int pixelValue = image.getRGB(posX, posY) & 0xFF;
                    if(pixelValue < min) min = pixelValue;
                }
            }
        }

        return min;
    }
}
