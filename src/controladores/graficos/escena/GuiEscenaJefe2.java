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

public class GuiEscenaJefe2 extends GuiEscena{
    private JButton btn1, btn2;
    private boolean turno = true; 
    Audio sfx = new Audio();
    Enemigo e = new Enemigo("Nocturne","Desconocido/a",200);
    Random rand = new Random();
    
    public GuiEscenaJefe2(){
        iniciar();
        sfx.elegirSonido(7);
    }
    
    @Override
    protected void construirVentana(){
        labelEscena.setIcon(new ImageIcon(RUTA + "escenas/jefe2.gif"));
        areaTexto.setText("¡Prepárate para luchar!");
    }
    
    @Override
    protected void construirPanelInferior(){
        btn1 = new JButton("Luchar");
        btn2 = new JButton("Continuar");
        panelInferior.add(btn1);
        panelInferior.add(btn2);
        btn2.setVisible(false);
        
        btn1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                if(turno && Juego.j.getVida() > 0 && e.getVida() > 0){
                    int randPlayer = rand.nextInt(20) + 1;
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
                    labelEscena.setIcon(new ImageIcon(RUTA + "escenas/jefe.gif"));
                    areaTexto.setText("FALTA REDACTAR ESTO");
                    btn1.setVisible(false);
                    btn2.setVisible(true);
                }else if(!turno && Juego.j.getVida() > 0 && e.getVida() > 0){
                    int randEnemy = rand.nextInt(20) + 1;
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
                Interfaz.audio.parar();
                Juego.i.setGui(9);
            }
        });
    }
}