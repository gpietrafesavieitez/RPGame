package graficos;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class Gui extends JFrame{
    protected final int ANCHO = 800, ALTO = 600;
    protected final String PATH = "/home/gab/NetBeansProjects/RPGame/img/";
    protected JPanel panelInferior;
    protected JLabel labelEscena;
    
    protected void init(){
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
    
    protected abstract void construirPanelInferior();
    protected abstract void construirVentana();
}