package org.example.Datos;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoDBConnection {

    private MongoClient mongoClient;
    private MongoDatabase database;

    public MongoDBConnection() {
        // Conectar a la base de datos local en MongoDB
        mongoClient = MongoClients.create("mongodb://localhost:27017");
        database = mongoClient.getDatabase("peliculas");
    }


    public MongoDatabase getDatabase() {
        return database;
    }

    public void close() {
        mongoClient.close();
    }
}

