package entidades;

public class Enemigo extends Personaje{
    private String nombre;
    private String raza;
    
    public Enemigo(){}

    public Enemigo(String nombre, String raza, int hp){
        this.hp = hp;
        this.nombre = nombre;
        this.raza = raza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }
}