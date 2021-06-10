package vista;

import javax.swing.*;
import java.awt.*;

public class AppVista {
    private JPanel mainPanel;
    private JPanel topPanel;
    private JPanel bottomPanel;
    private JPanel rightPanel;
    private JScrollPane centerPanel;
    private JTable table1;
    private JButton deleteButton;
    private JButton updateButton;
    private JButton addButton;
    private JTextField ibanTextField;
    private JTextField ccTextField;
    private JTextField balanceTextField;
    private JTextField nameTextField;
    private JButton saveButton;
    private JButton cancelButton;

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JPanel getTopPanel() {
        return topPanel;
    }

    public JPanel getBottomPanel() {
        return bottomPanel;
    }

    public JPanel getRightPanel() {
        return rightPanel;
    }

    public JScrollPane getCenterPanel() {
        return centerPanel;
    }

    public JTable getTable1() {
        return table1;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public JButton getUpdateButton() {
        return updateButton;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JTextField getIbanTextField() {
        return ibanTextField;
    }

    public JTextField getCcTextField() {
        return ccTextField;
    }

    public JTextField getBalanceTextField() {
        return balanceTextField;
    }

    public JTextField getNameTextField() {
        return nameTextField;
    }

    public JButton getSaveButton() {
        return saveButton;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }

    public AppVista() {
        JFrame frame = new JFrame("App Subida de Nota");
        frame.setContentPane(mainPanel);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(dimension.width/2,dimension.height/2);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
