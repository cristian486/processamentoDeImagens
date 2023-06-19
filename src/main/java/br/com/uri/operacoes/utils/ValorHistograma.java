package br.com.uri.operacoes.utils;

import java.util.Objects;

public class ValorHistograma {
    private int i;
    private int fI;
    private int cdf;

    public ValorHistograma(int i, int fI) {
        this.i = i;
        this.fI = fI;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ValorHistograma that = (ValorHistograma) o;
        return i == that.i;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i);
    }

    public void setI(int i) {
        this.i = i;
    }

    public void setfI(int fI) {
        this.fI = fI;
    }

    public void setCdf(int cdf) {
        this.cdf = cdf;
    }

    public int getI() {
        return i;
    }

    public int getfI() {
        return fI;
    }

    public int getCdf() {
        return cdf;
    }
}
