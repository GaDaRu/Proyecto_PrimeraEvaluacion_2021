package com.example.proyectofin.modelo;

public class Exponen {
    private String idExposicion, Dni;

    public Exponen() {
    }

    public Exponen(String idExposicion, String dni) {
        this.idExposicion = idExposicion;
        Dni = dni;
    }

    public String getIdExposicion() {
        return idExposicion;
    }

    public void setIdExposicion(String idExposicion) {
        this.idExposicion = idExposicion;
    }

    public String getDni() {
        return Dni;
    }

    public void setDni(String dni) {
        Dni = dni;
    }
}
