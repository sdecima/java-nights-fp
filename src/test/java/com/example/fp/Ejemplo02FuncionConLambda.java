package com.example.fp;

import org.junit.jupiter.api.Test;

class Ejemplo02FuncionConLambda {

    @FunctionalInterface
    interface Funcion {
        String ejecutar(String parametro);
    }

    private void ejecutarFuncion(Funcion f, String parametro) {
        String res = f.ejecutar(parametro);
        System.out.println(res);
    }

    @Test
    void ejemploFuncionConLambda() {
        Funcion f1 = (String nombre) -> {
            String mensaje = "hola ";
            return mensaje + nombre;
        };
        Funcion f2 = nombre -> "adios " + nombre;

        String nombre = "Juan";
        System.out.println(f1.ejecutar(nombre));
        ejecutarFuncion(f2, nombre);
    }

    @Test
    void ejemplo2FuncionConLambda() {
        String nombre = "Juan";
        ejecutarFuncion(
                n -> "hola " + n,
                nombre);
        ejecutarFuncion(
                n -> "adios " + n,
                nombre);
    }
}
