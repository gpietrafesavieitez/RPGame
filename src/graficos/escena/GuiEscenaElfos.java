package graficos.escena;

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
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class GuiEscenaElfos extends Gui{
    
    public GuiEscenaElfos(){
        Juego.j.setState(1);
        Juego.c.guardarPartida(Juego.j);
        init();
    }
    
    @Override
    protected void construirPanelInferior(){
        panelInferior = new JPanel();
        btn1 = new JButton("Atacar");
        btn2 = new JButton("Dialogar");
        btn3 = new JButton("Continuar");
        panelInferior.setLayout(new FlowLayout());
        panelInferior.setBackground(java.awt.Color.BLACK);
        panelInferior.setBorder(BorderFactory.createLineBorder(java.awt.Color.WHITE, 1));
        panelInferior.add(btn1);
        panelInferior.add(btn2);
        panelInferior.add(btn3);
        btn3.setVisible(false);
        
        btn1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                areaTexto.setText("De repente, uno de los elfos carga contra ti tan rápido que no te da tiempo ni a reaccionar y te asesta un golpe en la cara.\n\nTe apartas rápidamente pero no puedes ignorar el sabor de la nsangre.\n\nDesenfundas tu arma y te preparas para la batalla...");
                btn1.setVisible(false);
                btn2.setVisible(false);
                btn3.setVisible(true);
                btn3.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent evt){
                        Juego.i.setGui(3);
                    }
                });
            }
        });
        
        btn2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                Random rand = new Random();
                int randPlayer = rand.nextInt((100 - 0) + 1) + 0;
                if(Juego.j.getRaza().equals("Elfo")){
                    areaTexto.setText("El grupo de elfos parece amigable y hablando con ellos te cuentan que hace unas pocas horas vieron a una niña escapando de algo en dirección al centro del bosque.\n\nLes pides que concreten qué era lo que la perseguía pero te dicen que no tienen ni idea.");
                    btn1.setVisible(false);
                    btn2.setVisible(false);
                    btn3.setVisible(true);
                    btn3.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent evt){
                            Juego.i.setGui(6);
                        }
                    });
                }else{
                    areaTexto.setText("De repente, uno de los elfos carga contra ti tan rápido que no te da tiempo ni a reaccionar y te asesta un golpe en la cara.\n\nTe apartas rápidamente pero no puedes ignorar el sabor de la nsangre.\n\nDesenfundas tu arma y te preparas para la batalla...");
                    btn1.setVisible(false);
                    btn2.setVisible(false);
                    btn3.setVisible(true);
                    btn3.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent evt){
                            Juego.i.setGui(3);
                        }
                    });
                }
            }
        });
    }

    @Override
    protected void construirVentana(){
        labelEscena = new JLabel();
        areaTexto = new JTextArea();
        areaStats = new JTextArea();
        labelEscena.setIcon(new ImageIcon(PATH + "scenes\\elfos.gif"));
        areaTexto.setText("Te adentras por el camino de la izquierda y te encuentras con un pequeño grupo de elfos que se dan cuenta de tu presencia.\n\nNo sabes si son hostiles pero es posible que sepan algo acerca de tu hija.\n\n¿Qué haces?");
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