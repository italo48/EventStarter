package com.br.italoscompany.eventstarterapp.model;

import java.util.Date;

public class Event {
    private String nomeDoEvento;
    private Date data;
    private Adress endereco;
    private String caminhoFoto;

    public Event(String nomeDoEvento, Date data, Adress endereco, String caminhoFoto) {
        this.nomeDoEvento = nomeDoEvento;
        this.data = data;
        this.endereco = endereco;
        this.caminhoFoto = caminhoFoto;
    }

    public String getNomeDoEvento() {
        return nomeDoEvento;
    }

    public void setNomeDoEvento(String nomeDoEvento) {
        this.nomeDoEvento = nomeDoEvento;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Adress getEndereco() {
        return endereco;
    }

    public void setEndereco(Adress endereco) {
        this.endereco = endereco;
    }

    public String getCaminhoFoto() {
        return caminhoFoto;
    }

    public void setCaminhoFoto(String caminhoFoto) {
        this.caminhoFoto = caminhoFoto;
    }
}
