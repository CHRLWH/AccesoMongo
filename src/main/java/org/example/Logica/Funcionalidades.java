package org.example.Logica;

import org.example.Datos.PeliculaService;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

public class Funcionalidades {

        public static void buscador(String parametroQueBuscar, PeliculaService peliculaService) throws ParseException {

            List<Pelicula> peliculas = peliculaService.obtenerTodasLasPeliculas();

            List<Pelicula> peliculasEncontradas = peliculas.stream()
                    .filter(pelicula ->
                            pelicula.getTitulo().toLowerCase().contains(parametroQueBuscar.toLowerCase()))
                    .collect(Collectors.toList());

            if (peliculasEncontradas.isEmpty()) {
                System.out.println("No se han encontrado coincidencias para: " + parametroQueBuscar);
            } else {
                System.out.println("Se han encontrado " + peliculasEncontradas.size() + " coincidencias:");
                peliculasEncontradas.forEach(System.out::println);
            }
        }

    public static boolean buscadorRecursivo(String nombre, PeliculaService peliculaService) throws ParseException {
        List<Pelicula> peliculas = peliculaService.obtenerTodasLasPeliculas();


        if (peliculas == null) {
            System.out.println("La lista de películas es null.");
            return false;
        } else if (peliculas.isEmpty()) {
            System.out.println("La lista de películas está vacía.");
            return false;
        }

        System.out.println("Películas obtenidas: " + peliculas.size());

        return peliculas.stream()
                .anyMatch(pelicula -> pelicula.getTitulo() != null && pelicula.getTitulo().equalsIgnoreCase(nombre));
    }
}


