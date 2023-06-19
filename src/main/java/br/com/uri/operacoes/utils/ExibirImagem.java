package br.com.uri.operacoes.utils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ExibirImagem {

    public static void exibir(BufferedImage imagem, String tituloJanela, int duracao) {
        SwingUtilities.invokeLater(() -> {
            JFrame janela = new JFrame(tituloJanela);
            janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            JLabel label = new JLabel(new ImageIcon(imagem));
            janela.getContentPane().add(label);

            // Definir o tamanho da janela igual ao tamanho da imagem
            janela.pack();

            // Obter a dimensão da tela
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int screenWidth = screenSize.width;
            int screenHeight = screenSize.height;

            // Definir a posição central da janela
            int windowWidth = janela.getWidth();
            int windowHeight = janela.getHeight();
            int windowX = (screenWidth - windowWidth) / 2;
            int windowY = (screenHeight - windowHeight) / 2;
            janela.setBounds(windowX, windowY, windowWidth, windowHeight);

            janela.setVisible(true);

            try {
                Thread.sleep(duracao);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            janela.dispose();
        });
    }
}
