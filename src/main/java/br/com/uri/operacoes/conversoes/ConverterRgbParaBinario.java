package br.com.uri.operacoes.conversoes;

import br.com.uri.operacoes.Operacao;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.stream.IntStream;

public class ConverterRgbParaBinario implements Operacao {

    @Override
    public BufferedImage executar(BufferedImage primeiraImagem, BufferedImage none) {
        BufferedImage imagemResultante = new BufferedImage(primeiraImagem.getWidth(), primeiraImagem.getHeight(), BufferedImage.TYPE_BYTE_BINARY);

        // Configurar o limiar para converter em binário
        int threshold = 127;

        IntStream.range(0, primeiraImagem.getWidth()).forEach(linha -> {
            IntStream.range(0, primeiraImagem.getHeight()).forEach(coluna -> {
                int rgb = primeiraImagem.getRGB(linha, coluna);
                int alpha = (rgb >> 24) & 0xff;
                int red = (rgb >> 16) & 0xff;
                int green = (rgb >> 8) & 0xff;
                int blue = rgb & 0xff;

                // Converte o pixel em binário
                int binario = (red + green + blue) / 3;

                // Define o valor binário do pixel
                int novoRGB = (alpha << 24) | (binario << 16) | (binario << 8) | binario;
                imagemResultante.setRGB(linha, coluna, novoRGB);
            });
        });

        return imagemResultante;
    }
}
