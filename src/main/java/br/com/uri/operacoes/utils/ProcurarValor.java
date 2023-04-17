package br.com.uri.operacoes.utils;

import java.awt.image.BufferedImage;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class ProcurarValor {

    public static int valorMaximoDaImagem(BufferedImage imagem) {
        AtomicInteger maiorValor = new AtomicInteger(0);

        IntStream.range(0, imagem.getWidth()).forEach(linha -> {
            IntStream.range(0, imagem.getHeight()).forEach(coluna -> {
                if((imagem.getRGB(linha, coluna) & 0xFF) > maiorValor.get())
                    maiorValor.set(imagem.getRGB(linha, coluna));
            });
        });

        return maiorValor.get();
    }

    public static int valorMinimoDaImagem(BufferedImage imagem) {
        AtomicInteger menorValor = new AtomicInteger(999999);

        IntStream.range(0, imagem.getWidth()).forEach(linha -> {
            IntStream.range(0, imagem.getHeight()).forEach(coluna -> {
                if((imagem.getRGB(linha, coluna) & 0xFF) < menorValor.get())
                    menorValor.set(imagem.getRGB(linha, coluna));
            });
        });

        return menorValor.get();
    }
}
