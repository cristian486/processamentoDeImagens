package br.com.uri.operacoes;

import br.com.uri.operacoes.utils.ProcurarValor;

import java.awt.image.BufferedImage;
import java.util.stream.IntStream;

public class Normalizar {

    public static void normalizarImagem(BufferedImage imagem) {
        int valorMaximo = ProcurarValor.valorMaximoDaImagem(imagem) & 0xFF;
        int valorMinimo = ProcurarValor.valorMinimoDaImagem(imagem) & 0xFF;

        IntStream.range(0, imagem.getWidth()).forEach(linha -> {
            IntStream.range(0, imagem.getHeight()).forEach(coluna -> {
                int valorPixel = imagem.getRGB(linha, coluna) & 0xFF;
                int valorNormalizado = Normalizar.normalizarValor(valorMaximo, valorMinimo, valorPixel);
                imagem.setRGB(linha, coluna, valorNormalizado << 16 | valorNormalizado << 8 | valorNormalizado);
            });
        });
    }


    private static int normalizarValor(int valorMaximo, int valorMinimo, int valor) {
        Double valorNormalizado =  ((double) 255 / ((double) valorMaximo - (double) valorMinimo)) * ((double)  valor - (double) valorMinimo);
        return valorNormalizado.intValue();
    }
}
