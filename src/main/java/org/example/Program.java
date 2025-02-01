package org.example;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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

    public static Pelicula insertarProgram() {
        PeliculaService bd = new PeliculaService();

        String nombre = PedirDatos.obtenerNombrePelicula();

        LocalDate fechaEstreno = PedirDatosController.obtenerFechaEstreno();

        List<String> generos = PedirDatosController.obtenerGeneros();

        String nombreDirector =  PedirDatos.obtenerNombreDirector();

        List<String> actores =  PedirDatosController.obtenerActores();

        String descripcion =  PedirDatos.obtenerDescripcion();

        Pelicula peliculaAinsertar = new Pelicula(nombre, fechaEstreno, actores, nombreDirector, generos, descripcion);

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

