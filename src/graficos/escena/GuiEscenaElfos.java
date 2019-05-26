package graficos.escena;

import juego.Juego;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class GuiEscenaElfos extends GuiEscena{
    private JButton btn1, btn2, btn3;
    
    public GuiEscenaElfos(){
        inicializar();
    }
    
    @Override
    protected void construirVentana(){
        labelEscena.setIcon(new ImageIcon(RUTA + "escenas/elfos.gif"));
        areaTexto.setText("Te adentras por el camino de la izquierda y te encuentras con un pequeño grupo de elfos que se dan cuenta de tu presencia.\n\nNo sabes si son hostiles pero es posible que sepan algo acerca de tu hija.\n\n¿Qué haces?");
    }
    
    @Override
    protected void construirPanelInferior(){
        btn1 = new JButton("Atacar");
        btn2 = new JButton("Dialogar");
        btn3 = new JButton("Continuar");
        btn3.setVisible(false);
        panelInferior.add(btn1);
        panelInferior.add(btn2);
        panelInferior.add(btn3);
        
        btn1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                areaTexto.setText("De repente, uno de los elfos carga contra ti tan rápido que no te da tiempo ni a reaccionar y te asesta un golpe en la cara.\n\nTe apartas rápidamente pero no puedes ignorar el sabor de la nsangre.\n\nDesenfundas tu arma y te preparas para la batalla...");
                btn1.setVisible(false);
                btn2.setVisible(false);
                btn3.setVisible(true);
                btn3.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent evt){
                        Juego.i.setGui(3);
                    }
                });
            }
        });
        
        btn2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                Random rand = new Random();
                if(Juego.j.getRaza().equals("Elfo")){
                    areaTexto.setText("El grupo de elfos parece amigable y hablando con ellos te cuentan que hace unas pocas horas vieron a una niña escapando de algo en dirección al centro del bosque.\n\nLes pides que concreten qué era lo que la perseguía pero te dicen que no tienen ni idea.");
                    btn1.setVisible(false);
                    btn2.setVisible(false);
                    btn3.setVisible(true);
                    btn3.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent evt){
                            Juego.i.setGui(6);
                        }
                    });
                }else{
                    areaTexto.setText("De repente, uno de los elfos carga contra ti tan rápido que no te da tiempo ni a reaccionar y te asesta un golpe en la cara.\n\nTe apartas rápidamente pero no puedes ignorar el sabor de la nsangre.\n\nDesenfundas tu arma y te preparas para la batalla...");
                    btn1.setVisible(false);
                    btn2.setVisible(false);
                    btn3.setVisible(true);
                    btn3.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent evt){
                            Juego.i.setGui(3);
                        }
                    });
                }
            }
        });
    }
}