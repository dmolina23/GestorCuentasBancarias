
import controlador.Controlador;
import controlador.ModeloTablas;
import vista.AppVista;

public class App {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                AppVista vista = new AppVista();
                ModeloTablas modelo = new ModeloTablas();
                new Controlador(vista,modelo);
            }
        });
    }
}