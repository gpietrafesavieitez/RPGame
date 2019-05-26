package controladores.graficos;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class Gui extends JFrame{
    protected JPanel panelInferior;
    protected JLabel labelEscena;
    protected final String RUTA = "./img/";
    protected final int ANCHO = 800, ALTO = 600;

    protected abstract void construirPanelInferior();
    protected abstract void construirVentana();
}