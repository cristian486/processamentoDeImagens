package br.com.uri.operacoes;

import java.awt.image.BufferedImage;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Blending implements Operacao {
    @Override
    public BufferedImage executar(BufferedImage primeiraImagem, BufferedImage segundaImagem) {
        BufferedImage imagemResultante = new BufferedImage(primeiraImagem.getWidth(), primeiraImagem.getHeight(), BufferedImage.TYPE_BYTE_GRAY);

        double alpha = this.informarAlpha(new Scanner(System.in).useLocale(Locale.US));

        IntStream.range(0, primeiraImagem.getWidth()).forEach(linha -> {
            IntStream.range(0, primeiraImagem.getHeight()).forEach(coluna -> {
                int cor1 = primeiraImagem.getRGB(linha, coluna);
                int cor2 = segundaImagem.getRGB(linha, coluna);

                int r1 = (cor1 >> 16) & 0xFF;
                int g1 = (cor1 >> 8) & 0xFF;
                int b1 = cor1 & 0xFF;

                int r2 = (cor2 >> 16) & 0xFF;
                int g2 = (cor2 >> 8) & 0xFF;
                int b2 = cor2 & 0xFF;

                int r = (int) ((1 - alpha) * r1 + alpha * r2);
                int g = (int) ((1 - alpha) * g1 + alpha * g2);
                int b = (int) ((1 - alpha) * b1 + alpha * b2);

                int novaCor = (r << 16) | (g << 8) | b;
                imagemResultante.setRGB(linha, coluna, novaCor);
            });
        });

        Normalizar.normalizarImagem(imagemResultante);

        return imagemResultante;
    }

    private double informarAlpha(Scanner scanner) {

        System.out.println("Informe um valor entre 0.0 e 1.0 para o alfa: ");
        Double alpha = scanner.nextDouble();

        if(alpha < 0.0 || alpha > 1.0) this.informarAlpha(scanner);

        return alpha;
    }
}
