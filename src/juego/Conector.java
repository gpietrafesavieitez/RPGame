package juego;

import entidades.Jugador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Conector{
    private Connection con;
    private PreparedStatement sql;
    
    public Conector(){}
    
    public boolean conectar(){
        try{
            con = DriverManager.getConnection("jdbc:sqlite:juego.db");
            return true;
        }catch(SQLException sqle){
            sqle.printStackTrace();
            return false;
        }
    }
    
    public int insertar(String nombre, String raza, int vida){
        conectar();
        try{
            sql = con.prepareStatement("INSERT INTO jugadores(nombre,raza,vida) VALUES('"+ nombre + "','" + raza + "'," + vida + ")");
            return sql.executeUpdate();
        }catch(SQLException e){
            return -1;
        }finally{
            try{
                sql.close();
                con.close();
            }catch(SQLException sqle){
                sqle.printStackTrace();
                return -1;
            }
        }
    }
    
    public ArrayList<String> consultar(String nombre){
        conectar();
        try{
            sql = con.prepareStatement("SELECT " + nombre + " FROM jugadores");
            ResultSet rs = sql.executeQuery();
            ArrayList<String> lista = new ArrayList<>();
            while(rs.next()){
                lista.add(rs.getString(nombre));
            }
            return lista;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }finally{
            try{
                sql.close();
                con.close();
            }catch(SQLException sqle){
                sqle.printStackTrace();
                return null;
            }
        }
    }
    
    public Jugador cargarJugador(String nombre){
        conectar();
        try{
            sql = con.prepareStatement("SELECT * FROM jugadores WHERE nombre = '" + nombre + "'");
            ResultSet rs = sql.executeQuery();
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
            try{
                sql.close();
                con.close();
            }catch (SQLException sqle){
                sqle.printStackTrace();
                return null;
            }
        }
    }
    
    public int guardarJugador(Jugador j){
        conectar();
        try{
            sql = con.prepareStatement("UPDATE jugadores SET vida=" + j.getVida() + ",estadio=" + j.getEstadio() + " WHERE nombre='" + j.getNombre() + "'");
            return sql.executeUpdate();
        }catch(SQLException sqle){
            sqle.printStackTrace();
            return -1;
        }finally{
            try{
                sql.close();
                con.close();
            }catch(SQLException sqle){
                sqle.printStackTrace();
                return -1;
            }
        }
    }
}