package br.com.uri;

import br.com.uri.imagens.Salvar;
import br.com.uri.operacoes.*;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class VerificarOpcao {

    public void verificar(String opcao, BufferedImage primeiraImagem, BufferedImage segundaImagem) throws IOException {
        switch(opcao) {
            case "0":
                // Sair
                System.out.println("Programa encerrado.");
                break;
            case "1":
                // Adição
                BufferedImage imagemSoma = new Adicao().executar(primeiraImagem, segundaImagem);
                Salvar.salvarImagem(imagemSoma, "imagemSoma.png");
                break;
            case "2":
                // Subtração
                BufferedImage imagemSubtracao = new Subtracao().executar(primeiraImagem, segundaImagem);
                Salvar.salvarImagem(imagemSubtracao, "imagemSubtracao.png");
                break;
            case "3":
                // Multiplicação
                BufferedImage imagemMultiplicacao = new Multiplicacao().executar(primeiraImagem, segundaImagem);
                Salvar.salvarImagem(imagemMultiplicacao, "imagemMultiplicacao.png");
                break;
            case "4":
                // Divisão
                BufferedImage imagemDivisao = new Divisao().executar(primeiraImagem, segundaImagem);
                Salvar.salvarImagem(imagemDivisao, "imagemDivisao.png");
                break;
            case "5":
                // Média
                BufferedImage imagemMedia = new Media().executar(primeiraImagem, segundaImagem);
                Salvar.salvarImagem(imagemMedia, "imagemMedia.png");
                break;
            case "6":
                // Blending
                BufferedImage imagemBlending = new Blending().executar(primeiraImagem, segundaImagem);
                Salvar.salvarImagem(imagemBlending, "imagemBlending.png");
                break;
            case "7":
                // Blending
                BufferedImage imagemAnd = new And().executar(primeiraImagem, segundaImagem);
                Salvar.salvarImagem(imagemAnd, "imagemAnd.png");
                break;
            case "8":
                // Blending
                BufferedImage imagemOr = new Or().executar(primeiraImagem, segundaImagem);
                Salvar.salvarImagem(imagemOr, "imagemOr.png");
                break;
            case "9":
                // Blending
                BufferedImage imagemXor = new Xor().executar(primeiraImagem, segundaImagem);
                Salvar.salvarImagem(imagemXor, "imagemXor.png");
                break;
            case "10":
                // Blending
                BufferedImage imagemNot = new Not().executar(primeiraImagem, segundaImagem);
                Salvar.salvarImagem(imagemNot, "imagemNot.png");
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }
}
