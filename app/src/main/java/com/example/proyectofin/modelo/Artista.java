package com.example.proyectofin.modelo;

import java.util.Date;

public class Artista {

    private String Dni, nombre, direccion, poblacion, provincia, pais, email, webBlog;
    private int MovilTrabajo, movilPersonal, telefono;
    private Date fechaN;

    public Artista() {
    }

    public Artista(String dni, String nombre, String direccion, String poblacion, String provincia, String pais, String email, String webBlog, int movilTrabajo, int movilPersonal, int telefono, Date fechaN) {
        Dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.poblacion = poblacion;
        this.provincia = provincia;
        this.pais = pais;
        this.email = email;
        this.webBlog = webBlog;
        MovilTrabajo = movilTrabajo;
        this.movilPersonal = movilPersonal;
        this.telefono = telefono;
        this.fechaN = fechaN;
    }

    public String getDni() {
        return Dni;
    }

    public void setDni(String dni) {
        Dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebBlog() {
        return webBlog;
    }

    public void setWebBlog(String webBlog) {
        this.webBlog = webBlog;
    }

    public int getMovilTrabajo() {
        return MovilTrabajo;
    }

    public void setMovilTrabajo(int movilTrabajo) {
        MovilTrabajo = movilTrabajo;
    }

    public int getMovilPersonal() {
        return movilPersonal;
    }

    public void setMovilPersonal(int movilPersonal) {
        this.movilPersonal = movilPersonal;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public Date getFechaN() {
        return fechaN;
    }

    public void setFechaN(Date fechaN) {
        this.fechaN = fechaN;
    }
}
