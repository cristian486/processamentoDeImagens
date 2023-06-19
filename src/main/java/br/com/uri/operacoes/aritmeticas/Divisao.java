package br.com.uri.operacoes.aritmeticas;

import br.com.uri.operacoes.Normalizar;
import br.com.uri.operacoes.Operacao;
import br.com.uri.utils.EntradaValorNumerico;

import java.awt.image.BufferedImage;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Divisao implements Operacao {
    @Override
    public BufferedImage executar(BufferedImage primeiraImagem, BufferedImage segundaImagem) {
        BufferedImage imagemResultante = new BufferedImage(primeiraImagem.getWidth(), primeiraImagem.getHeight(), BufferedImage.TYPE_BYTE_GRAY);

        int divisor = EntradaValorNumerico.obterValorInteiro("Insira o valor para a divisão: ", 1, 255);

        IntStream.range(0, primeiraImagem.getWidth()).forEach(linha -> {
            IntStream.range(0, primeiraImagem.getHeight()).forEach(coluna -> {
                int valorPixelPrimeiraImagem = primeiraImagem.getRGB(linha, coluna) & 0xFF;;
                int novoValor = valorPixelPrimeiraImagem / divisor;
                imagemResultante.setRGB(linha, coluna, novoValor << 16 | novoValor << 8 | novoValor);
            });
        });

        Normalizar.normalizarImagem(imagemResultante);

        return imagemResultante;
    }

}
