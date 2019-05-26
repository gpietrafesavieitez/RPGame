package graficos.escena;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import juego.Interfaz;
import juego.Juego;

public class GuiEscenaHija extends GuiEscena{
    private JButton btn1;
    
    public GuiEscenaHija(){
        Juego.j.guardarPartida(0);
        inicializar();
    }
    
    @Override
    protected void construirVentana(){
        labelEscena.setIcon(new ImageIcon(RUTA + "escenas/hija2.gif"));
        areaTexto.setText("¡Felicidades, lo has conseguido!\n\nHas rescatado a tu hija, ahora está sana y salva.\n\nHaz click para empezar una nueva partida.");
    }

    @Override
    protected void construirPanelInferior(){
        btn1 = new JButton("Fin");
        btn1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                Interfaz.gui.dispose();
                Interfaz.cancion.stop();
                Juego.i.setGui(0);
            }
        });
        panelInferior.add(btn1);
    }
}