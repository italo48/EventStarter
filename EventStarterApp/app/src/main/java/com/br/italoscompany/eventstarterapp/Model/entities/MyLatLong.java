package com.br.italoscompany.eventstarterapp.Model.entities;

public class MyLatLong {
    private double latidude;
    private double longitude;

    public MyLatLong(double latidude, double longitude) {
        this.latidude = latidude;
        this.longitude = longitude;
    }

    public MyLatLong() {
    }

    public double getLatidude() {
        return latidude;
    }

    public void setLatidude(double latidude) {
        this.latidude = latidude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
