package entidades;

public class Jugador extends Personaje{
    private String nick, raza, icono;
    private int atq, def, state;
    
    public Jugador(){
    }

    public Jugador(String raza){
        this.raza = raza;
        this.icono = "img/icons/" + this.raza + ".jpg";
        setStats();
    }
    
    public void setStats(){
        if(raza.equals("Humano")){
            hp = 100;
            atq = 1;
            def = 3;
        }else if(raza.equals("Elfo")){
            hp = 200;
            atq = 2;
            def = 1;
        }else{
            hp = 80;
            atq = 3;
            def = 2;
        }
    }

    public String getNick(){
        return nick;
    }

    public void setNick(String nick){
        this.nick = nick;
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

    public void setAtq(int atq) {
        this.atq = atq;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    @Override
    void morir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}