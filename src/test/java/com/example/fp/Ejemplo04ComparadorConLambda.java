package com.example.fp;

import com.example.fp.common.TestPersonas;
import com.example.fp.model.Persona;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

class Ejemplo04ComparadorConLambda extends TestPersonas {

    @Test
    void ordenarPorEdad() {
        listaPersonas.sort(
                (p1, p2) -> p1.getNombre().compareToIgnoreCase(p2.getNombre())
        );

        for (Persona persona : listaPersonas) {
            System.out.println(persona);
        }
    }

    @Test
    void ordenarPorEdad2() {
//        personas.sort(Comparator.comparing(Persona::getNombre));
//        personas.sort(Comparator.comparing(Persona::getApellido));
        listaPersonas.sort(
                Comparator.comparingInt(Persona::getEdad));

        for (Persona persona : listaPersonas) {
            System.out.println(persona);
        }
    }
}
