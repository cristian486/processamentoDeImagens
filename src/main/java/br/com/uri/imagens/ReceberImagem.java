package br.com.uri.imagens;

import br.com.uri.imagens.Carregar;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Scanner;

public class ReceberImagem {

    public BufferedImage receberImagem(String mensagem, Scanner scanner) throws IOException {

        BufferedImage imagem = null;

        while(imagem == null) {
            apresentarMensagem(mensagem);
            String caminhoImagem = scanner.nextLine();
            try {
                imagem = Carregar.carregarImagem(caminhoImagem);
            } catch (IOException ex) {
                apresentarMensagem("Não foi possível abrir a imagem. Certifique-se de que o caminho passado esta correto!");
            }
        }


        return imagem;
    }

    private void apresentarMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}
