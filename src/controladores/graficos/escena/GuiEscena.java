package controladores.graficos.escena;

import controladores.graficos.Gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import juego.Juego;

public abstract class GuiEscena extends Gui{
    protected JPanel panelSuperior;
    protected JLabel labelNick, labelVida, labelAtq, labelDef;
    protected JTextArea areaTexto;
    
    protected void iniciar(){
        try{
            for(javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()){
                if("Nimbus".equals(info.getName())){
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }catch(ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException e){
            e.printStackTrace();
            System.out.println("[ aviso ] No se ha encontrado el tema personalizado para la UI.");
        }finally{
            panelInferior = new JPanel();
            panelInferior.setLayout(new FlowLayout());
            panelInferior.setBackground(Color.BLACK);

            labelEscena = new JLabel();

            areaTexto = new JTextArea();
            areaTexto.setLineWrap(true);
            areaTexto.setWrapStyleWord(true);
            areaTexto.setEditable(false);
            areaTexto.setFocusable(false);
            areaTexto.setOpaque(true);
            areaTexto.setSize(180,50);
            areaTexto.setBackground(Color.BLACK);
            areaTexto.setForeground(Color.WHITE);

            labelNick = new JLabel();
            labelNick.setFont(new Font("Times New Roman",Font.PLAIN,16));
            labelNick.setIcon(new ImageIcon(RUTA + "iconos/" + Juego.j.getRaza() + "2.png"));
            labelNick.setText(Juego.j.getNombre());
            labelNick.setBackground(Color.BLACK);
            labelNick.setForeground(Color.YELLOW);

            labelVida = new JLabel();
            labelVida.setText(Juego.j.getVida() + "");
            labelVida.setFont(new Font("Times New Roman",Font.PLAIN,16));
            labelVida.setIcon(new ImageIcon(RUTA + "iconos/vida.png"));
            labelVida.setBackground(Color.BLACK);
            labelVida.setForeground(Color.GREEN);
            
            labelAtq = new JLabel();
            labelAtq.setText(Juego.j.getAtaque() + "");
            labelAtq.setFont(new Font("Times New Roman",Font.PLAIN,16));
            labelAtq.setIcon(new ImageIcon(RUTA + "iconos/ataque.png"));
            labelAtq.setBackground(Color.BLACK);
            labelAtq.setForeground(Color.RED);
            
            labelDef = new JLabel();
            labelDef.setText(""+Juego.j.getDefensa() + "");
            labelDef.setFont(new Font("Times New Roman",Font.PLAIN,16));
            labelDef.setIcon(new ImageIcon(RUTA + "iconos/defensa.png"));
            labelDef.setBackground(Color.BLACK);
            labelDef.setForeground(Color.CYAN);

            panelSuperior = new JPanel();
            panelSuperior.setLayout(new FlowLayout((FlowLayout.CENTER)));
            panelSuperior.setBackground(Color.BLACK);
            panelSuperior.add(labelNick);
            panelSuperior.add(labelAtq);
            panelSuperior.add(labelDef);
            panelSuperior.add(labelVida);
            
            construirPanelInferior();
            construirVentana();
            
            this.setLayout(new BorderLayout());
            this.add(labelEscena, BorderLayout.CENTER);
            this.add(panelSuperior, BorderLayout.NORTH);
            this.add(areaTexto, BorderLayout.EAST);
            this.add(panelInferior, BorderLayout.SOUTH);
            this.setTitle("RPGame");
            this.setSize(ANCHO, ALTO);
            this.setIconImage(new ImageIcon(RUTA + "iconos/icono.png").getImage());
            this.setLocationRelativeTo(null);
            this.pack();
            this.setResizable(false);
            this.setVisible(true);
            this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        }
    }

    @Override
    protected void construirPanelInferior(){}

    @Override
    protected void construirVentana(){}
}