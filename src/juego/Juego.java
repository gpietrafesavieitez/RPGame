package juego;

import controladores.Sonido;
import entidades.Enemigo;
import entidades.Jugador;
import javax.swing.ImageIcon;

public class Juego{
    public static Conector c;
    public static Interfaz i; //g y s1
    public static Sonido s2;
    public static Jugador j;
    public static Enemigo e;
    public static ImageIcon avatar;
    
    public void iniciar(){
        c = new Conector();
        if(c.conectar()){
            i = new Interfaz();
            i.setGui(0);
            System.out.println("[ info ] Conexión establecida");
        }else{
            System.out.println("[ error ] No se ha podido establecer una conexión");
        }
    }

    public static void main(String[] args){
        new Juego().iniciar();
    }
}