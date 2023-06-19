package br.com.uri.operacoes;

import br.com.uri.operacoes.utils.GraficoHistograma;

import java.awt.image.BufferedImage;
import java.util.stream.IntStream;

public class Histograma implements Operacao {

    @Override
    public BufferedImage executar(BufferedImage primeiraImagem, BufferedImage none) {
        BufferedImage imagemResultante = new BufferedImage(primeiraImagem.getWidth() - 1, primeiraImagem.getHeight() - 1, BufferedImage.TYPE_BYTE_GRAY);

        GraficoHistograma grafico = new GraficoHistograma();

        grafico.mostrarGrafico(primeiraImagem, "Histograma - Antes");

        int largura = primeiraImagem.getWidth(), altura = primeiraImagem.getHeight();
        int[] histograma = new int[256];

        IntStream.range(1, primeiraImagem.getWidth()).forEach(linha -> {
            IntStream.range(1, primeiraImagem.getHeight()).forEach(coluna -> {
                int gray = primeiraImagem.getRGB(linha, coluna) & 0xFF;
                histograma[gray]++;
            });
        });

        int ultimoValor = 0;
        int minValor = 500;
        int[] cfd = new int[256];

        for(int i = 0; i < histograma.length; i++) {
            cfd[i] = ultimoValor + histograma[i];
            ultimoValor = cfd[i];
            if(cfd[i] < minValor) minValor = cfd[i];
        }

        int l = histograma.length;

        int finalMinValor = minValor;
        IntStream.range(1, primeiraImagem.getWidth() - 1).forEach(linha -> {
            IntStream.range(1, primeiraImagem.getHeight() - 1).forEach(coluna -> {
                int pixel = primeiraImagem.getRGB(linha, coluna) & 0xFF;
                int novoValor =  (int) Math.floor(  (   (double) (cfd[pixel] - finalMinValor)  / (double) ( (altura * largura) - finalMinValor))  * (double) (l - 1));
                novoValor = novoValor < 0 ? 0 : (novoValor > 255 ? 255 : novoValor);
                // imagemResultante.setRGB(linha, coluna, novoValor << 16 | novoValor << 8 | novoValor);
                imagemResultante.setRGB(linha, coluna, novoValor | novoValor << 8 | novoValor << 16);
            });
        });

        grafico.mostrarGrafico(imagemResultante, "Histograma - Depois");

        return imagemResultante;
    }
}