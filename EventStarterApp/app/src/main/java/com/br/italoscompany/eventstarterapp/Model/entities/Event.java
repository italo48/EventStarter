package com.br.italoscompany.eventstarterapp.Model.entities;

import java.util.Date;

public class Event {
    private String nomeDoEvento;
    private Date data;
    private Address endereco;
    private String caminhoFoto;

    public  Event() {

    }

    public Event(String nomeDoEvento, Date data, Address endereco, String caminhoFoto) {
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

    public Address getEndereco() {
        return endereco;
    }

    public void setEndereco(Address endereco) {
        this.endereco = endereco;
    }

    public String getCaminhoFoto() {
        return caminhoFoto;
    }

    public void setCaminhoFoto(String caminhoFoto) {
        this.caminhoFoto = caminhoFoto;
    }
}
