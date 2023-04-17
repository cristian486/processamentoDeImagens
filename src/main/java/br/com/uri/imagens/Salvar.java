package br.com.uri.imagens;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Salvar {

    public static void salvarImagem(BufferedImage imagem, String caminhoArquivo) throws IOException {
        File arquivo = new File(caminhoArquivo);
        ImageIO.write(imagem, "png", arquivo);
    }
}
