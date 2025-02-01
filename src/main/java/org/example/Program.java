package org.example;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void buscadorProgram(){
        PeliculaService bd = new PeliculaService();
        String datoAbuscar;
        System.out.println("Bienvenido al buscador de datos!");
        System.out.println("Recuerda introducir el dato que desea buscar al completo");
        System.out.print("Introduzca el dato a buscar -->");
        datoAbuscar = new Scanner(System.in).nextLine();
        try {
            Funcionalidades.buscador(datoAbuscar, bd);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Pelicula insertarProgram(){
        PeliculaService bd = new PeliculaService();
        List <String> generos = new ArrayList<>();
        List <String> actores = new ArrayList<>();
        System.out.println("Bienvenido a crear una pelicula");
        System.out.println("Introduce el nombre de la pelicula");
        String nombre = new Scanner(System.in).nextLine();
        System.out.println("Introduce la fecha de estreno");
        LocalDate fechaEstreno = LocalDate.parse(new Scanner(System.in).nextLine());
        System.out.println("Cuantos generos quieres introducir?");
        int numeroGenerosAIntroducir = new Scanner(System.in).nextInt();
        do {
            System.out.println("Introduce el nombre del genero a introducir");
            String nombregenero = new Scanner(System.in).nextLine();
            generos.add(nombregenero);
            numeroGenerosAIntroducir--;
        }while (numeroGenerosAIntroducir >0);

        System.out.println("Introduce el nombre del director");
        String nombreDirector = new Scanner(System.in).nextLine();

        System.out.println("Cuantos Actores estan en la pelicula?");
        int numeroActoresAIntroducir = new Scanner(System.in).nextInt();
        do {
            System.out.println("Introduce el nombre del Actor");
            String nombreActor = new Scanner(System.in).nextLine();
            generos.add(nombreActor);
            numeroActoresAIntroducir--;
        }while (numeroActoresAIntroducir >0);
        System.out.println("Introduce la descripcion de la pelicula");
        String descripcion = new Scanner(System.in).nextLine();
        Pelicula peliculaAinsertar = new Pelicula(nombre,fechaEstreno,generos,nombreDirector,actores,descripcion);
        bd.crearPelicula(peliculaAinsertar);
       return peliculaAinsertar;
    }
    public static void borrarProgram(){
        PeliculaService bd = new PeliculaService();
        System.out.println("Bienvenido al borrar una pelicula!");
        System.out.println("Introduce el nombre de la pelicula que deseas borrar:");
        String nombrePeliculaAborrar = new Scanner(System.in).nextLine();
        bd.eliminarPelicula(nombrePeliculaAborrar);
    }

    public static void mostrarTodoProgram() throws ParseException {
        PeliculaService bd = new PeliculaService();

        System.out.println("Todos los datos");
        bd.obtenerTodasLasPeliculas().stream().forEach(System.out::println);
    }

    public static void actualizar(){
        PeliculaService bd = new PeliculaService();

        System.out.println("Introduce el titulo de la pelicula que quieras actualizar");
        String nombrePeliculaAborrar = new Scanner(System.in).nextLine();
        Pelicula pelicula = insertarProgram();
        bd.actualizarPelicula(nombrePeliculaAborrar, pelicula);
    }


}

