package graficos.escena;

import controladores.Audio;
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
        inicializar();
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
                if(turno && Juego.j.getHp() > 0 && e.getHp() > 0){
                    int randPlayer = rand.nextInt(20) + 1;
                    e.setHp(e.getHp() - Math.abs(randPlayer * Juego.j.getAtq()));
                    sfx.stop();
                    sfx.play();
                    if(e.getHp() < 0){
                        e.setHp(0);
                    }
                    areaTexto.setText("Vida restante: " + e.getHp());
                    turno = false;
                }else if((turno && Juego.j.getHp() <= 0) || (!turno && Juego.j.getHp() <= 0)){
                    Juego.j.setHp(0);
                    JOptionPane.showMessageDialog(null, "Has muerto.", "RPGame", 1, new ImageIcon(RUTA + "iconos/morir.png"));
                    Interfaz.cancion.stop();
                    Interfaz.gui.dispose();
                    Juego.i.setGui(0);
                }else if((!turno && e.getHp() <= 0) || (turno && e.getHp() <= 0)){
                    Interfaz.cancion.stop();
                    Interfaz.cancion.elegirSonido(1);
                    Interfaz.cancion.loop();
                    labelEscena.setIcon(new ImageIcon(RUTA + "escenas/jefe.gif"));
                    areaTexto.setText("FALTA REDACTAR ESTO");
                    btn1.setVisible(false);
                    btn2.setVisible(true);
                }else if(!turno && Juego.j.getHp() > 0 && e.getHp() > 0){
                    int randEnemy = rand.nextInt(20) + 1;
                    Juego.j.setHp(Juego.j.getHp() - Math.abs(randEnemy / Juego.j.getDef()));
                    sfx.stop();
                    sfx.play();
                    areaTexto.setText("Vida restante: " + e.getHp());
                    if(Juego.j.getHp() < 0){
                        Juego.j.setHp(0);
                    }
                    labelVida.setText(""+Juego.j.getHp());
                    turno = true;
                }
            }
        });
        
        btn2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                Interfaz.cancion.stop();
                Juego.i.setGui(9);
            }
        });
    }
}