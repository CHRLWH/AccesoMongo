package org.example;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MongoDBConnection mongoConnection = new MongoDBConnection();
        PeliculaService peliculaService = new PeliculaService(mongoConnection.getDatabase());



        Funcionalidades.buscador("Gladiator");
    }
}
