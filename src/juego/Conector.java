package juego;

import entidades.Jugador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Conector{
    private Connection conn;
    
    public Conector(){}
    
    public boolean conectar(){
        try{
            conn = DriverManager.getConnection("jdbc:sqlite:rpgame.db");
            return true;
        }catch(SQLException e){
            return false;
        }
    }

    public int insertar(String nick, String raza, int hp){
        try{
            PreparedStatement st = conn.prepareStatement("INSERT INTO jugadores(nick,raza,hp) VALUES('"+ nick + "','" + raza + "'," + hp + ")");
            return st.executeUpdate();
        }catch(SQLException e){
            return -1;
        }
    }
    
    public ArrayList<String> consultar(String campo){
        try{
            PreparedStatement st = conn.prepareStatement("SELECT " + campo + " FROM jugadores");
            ResultSet rs = st.executeQuery();
            ArrayList<String> lista = new ArrayList<>();
            while(rs.next()){
                lista.add(rs.getString(campo));
            }
            return lista;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    
    public int modificar(Object colID, Object colNombre, Object colApellido){
        try{
            PreparedStatement st = conn.prepareStatement("UPDATE alumnos SET Nombre='" + colNombre + "',Apellido='" + colApellido + "' WHERE ID=" + colID);
            return st.executeUpdate();
        }catch(SQLException e){
            return -1;
        }
    }
    
    public Jugador cargar(String nick){
        Jugador j;
        try{
            PreparedStatement st = conn.prepareStatement("SELECT * FROM jugadores WHERE nick = '" + nick + "'");
            ResultSet rs = st.executeQuery();
            j = new Jugador();
            while(rs.next()){
                j.setNick(rs.getString("nick"));
                j.setRaza(rs.getString("raza"));
                j.setHp(rs.getInt("hp"));
                j.setState(rs.getInt("state"));
            }
            j.setStats();
            return j;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    
    public int guardarPartida(Jugador j){
        try{
            PreparedStatement st = conn.prepareStatement("UPDATE jugadores SET hp=" + j.getHp() + ",state=" + j.getState() + " WHERE nick='" + j.getNick() + "'");
            return st.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
            return -1;
        }
    }
}