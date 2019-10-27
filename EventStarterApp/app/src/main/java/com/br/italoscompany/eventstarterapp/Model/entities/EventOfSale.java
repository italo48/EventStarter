package com.br.italoscompany.eventstarterapp.Model.entities;

public class EventOfSale {
    private String nomeDoEstabelecimento;
    private int qtdIngressos;
    private String nomeDoEvento;

    public EventOfSale(String nomeDoEstabelecimento, int qtdIngressos, String nomeDoEvento) {
        this.nomeDoEstabelecimento = nomeDoEstabelecimento;
        this.qtdIngressos = qtdIngressos;
        this.nomeDoEvento = nomeDoEvento;
    }

    public String getNomeDoEstabelecimento() {
        return nomeDoEstabelecimento;
    }

    public void setNomeDoEstabelecimento(String nomeDoEstabelecimento) {
        this.nomeDoEstabelecimento = nomeDoEstabelecimento;
    }

    public int getQtdIngressos() {
        return qtdIngressos;
    }

    public void setQtdIngressos(int qtdIngressos) {
        this.qtdIngressos = qtdIngressos;
    }

    public String getNomeDoEvento() {
        return nomeDoEvento;
    }

    public void setNomeDoEvento(String nomeDoEvento) {
        this.nomeDoEvento = nomeDoEvento;
    }
}
