package br.com.uri;

import br.com.uri.imagens.ReceberImagem;
import br.com.uri.imagens.ValidarImagens;
import br.com.uri.utils.VerificarOpcao;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        ReceberImagem receberImagem = new ReceberImagem();

        BufferedImage primeiraImagem = receberImagem.receberImagem("Insira o caminho absoluto da primeira imagem:", scanner);
        BufferedImage segundaImagem = receberImagem.receberImagem("Insira o caminho absoluto da segunda imagem:", scanner);

        if (primeiraImagem.getWidth() != segundaImagem.getWidth() || primeiraImagem.getHeight() != segundaImagem.getHeight()) {
            if (primeiraImagem.getWidth() > segundaImagem.getWidth() || primeiraImagem.getHeight() > segundaImagem.getHeight()) {
                primeiraImagem = ValidarImagens.validarDimensaoImagens(primeiraImagem, segundaImagem.getWidth(), segundaImagem.getHeight());
            } else {
                segundaImagem = ValidarImagens.validarDimensaoImagens(segundaImagem, primeiraImagem.getWidth(), primeiraImagem.getHeight());
            }
        }

        Main.menu(scanner, primeiraImagem, segundaImagem);

        scanner.close();
    }


    public static void menu(Scanner scanner, BufferedImage primeiraImagem, BufferedImage segundaImagem) throws IOException {

        String opcao = "";
        VerificarOpcao verificar = new VerificarOpcao();

        do {
            System.out.println("\n\n\n0 - Sair");
            System.out.println("Operações Aritméticas:");
            System.out.print("1 - Adição\t");
            System.out.print("2 - Subtração\t");
            System.out.print("3 - Multiplicação\t");
            System.out.print("4 - Divisão\t");
            System.out.print("5 - Média\t");
            System.out.println("6 - Blending");

            System.out.println("\nOperações Lógicas:");
            System.out.print("7 - AND\t");
            System.out.print("8 - OR\t");
            System.out.print("9 - XOR\t");
            System.out.println("10 - NOT");

            System.out.println("\nOutras Operações:");
            System.out.print("11 - RGB para BINÁRIO\t");
            System.out.print("12 - RGB para Escala de Cinza\t");
            System.out.print("13 - Histogram\t");
            System.out.println("14 - Negativo");

            //System.out.print("\u001B[1m"); // Início do negrito
            //System.out.println("\u001B[0m"); // Fim do negrito

            System.out.println("\nFiltros:");
            System.out.print("15 - Por valor máximo\t");
            System.out.print("16 - Por valor mínimo\t");
            System.out.print("17 - Por média\t");
            System.out.print("18 - Por mediana\t");
            System.out.print("19 - Por ordem\t");
            System.out.print("20 - Por suavização conservativa\t");
            System.out.println("21 - Gaussiano");

            opcao = scanner.nextLine();

            verificar.verificar(opcao, primeiraImagem, segundaImagem, scanner);
        } while (!opcao.equals("0"));
    }
}

