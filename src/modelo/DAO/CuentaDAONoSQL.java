package modelo.DAO;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import modelo.Conexion;
import modelo.DTO.Cuenta;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class CuentaDAONoSQL implements CuentaDAO {
    private static MongoClient conexion = Conexion.getConexion();
    private static MongoCollection coleccion = conexion.getDatabase("db1").getCollection("accounts");

    @Override
    public List<Cuenta> listarCuentas() {
        List<Cuenta> listaCuentas = new ArrayList<>();
        coleccion.find().forEach((Consumer<Document>) (Document d) -> {
            String fecha;
            LocalDate fechaActual = LocalDate.now();
            listaCuentas.add(new Cuenta(
                    d.getObjectId("_id"),
                    d.getString("iban"),
                    d.getString("creditCard"),
                    d.getDouble("balance"),
                    d.getString("fullName"),
                    String.format("%d-%d-%d", fechaActual.getYear(),fechaActual.getMonthValue(),
                            fechaActual.getDayOfMonth())));
            }
        );
        System.out.println(listaCuentas);
        System.out.println(listaCuentas.size());
        return listaCuentas;
    }

    @Override
    public boolean borrarCuentaPorId(String idCuenta) {
        Document document = new Document();
        coleccion.deleteOne(document.append("_id", new ObjectId(idCuenta)));
        return coleccion.deleteOne(document).getDeletedCount() != 0;
    }

    @Override
    public boolean insertarCuenta(Cuenta cuenta) {
        long numInicial = coleccion.countDocuments();
        Document document = new Document();
        document.append("iban",cuenta.getIban());
        document.append("creditCard", cuenta.getCreditCard());
        document.append("balance", cuenta.getBalance());
        document.append("fullName", cuenta.getFullName());
        document.append("date", cuenta.getDate());
        coleccion.insertOne(document);
        long numFinal = coleccion.countDocuments();
        return (numFinal - numInicial) != 0;
    }

    @Override
    public boolean actualizarCuentaPorId(Cuenta cuenta) {
        return false;
    }
}
