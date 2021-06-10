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
