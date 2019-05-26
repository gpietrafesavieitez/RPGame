package controladores.graficos.escena;

import controladores.audio.Audio;
import entidades.Enemigo;
import juego.Juego;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import juego.Interfaz;

public class GuiEscenaElfos2 extends GuiEscena{
    private JButton btn1, btn2;
    private boolean turno = true;
    Enemigo e = new Enemigo("Arwin","Elfo",75);
    Audio sfx = new Audio();
    Random rand = new Random();
    
    public GuiEscenaElfos2(){
        Juego.j.guardarPartida(2);
        iniciar();
    }
    
    @Override
    protected void construirVentana(){
        labelEscena.setIcon(new ImageIcon(RUTA + "escenas/elfos2.gif"));
        areaTexto.setText("¡Prepárate para luchar!");
    }
    
    @Override
    protected void construirPanelInferior(){
        btn1 = new JButton("Luchar");
        btn2 = new JButton("Leer");
        panelInferior.add(btn1);
        panelInferior.add(btn2);
        btn2.setVisible(false);
        sfx.elegirSonido(7);
        
        btn1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                if(turno && Juego.j.getVida() > 0 && e.getVida() > 0){
                    int randPlayer = rand.nextInt(10) + 1;
                    e.setVida(e.getVida() - Math.abs(randPlayer * Juego.j.getAtaque()));
                    sfx.parar();
                    sfx.iniciar();
                    if(e.getVida() < 0){
                        e.setVida(0);
                    }
                    areaTexto.setText("Vida restante: " + e.getVida());
                    turno = false;
                }else if((turno && Juego.j.getVida() <= 0) || (!turno && Juego.j.getVida() <= 0)){
                    Juego.j.setVida(0);
                    JOptionPane.showMessageDialog(null, "Has muerto.", "RPGame", 1, new ImageIcon(RUTA + "iconos/morir.png"));
                    Interfaz.audio.parar();
                    Interfaz.gui.dispose();
                    Juego.i.setGui(0);
                }else if((!turno && e.getVida() <= 0) || (turno && e.getVida() <= 0)){
                    Interfaz.audio.parar();
                    Interfaz.audio.elegirSonido(1);
                    Interfaz.audio.bucle();
                    labelEscena.setIcon(new ImageIcon(RUTA + "escenas/elfos.gif"));
                    areaTexto.setText("Finalmente consigues encajar un golpe mortal al elfo y éste cae redondo al suelo.\n\nAnte tal situación, los elfos que quedan huyen despavoridos.\n\nDecides registrar al elfo por si lleva algun tipo de objeto o pista que te ayude a encontrar a tu hija y rebuscando entre sus bolsillos te encuentras con una extraña nota...");
                    btn1.setVisible(false);
                    btn2.setVisible(true);
                }else if(!turno && Juego.j.getVida() > 0 && e.getVida() > 0){
                    int randEnemy = rand.nextInt(10) + 1;
                    Juego.j.setVida(Juego.j.getVida() - Math.abs(randEnemy / Juego.j.getDefensa()));
                    sfx.parar();
                    sfx.iniciar();
                    areaTexto.setText("Vida restante: " + e.getVida());
                    if(Juego.j.getVida() < 0){
                        Juego.j.setVida(0);
                    }
                    labelVida.setText(""+Juego.j.getVida());
                    turno = true;
                }
            }
        });
        
        btn2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                JOptionPane.showMessageDialog(null, "La nota reza:\nSigue por el sendero sombrío y hallarás tu destino.", "RPGame", 1, new ImageIcon(RUTA + "iconos/pista.png"));
                Juego.i.setGui(6);
            }
        });
    }
}