package br.com.uri.operacoes.filtros;

import br.com.uri.operacoes.Operacao;
import br.com.uri.utils.EntradaValorNumerico;

import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class FiltroPorOrdem implements Operacao {
    @Override
    public BufferedImage executar(BufferedImage primeiraImagem, BufferedImage segundaImagem) {
        BufferedImage imagemResultante = new BufferedImage(primeiraImagem.getWidth(), primeiraImagem.getHeight(), BufferedImage.TYPE_INT_RGB);

        int ordemMediana = EntradaValorNumerico.obterValorInteiro("Insira o valor a ser utilizado entre 1 e 8: ", 1, 8);

        IntStream.range(0, primeiraImagem.getWidth()).forEach(linha -> {
            IntStream.range(0, primeiraImagem.getHeight()).forEach(coluna -> {
                int medianValue = getMedianValue(primeiraImagem, linha, coluna, ordemMediana);
                imagemResultante.setRGB(linha, coluna, medianValue << 16 | medianValue << 8 | medianValue);
            });
        });

        return imagemResultante;
    }

    private int getMedianValue(BufferedImage image, int x, int y, int ordem) {
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

        return Arrays.stream(values).sorted().toArray()[ordem];
    }

}
