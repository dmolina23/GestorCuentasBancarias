package controlador;

import modelo.DAO.CuentaDAO;
import modelo.DAO.CuentaDAONoSQL;
import modelo.DTO.Cuenta;
import org.bson.types.ObjectId;

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
        return cuentas.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMNAS.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Object celda = null;
        switch (column) {
            case 0:
                celda = cuentas.get(row).getIban();
                break;
            case 1:
                celda = cuentas.get(row).getCreditCard();
                break;
            case 2:
                celda = cuentas.get(row).getBalance();
                break;
            case 3:
                celda = cuentas.get(row).getFullName();
                break;
            case 4:
                celda = cuentas.get(row).getDate();
                break;
        }
        return celda;
    }

    @Override
    public String getColumnName(int column) {
        return COLUMNAS[column];
    }

    public void addRow(Cuenta cuenta) {
        cuentaDAO.insertarCuenta(cuenta);
        cuentas.add(cuenta);
        fireTableDataChanged();
    }

    public void removeRow(int row) {
        if (row < 0)
            return;
        //eliminar de la BD
//        System.out.println(cuentas.get(row).getId());
        cuentaDAO.borrarCuentaPorId(cuentas.get(row).getId().toString());
        //eliminar de la lista
        cuentas.remove(row);
        fireTableDataChanged();
    }
}
