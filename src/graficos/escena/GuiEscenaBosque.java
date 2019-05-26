package graficos.escena;

import juego.Juego;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class GuiEscenaBosque extends GuiEscena{
    private JButton btn1, btn2;
    
    public GuiEscenaBosque(){
        Juego.j.guardarPartida(1);
        inicializar();
    }
    
    @Override
    protected void construirVentana() {
        labelEscena.setIcon(new ImageIcon(RUTA + "escenas/bosque.gif"));
        areaTexto.setText("Te despiertas en medio de un oscuro bosque. Llueve bastante y apenas hay luz pero no estás muy seguro que sea de noche. No sabes que haces ahí pero recuerdas que hace poco estabas con tu hija pequeña Megumin dando un paseo y ahora ha desaparecido.\n\nDecides ir a buscarla pero frente tuya hay dos caminos que se separan. Hace frío y no sabes si tu hija estará bien.\n\n¿Qué camino tomarás?");
    }
    
    @Override
    protected void construirPanelInferior(){
        btn1 = new JButton("Izquierda");
        btn1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                Juego.i.setGui(2);
            }
        });
        btn2 = new JButton("Derecha");
        btn2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                Juego.i.setGui(4);
            }
        });
        panelInferior.add(btn1);
        panelInferior.add(btn2);
    }
}