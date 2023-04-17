package br.com.uri.operacoes;

import java.awt.image.BufferedImage;

public interface Operacao {

    BufferedImage executar(BufferedImage primeiraImagem, BufferedImage segundaImagem);
}
