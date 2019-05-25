package graficos.escena;

import juego.Juego;
import graficos.Gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class GuiEscenaBosque extends Gui{
    
    public GuiEscenaBosque(){
        Juego.j.setState(1);
        Juego.c.guardarPartida(Juego.j);
        init();
    }
    
    @Override
    protected void construirPanelInferior(){
        btn1 = new JButton("Izquierda");
        btn1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                Juego.i.setGui(2);
            }
        });
        
        btn2 = new JButton("Derecha");
        btn2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                Juego.i.setGui(4);
            }
        });
        
        panelInferior = new JPanel();
        panelInferior.setLayout(new FlowLayout());
        panelInferior.setBackground(Color.BLACK);
        panelInferior.add(btn1);
        panelInferior.add(btn2);
    }

    @Override
    protected void construirVentana(){
        areaTexto = new JTextArea();
        labelEscena = new JLabel();
        labelNick = new JLabel();
        labelVida = new JLabel();
        
        labelEscena.setIcon(new ImageIcon(PATH + "scenes/bosque.gif"));
        
        areaTexto.setText("Te despiertas en medio de un oscuro bosque. Llueve bastante y apenas hay luz pero no estás muy seguro que sea de noche. No sabes que haces ahí pero recuerdas que hace poco estabas con tu hija pequeña Megumin dando un paseo y ahora ha desaparecido.\n\nDecides ir a buscarla pero frente tuya hay dos caminos que se separan. Hace frío y no sabes si tu hija estará bien.\n\n¿Qué camino tomarás?");
        areaTexto.setLineWrap(true);
        areaTexto.setWrapStyleWord(true);
        areaTexto.setEditable(false);
        areaTexto.setFocusable(false);
        areaTexto.setOpaque(true);
        areaTexto.setSize(180,50);
        areaTexto.setBackground(Color.BLACK);
        areaTexto.setForeground(Color.WHITE);
        
        labelNick.setFont(new Font("Consolas",Font.PLAIN,16));
        labelNick.setIcon(new ImageIcon(PATH + "icons/" + Juego.j.getRaza() + ".png"));
        labelNick.setText(Juego.j.getNick());
        labelNick.setBackground(Color.BLACK);
        labelNick.setForeground(Color.WHITE);
        
        labelVida.setText(""+Juego.j.getHp());
        labelVida.setFont(new Font("Consolas",Font.BOLD,16));
        labelVida.setIcon(new ImageIcon(PATH + "icons/hp.png"));
        labelVida.setBackground(Color.BLACK);
        labelVida.setForeground(Color.WHITE);
        
        panelSuperior = new JPanel();
        panelSuperior.setBackground(Color.BLACK);
        panelSuperior.setLayout(new BorderLayout());
        panelSuperior.add(labelNick, BorderLayout.LINE_START);
        panelSuperior.add(labelVida, BorderLayout.LINE_END);
        
        this.setLayout(new BorderLayout());
        this.add(labelEscena, BorderLayout.CENTER);
        this.add(panelSuperior, BorderLayout.NORTH);
        this.add(areaTexto, BorderLayout.EAST);
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