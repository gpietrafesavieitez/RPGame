package controladores.graficos.escena;

import juego.Juego;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class GuiEscenaJefe extends GuiEscena{
    private JButton btn1;
    
    public GuiEscenaJefe(){
        iniciar();
    }
    
    @Override
    protected void construirVentana(){
        labelEscena.setIcon(new ImageIcon(RUTA + "escenas/jefe.gif"));
        areaTexto.setText("Tus pasos te acaban llevando hasta un pequeño claro. Justo en el medio se encuentra una criatura la cual no sabrías identificar pero con aspecto terrorífico. La criatura parece estar afilando su arma hasta que se entera de tu presencia y carga contra ti, pero tu ya estás preparado para lo que se avecina a continuación...");
    }
    
    @Override
    protected void construirPanelInferior(){
        btn1 = new JButton("Continuar");
        panelInferior.add(btn1);

        btn1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                Juego.i.setGui(8);
            }
        });
    }
}