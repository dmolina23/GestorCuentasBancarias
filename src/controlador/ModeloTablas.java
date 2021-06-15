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

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex != 4;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Cuenta cuentaAModificar = cuentas.get(rowIndex);
        switch (columnIndex){
            case 0:
                cuentaAModificar.setIban((String) aValue);
                break;
            case 1:
                cuentaAModificar.setCreditCard((String) aValue);
                break;
            case 2:
                cuentaAModificar.setBalance(Double.parseDouble((String) aValue));
                break;
            case 3:
                cuentaAModificar.setFullName((String) aValue);
                break;
        }
        cuentaDAO.actualizarCuentaPorId(cuentaAModificar);
    }

    public void addRow(Cuenta cuenta) {
        cuentaDAO.insertarCuenta(cuenta);
        cuentas.add(cuenta);
        fireTableDataChanged();
        cuentaDAO.listarCuentas();
    }

    public void removeRow(int row) {
        if (row < 0)
            return;
        //eliminar de la BD
        cuentaDAO.borrarCuentaPorId(cuentas.get(row).getId().toString());
        //eliminar de la lista
        cuentas.remove(row);
        fireTableDataChanged();
    }
}