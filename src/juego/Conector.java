package juego;

import entidades.Jugador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conector{
    private Connection con;
    private PreparedStatement st;
    
    public Conector(){}
    
    public boolean conectar(){
        try{
            con = DriverManager.getConnection("jdbc:sqlite:rpgame.db");
            return true;
        }catch(SQLException e){
            return false;
        }
    }

    public int insertar(String nombre, String raza, int vida){
        conectar();
        try{
            st = con.prepareStatement("INSERT INTO jugadores(nombre,raza,vida) VALUES('"+ nombre + "','" + raza + "'," + vida + ")");
            return st.executeUpdate();
        }catch(SQLException e){
            return -1;
        }finally{
            try {
                st.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public ArrayList<String> consultar(String nombre){
        conectar();
        try{
            st = con.prepareStatement("SELECT " + nombre + " FROM jugadores");
            ResultSet rs = st.executeQuery();
            ArrayList<String> lista = new ArrayList<>();
            while(rs.next()){
                lista.add(rs.getString(nombre));
            }
            return lista;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }finally{
            try {
                st.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public Jugador cargarJugador(String nombre){
        conectar();
        try{
            st = con.prepareStatement("SELECT * FROM jugadores WHERE nombre = '" + nombre + "'");
            ResultSet rs = st.executeQuery();
            Jugador j = new Jugador();
            while(rs.next()){
                j.setNombre(rs.getString("nombre"));
                j.setRaza(rs.getString("raza"));
                j.setVida(rs.getInt("vida"));
                j.setEstadio(rs.getInt("estadio"));
            }
            j.setEstadisticas();
            return j;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }finally{
            try {
                st.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public int guardarJugador(Jugador j){
        conectar();
        try{
            st = con.prepareStatement("UPDATE jugadores SET vida=" + j.getVida() + ",estadio=" + j.getEstadio() + " WHERE nombre='" + j.getNombre() + "'");
            return st.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
            return -1;
        }finally{
            try {
                st.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}