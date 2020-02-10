package com.example.discoapp.modelo;

import java.io.Serializable;

public class Usuario implements Serializable {

    private int id;
    private String correo;
    private String nombre;
    private String pass;

    public Usuario(){}
    public Usuario(int id, String correo, String nombre, String pass) {
        this.id = id;
        this.correo = correo;
        this.nombre = nombre;
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
