package br.com.uri.operacoes.conversoes;

import br.com.uri.operacoes.Normalizar;
import br.com.uri.operacoes.Operacao;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.stream.IntStream;

public class ConverterRgbParaEscalaDeCinza implements Operacao {

    @Override
    public BufferedImage executar(BufferedImage primeiraImagem, BufferedImage none) {
        BufferedImage imagemResultante = new BufferedImage(primeiraImagem.getWidth(), primeiraImagem.getHeight(), BufferedImage.TYPE_BYTE_GRAY);


        IntStream.range(0, primeiraImagem.getWidth()).forEach(linha -> {
            IntStream.range(0, primeiraImagem.getHeight()).forEach(coluna -> {
                Color color = new Color(primeiraImagem.getRGB(linha, coluna));
                int gray = (int) (0.2126 * color.getRed() + 0.7152 * color.getGreen() + 0.0722 * color.getBlue());
                Color grayColor = new Color(gray, gray, gray);
                imagemResultante.setRGB(linha, coluna, grayColor.getRGB());
            });
        });

        Normalizar.normalizarImagem(imagemResultante);

        return imagemResultante;
    }
}
