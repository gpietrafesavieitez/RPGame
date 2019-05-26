package controladores.graficos.escena;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import juego.Juego;

public class GuiEscenaCiudad2 extends GuiEscena{
    private JButton btn1, btn2, btn3;
    
    public GuiEscenaCiudad2(){
        Juego.j.guardarPartida(3);
        iniciar();
    }
    
    @Override
    protected void construirVentana(){
        labelEscena.setIcon(new ImageIcon(RUTA + "escenas/ciudad2.gif"));
        areaTexto.setText("Consigues adentrarte sigilosamente en la ciudad a través del sistema de alcantarillado sin que los guardias te detecten.\n\nSigues un largo tunel y acabas en una especie de zona secreta donde te encuentras con un hombre barbudo de pinta sospechosa que te pregunta qué ***** haces ahí.");
    }

    @Override
    protected void construirPanelInferior(){
        btn1 = new JButton("Amenazar");
        btn1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                areaTexto.setText("- Tú: ¡¿DÓNDE ESTÁ MI HIJA?!\n\n- Anciano: ¡Hey, no hace falta que me grites! ¿Una chiquilla de rojo? si, vi alguien así hace unas horas corriendo hacia el bosque. Si ha ido hacia allí será mejor que te des prisa en encontrarla porque dentro vive una criatura siniestra.");
                btn1.setVisible(false);
                btn2.setVisible(false);
                btn3.setVisible(true);
            }
        });
        btn2 = new JButton("Preguntar");
        btn2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                areaTexto.setText("- Tú: ¿No ha visto por casualidad una niña de rojo?\n\n- Anciano: Sí, vi alguien así hace unas horas corriendo hacia el bosque. Si ha ido hacia allí será mejor que te des prisa en encontrarla porque dentro vive una criatura siniestra.");
                btn1.setVisible(false);
                btn2.setVisible(false);
                btn3.setVisible(true);
            }
        });
        btn3 = new JButton("Continuar");
        btn3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                Juego.i.setGui(6);
            }
        });
        
        panelInferior.add(btn1);
        panelInferior.add(btn2);
        panelInferior.add(btn3);
        
        btn3.setVisible(false);
    }
}