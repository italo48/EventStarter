package com.br.italoscompany.eventstarterapp.Model.entities;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public class Event {
    private long id;
    private String nomeDoEvento;
    private String data;
    private LatLng location;
    private List<Outlets> pontosDevendas;

    public  Event() {

    }

    public Event(int id, String nomeDoEvento, String data, LatLng location, List<Outlets> pontosDevendas) {
        this.id = id;
        this.pontosDevendas = new ArrayList<>();
        this.pontosDevendas = pontosDevendas;
        this.nomeDoEvento = nomeDoEvento;
        this.data = data;
        this.location = location;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomeDoEvento() {
        return nomeDoEvento;
    }

    public void setNomeDoEvento(String nomeDoEvento) {
        this.nomeDoEvento = nomeDoEvento;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public LatLng getLocation() {
        return location;
    }

    public void setLocation(LatLng location) {
        this.location = location;
    }

    public List<Outlets> getPontosDevendas() {
        return pontosDevendas;
    }

    public void setPontosDevendas(List<Outlets> pontosDevendas) {
        this.pontosDevendas = pontosDevendas;
    }
}
