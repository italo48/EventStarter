package com.br.italoscompany.eventstarterapp.Model.entities;

import com.google.android.gms.maps.model.LatLng;

public class Outlets {
    private String nomeDoEstabelecimento;
    private int qtdIngressos;
    private LatLng location;

    public Outlets(){ }

    public Outlets(String nomeDoEstabelecimento, int qtdIngressos, LatLng location) {
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

    public LatLng getLocation() {
        return location;
    }

    public void setLocation(LatLng location) {
        this.location = location;
    }
}
