package com.example.discoapp.modelo;


import java.io.Serializable;

public class Discoteca implements Serializable {

    private int id;
    private String nombre;
    private String imgRuta;
    private double rate;
    private double lat;
    private double lng;


    public Discoteca(){}

    public Discoteca(int id, String nombre, String imgRuta, double rate, double lat, double lng) {
        this.id = id;
        this.nombre = nombre;
        this.imgRuta = imgRuta;
        this.rate = rate;
        this.lat = lat;
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImgRuta() {
        return imgRuta;
    }

    public void setImgRuta(String imgRuta) {
        this.imgRuta = imgRuta;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    };
}
