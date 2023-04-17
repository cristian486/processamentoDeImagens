package br.com.uri;

import br.com.uri.imagens.Carregar;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Scanner;

public class ReceberImagem {

    public BufferedImage receberImagem(String mensagem, Scanner scanner) throws IOException {
        System.out.println(mensagem);
        String caminhoImagem = scanner.nextLine();

        return Carregar.carregarImagem(caminhoImagem);
    }
}
