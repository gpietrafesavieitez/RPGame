package entidades;

public abstract class Personaje{
    protected int hp;

    public int getHp(){
        return hp;
    }

    public void setHp(int hp){
        this.hp = hp;
    }
    
    abstract void morir();
}