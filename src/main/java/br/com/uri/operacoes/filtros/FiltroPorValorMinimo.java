package br.com.uri.operacoes.filtros;

import br.com.uri.operacoes.Operacao;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.stream.IntStream;

public class FiltroPorValorMinimo implements Operacao {
    @Override
    public BufferedImage executar(BufferedImage primeiraImagem, BufferedImage segundaImagem) {
        BufferedImage imagemResultante = new BufferedImage(primeiraImagem.getWidth(), primeiraImagem.getHeight(), BufferedImage.TYPE_INT_RGB);

        int width = primeiraImagem.getWidth();
        int height = primeiraImagem.getHeight();

        IntStream.range(1, primeiraImagem.getWidth()).forEach(linha -> {
            IntStream.range(1, primeiraImagem.getHeight()).forEach(coluna -> {
                int minValue = getMinValue(primeiraImagem, linha, coluna);
                imagemResultante.setRGB(linha, coluna, minValue << 16 | minValue << 8 | minValue);
            });
        });

        return imagemResultante;
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
