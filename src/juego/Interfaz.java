package juego;

import controladores.audio.Audio;
import controladores.graficos.Gui;
import controladores.graficos.escena.*;
import controladores.graficos.menu.GuiMenuPrincipal;

public class Interfaz{
    public static Gui gui;
    public static Audio audio;
    
    public Interfaz(){}
    
    public void setGui(int tipo){
        switch (tipo) {
            case 0:
                gui = new GuiMenuPrincipal();
                audio = new Audio(0);
                audio.bucle();
                break;
            case 1:
                gui.dispose();
                audio.parar();
                gui = new GuiEscenaBosque();
                audio = new Audio(1);
                audio.bucle();
                break;
            case 2:
                gui.dispose();
                audio.parar();
                gui = new GuiEscenaElfos();
                audio = new Audio(1);
                audio.bucle();
                break;
            case 3:
                gui.dispose();
                audio.parar();
                gui = new GuiEscenaElfos2();
                audio = new Audio(2);
                audio.bucle();
                break;
            case 4:
                gui.dispose();
                audio.parar();
                gui = new GuiEscenaCiudad();
                audio = new Audio(3);
                audio.bucle();
                break;
            case 5:
                gui.dispose();
                audio.parar();
                gui = new GuiEscenaCiudad2();
                audio = new Audio(4);
                audio.bucle();
                break;
            case 6:
                gui.dispose();
                audio.parar();
                gui = new GuiEscenaSendero();
                audio = new Audio(6);
                audio.bucle();
                break;
            case 7:
                gui.dispose();
                audio.parar();
                gui = new GuiEscenaJefe();
                audio = new Audio(6);
                audio.bucle();
                break;
            case 8:
                gui.dispose();
                audio.parar();
                gui = new GuiEscenaJefe2();
                audio = new Audio(2);
                audio.bucle();
                break;
            case 9:
                gui.dispose();
                audio.parar();
                gui = new GuiEscenaHija();
                audio = new Audio(5);
                audio.bucle();
                break;
        }
    }
}