package com.example.discoapp.modelo;


import java.io.Serializable;

public class Discoteca implements Serializable {

    private int id;
    private String imgRuta;
    private String nombre;
    private String descripcion;
    private double rate;
    private double lat;
    private double lng;

    public Discoteca(){}

    public Discoteca(String imgRuta,String nombre, String descripcion) {
        this.imgRuta = imgRuta;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Discoteca(int id, String imgRuta, String nombre, String descripcion, double rate, double lat, double lng) {
        this.id = id;
        this.imgRuta = imgRuta;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.rate = rate;
        this.lat = lat;
        this.lng = lng;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImgFoto() {
        return imgRuta;
    }

    public void setImgFoto(String imgFoto) {
        this.imgRuta = imgFoto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
}
