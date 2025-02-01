package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class PedirDatosController {

    public static List<String> obtenerGeneros(){
        boolean controladorDeExcepcion = false;
        List<String> generos = new ArrayList<>();
        do {
            try {
                generos =  PedirDatos.obtenerGeneros();
            }catch (InputMismatchException a){
                System.out.println("Introduce solo numeros");
                controladorDeExcepcion =true;

            }catch (Exception e){
                System.out.println("Excepcion desconocida");
                e.printStackTrace();
            }
        }while (controladorDeExcepcion);
        return generos;
    }
    public static List<String> obtenerActores(){
        boolean controladorDeExcepcion = false;
        List <String> actores = new ArrayList<>();
        do {
            try {
                actores =  PedirDatos.obtenerActores();
            }catch (InputMismatchException a){
                System.out.println("Introduce solo numeros");
                controladorDeExcepcion =true;

            }catch (Exception e){
                System.out.println("Excepcion desconocida");
                e.printStackTrace();
            }
        }while (controladorDeExcepcion);
        return actores;
    }

    public static LocalDate obtenerFechaEstreno(){
            boolean controladorDeExcepcion = false;
            LocalDate fecha = null;
            do {
                try {
                    fecha =  PedirDatos.obtenerFechaEstreno();
                }catch (DateTimeParseException a){
                    System.out.println("Recuerda introducir la fecha en formato (formato: yyyy-MM-dd)");
                    controladorDeExcepcion =true;

                }catch (Exception e){
                    System.out.println("Excepcion desconocida");
                    e.printStackTrace();
                }
            }while (controladorDeExcepcion);
            return fecha;
    }
}
