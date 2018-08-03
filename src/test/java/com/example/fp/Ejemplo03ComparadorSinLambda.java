package com.example.fp;

import com.example.fp.common.TestPersonas;
import com.example.fp.model.Persona;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

class Ejemplo03ComparadorSinLambda extends TestPersonas {

    static class OrdenarPorNombre implements Comparator<Persona> {
        @Override
        public int compare(Persona p1, Persona p2) {
            return p1.getNombre().compareToIgnoreCase(p2.getNombre());
        }
    }

    @Test
    void ordenarPorNombre() {
        listaPersonas.sort(new OrdenarPorNombre());

        for (Persona persona : listaPersonas) {
            System.out.println(persona);
        }
    }

    @Test
    void ordenarPorApellido() {
        listaPersonas.sort(new Comparator<Persona>() {
            @Override
            public int compare(Persona p1, Persona p2) {
                return p1.getApellido().compareToIgnoreCase(p2.getApellido());
            }
        });

        for (Persona persona : listaPersonas) {
            System.out.println(persona);
        }
    }
}
