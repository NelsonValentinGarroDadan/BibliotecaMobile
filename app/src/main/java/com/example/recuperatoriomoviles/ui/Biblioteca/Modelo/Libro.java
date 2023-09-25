package com.example.recuperatoriomoviles.ui.Biblioteca.Modelo;

import java.io.Serializable;

public class Libro implements Serializable {
    private String Titulo;
    private String Autor;
    private String Editorial;
    private int Anio;

    public Libro(String titulo, String autor, String editorial, int anio) {
        Titulo = titulo;
        Autor = autor;
        Editorial = editorial;
        Anio = anio;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String autor) {
        Autor = autor;
    }

    public String getEditorial() {
        return Editorial;
    }

    public void setEditorial(String editorial) {
        Editorial = editorial;
    }

    public int getAnio() {
        return Anio;
    }

    public void setAnio(int anio) {
        Anio = anio;
    }
}
