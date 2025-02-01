package org.example;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ParseException {

        PeliculaService bd = new PeliculaService();
      Funcionalidades.buscador("", bd);
    }
}