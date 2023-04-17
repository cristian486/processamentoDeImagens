package br.com.uri.imagens;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Carregar {

    public static BufferedImage carregarImagem(String caminhoArquivo) throws IOException {
        File arquivo = new File(caminhoArquivo);
        BufferedImage imagem = ImageIO.read(arquivo);
        return imagem;
    }
}
