package com.example.fp.common;

import com.example.fp.model.ModelManager;
import com.example.fp.model.Persona;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestPersonas {
    private static List<Persona> globalPersonas;
    protected List<Persona> listaPersonas;
    protected Set<Persona> setPersonas;

    @BeforeAll
    static void cargarPersonas() {
        globalPersonas = ModelManager.crearListaDePersonas();
    }

    @BeforeEach
    void copiarPersonas() {
        listaPersonas = new ArrayList<>(globalPersonas);
        setPersonas = new HashSet<>(globalPersonas);
    }

    private String calcularHash(Persona persona) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] hash = md5.digest(persona.toString().getBytes(Charset.forName("UTF-8")));
            BigInteger n = new BigInteger(1, hash);
            return n.toString(16);
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    protected String calcularHashLento(Persona persona) {
        try {
            Thread.sleep(10);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        return calcularHash(persona);
    }

}
