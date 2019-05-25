package graficos.escena;

import graficos.Gui;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import juego.Juego;

public class GuiEscenaSendero extends Gui{

    public GuiEscenaSendero(){
        Juego.j.setState(4);
        Juego.c.guardarPartida(Juego.j);
        init();
    }

    @Override
    protected void construirPanelInferior(){
        panelInferior = new JPanel();
        btn1 = new JButton("Continuar");
        
        panelInferior.setLayout(new FlowLayout());
        panelInferior.setBackground(java.awt.Color.BLACK);
        panelInferior.setBorder(BorderFactory.createLineBorder(java.awt.Color.WHITE, 1));
        panelInferior.add(btn1);

        btn1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                Juego.i.setGui(7);
            }
        });
    }

    @Override
    protected void construirVentana(){
        labelEscena = new JLabel();
        areaTexto = new JTextArea();
        areaStats = new JTextArea();
        labelEscena.setIcon(new ImageIcon(PATH + "scenes\\sendero.gif"));
        areaTexto.setText("La pista te conduce hacia un oscuro sendero que lleva a un lugar recóndito del bosque.\n\nMientras sigues el camino puedes observar manchas de sangre por el suelo, todavía frescas.\n\nTe temes lo peor así que apuras el paso...");
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