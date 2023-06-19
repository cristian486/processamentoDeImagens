package br.com.uri.operacoes.filtros;

import br.com.uri.operacoes.Operacao;

import java.awt.image.BufferedImage;
import java.util.stream.IntStream;

public class FiltroPorMedia implements Operacao {
    @Override
    public BufferedImage executar(BufferedImage primeiraImagem, BufferedImage segundaImagem) {
        BufferedImage imagemResultante = new BufferedImage(primeiraImagem.getWidth(), primeiraImagem.getHeight(), BufferedImage.TYPE_INT_RGB);

        IntStream.range(0, primeiraImagem.getWidth()).forEach(linha -> {
            IntStream.range(0, primeiraImagem.getHeight()).forEach(coluna -> {
                int averageValue = getAverageValue(primeiraImagem, linha, coluna);
                imagemResultante.setRGB(linha, coluna, averageValue << 16 | averageValue << 8 | averageValue);
            });
        });

        return imagemResultante;
    }

    private int getAverageValue(BufferedImage image, int x, int y) {
        int sum = 0;

        for(int i = -1; i < 2; i++) {
            for(int j = -1; j < 2; j++) {
                int posX = x + i;
                int posY = y + 1;
                if (posX >= 0 && posX < image.getWidth() && posY >= 0 && posY < image.getHeight()) {
                    sum += image.getRGB(posX, posY) & 0xFF;
                }
            }
        }

        return sum / 9;
    }
}
