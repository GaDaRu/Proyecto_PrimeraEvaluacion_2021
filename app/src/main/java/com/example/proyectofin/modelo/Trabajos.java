package com.example.proyectofin.modelo;

public class Trabajos {
    private String NombreTra, Descripcion, Dni, foto;
    private int Tamano, peso;

    public Trabajos() {
    }

    public Trabajos(String nombreTra, String descripcion, String dni, String foto, int tamano, int peso) {
        NombreTra = nombreTra;
        Descripcion = descripcion;
        Dni = dni;
        this.foto = foto;
        Tamano = tamano;
        this.peso = peso;
    }

    public String getNombreTra() {
        return NombreTra;
    }

    public void setNombreTra(String nombreTra) {
        NombreTra = nombreTra;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getDni() {
        return Dni;
    }

    public void setDni(String dni) {
        Dni = dni;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getTamano() {
        return Tamano;
    }

    public void setTamano(int tamano) {
        Tamano = tamano;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
}
