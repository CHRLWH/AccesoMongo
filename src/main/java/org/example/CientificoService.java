package org.example;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;


import java.util.List;
import java.util.ArrayList;

public class CientificoService {
    private MongoDatabase database;

    // Constructor que recibe la conexión a la base de datos
    public CientificoService(MongoDatabase database) {
        this.database = database;
    }

    // Crear (Insertar) un nuevo científico
    public void crearCientifico(Cientifico cientifico) {
        MongoCollection<Document> collection = database.getCollection("cientificos");

        // Convertir el objeto Cientifico a un documento BSON
        Document document = new Document("nombre", cientifico.getNombre())
                .append("nacimiento", cientifico.getNacimiento())
                .append("fallecimiento", cientifico.getFallecimiento())
                .append("nacionalidad", cientifico.getNacionalidad())
                .append("campo", cientifico.getCampo())
                .append("logros", cientifico.getLogros());

        // Insertar el documento en la colección
        collection.insertOne(document);
        System.out.println("Científico insertado correctamente.");
    }

    // Leer (Buscar) un científico por su nombre
    public void obtenerCientificoPorNombre(String nombre) {
        MongoCollection<Document> collection = database.getCollection("cientificos");

        // Crear una consulta para buscar por nombre
        Document query = new Document("nombre", nombre);

        // Obtener el resultado
        Document doc = collection.find(query).first();

        if (doc != null) {
            System.out.println("Científico encontrado: " + doc.toJson());
        } else {
            System.out.println("Científico no encontrado.");
        }
    }

    // Leer todos los científicos
    public List<Cientifico> obtenerTodosCientificos() {
        MongoCollection<Document> collection = database.getCollection("cientificos");

        // Obtener todos los documentos de la colección
        List<Cientifico> cientificos = new ArrayList<>();
        for (Document doc : collection.find()) {
            Cientifico cientifico = new Cientifico();
            cientifico.setNombre(doc.getString("nombre"));
            cientifico.setNacimiento(doc.getString("nacimiento"));
            cientifico.setFallecimiento(doc.getString("fallecimiento"));
            cientifico.setNacionalidad(doc.getString("nacionalidad"));
            cientifico.setCampo((List<String>) doc.get("campo"));
            cientifico.setLogros((List<String>) doc.get("logros"));
            cientificos.add(cientifico);
        }

        return cientificos;
    }

    // Actualizar un científico por nombre
    public void actualizarCientifico(String nombre, Cientifico nuevoCientifico) {
        MongoCollection<Document> collection = database.getCollection("cientificos");

        // Crear el documento con los nuevos datos
        Document updatedData = new Document("nombre", nuevoCientifico.getNombre())
                .append("nacimiento", nuevoCientifico.getNacimiento())
                .append("fallecimiento", nuevoCientifico.getFallecimiento())
                .append("nacionalidad", nuevoCientifico.getNacionalidad())
                .append("campo", nuevoCientifico.getCampo())
                .append("logros", nuevoCientifico.getLogros());

        // Actualizar el documento en la base de datos
        collection.updateOne(Filters.eq("nombre", nombre), Updates.set("nombre", nuevoCientifico.getNombre()));
        collection.updateOne(Filters.eq("nombre", nombre), Updates.set("nacimiento", nuevoCientifico.getNacimiento()));
        collection.updateOne(Filters.eq("nombre", nombre), Updates.set("fallecimiento", nuevoCientifico.getFallecimiento()));
        collection.updateOne(Filters.eq("nombre", nombre), Updates.set("nacionalidad", nuevoCientifico.getNacionalidad()));
        collection.updateOne(Filters.eq("nombre", nombre), Updates.set("campo", nuevoCientifico.getCampo()));
        collection.updateOne(Filters.eq("nombre", nombre), Updates.set("logros", nuevoCientifico.getLogros()));

        System.out.println("Científico actualizado correctamente.");
    }

    // Eliminar un científico por nombre
    public void eliminarCientifico(String nombre) {
        MongoCollection<Document> collection = database.getCollection("cientificos");

        // Eliminar el documento que coincida con el nombre
        collection.deleteOne(Filters.eq("nombre", nombre));

        System.out.println("Científico eliminado correctamente.");
    }
}


