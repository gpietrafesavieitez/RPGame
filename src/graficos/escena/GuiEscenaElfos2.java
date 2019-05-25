package graficos.escena;

import controladores.Sonido;
import entidades.Enemigo;
import juego.Juego;
import graficos.Gui;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import juego.Interfaz;

public class GuiEscenaElfos2 extends Gui{
    private JLabel labelEscena;
    private JTextArea areaTexto, areaStats;
    private JButton btn1, btn2;
    
    public GuiEscenaElfos2(){
        Juego.j.setState(1);
        Juego.c.guardarPartida(Juego.j);
        Juego.s = new Sonido();
        init();
    }
    
    @Override
    protected void construirPanelInferior(){
        panelInferior = new JPanel();
        btn1 = new JButton("Atacar");
        btn2 = new JButton("Leer");
        panelInferior.setLayout(new FlowLayout());
        panelInferior.setBackground(java.awt.Color.BLACK);
        panelInferior.setBorder(BorderFactory.createLineBorder(java.awt.Color.WHITE, 1));
        panelInferior.add(btn1);
        panelInferior.add(btn2);
        btn2.setVisible(false);
        Juego.e = new Enemigo("Arwin","Elfo",150);
        Random rand = new Random();
        
        btn1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                if(Juego.j.getHp() <= 0){
                    System.out.println("MORISTE PUTO");
                    System.exit(0);
                }
                if(Juego.e.getHp() <= 0){
                    Interfaz.s.stop();
                    labelEscena.setIcon(new ImageIcon(PATH + "scenes\\elfos.gif"));
                    areaTexto.setText("Finalmente consigues encajar un golpe mortal al elfo y éste cae redondo al suelo.\n\nAnte tal situación, los elfos que quedan huyen despavoridos.\n\nDecides registrar al elfo por si lleva algun tipo de objeto o pista que te ayude a encontrar a tu hija y rebuscando entre sus bolsillos te encuentras con una extraña nota...");
                    btn1.setVisible(false);
                    btn2.setVisible(true);
                }else{
                    int randEnemy = rand.nextInt((15 - 0) + 1) + 0; // Daño producido por el enemigo
                    Juego.j.setHp(Juego.j.getHp() - Math.abs(randEnemy - Juego.j.getDef()));
                    int randPlayer = rand.nextInt((10 - 0) + 1) + 0; // Daño producido por el jugador
                    Juego.s.sfx(randPlayer);
                    Juego.s.play();
                    Juego.e.setHp(Juego.e.getHp() - Math.abs(randPlayer * Juego.j.getAtq()));
                    areaStats.setText("Nick: " + Juego.j.getNick() + "\n\nRaza: " + Juego.j.getRaza() + "\n\nVida: " + Juego.j.getHp() + "\n\nAtaque: " + Juego.j.getAtq() + "\n\nDefensa: " + Juego.j.getDef() + "\n\nDEBUG:" + Juego.j.getState());
                    areaTexto.setText("Enemigo: " + Juego.e.getNombre() + "\n\nRaza: " + Juego.e.getRaza() + "\n\nVida: " + Juego.e.getHp());
                    //areaTexto.setText("El elfo arremete contra ti y te hace " + randEnemy + " punto(s) de daño.\n\nAhora tu atacas al elfo y le causas " + randPlayer + " punto(s) de daño.\n\nLe quedan " + Juego.e.getHp() + " punto(s) de vida.");
                }
            }
        });
        
        btn2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                JOptionPane.showMessageDialog(null, "La nota reza:\nSigue por el sendero sombrío y hallarás tu destino.", "RPGame", 1, new ImageIcon(PATH + "icons\\pista.jpg"));
                Juego.i.setGui(6);
            }
        });
    }

    @Override
    protected void construirVentana(){
        labelEscena = new JLabel();
        areaTexto = new JTextArea();
        areaStats = new JTextArea();
        labelEscena.setIcon(new ImageIcon(PATH + "scenes\\elfos2.gif"));
        areaTexto.setText("hola");
        areaTexto.setLineWrap(true);
        areaTexto.setWrapStyleWord(true);
        areaTexto.setEditable(false);
        areaTexto.setFocusable(false);
        areaTexto.setOpaque(true);
        areaTexto.setBackground(java.awt.Color.BLACK);
        areaTexto.setForeground(java.awt.Color.WHITE);
        areaStats.setLineWrap(true);
        areaStats.setWrapStyleWord(true);
        areaStats.setEditable(false);
        areaStats.setFocusable(false);
        areaStats.setOpaque(true);
        areaStats.setText("Nick: " + Juego.j.getNick() + "\n\nRaza: " + Juego.j.getRaza() + "\n\nVida: " + Juego.j.getHp() + "\n\nAtaque: " + Juego.j.getAtq() + "\n\nDefensa: " + Juego.j.getDef() + "\n\nDEBUG:" + Juego.j.getState());
        areaStats.setBackground(java.awt.Color.BLACK);
        areaStats.setForeground(java.awt.Color.WHITE);
        areaStats.setOpaque(true);
        this.setLayout(new BorderLayout());
        this.add(labelEscena, BorderLayout.CENTER);
        this.add(areaTexto, BorderLayout.EAST);
        this.add(areaStats, BorderLayout.WEST);
        this.add(panelInferior, BorderLayout.SOUTH);
        this.setTitle("RPGame");
        this.setSize(ANCHO, ALTO);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
    }
    
}