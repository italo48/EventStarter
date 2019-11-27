package com.br.italoscompany.eventstarterapp.Model.entities;

import android.os.Parcel;

import java.util.List;

public class Event {
    private String id;
    private String nomeDoEvento;
    private String data;
    private MyLatLong location;
    private List<Outlets> pontosDevendas;

    public  Event() {

    }

    public Event(String id, String nomeDoEvento, String data, MyLatLong location, List<Outlets> pontosDevendas) {
        this.id = id;
        this.pontosDevendas = pontosDevendas;
        this.nomeDoEvento = nomeDoEvento;
        this.data = data;
        this.location = location;
    }

    public Event(Parcel in) {
        id = in.readString();
        nomeDoEvento = in.readString();
        data = in.readString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public MyLatLong getLocation() {
        return location;
    }

    public void setLocation(MyLatLong location) {
        this.location = location;
    }

    public List<Outlets> getPontosDevendas() {
        return pontosDevendas;
    }

    public void setPontosDevendas(List<Outlets> pontosDevendas) {
        this.pontosDevendas = pontosDevendas;
    }
}
