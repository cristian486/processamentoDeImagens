package br.com.uri.operacoes.filtros;

import br.com.uri.operacoes.Operacao;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.stream.IntStream;

public class FiltroPorMediana implements Operacao {
    @Override
    public BufferedImage executar(BufferedImage primeiraImagem, BufferedImage segundaImagem) {
        BufferedImage imagemResultante = new BufferedImage(primeiraImagem.getWidth(), primeiraImagem.getHeight(), BufferedImage.TYPE_INT_RGB);

        IntStream.range(0, primeiraImagem.getWidth()).forEach(linha -> {
            IntStream.range(0, primeiraImagem.getHeight()).forEach(coluna -> {
                int maxValue = getMedian(primeiraImagem, linha, coluna);
                imagemResultante.setRGB(linha, coluna, maxValue << 16 | maxValue << 8 | maxValue);
            });
        });

        return imagemResultante;
    }


    private int getMedian(BufferedImage image, int x, int y) {
        int[] values = new int[9];
        int index = 0;
        for(int i = -1; i < 2; i++) {
            for(int j = -1; j < 2; j++) {
                int posX = x + i;
                int posY = y + 1;
                if (posX >= 0 && posX < image.getWidth() && posY >= 0 && posY < image.getHeight()) {
                    int pixelValue = image.getRGB(posX, posY) & 0xFF;
                    values[index++] = pixelValue;
                }
            }
        }

        int halfVector = (int) Math.ceil(9.0 / 2.0);
        return values[halfVector];
    }
}
