package org.example.Logica;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pelicula {
    private String titulo;
    private LocalDate estreno;
    private List<String> genero;
    private String director;
    private List<String> actores;
    private String descripcion;

    public Pelicula(String titulo, LocalDate estreno, List<String> actores, String director, List<String> genero, String descripcion) {
        this.titulo = titulo;
        this.estreno = estreno;
        this.actores = new ArrayList<String>();
        this.director = director;
        this.genero = genero;
        this.descripcion = descripcion;
    }

    public Pelicula() {
    }

    @Override
    public String toString() {
        return "Pelicula" +
                "titulo='" + titulo + '\'' +
                ", estreno=" + estreno +
                ", genero=" + genero +
                ", director='" + director + '\'' +
                ", actores=" + actores +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
// Getters y Setters

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getEstreno() {
        return estreno;
    }

    public void setEstreno(LocalDate estreno) {
        this.estreno = estreno;
    }

    public List<String> getGenero() {
        return genero;
    }

    public void setGenero(List<String> genero) {
        this.genero = genero;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public List<String> getActores() {
        return actores;
    }

    public void setActores(List<String> actores) {
        this.actores = actores;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

