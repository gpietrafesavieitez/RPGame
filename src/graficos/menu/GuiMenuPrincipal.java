package graficos.menu;

import entidades.Jugador;
import graficos.Gui;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import juego.Juego;

public class GuiMenuPrincipal extends Gui{
    
    public GuiMenuPrincipal(){
        init();
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
                String raza = (String) JOptionPane.showInputDialog(null, "Escoge tu raza:", "RPGame", 0, new ImageIcon(PATH + "icons/raza.jpg"), new String[]{"Humano", "Elfo", "Orco"}, null);
                if(handler(raza)){
                    Juego.j = new Jugador(raza);
                    Juego.avatar = new ImageIcon(Juego.j.getIcono());
                    String nick;
                    do{
                        nick = (String) JOptionPane.showInputDialog(null, "Has seleccionado: '" + raza + "'.\n\nDale un nombre a tu personaje:", "RPGame", 0, Juego.avatar, null, null);
                        if(nick == null){
                            break;
                        }
                    }while(!validar(nick));
                    if(handler(nick)){
                    Juego.j.setNick(nick);
                        if(Juego.c.insertar(nick, raza, Juego.j.getHp()) > 0){
                            JOptionPane.showMessageDialog(null, "Te damos la bienvenida: " + Juego.j.getNick() + "\n\nHaz click para comenzar.","RPGame", 0, Juego.avatar);
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
                Object[] jugadores = Juego.c.consultar("nick").toArray();
                if(jugadores.length > 0){
                    String nick = (String) JOptionPane.showInputDialog(null, "Selecciona tu personaje:", "RPGame", 0, new ImageIcon(PATH + "icons/cargar.jpg"), jugadores, null);
                    if(handler(nick)){
                        Juego.j = Juego.c.cargar(nick);
                        switch(Juego.j.getState()){
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
                }else{
                    JOptionPane.showMessageDialog(null, "No hay datos guardados, crea una nueva partida.", "RPGame", 2);
                }
            }
        });
        
        btn3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                JOptionPane.showMessageDialog(null, "Créditos:\n- Autor: Gabriel P.\n- Versión: 2.0.0a", "RPGame", 1);
            }
        });
        
        btn4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                System.exit(0);
            }
        });
    }

    @Override
    protected void construirVentana(){
        labelEscena = new JLabel();
        labelEscena.setIcon(new ImageIcon(PATH + "scenes/menu.gif"));
        this.setLayout(new BorderLayout());
        this.add(labelEscena, BorderLayout.CENTER);
        this.add(panelInferior, BorderLayout.SOUTH);
        this.setTitle("RPGame");
        this.setSize(ANCHO, ALTO);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
    }
    
    public boolean validar(String nick){
        if(nick.matches("^[a-zA-Z]+$") && !(nick.isBlank() && nick.isEmpty())){
            ArrayList<String> lista = Juego.c.consultar("nick");
            for(String n : lista){
                if(n.equals(nick)){
                    JOptionPane.showMessageDialog(null, "Ya existe ese nombre, elige otro.", "RPGame", 2);
                    return false;
                }
            }
            return true;
        }else{
            JOptionPane.showMessageDialog(null, "Introduce un nick válido.", "RPGame", 2);
            return false;
        }
    }
    
    public boolean handler(String str){
        if((str != null) && (str.length() > 0)){
            return true;
        }else{
            return false;
        }
    }
}