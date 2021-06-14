package modelo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


public class Conexion {
    private static MongoClient client = null;
    private static MongoCollection collection;
    private static MongoDatabase bd=null;

    private Conexion(){
        client = new MongoClient("localhost", 27017);
        System.out.println("Se ha creado la conexion");
    }

    public static MongoClient getConexion() {
        if (client == null)
            new Conexion();
        System.out.println("Se ha establecido la conexion");
        return client;
    }

    public void cerrarConexion(){
        client.close();
    }

    public static void cerrar() {
        if (client == null)
            client.close();
    }
}
