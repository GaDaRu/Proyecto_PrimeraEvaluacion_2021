package com.example.proyectofin.modelo;

import java.util.Date;

public class Exposicion {
    private String idExposicion, Nombre, Descripcion;
    private Date fechaIni, fechaFin;

    public Exposicion() {
    }

    public Exposicion(String idExposicion, String nombre, String descripcion, Date fechaIni, Date fechaFin) {
        this.idExposicion = idExposicion;
        Nombre = nombre;
        Descripcion = descripcion;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
    }

    public String getIdExposicion() {
        return idExposicion;
    }

    public void setIdExposicion(String idExposicion) {
        this.idExposicion = idExposicion;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public Date getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(Date fechaIni) {
        this.fechaIni = fechaIni;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
}
