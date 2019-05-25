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

public class GuiEscenaCiudad2 extends Gui{
    private JLabel labelEscena;
    private JTextArea areaTexto, areaStats;
    private JButton btn1, btn2, btn3;
    
    public GuiEscenaCiudad2(){
        Juego.j.setState(3);
        Juego.c.guardarPartida(Juego.j);
        init();
    }

    @Override
    protected void construirPanelInferior(){
        panelInferior = new JPanel();
        btn1 = new JButton("Amenazar");
        btn2 = new JButton("Preguntar");
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
                areaTexto.setText("- Tú: ¡¿DÓNDE ESTÁ MI HIJA?!\n\n- Anciano: ¡Hey, no hace falta que me grites! ¿Una chiquilla de rojo? si, vi alguien así hace unas horas corriendo hacia el bosque. Si ha ido hacia allí será mejor que te des prisa en encontrarla porque dentro vive una criatura siniestra.");
                btn1.setVisible(false);
                btn2.setVisible(false);
                btn3.setVisible(true);
            }
        });
        
        btn2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                areaTexto.setText("- Tú: ¿No ha visto por casualidad una niña de rojo?\n\n- Anciano: Sí, vi alguien así hace unas horas corriendo hacia el bosque. Si ha ido hacia allí será mejor que te des prisa en encontrarla porque dentro vive una criatura siniestra.");
                btn1.setVisible(false);
                btn2.setVisible(false);
                btn3.setVisible(true);
            }
        });
        
        btn3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                Juego.i.setGui(6);
            }
        });
    }

    @Override
    protected void construirVentana(){
        labelEscena = new JLabel();
        areaTexto = new JTextArea();
        areaStats = new JTextArea();
        labelEscena.setIcon(new ImageIcon(PATH + "scenes\\ciudad2.gif"));
        areaTexto.setText("Consigues adentrarte sigilosamente en la ciudad a través del sistema de alcantarillado sin que los guardias te detecten.\n\nSigues un largo tunel y acabas en una especie de zona secreta donde te encuentras con un hombre barbudo de pinta sospechosa que te pregunta qué ***** haces ahí.");
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