package br.com.uri;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        ReceberImagem receberImagem = new ReceberImagem();

        BufferedImage primeiraImagem = receberImagem.receberImagem("Insira o caminho absoluto da primeira imagem:", scanner);
        BufferedImage segundaImagem = receberImagem.receberImagem("Insira o caminho absoluto da segunda imagem:", scanner);

        boolean imagensTemAsMesmasDimensoes = ValidarImagens.validarDimensaoImagens(primeiraImagem, segundaImagem);

        if(!imagensTemAsMesmasDimensoes) {
            System.out.println("As imagens devem ter as mesmas dimensões!");
            main(args);
        }

        Main.menu(scanner, primeiraImagem, segundaImagem);

        scanner.close();
    }


    public static void menu(Scanner scanner, BufferedImage primeiraImagem, BufferedImage segundaImagem) throws IOException {

        String opcao = "";
        VerificarOpcao verificar = new VerificarOpcao();

        do {
            System.out.println("Operações Aritméticas:");
            System.out.println("0 - Sair");
            System.out.println("1 - Adição");
            System.out.println("2 - Subtração");
            System.out.println("3 - Multiplicação");
            System.out.println("4 - Divisão");
            System.out.println("5 - Média");
            System.out.println("6 - Blending");

            System.out.println("Operações Lógicas:");
            System.out.println("7 - AND");
            System.out.println("8 - OR");
            System.out.println("9 - XOR");
            System.out.println("10 - NOT");

            opcao = scanner.nextLine();

            verificar.verificar(opcao, primeiraImagem, segundaImagem);
        } while (!opcao.equals("0"));
    }
}

