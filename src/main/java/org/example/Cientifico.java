package org.example;

import java.util.List;

public class Cientifico {
    private String nombre;
    private String nacimiento;
    private String fallecimiento;
    private String nacionalidad;
    private List<String> campo;
    private List<String> logros;

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getFallecimiento() {
        return fallecimiento;
    }

    public void setFallecimiento(String fallecimiento) {
        this.fallecimiento = fallecimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public List<String> getCampo() {
        return campo;
    }

    public void setCampo(List<String> campo) {
        this.campo = campo;
    }

    public List<String> getLogros() {
        return logros;
    }

    public void setLogros(List<String> logros) {
        this.logros = logros;
    }
}

