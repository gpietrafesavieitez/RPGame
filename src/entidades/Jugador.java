package entidades;

import juego.Juego;

public class Jugador extends Personaje{
    private String nombre, raza, icono;
    private int atq, def, state;
    
    public Jugador(){}

    public Jugador(String raza){
        this.raza = raza;
        this.icono = "img/iconos/" + this.raza + ".png";
        setStats();
    }
    
    public void setStats(){
        if(raza.equals("Humano")){
            hp = 100;
            atq = 1;
            def = 3;
        }else if(raza.equals("Elfo")){
            hp = 120;
            atq = 2;
            def = 1;
        }else{
            hp = 80;
            atq = 3;
            def = 2;
        }
    }

    public String getNick(){
        return nombre;
    }

    public void setNick(String nick){
        this.nombre = nick;
    }

    public String getRaza(){
        return raza;
    }

    public void setRaza(String raza){
        this.raza = raza;
    }

    public String getIcono(){
        return icono;
    }

    public void setIcono(String icono){
        this.icono = icono;
    }

    public int getState(){
        return state;
    }

    public void setState(int state){
        this.state = state;
    }

    public int getAtq() {
        return atq;
    }

    public int getDef() {
        return def;
    }
    
    public void guardarPartida(int state){
        setState(state);
        Juego.c.guardarJugador(this);
    }
    
    public void cargarPartida(){
        Juego.c.guardarJugador(this);
    }
}