package controladores.graficos.menu;

import controladores.graficos.Gui;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class GuiMenu extends Gui{

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
            construirPanelInferior();
            construirVentana();
        }
    }
    
    @Override
    protected void construirPanelInferior(){}
    
    @Override
    protected void construirVentana(){
        labelEscena = new JLabel();
        labelEscena.setIcon(new ImageIcon(RUTA + "escenas/menu.gif"));
        this.setLayout(new BorderLayout());
        this.add(labelEscena, BorderLayout.CENTER);
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