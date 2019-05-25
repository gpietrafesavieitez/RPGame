package juego;

import graficos.Gui;
import controladores.Sonido;
import graficos.escena.GuiEscenaBosque;
import graficos.escena.GuiEscenaCiudad;
import graficos.escena.GuiEscenaCiudad2;
import graficos.escena.GuiEscenaElfos;
import graficos.escena.GuiEscenaElfos2;
import graficos.escena.GuiEscenaSendero;
import graficos.menu.GuiMenuPrincipal;

public class Interfaz{
    public static Gui g;
    public static Sonido s;
    
    public Interfaz(){
    }
    
    public void setGui(int tipo){
        switch (tipo) {
            case 0:
                g = new GuiMenuPrincipal();
                s = new Sonido(tipo);
                s.loop();
                break;
            case 1:
                g.dispose();
                s.stop();
                g = new GuiEscenaBosque();
                s = new Sonido(tipo);
                s.loop();
                break;
            case 2:
                g.dispose();
                s.stop();
                g = new GuiEscenaElfos();
                s = new Sonido(tipo);
                s.loop();
                break;
            case 3:
                g.dispose();
                s.stop();
                g = new GuiEscenaElfos2();
                s = new Sonido(tipo);
                s.loop();
                break;
            case 4:
                g.dispose();
                s.stop();
                g = new GuiEscenaCiudad();
                s = new Sonido(tipo);
                s.loop();
                break;
            case 5:
                g.dispose();
                s.stop();
                g = new GuiEscenaCiudad2();
                s = new Sonido(tipo);
                s.loop();
                break;
            case 6:
                g.dispose();
                s.stop();
                g = new GuiEscenaSendero();
                s = new Sonido(tipo);
                s.loop();
                break;
            case 7:
                g.dispose();
                s.stop();
                //g = new GuiEscenaJefe();
                s = new Sonido(tipo);
                s.loop();
                break;
            case 8:
                g.dispose();
                s.stop();
                //g = new GuiEscenaHija();
                s = new Sonido(tipo);
                s.loop();
                break;
        }
    }
}