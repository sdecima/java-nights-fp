package com.example.fp.model;

import com.opencsv.bean.CsvBindByName;

public class Persona {

    @CsvBindByName
    private String nombre = "";

    @CsvBindByName
    private String apellido = "";

    @CsvBindByName
    private int edad = 0;

    public Persona() {

    }

    public Persona(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return getNombre() + " " + getApellido() + " (" + getEdad() + ")";
    }
}
