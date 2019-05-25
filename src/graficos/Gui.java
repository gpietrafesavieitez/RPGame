package graficos;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public abstract class Gui extends JFrame{
    protected final int ANCHO = 800, ALTO = 600;
    protected final String PATH = "./img/";
    protected JPanel panelSuperior, panelInferior;
    protected JLabel labelEscena, labelNick, labelVida;
    protected JTextArea areaTexto, areaStats;
    protected JButton btn1, btn2, btn3, btn4;
    
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