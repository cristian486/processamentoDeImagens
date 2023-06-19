package br.com.uri.utils;

import javax.swing.*;

public class EntradaValorNumerico {

    public static int obterValorInteiro(String frase, int min, int max) {
        int valor = Integer.MIN_VALUE;

        while(valor < min || valor > max) {
            try {
                String valorEntrada = JOptionPane.showInputDialog(null, frase);
                valor = Integer.parseInt(valorEntrada);
            } catch (NumberFormatException e) {
                System.out.println("Valor de entrada inválido");
            }
        }

        return valor;
    }

    public static double obterValorFlutuante(String frase, double min, double max) {
        double valor = -1d;

        while(valor < min || valor > max) {
            try {
                String valorEntrada = JOptionPane.showInputDialog(null, frase);
                valor = Double.parseDouble(valorEntrada);
            } catch (NumberFormatException e) {
                System.out.println("Valor de entrada inválido");
            }
        }

        return valor;
    }
}
