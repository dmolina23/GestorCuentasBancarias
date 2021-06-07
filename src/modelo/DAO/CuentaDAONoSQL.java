package modelo.DAO;

import com.mongodb.MongoClient;
import modelo.Conexion;
import modelo.DTO.Cuenta;
import org.bson.Document;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class CuentaDAONoSQL implements CuentaDAO {
    private static MongoClient conexion = Conexion.getConexion();

    @Override
    public List<Cuenta> listarCuentas() {
        List<Cuenta> listaCuentas = new ArrayList<>();
        conexion.getDatabase("db1").
                getCollection("accounts").find().forEach((Consumer<Document>) (Document d) -> {
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
        return false;
    }

    @Override
    public boolean insertarCuenta(Cuenta cuenta) {
        return false;
    }

    @Override
    public boolean actualizarCuentaPorId(Cuenta cuenta) {
        return false;
    }

    public static void main(String[] args) {
        CuentaDAO cuentaDAO = new CuentaDAONoSQL();
        cuentaDAO.listarCuentas();
    }
}
