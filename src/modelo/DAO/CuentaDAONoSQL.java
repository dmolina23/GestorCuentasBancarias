package modelo.DAO;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import modelo.Conexion;
import modelo.DTO.Cuenta;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;

public class CuentaDAONoSQL implements CuentaDAO {
    private static MongoClient conexion = Conexion.getConexion();
    private static MongoCollection coleccion = conexion.getDatabase("db1").getCollection("accounts");

    @Override
    public List<Cuenta> listarCuentas() {
        List<Cuenta> listaCuentas = new ArrayList<>();
        coleccion.find().forEach((Consumer<Document>) (Document d) -> {
                    try {
                        listaCuentas.add(new Cuenta(
                                d.getString(""),
                                d.getString("iban"),
                                d.getString("creditCard"),
                                d.getDouble("balance"),
                                d.getString("fullName"),
                                new SimpleDateFormat("yyyy-MM-dd").parse(d.getString("date"))));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
            }
        );
        System.out.println(listaCuentas);
        System.out.println(listaCuentas.size());
        return listaCuentas;
    }

    @Override
    public boolean borrarCuentaPorId(String idCuenta) {
        Document document = new Document();
        coleccion.deleteOne(document.append("_id",new ObjectId(idCuenta)));
        return coleccion.deleteOne(document).getDeletedCount() != 0;
    }

    @Override
    public boolean insertarCuenta(Cuenta cuenta) {
        long numInicial = coleccion.countDocuments();
        Document document = new Document();
        document.put("iban",cuenta.getIban());
        document.put("creditCard", cuenta.getCreditCard());
        document.put("balance", cuenta.getBalance());
        document.put("fullName", cuenta.getFullName());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(cuenta.getDate().getYear());
        stringBuilder.append(cuenta.getDate().getMonth());
        stringBuilder.append(cuenta.getDate().getDay());
        document.put("date", stringBuilder.toString());
        coleccion.insertOne(document);
        long numFinal = coleccion.countDocuments();
        return (numFinal - numInicial) != 0;
    }

    @Override
    public boolean actualizarCuentaPorId(Cuenta cuenta) {
        return false;
    }
}
