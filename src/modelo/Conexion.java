package modelo;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;


public class Conexion {
    private static MongoClient client = null;
    private static DBCollection collection;
    private static DB bd=null;

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

    public static DB getBd() {
        if (bd == null)
            bd = client.getDB("db1");
        System.out.println("Se ha accedido a la BD");
        return bd;
    }

    public static DBCollection getCollection() {
        if (collection != null)
            collection = bd.getCollection("accounts");
        return collection;
    }

    public void cerrarConexion(){
        client.close();
    }

    public static void cerrar() {
        if (client == null)
            client.close();
    }

    public static void main(String[] args) {
        Conexion conexion = new Conexion();
        Conexion.getConexion();
        Conexion.getCollection();
        System.out.println(conexion);
    }
}
