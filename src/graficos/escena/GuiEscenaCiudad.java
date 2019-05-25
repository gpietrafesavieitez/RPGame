package graficos.escena;

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
import juego.Juego;

public class GuiEscenaCiudad extends Gui{
    
    public GuiEscenaCiudad(){
        Juego.j.setState(1);
        Juego.c.guardarPartida(Juego.j);
        init();
    }

    @Override
    protected void construirPanelInferior(){
        panelInferior = new JPanel();
        btn1 = new JButton("Volver");
        btn2 = new JButton("Entrar");
        btn3 = new JButton("Infiltrarte");
        panelInferior.setLayout(new FlowLayout());
        panelInferior.setBackground(java.awt.Color.BLACK);
        panelInferior.setBorder(BorderFactory.createLineBorder(java.awt.Color.WHITE, 1));
        panelInferior.add(btn1);
        panelInferior.add(btn2);
        panelInferior.add(btn3);
        
        btn1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                Juego.i.setGui(1);
            }
        });
        
        btn2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                areaTexto.setText("Nada más dar un paso los guardias te apuntan con sus armas y te gritan que te marches de allí, así que no te queda más remedio que dar media vuelta...");
            }
        });
        
        btn3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                Random rand = new Random();
                int randPlayer = rand.nextInt((100 - 0) + 1) + 0;
                if(randPlayer > 80){
                    Juego.i.setGui(5);
                }else{
                    areaTexto.setText("Intentas escabullirte y fracasas estrepitosamente.\n\nLos guardias te han visto tratando de saltar inutilmente la muralla.\n\nInmediatamente te agarran y te echan de la ciudad.");
                }
            }
        });
    }

    @Override
    protected void construirVentana(){
        labelEscena = new JLabel();
        areaTexto = new JTextArea();
        areaStats = new JTextArea();
        labelEscena.setIcon(new ImageIcon(PATH + "scenes\\ciudad.gif"));
        areaTexto.setText("Tomas el camino de la derecha y llegas a las puertas de una pequeña ciudadela.\n\nA ambos lados hay unos enormes guardias que las custodian. Es posible que dentro haya alguien que sepa algo sobre tu hija pero no nsabes si serás bien recibido en esa ciudad.\n\n¿Qué opcion eliges?");
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