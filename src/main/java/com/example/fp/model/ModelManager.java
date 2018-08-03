package com.example.fp.model;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class ModelManager {

    @SuppressWarnings("unchecked")
    public static List<Persona> crearListaDePersonas() {
        List<Persona> beans = null;
        try {
            beans = new CsvToBeanBuilder(new FileReader("personas1000.csv"))
                    .withSeparator(',')
                    .withType(Persona.class)
                    .build().parse();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return beans;
    }
}
