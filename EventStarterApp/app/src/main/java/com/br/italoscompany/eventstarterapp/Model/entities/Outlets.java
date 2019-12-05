package com.br.italoscompany.eventstarterapp.Model.entities;

import java.io.Serializable;

public class Outlets implements Serializable {

    private String id;
    private String nomeDoEstabelecimento;
    private int qtdIngressos;
    private MyLatLong location;

    public Outlets(){ }

    public Outlets(String id, String nomeDoEstabelecimento, int qtdIngressos, MyLatLong location) {
        this.id = id;
        this.nomeDoEstabelecimento = nomeDoEstabelecimento;
        this.qtdIngressos = qtdIngressos;
        this.location = location;
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

    public MyLatLong getLocation() {
        return location;
    }

    public void setLocation(MyLatLong location) {
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
