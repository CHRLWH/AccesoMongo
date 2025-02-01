package org.example.Datos;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.example.Logica.Pelicula;


import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class PeliculaService {
    private MongoDatabase database;

    // Constructor que recibe la conexión a la base de datos
    public PeliculaService() {
        MongoDBConnection conexion = new MongoDBConnection();
        this.database = conexion.getDatabase() ;
    }


    // Crear (Insertar) un nuevo científico
    public void crearPelicula(Pelicula pelicula) {

        MongoCollection<Document> collection = database.getCollection("pelicula");

        Document document = new Document("titulo", pelicula.getTitulo())
                .append("estreno", pelicula.getEstreno().toString())
                .append("genero", pelicula.getGenero())
                .append("director", pelicula.getDirector())
                .append("actores", pelicula.getActores())
                .append("descripcion", pelicula.getDescripcion());

        collection.insertOne(document);
        System.out.println("Pelicula insertada correctamente !");
    }

    // Leer todos los científicos
    public List<Pelicula> obtenerTodasLasPeliculas() throws ParseException {
        MongoCollection<Document> collection = database.getCollection("pelicula");

        // Obtener todos los documentos de la colección
        List<Pelicula> peliculas = new ArrayList<>();
        for (Document doc : collection.find()) {
            Pelicula pelicula = new Pelicula();
            pelicula.setTitulo(doc.getString("titulo"));
            pelicula.setEstreno(LocalDate.parse(doc.getString("estreno")));
            pelicula.setGenero(doc.getList("genero",String.class));
            pelicula.setDirector(doc.getString("director"));
            pelicula.setActores(doc.getList("genero",String.class));
            pelicula.setDescripcion(doc.getString("descripcion"));
            peliculas.add(pelicula);
        }

        return peliculas;
    }

    public void actualizarPelicula(String titulo, Pelicula nuevaPelicula) {
        MongoCollection<Document> collection = database.getCollection("pelicula");

        // Crear el documento con los nuevos datos
        Document document = new Document("Titulo", nuevaPelicula.getTitulo())
                .append("Estreno", nuevaPelicula.getEstreno())
                .append("Genero", nuevaPelicula.getGenero())
                .append("Director", nuevaPelicula.getDirector())
                .append("Actores", nuevaPelicula.getActores())
                .append("Descripcion", nuevaPelicula.getDescripcion());


        // Actualizar el documento en la base de datos
        collection.updateOne(Filters.eq("titulo", titulo), Updates.set("titulo", nuevaPelicula.getTitulo()));
        collection.updateOne(Filters.eq("titulo", titulo), Updates.set("estreno", nuevaPelicula.getEstreno()));
        collection.updateOne(Filters.eq("titulo", titulo), Updates.set("genero", nuevaPelicula.getGenero()));
        collection.updateOne(Filters.eq("titulo", titulo), Updates.set("director", nuevaPelicula.getDirector()));
        collection.updateOne(Filters.eq("titulo", titulo), Updates.set("actores", nuevaPelicula.getActores()));
        collection.updateOne(Filters.eq("titulo", titulo), Updates.set("descripcion", nuevaPelicula.getDescripcion()));

        System.out.println("Pelicula actualizada correctamente.");
    }

    // Eliminar un científico por nombre
    public void eliminarPelicula(String titulo) {
        MongoCollection<Document> collection = database.getCollection("pelicula");

        // Eliminar el documento que coincida con el nombre
        collection.deleteOne(Filters.eq("titulo", titulo));

        System.out.println("Pelicula eliminada correctamente.");
    }

    public void cerrarConexion(){
        MongoDBConnection conexion = new MongoDBConnection();
        conexion.close();
    }
}


