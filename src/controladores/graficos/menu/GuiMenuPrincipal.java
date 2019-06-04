package controladores.graficos.menu;

import entidades.Jugador;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import juego.Juego;
import extras.Utiles;

public class GuiMenuPrincipal extends GuiMenu{
    private JButton btn1, btn2, btn3, btn4;
    
    public GuiMenuPrincipal(){
        iniciar();
    }
    
    @Override
    protected void construirPanelInferior(){
        panelInferior = new JPanel();
        btn1 = new JButton("Nueva partida");
        btn2 = new JButton("Continuar");
        btn3 = new JButton("Créditos");
        btn4 = new JButton("Salir");
        panelInferior.setLayout(new FlowLayout());
        panelInferior.setBackground(new java.awt.Color(33,26,33));
        panelInferior.add(btn1);
        panelInferior.add(btn2);
        panelInferior.add(btn3);
        panelInferior.add(btn4);

        btn1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                String raza = (String) JOptionPane.showInputDialog(null, "Escoge tu raza:", "RPGame", 0, new ImageIcon(RUTA + "iconos/raza.png"), new String[]{"Humano", "Elfo", "Orco"}, null);
                if(Utiles.handler(raza)){
                    Juego.j = new Jugador(raza);
                    String nombre;
                    do{
                        nombre = (String) JOptionPane.showInputDialog(null, "Has seleccionado: '" + raza + "'.\n\nDale un nombre a tu personaje:", "RPGame", 0, new ImageIcon(Juego.j.getIcono()), null, null);
                        if(nombre == null){
                            break;
                        }
                    }while(!comprobar(nombre));
                    if(Utiles.handler(nombre)){
                    Juego.j.setNombre(nombre);
                        if(Juego.c.insertar(nombre, raza, Juego.j.getVida()) > 0){
                            JOptionPane.showMessageDialog(null, "Te damos la bienvenida: " + Juego.j.getNombre() + "\n\nHaz click para comenzar.","RPGame", 0, new ImageIcon(Juego.j.getIcono()));
                            Juego.i.setGui(1);
                        }else{
                            System.out.println("[ error ] No se ha podido insertar.");
                        }
                    }
                }
            }
        });
        
        btn2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                Object[] jugadores = Juego.c.consultar("nombre").toArray();
                if(jugadores.length > 0){
                    String nombre = (String) JOptionPane.showInputDialog(null, "Selecciona tu personaje:", "RPGame", 0, new ImageIcon(RUTA + "iconos/cargar.png"), jugadores, null);
                    if(Utiles.handler(nombre)){
                        Juego.j = Juego.c.cargarJugador(nombre);
                        Juego.j.cargarPartida();
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "No hay datos guardados, crea una nueva partida.", "RPGame", 2);
                }
            }
        });
        
        btn3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                JOptionPane.showMessageDialog(null, "Créditos:\n- Autor: Gabriel P.\n- Versión: 2.0.0", "RPGame", 1);
            }
        });
        
        btn4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                System.exit(0);
            }
        });
    }
    
    public boolean comprobar(String nombre){
        if(Utiles.validar(nombre)){
            ArrayList<String> lista = Juego.c.consultar("nombre");
            for(String n : lista){
                if(n.equals(nombre)){
                    JOptionPane.showMessageDialog(null, "Ya existe ese nombre, elige otro.", "RPGame", 2);
                    return false;
                }
            }
            return true;
        }else{
            JOptionPane.showMessageDialog(null, "Introduce un nombre válido.", "RPGame", 2);
            return false;
        }
    }
}