package br.com.uri.utils;

import br.com.uri.imagens.Salvar;
import br.com.uri.operacoes.*;
import br.com.uri.operacoes.aritmeticas.*;
import br.com.uri.operacoes.conversoes.ConverterRgbParaBinario;
import br.com.uri.operacoes.conversoes.ConverterRgbParaEscalaDeCinza;
import br.com.uri.operacoes.filtros.*;
import br.com.uri.operacoes.logicas.And;
import br.com.uri.operacoes.logicas.Not;
import br.com.uri.operacoes.logicas.Or;
import br.com.uri.operacoes.logicas.Xor;
import br.com.uri.operacoes.utils.ExibirImagem;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Scanner;

public class VerificarOpcao {

    public void verificar(String opcao, BufferedImage primeiraImagem, BufferedImage segundaImagem, Scanner scanner) throws IOException {
        switch(opcao) {
            case "0":
                // Sair
                System.out.println("Programa encerrado.");
                break;
            case "1":
                // Adição
                BufferedImage imagemSoma = new Adicao().executar(primeiraImagem, segundaImagem);
                ExibirImagem.exibir(imagemSoma, "Imagem resultante:", 4000);
                Salvar.salvarImagem(imagemSoma, "imagemSoma.png");
                break;
            case "2":
                // Subtração
                BufferedImage imagemSubtracao = new Subtracao().executar(primeiraImagem, segundaImagem);
                ExibirImagem.exibir(imagemSubtracao, "Imagem resultante:", 4000);
                Salvar.salvarImagem(imagemSubtracao, "imagemSubtracao.png");
                break;
            case "3":
                // Multiplicação
                BufferedImage imagemMultiplicacao = new Multiplicacao().executar(primeiraImagem, segundaImagem);
                ExibirImagem.exibir(imagemMultiplicacao, "Imagem resultante:", 4000);
                Salvar.salvarImagem(imagemMultiplicacao, "imagemMultiplicacao.png");
                break;
            case "4":
                // Divisão
                BufferedImage imagemDivisao = new Divisao().executar(primeiraImagem, segundaImagem);
                ExibirImagem.exibir(imagemDivisao, "Imagem resultante:", 4000);
                Salvar.salvarImagem(imagemDivisao, "imagemDivisao.png");
                break;
            case "5":
                // Média
                BufferedImage imagemMedia = new Media().executar(primeiraImagem, segundaImagem);
                ExibirImagem.exibir(imagemMedia, "Imagem resultante:", 4000);
                Salvar.salvarImagem(imagemMedia, "imagemMedia.png");
                break;
            case "6":
                // Blending
                BufferedImage imagemBlending = new Blending().executar(primeiraImagem, segundaImagem);
                ExibirImagem.exibir(imagemBlending, "Imagem resultante:", 4000);
                Salvar.salvarImagem(imagemBlending, "imagemBlending.png");
                break;
            case "7":
                // AND
                BufferedImage imagemAnd = new And().executar(primeiraImagem, segundaImagem);
                ExibirImagem.exibir(imagemAnd, "Imagem resultante:", 4000);
                Salvar.salvarImagem(imagemAnd, "imagemAnd.png");
                break;
            case "8":
                // OR
                BufferedImage imagemOr = new Or().executar(primeiraImagem, segundaImagem);
                ExibirImagem.exibir(imagemOr, "Imagem resultante:", 4000);
                Salvar.salvarImagem(imagemOr, "imagemOr.png");
                break;
            case "9":
                // XOR
                BufferedImage imagemXor = new Xor().executar(primeiraImagem, segundaImagem);
                ExibirImagem.exibir(imagemXor, "Imagem resultante:", 4000);
                Salvar.salvarImagem(imagemXor, "imagemXor.png");
                break;
            case "10":
                // NOT
                BufferedImage imagemNot = new Not().executar(primeiraImagem, segundaImagem);
                ExibirImagem.exibir(imagemNot, "Imagem resultante:", 4000);
                Salvar.salvarImagem(imagemNot, "imagemNot.png");
                break;
            case "11":
                // RGBtoBIN
                BufferedImage rgbParaBinario = new ConverterRgbParaBinario().executar(primeiraImagem, segundaImagem);
                ExibirImagem.exibir(rgbParaBinario, "Imagem resultante:", 4000);
                Salvar.salvarImagem(rgbParaBinario, "rgbParaBinario.png");
                break;
            case "12":
                // RGBtoGRAY
                BufferedImage rgbParaEscalaDeCinza = new ConverterRgbParaEscalaDeCinza().executar(primeiraImagem, segundaImagem);
                ExibirImagem.exibir(rgbParaEscalaDeCinza, "Imagem resultante:", 4000);
                Salvar.salvarImagem(rgbParaEscalaDeCinza, "rgbParaEscalaDeCinza.png");
                break;
            case "13":
                // HISTOGRAM
                BufferedImage histograma = new Histograma().executar(primeiraImagem, segundaImagem);
                ExibirImagem.exibir(histograma, "Imagem resultante:", 4000);
                Salvar.salvarImagem(histograma, "histograma.png");
                break;
            case "14":
                // NEGATIVO
                BufferedImage negativo = new Negativo().executar(primeiraImagem, segundaImagem);
                ExibirImagem.exibir(negativo, "Imagem resultante:", 4000);
                Salvar.salvarImagem(negativo, "negativo.png");
                break;
            case "15":
                // FILTER BY MAX VALUE
                BufferedImage filtroPorMaiorValor = new FiltroPorValorMaximo().executar(primeiraImagem, segundaImagem);
                ExibirImagem.exibir(filtroPorMaiorValor, "Imagem resultante:", 4000);
                Salvar.salvarImagem(filtroPorMaiorValor, "filtroPorMaiorValor.png");
                break;
            case "16":
                // FILTER BY MIN VALUE
                BufferedImage filtroPorMenorValor = new FiltroPorValorMinimo().executar(primeiraImagem, segundaImagem);
                ExibirImagem.exibir(filtroPorMenorValor, "Imagem resultante:", 4000);
                Salvar.salvarImagem(filtroPorMenorValor, "filtroPorMenorValor.png");
                break;
            case "17":
                // FILTER BY AVERAGE
                BufferedImage filtroPorMedia = new FiltroPorMedia().executar(primeiraImagem, segundaImagem);
                ExibirImagem.exibir(filtroPorMedia, "Imagem resultante:", 4000);
                Salvar.salvarImagem(filtroPorMedia, "filtroPorMedia.png");
                break;
            case "18":
                // FILTER BY MEDIAN
                BufferedImage filtroPorMediana = new FiltroPorMediana().executar(primeiraImagem, segundaImagem);
                ExibirImagem.exibir(filtroPorMediana, "Imagem resultante:", 4000);
                Salvar.salvarImagem(filtroPorMediana, "filtroPorMediana.png");
                break;
            case "19":
                // FILTER BY ORDER
                BufferedImage filtroPorOrdem = new FiltroPorOrdem().executar(primeiraImagem, segundaImagem);
                ExibirImagem.exibir(filtroPorOrdem, "Imagem resultante:", 4000);
                Salvar.salvarImagem(filtroPorOrdem, "filtroPorOrdem.png");
                break;
            case "20":
                // FILTER BY SUAVIZAÇÃO CONSERVATIVA
                BufferedImage filtroSuavizacaoConservativa = new FiltroPorSuavizacaoConservativa().executar(primeiraImagem, segundaImagem);
                ExibirImagem.exibir(filtroSuavizacaoConservativa, "Imagem resultante:", 4000);
                Salvar.salvarImagem(filtroSuavizacaoConservativa, "filtroSuavizacaoConservativa.png");
                break;
            case "21":
                // GAUSSIAN FILTER
                BufferedImage filtroGaussiano = new FiltroGaussiano().executar(primeiraImagem, segundaImagem);
                ExibirImagem.exibir(filtroGaussiano, "Imagem resultante:", 4000);
                Salvar.salvarImagem(filtroGaussiano, "filtroGaussiano.png");
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }
}
