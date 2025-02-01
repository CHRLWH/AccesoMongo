package org.example;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Funcionalidades {

    public static void buscador(String parametroQueBuscar) {
        MongoDBConnection mongoConnection = new MongoDBConnection();
        PeliculaService pel = new PeliculaService();
        List<Object> tablaEntera = Collections.singletonList(pel.obtenerTodasLasPeliculas());

        // Filtra las ocurrencias que contienen el término de búsqueda (ignorando mayúsculas/minúsculas)
        List<Object> listaConOcurrenciasEncontradas = tablaEntera
                .stream()
                .filter(o -> o.toString()
                        .toLowerCase()
                        .contains(parametroQueBuscar.toLowerCase()))
                .collect(Collectors.toList());

        System.out.println("Se han encontrado " + listaConOcurrenciasEncontradas.size() + " ocurrencias");
        listaConOcurrenciasEncontradas.forEach(System.out::println);
    }
}
