package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        MongoDBConnection mongoConnection = new MongoDBConnection();
        CientificoService cientificoService = new CientificoService(mongoConnection.getDatabase());

        // Crear un nuevo científico

        Cientifico nuevoCientifico = new Cientifico();
        nuevoCientifico.setNombre("Marie Curie 2");
        nuevoCientifico.setNacimiento("1867-11-07");
        nuevoCientifico.setFallecimiento("1934-07-04");
        nuevoCientifico.setNacionalidad("Francesa");
        nuevoCientifico.setCampo(List.of("Física", "Química"));
        nuevoCientifico.setLogros(List.of("Descubrimiento del radio y polonio", "Doble Premio Nobel"));
        cientificoService.crearCientifico(nuevoCientifico);

        // Leer un científico
        cientificoService.obtenerCientificoPorNombre("Marie Curie 2");

        // Actualizar un científico
        nuevoCientifico.setNacimiento("1867-11-07"); // Cambiar datos si es necesario
        cientificoService.actualizarCientifico("Marie Curie 2", nuevoCientifico);

        // Eliminar un científico
        cientificoService.eliminarCientifico("Marie Curie 2");

        // Cerrar conexión
        mongoConnection.close();
    }
}
