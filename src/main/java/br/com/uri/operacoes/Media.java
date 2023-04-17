package br.com.uri.operacoes;

import java.awt.image.BufferedImage;
import java.util.stream.IntStream;

public class Media implements Operacao {
    @Override
    public BufferedImage executar(BufferedImage primeiraImagem, BufferedImage segundaImagem) {
        BufferedImage imagemResultante = new BufferedImage(primeiraImagem.getWidth(), primeiraImagem.getHeight(), BufferedImage.TYPE_BYTE_GRAY);

        IntStream.range(0, primeiraImagem.getWidth()).forEach(linha -> {
            IntStream.range(0, primeiraImagem.getHeight()).forEach(coluna -> {
                int valorPixelPrimeiraImagem = primeiraImagem.getRGB(linha, coluna) & 0xFF;
                int valorPixelSegundaImagem = segundaImagem.getRGB(linha, coluna) & 0xFF;
                int novoValor = (valorPixelSegundaImagem + valorPixelSegundaImagem) / 2;
                imagemResultante.setRGB(linha, coluna, novoValor << 16 | novoValor << 8 | novoValor);
            });
        });

        Normalizar.normalizarImagem(imagemResultante);

        return imagemResultante;
    }
}
