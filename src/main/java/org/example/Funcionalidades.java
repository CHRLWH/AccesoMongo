package org.example;

import java.text.ParseException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Funcionalidades {

        public static void buscador(String parametroQueBuscar, PeliculaService peliculaService) throws ParseException {
            List<Pelicula> peliculas = peliculaService.obtenerTodasLasPeliculas();

            List<Pelicula> peliculasEncontradas = peliculas.stream()
                    .filter(pelicula ->
                            pelicula.getTitulo().toLowerCase().contains(parametroQueBuscar.toLowerCase()) ||
                                    pelicula.getDescripcion().toLowerCase().contains(parametroQueBuscar.toLowerCase()))
                    .collect(Collectors.toList());

            // Mostrar resultados
            System.out.println("Se han encontrado " + peliculasEncontradas.size() + " coincidencias:");
            peliculasEncontradas.forEach(System.out::println);
        }
}


