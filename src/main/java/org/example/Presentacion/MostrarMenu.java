package org.example.Presentacion;

import java.text.ParseException;

public class MostrarMenu {
    public static void program(){
        boolean excepcion = false;
     do {
         try {
             excepcion = false;
             int eleccion = EntradaDeDatos.pedirNumeros("Bienvenido!\n" +
                     "1.-Buscador de datos\n" +
                     "2.-Borrar de la una pelicula\n" +
                     "3.-Insertar una pelicula\n" +
                     "4.-Mostrar todas las peliculas\n" +
                     "5.-Actualizar pelicula");
             Menu.menu(eleccion);
         }catch (ParseException e){
             System.out.println("Introduce solo una de las opciones disponibles y evita los caracteres especiales y letras!");
             excepcion = true;
         }
     }while (excepcion);

    }
}
