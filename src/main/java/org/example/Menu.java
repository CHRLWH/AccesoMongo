package org.example;

import java.text.ParseException;

public class Menu {

    public static void menu(int eleccion) throws ParseException {

        switch (eleccion){
            case 1:
                Program.buscadorProgram();
                break;
            case 2:
                Program.borrarProgram();
                break;
            case 3:
                Program.insertarProgram();
                break;
            case 4:
                Program.mostrarTodoProgram();
                break;
            case 5:
                Program.actualizar();
                break;

        }
    }
}
