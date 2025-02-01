package org.example.Presentacion;

import java.time.LocalDate;
import java.util.Scanner;

public class EntradaDeDatos {

        public static String pedirStringConMensaje(String mensaje) {
            rotular(mensaje);
            String lector = new Scanner(System.in).nextLine();
            return lector;
        }


        public static String pedirStringSinMensaje() {
            String lector = new java.util.Scanner(System.in).nextLine();
            return lector;
        }


        public static int pedirNumeros(String mensaje) {
            rotular(mensaje);
            int lector = new Scanner(System.in).nextInt();
            return lector;
        }


        public static double pedirConDecimales(String mensaje) {
            rotular(mensaje);
            double numeroConDecimales = new Scanner(System.in).nextInt();
            return numeroConDecimales;
        }

        public static LocalDate pedirFecha(String mensaje){
            rotular(mensaje);
            LocalDate fecha = LocalDate.parse(new Scanner(System.in).nextLine());
            return fecha;
        }
        private static void rotular(String rotulo) {
            String resetear = "\u001B[0m";
            String verde = "\u001B[32m";
            System.out.println(verde + rotulo + resetear);
        }
    }

