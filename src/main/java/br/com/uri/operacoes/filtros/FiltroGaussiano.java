package br.com.uri.operacoes.filtros;

import br.com.uri.operacoes.Operacao;
import br.com.uri.utils.EntradaValorNumerico;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.stream.IntStream;

public class FiltroGaussiano implements Operacao {

    @Override
    public BufferedImage executar(BufferedImage primeiraImagem, BufferedImage segundaImagem) {
        BufferedImage imagemResultante = new BufferedImage(primeiraImagem.getWidth(), primeiraImagem.getHeight(), BufferedImage.TYPE_INT_ARGB);

        double sigma = EntradaValorNumerico.obterValorFlutuante("Insira o valor para o sigma: ", 0d, 100d);

        double[][] matrizGaussiana = gerarMatrizGaussiana(5, sigma);

        IntStream.range(1, primeiraImagem.getHeight()).forEach(linha -> {
            IntStream.range(1, primeiraImagem.getWidth()).forEach(coluna -> {
                Color color = this.calcularValorDoPixel(primeiraImagem, matrizGaussiana, coluna, linha);
                imagemResultante.setRGB(coluna, linha, color.getRGB());
            });
        });

        return imagemResultante;
    }

    public double[][] gerarMatrizGaussiana(int tamanho, double sigma) {
        double[][] matrizGaussiana = new double[tamanho][tamanho];
        double soma = 0d;
        int range = tamanho / 2;

        for (int i = -range; i <= range; i++) {
            for (int j = -range; j <= range; j++) {
                double valorGerado = (1.0 / (2.0 * Math.PI * (sigma * sigma))) * Math.exp((- ( ((i * i) + (j * j)) / (2.0 * (sigma * sigma))  )));
                matrizGaussiana[i + range][j + range] = valorGerado;
                soma += valorGerado;
            }
        }

        for (int x = -range; x <= range; x++) {
            for (int y = -range; y <= range; y++) {
                matrizGaussiana[x + range][y + range] =  matrizGaussiana[x + range][y + range] / soma;
            }
        }

        return matrizGaussiana;
    }


    public Color calcularValorDoPixel(BufferedImage image, double[][] matrizGaussiana, int posAtualX, int posAtualY) {
        int tamanhoMatriz = matrizGaussiana.length / 2;
        int linha = 0;
        int coluna = 0;
        double somaR = 0;
        double somaG = 0;
        double somaB = 0;

        for (int i = -tamanhoMatriz; i <= tamanhoMatriz; i++) {
            for (int j = -tamanhoMatriz; j <= tamanhoMatriz; j++) {
                int pixelX = posAtualX + j;
                int pixelY = posAtualY + i;

                if (pixelX >= 0 && pixelX < image.getWidth() && pixelY >= 0 && pixelY < image.getHeight()) {
                    Color cor = new Color(image.getRGB(pixelX, pixelY));
                    double peso = matrizGaussiana[linha][coluna];
                    somaR += cor.getRed() * peso;
                    somaG += cor.getGreen() * peso;
                    somaB += cor.getBlue() * peso;
                }
                coluna = (coluna + 1) >= matrizGaussiana[0].length ? 0 : coluna + 1;
            }
            linha = (linha + 1) >= matrizGaussiana.length ? 0 : linha + 1;
        }

        int novoR = (int) Math.round(somaR);
        int novoG = (int) Math.round(somaG);
        int novoB = (int) Math.round(somaB);

        novoR = Math.min(255, Math.max(0, novoR));
        novoG = Math.min(255, Math.max(0, novoG));
        novoB = Math.min(255, Math.max(0, novoB));

        return new Color(novoR, novoG, novoB);
    }

}
