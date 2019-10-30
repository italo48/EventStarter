package com.br.italoscompany.eventstarterapp.Model.entities;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public class Event {
    private long id;
    private String nomeDoEvento;
    private String data;
    private LatLng location;
    private List<PointOfSala> pontosDevendas;

    public  Event() {

    }

    public Event(String nomeDoEvento, String data, LatLng location, List<PointOfSala> pontosDevendas) {
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

    public List<PointOfSala> getPontosDevendas() {
        return pontosDevendas;
    }

    public void setPontosDevendas(List<PointOfSala> pontosDevendas) {
        this.pontosDevendas = pontosDevendas;
    }
}
