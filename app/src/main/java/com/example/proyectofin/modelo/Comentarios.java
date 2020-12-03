package com.example.proyectofin.modelo;

public class Comentarios {
    String idExposicion, NombreTra, Comentario;

    public Comentarios() {
    }

    public Comentarios(String idExposicion, String nombreTra, String comentario) {
        this.idExposicion = idExposicion;
        NombreTra = nombreTra;
        Comentario = comentario;
    }

    public String getIdExposicion() {
        return idExposicion;
    }

    public void setIdExposicion(String idExposicion) {
        this.idExposicion = idExposicion;
    }

    public String getNombreTra() {
        return NombreTra;
    }

    public void setNombreTra(String nombreTra) {
        NombreTra = nombreTra;
    }

    public String getComentario() {
        return Comentario;
    }

    public void setComentario(String comentario) {
        Comentario = comentario;
    }
}
