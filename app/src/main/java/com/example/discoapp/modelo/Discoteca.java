package com.example.discoapp.modelo;



public class Discoteca {

    private int id;
    private String nombre;
    private String imgRuta;
    private float rate;
    private String locacalización;//Link a Maps

    public Discoteca(){}

    public Discoteca(int id, String nombre, String imgRuta, float rate, String locacalización) {
        this.id = id;
        this.nombre = nombre;
        this.imgRuta = imgRuta;
        this.rate = rate;
        this.locacalización = locacalización;
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

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public String getLocacalización() {
        return locacalización;
    }

    public void setLocacalización(String locacalización) {
        this.locacalización = locacalización;
    }
}
