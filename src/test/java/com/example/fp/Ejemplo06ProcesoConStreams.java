package com.example.fp;

import com.example.fp.common.TestPersonas;
import com.example.fp.model.Persona;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Ejemplo06ProcesoConStreams extends TestPersonas {

    @Test
    void encontrarMaximaEdad() {
        BinaryOperator<Integer> funcionMax = (a, b) -> a > b ? a : b;

        int max = setPersonas.stream()
                .map(persona -> persona.getEdad())
                .reduce(0, funcionMax, funcionMax);
        System.out.println("Persona de mayor edad: " + max);
    }

    @Test
    void encontrarMaximaEdad2() {
        OptionalInt max = setPersonas
                .stream()
                .mapToInt(Persona::getEdad)
                .max();
        System.out.println("Persona de mayor edad: " + max.getAsInt());
    }

    @Test
    void encontrarPromedioEdad() {
        OptionalDouble promedio = setPersonas
                .stream()
                .mapToInt(Persona::getEdad)
                .average();
        System.out.println("Promedio de edad: " + promedio.getAsDouble());
    }

    @Test
    void obtenerMenoresDe40() {
        Set<Persona> menoresDe40 = setPersonas.stream()
                .filter(persona -> persona.getEdad() < 40)
                .collect(Collectors.toSet());

        for (Persona persona : menoresDe40) {
            System.out.println(persona);
        }
    }

    @Test
    void agruparPorEdad() {
        // grupo 1 => de 18 a 30
        // grupo 2 => de 31 a 50
        // grupo 3 => de 51 en adelante
        Predicate<Persona> filtroGrupo1 =
                persona -> persona.getEdad() >= 18 && persona.getEdad() <= 30;
        Predicate<Persona> filtroGrupo2 =
                persona -> persona.getEdad() >= 31 && persona.getEdad() <= 50;
        Predicate<Persona> filtroGrupo3 =
                persona -> persona.getEdad() >= 51;

        Map<Integer, List<Persona>> grupos = setPersonas
                .stream()
                .collect(Collectors.groupingBy(persona -> {
            if (filtroGrupo1.test(persona))
                return 1;
            if (filtroGrupo2.test(persona))
                return 2;
            if (filtroGrupo3.test(persona))
                return 3;
            return 0;
        }));

        for (Map.Entry<Integer, List<Persona>> entry : grupos.entrySet()) {
            System.out.println("Grupo " + entry.getKey() + ":");
            for (Persona persona : entry.getValue()) {
                System.out.println(persona);
            }
            System.out.println();
        }
    }

    @Test
    void calcularHashPersonasStream() {
        ConcurrentMap<Persona, String> hashMap = setPersonas
                .parallelStream()
                .collect(
                        Collectors.toConcurrentMap(
                                Function.identity(),
                                this::calcularHashLento));

        for (Persona persona : setPersonas) {
            System.out.print(persona);
            System.out.print(" ");
            System.out.println(hashMap.get(persona));
        }
    }
}
