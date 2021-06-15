package modelo.DAO;

import modelo.DTO.Cuenta;

import java.util.List;

public interface CuentaDAO {
    List<Cuenta> listarCuentas();
    boolean borrarCuentaPorId(String idCuenta);
    boolean insertarCuenta(Cuenta cuenta);
    void actualizarCuentaPorId(Cuenta cuenta);
}
