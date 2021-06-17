package controlador;

import modelo.DAO.CuentaDAO;
import modelo.DAO.CuentaDAONoSQL;
import modelo.DTO.Cuenta;
import org.bson.types.ObjectId;
import vista.AppVista;

import java.time.LocalDate;


public class Controlador {
    private AppVista vista;
    private ModeloTablas modelo;
    private CuentaDAO cuentaDAO = new CuentaDAONoSQL();

    public Controlador(AppVista vista, ModeloTablas modelo){
        this.vista = vista;
        this.modelo = modelo;
        generarTabla();
        registrarEventos();
    }

    private void registrarEventos() {
        vista.getDeleteButton().addActionListener(e -> borrarFila());
        vista.getCancelButton().addActionListener(e -> hideAdd());
        vista.getSaveButton().addActionListener(e -> guardarCuenta());
        vista.getAddButton().addActionListener(e -> addRow());
    }

    private void borrarFila() {
        int selectedRow = vista.getTable1().getSelectedRow();
        int r = vista.getTable1().convertRowIndexToModel(selectedRow);
        modelo.removeRow(r);
    }

    private void guardarCuenta() {
        ObjectId id = new ObjectId();
        String iban = vista.getIbanTextField().getText();
        String cCard = vista.getCcTextField().getText();
        Double balance = Double.valueOf(vista.getBalanceTextField().getText());
        String name = vista.getNameTextField().getText();
        String date = LocalDate.now().toString();

        //añadimos la cuenta a la lista
        Cuenta cuenta = new Cuenta(id,iban,cCard,balance,name,date);
        modelo.addRow(cuenta);
        hideAdd();
    }

    private void hideAdd() {
        vista.getRightPanel().setVisible(false);
        vista.getIbanTextField().setText("");
        vista.getCcTextField().setText("");
        vista.getBalanceTextField().setText("");
        vista.getNameTextField().setText("");
    }

    private void addRow() {
        vista.getRightPanel().setVisible(true);
    }

    private void generarTabla() {
        vista.getTable1().setModel(modelo);
        vista.getRightPanel().setVisible(false);
    }
}
