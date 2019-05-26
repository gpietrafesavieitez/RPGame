package juego;

import controladores.Audio;
import graficos.Gui;
import graficos.escena.*;
import graficos.menu.GuiMenuPrincipal;

public class Interfaz{
    public static Gui gui;
    public static Audio cancion;
    
    public Interfaz(){}
    
    public void setGui(int tipo){
        switch (tipo) {
            case 0:
                gui = new GuiMenuPrincipal();
                cancion = new Audio(0);
                cancion.loop();
                break;
            case 1:
                gui.dispose();
                cancion.stop();
                gui = new GuiEscenaBosque();
                cancion = new Audio(1);
                cancion.loop();
                break;
            case 2:
                gui.dispose();
                cancion.stop();
                gui = new GuiEscenaElfos();
                cancion = new Audio(1);
                cancion.loop();
                break;
            case 3:
                gui.dispose();
                cancion.stop();
                gui = new GuiEscenaElfos2();
                cancion = new Audio(2);
                cancion.loop();
                break;
            case 4:
                gui.dispose();
                cancion.stop();
                gui = new GuiEscenaCiudad();
                cancion = new Audio(3);
                cancion.loop();
                break;
            case 5:
                gui.dispose();
                cancion.stop();
                gui = new GuiEscenaCiudad2();
                cancion = new Audio(4);
                cancion.loop();
                break;
            case 6:
                gui.dispose();
                cancion.stop();
                gui = new GuiEscenaSendero();
                cancion = new Audio(6);
                cancion.loop();
                break;
            case 7:
                gui.dispose();
                cancion.stop();
                gui = new GuiEscenaJefe();
                cancion = new Audio(6);
                cancion.loop();
                break;
            case 8:
                gui.dispose();
                cancion.stop();
                gui = new GuiEscenaJefe2();
                cancion = new Audio(2);
                cancion.loop();
                break;
            case 9:
                gui.dispose();
                cancion.stop();
                gui = new GuiEscenaHija();
                cancion = new Audio(5);
                cancion.loop();
                break;
        }
    }
}