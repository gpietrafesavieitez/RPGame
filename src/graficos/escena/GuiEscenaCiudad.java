package graficos.escena;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import juego.Juego;

public class GuiEscenaCiudad extends GuiEscena{
    private JButton btn1, btn2, btn3;
    public static boolean flagIntento = false;
    
    public GuiEscenaCiudad(){
        inicializar();
    }
    
    @Override
    protected void construirVentana(){
        labelEscena.setIcon(new ImageIcon(RUTA + "escenas/ciudad.gif"));
        areaTexto.setText("Tomas el camino de la derecha y llegas a las puertas de una pequeña ciudadela.\n\nA ambos lados hay unos enormes guardias que las custodian. Es posible que dentro haya alguien que sepa algo sobre tu hija pero no nsabes si serás bien recibido en esa ciudad.\n\n¿Qué opcion eliges?");
    }

    @Override
    protected void construirPanelInferior(){
        btn1 = new JButton("Volver");
        btn1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                Juego.i.setGui(1);
            }
        });
        btn2 = new JButton("Entrar");
        btn2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                areaTexto.setText("Nada más dar un paso los guardias te apuntan con sus armas y te gritan que te marches de allí, así que no te queda más remedio que dar media vuelta...");
            }
        });
        btn3 = new JButton("Infiltrarte");
        if(flagIntento){
            btn3.setVisible(false);
        }
        btn3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                Random rand = new Random();
                int randPlayer = rand.nextInt((100 - 0) + 1) + 0;
                if(randPlayer > 80){
                    Juego.i.setGui(5);
                }else{
                    flagIntento = true;
                    btn3.setVisible(false);
                    areaTexto.setText("Intentas escabullirte y fracasas estrepitosamente.\n\nLos guardias te han visto tratando de saltar inutilmente la muralla.\n\nInmediatamente te agarran y te echan de la ciudad. Has perdido tu única oportunidad de colarte en la ciudadela, será mejor pensar en otra cosa.");
                }
            }
        });
        panelInferior.add(btn1);
        panelInferior.add(btn2);
        panelInferior.add(btn3);
    }
}