package com.example.fp;

import com.example.fp.common.TestPersonas;
import com.example.fp.model.Persona;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class Ejemplo05ProcesoSinStreams extends TestPersonas {

    @Test
    void encontrarMaximaEdad() {
        int max = 0;
        for (Persona persona : setPersonas) {
            if(persona.getEdad() > max) {
                max = persona.getEdad();
            }
        }
        System.out.println("Persona de mayor edad: " + max);
    }

    @Test
    void encontrarPromedioEdad() {
        int sumatoria = 0;
        for (Persona persona : setPersonas) {
            sumatoria = sumatoria + persona.getEdad();
        }
        int promedio = sumatoria / setPersonas.size();
        System.out.println("Promedio de edad: " + promedio);
    }

    @Test
    void obtenerMenoresDe40() {
        Set<Persona> menoresDe40 = new HashSet<>();
        for (Persona persona : setPersonas) {
            if(persona.getEdad() < 40) {
                menoresDe40.add(persona);
            }
        }

        for (Persona persona : menoresDe40) {
            System.out.println(persona);
        }
    }

    @Test
    void agruparPorEdad() {
        // grupo 1 => de 18 a 30
        // grupo 2 => de 31 a 50
        // grupo 3 => de 51 en adelante
        Set<Persona> grupo1 = new HashSet<>();
        Set<Persona> grupo2 = new HashSet<>();
        Set<Persona> grupo3 = new HashSet<>();
        for (Persona persona : setPersonas) {
            if(persona.getEdad() >= 18 && persona.getEdad() <= 30) {
                grupo1.add(persona);
            }
            if(persona.getEdad() >= 31 && persona.getEdad() <= 50) {
                grupo2.add(persona);
            }
            if(persona.getEdad() >= 51) {
                grupo3.add(persona);
            }
        }

        System.out.println("Grupo 1:");
        for (Persona persona : grupo1) {
            System.out.println(persona);
        }
        System.out.println();

        System.out.println("Grupo 2:");
        for (Persona persona : grupo2) {
            System.out.println(persona);
        }
        System.out.println();

        System.out.println("Grupo 3:");
        for (Persona persona : grupo3) {
            System.out.println(persona);
        }
        System.out.println();
    }

    @Test
    void calcularHashPersonas() {
        HashMap<Persona, String> hashMap = new HashMap<>(setPersonas.size());
        for (Persona persona : setPersonas) {
            hashMap.put(persona, calcularHashLento(persona));
        }

        for (Persona persona : setPersonas) {
            System.out.print(persona);
            System.out.print(" ");
            System.out.println(hashMap.get(persona));
        }
    }
}
