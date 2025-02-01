package org.example;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        int seleccion = new Scanner(System.in).nextInt();
        Menu.menu(seleccion);
    }
}