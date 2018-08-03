package com.example.fp;

import org.junit.jupiter.api.Test;

class Ejemplo01FuncionSinLambda {

    interface Funcion {
        String ejecutar(String parametro);
    }

    static class FuncionHola implements Funcion {
        public String ejecutar(String nombre) {
            return "hola " + nombre;
        }
    }

    private void ejecutarFuncion(Funcion f, String parametro) {
        String res = f.ejecutar(parametro);
        System.out.println(res);
    }

    @Test
    void ejemploFuncionSinLambda() {
        Funcion f1 = new FuncionHola();
        String res = f1.ejecutar("Juan");
        System.out.println(res);

        Funcion f2 = new Funcion() {
            public String ejecutar(String nombre) {
                return "adios " + nombre;
            }
        };

        ejecutarFuncion(f2, "Juan");
    }
}
