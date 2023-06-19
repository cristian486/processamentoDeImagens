package br.com.uri.operacoes.aritmeticas;

import br.com.uri.operacoes.Normalizar;
import br.com.uri.operacoes.Operacao;
import br.com.uri.utils.EntradaValorNumerico;

import java.awt.image.BufferedImage;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Multiplicacao implements Operacao {
    @Override
    public BufferedImage executar(BufferedImage primeiraImagem, BufferedImage segundaImagem) {
        BufferedImage imagemResultante = new BufferedImage(primeiraImagem.getWidth(), primeiraImagem.getHeight(), BufferedImage.TYPE_BYTE_GRAY);

        int valorMultiplicacao = EntradaValorNumerico.obterValorInteiro("Insira o valor para a multiplicação: ", 1, 255);

        IntStream.range(0, primeiraImagem.getHeight()).forEach(linha -> {
            IntStream.range(0, primeiraImagem.getWidth()).forEach(coluna -> {
                int pixel = primeiraImagem.getRGB(linha, coluna);
                int alpha = (pixel >> 24) & 0xff;
                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue = pixel & 0xff;

                red *= valorMultiplicacao;
                green *= valorMultiplicacao;
                blue *= valorMultiplicacao;

                pixel = (alpha << 24) | (red << 16) | (green << 8) | blue;
                imagemResultante.setRGB(linha, coluna, pixel);
            });
        });

        Normalizar.normalizarImagem(imagemResultante);

        return imagemResultante;
    }
}
