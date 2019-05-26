package graficos.escena;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import juego.Juego;

public class GuiEscenaSendero extends GuiEscena{
    private JButton btn1;
    
    public GuiEscenaSendero(){
        Juego.j.guardarPartida(4);
        inicializar();
    }
    
    @Override
    protected void construirVentana(){
        labelEscena.setIcon(new ImageIcon(RUTA + "escenas/sendero.gif"));
        areaTexto.setText("La pista te conduce hacia un oscuro sendero que lleva a un lugar recóndito del bosque.\n\nMientras sigues el camino puedes observar manchas de sangre por el suelo, todavía frescas.\n\nTe temes lo peor así que apuras el paso...");
    }

    @Override
    protected void construirPanelInferior(){
        btn1 = new JButton("Continuar");
        btn1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                Juego.i.setGui(7);
            }
        });
        panelInferior.add(btn1);
    }
}