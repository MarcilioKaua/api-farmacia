package com.printf.apifarmacia.controller.relatorios;

public interface Relatorio {
    public void gerarCabecalho();
    public void gerarCorpo();
    public void gerarRodape();
    public void imprimir();
}

