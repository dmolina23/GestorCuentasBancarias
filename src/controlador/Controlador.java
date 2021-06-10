package controlador;

import modelo.DTO.Cuenta;
import vista.AppVista;

import java.time.Instant;
import java.util.Date;


public class Controlador {
    private AppVista vista;
    private ModeloTablas modelo;

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
        modelo.removeRow(selectedRow);
    }

    private void guardarCuenta() {
        String iban = vista.getIbanTextField().getText();
        String cCard = vista.getCcTextField().getText();
        Double balance = Double.valueOf(vista.getBalanceTextField().getText());
        String name = vista.getNameTextField().getText();

        Cuenta cuenta = new Cuenta(iban,cCard,balance,name, Date.from(Instant.now()));
        modelo.addRow(cuenta);
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
