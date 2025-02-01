package org.example.Datos;

import org.example.Presentacion.EntradaDeDatos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PedirDatos {


    public static String obtenerNombrePelicula() {
        System.out.println("Introduce el nombre de la pelicula");
        return new Scanner(System.in).nextLine();
    }

    public static LocalDate obtenerFechaEstreno() {
        return EntradaDeDatos.pedirFecha("Introduce la fecha de estreno (formato: yyyy-MM-dd)");
    }

    public static List<String> obtenerGeneros() {
        int generosAintroducir = EntradaDeDatos.pedirNumeros("Cuantos generos quieres introducir?");
        List <String> generos = new ArrayList<>();

        do {
            String nombregenero = EntradaDeDatos.pedirStringConMensaje("Introduce el nombre del genero a introducir");
            generos.add(nombregenero);
            generosAintroducir--;
        }while (generosAintroducir >0);
        return generos;
    }

    // Método para obtener el nombre del director
    public static String obtenerNombreDirector() {
        System.out.println("Introduce el nombre del director");
        return EntradaDeDatos.pedirStringConMensaje("Introduce el nombre del director");
    }

    // Método para obtener los actores
    public static List<String> obtenerActores() {

        List <String> actores = new ArrayList<>();
               int actoresAintroducir = EntradaDeDatos.pedirNumeros("Cuantos actores quieres introducir?");

               do {
                   String nombregenero = EntradaDeDatos.pedirStringConMensaje("Introduce el nombre del actor a introducir");
                   actores.add(nombregenero);
                   actoresAintroducir--;
               } while (actoresAintroducir > 0);

        return actores;
    }

    // Método para obtener la descripción de la película
    public static String obtenerDescripcion() {
        return EntradaDeDatos.pedirStringConMensaje("Introduce la descripcion de la pelicula");
    }

}
