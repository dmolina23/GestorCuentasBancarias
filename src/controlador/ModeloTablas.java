package controlador;

import modelo.DAO.CuentaDAO;
import modelo.DAO.CuentaDAONoSQL;
import modelo.DTO.Cuenta;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ModeloTablas extends AbstractTableModel {
    private static final String[] COLUMNAS = {"IBAN", "CREDIT CARD", "BALANCE", "FULL NAME", "DATE"};
    private static final CuentaDAO cuentaDAO = new CuentaDAONoSQL();
    private static List<Cuenta> cuentas;

    public ModeloTablas() {
        cuentas = cuentaDAO.listarCuentas();
    }

    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public int getColumnCount() {
        return 0;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
    }
}
