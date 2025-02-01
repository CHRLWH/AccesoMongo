package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class PedirDatos {


    public static String obtenerNombrePelicula() {
        System.out.println("Bienvenido a crear una pelicula");
        System.out.println("Introduce el nombre de la pelicula");
        return new Scanner(System.in).nextLine();
    }

    public static LocalDate obtenerFechaEstreno() {
        System.out.println("Introduce la fecha de estreno (formato: yyyy-MM-dd)");
        return LocalDate.parse(new Scanner(System.in).nextLine());
    }

    public static List<String> obtenerGeneros() {
        System.out.println("Cuantos generos quieres introducir?");
        int generosAintroducir = new Scanner(System.in).nextInt();
        List <String> generos = new ArrayList<>();

        do {
            System.out.println("Introduce el nombre del genero a introducir");
            String nombregenero = new Scanner(System.in).nextLine();
            generos.add(nombregenero);
            generosAintroducir--;
        }while (generosAintroducir >0);
        return generos;
    }

    // Método para obtener el nombre del director
    public static String obtenerNombreDirector() {
        System.out.println("Introduce el nombre del director");
        return new Scanner(System.in).nextLine();
    }

    // Método para obtener los actores
    public static List<String> obtenerActores() {

        List <String> actores = new ArrayList<>();
               System.out.println("Cuantos actores quieres introducir?");
               int actoresAintroducir = new Scanner(System.in).nextInt();

               do {
                   System.out.println("Introduce el nombre del actor a introducir");
                   String nombregenero = new Scanner(System.in).nextLine();
                   actores.add(nombregenero);
                   actoresAintroducir--;
               } while (actoresAintroducir > 0);

        return actores;
    }

    // Método para obtener la descripción de la película
    public static String obtenerDescripcion() {
        System.out.println("Introduce la descripcion de la pelicula");
        return new Scanner(System.in).nextLine();
    }

}
