package entidades;

import juego.Juego;

public class Jugador extends Personaje{
    private String icono;
    private int ataque, defensa, estadio;
    
    public Jugador(){}

    public Jugador(String raza){
        this.raza = raza;
        this.icono = "img/iconos/" + this.raza + ".png";
        setEstadisticas();
    }
    
    public void setEstadisticas(){
        if(raza.equals("Humano")){
            vida = 100;
            ataque = 1;
            defensa = 3;
        }else if(raza.equals("Elfo")){
            vida = 120;
            ataque = 2;
            defensa = 1;
        }else{
            vida = 80;
            ataque = 3;
            defensa = 2;
        }
    }

    public String getIcono(){
        return icono;
    }

    public void setIcono(String icono){
        this.icono = icono;
    }

    public int getEstadio(){
        return estadio;
    }

    public void setEstadio(int estadio){
        this.estadio = estadio;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefensa() {
        return defensa;
    }
    
    public void guardarPartida(int estadio){
        setEstadio(estadio);
        Juego.c.guardarJugador(this);
    }
    
    public void cargarPartida(){
        switch(estadio){
            case 0: // menu
                Juego.i.setGui(1);
            break;
            case 1: // bosque//ciudad//elfos
                Juego.i.setGui(1);
            break;
            case 2: // elfos derrotados
                Juego.i.setGui(3);
            break;
            case 3: // ciudad traspasada
                Juego.i.setGui(5);
            break;
            case 4: // en al sendero
                Juego.i.setGui(6);
            break;
        }
    }
}