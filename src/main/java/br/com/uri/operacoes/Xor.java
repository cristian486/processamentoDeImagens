package br.com.uri.operacoes;

import java.awt.image.BufferedImage;
import java.util.stream.IntStream;

public class Xor implements Operacao {
    @Override
    public BufferedImage executar(BufferedImage primeiraImagem, BufferedImage segundaImagem) {
        BufferedImage imagemResultante = new BufferedImage(primeiraImagem.getWidth(), primeiraImagem.getHeight(), BufferedImage.TYPE_BYTE_GRAY);

        IntStream.range(0, primeiraImagem.getWidth()).forEach(linha -> {
            IntStream.range(0, primeiraImagem.getHeight()).forEach(coluna -> {
                int valorPixelPrimeiraImagem = primeiraImagem.getRGB(linha, coluna) & 0xFF;
                int novoValor = ~valorPixelPrimeiraImagem;
                imagemResultante.setRGB(linha, coluna, novoValor);
            });
        });

        Normalizar.normalizarImagem(imagemResultante);

        return imagemResultante;
    }
}
