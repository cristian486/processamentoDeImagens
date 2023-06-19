package br.com.uri.operacoes.filtros;

import br.com.uri.operacoes.Operacao;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class FiltroPorValorMaximo implements Operacao {
    @Override
    public BufferedImage executar(BufferedImage primeiraImagem, BufferedImage segundaImagem) {
        BufferedImage imagemResultante = new BufferedImage(primeiraImagem.getWidth(), primeiraImagem.getHeight(), BufferedImage.TYPE_INT_RGB);

        IntStream.range(1, primeiraImagem.getWidth()).forEach(linha -> {
            IntStream.range(1, primeiraImagem.getHeight()).forEach(coluna -> {
                int maxValue = getMaxValue(primeiraImagem, linha, coluna);
                imagemResultante.setRGB(linha, coluna, maxValue << 16 | maxValue << 8 | maxValue);
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
}
