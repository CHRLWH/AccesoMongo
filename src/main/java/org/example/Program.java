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
        bd.cerrarConexion();

    }

    public static void insertarProgram() {
        PeliculaService bd = new PeliculaService();

        String nombre = PedirDatos.obtenerNombrePelicula();

        LocalDate fechaEstreno = PedirDatosController.obtenerFechaEstreno();

        List<String> generos = PedirDatosController.obtenerGeneros();

        String nombreDirector =  PedirDatos.obtenerNombreDirector();

        List<String> actores =  PedirDatosController.obtenerActores();

        String descripcion =  PedirDatos.obtenerDescripcion();

        Pelicula peliculaAinsertar = new Pelicula(nombre, fechaEstreno, actores, nombreDirector, generos, descripcion);

        bd.crearPelicula(peliculaAinsertar);

        bd.cerrarConexion();

    }
    public static void borrarProgram(){
        PeliculaService bd = new PeliculaService();
        System.out.println("Bienvenido al borrar una pelicula!");
        System.out.println("Introduce el nombre de la pelicula que deseas borrar:");
        String nombrePeliculaAborrar = new Scanner(System.in).nextLine();
        bd.eliminarPelicula(nombrePeliculaAborrar);
        bd.cerrarConexion();

    }

    public static void mostrarTodoProgram() throws ParseException {
        PeliculaService bd = new PeliculaService();

        System.out.println("Todos los datos");
        bd.obtenerTodasLasPeliculas().stream().forEach(System.out::println);
    }

    public static void actualizar() throws ParseException {
        PeliculaService bd = new PeliculaService();
        String insertarVF;
        String nombre = PedirDatos.obtenerNombrePelicula();
        boolean existePelicula = Funcionalidades.buscadorRecursivo(nombre,bd);
        if (!existePelicula) {
            System.out.println("La pelicula no existe,desea insertar?");
            insertarVF = new Scanner(System.in).nextLine();
            if (insertarVF.equalsIgnoreCase("s")) {
                Program.insertarProgram();
            }else{
                System.out.println("Adios!");
            }
        } else {
            LocalDate fechaEstreno = PedirDatosController.obtenerFechaEstreno();
            List<String> generos = PedirDatosController.obtenerGeneros();
            String nombreDirector =  PedirDatos.obtenerNombreDirector();
            List<String> actores =  PedirDatosController.obtenerActores();
            String descripcion =  PedirDatos.obtenerDescripcion();
            Pelicula pelicula = new Pelicula(nombre, fechaEstreno, actores, nombreDirector, generos, descripcion);
            bd.actualizarPelicula(nombre, pelicula);
        }

        bd.cerrarConexion();

    }


}

