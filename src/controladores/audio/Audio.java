package controladores.audio;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Audio{
    private Clip audio;
    private final String RUTA = "./sfx/";
    
    public Audio(){}
    
    public Audio(int tipo){
        elegirSonido(tipo);
    }
    
    public void elegirSonido(int tipo){
        switch(tipo){
            case 0:
                setAudio("menu.wav");
            break;
            case 1:
                setAudio("lluvia.wav");
            break;
            case 2:
                setAudio("batalla.wav");
            break;
            case 3:
                setAudio("ciudad.wav");
            break;
            case 4:
                setAudio("cueva.wav");
            break;
            case 5:
                setAudio("fin.wav");
            break;
            case 6:
                setAudio("siniestro.wav");
            break;
            case 7:
                setAudio("golpe.wav");
            break;
        }
    }
    
    private void setAudio(String name){
        try{
            AudioInputStream sound = AudioSystem.getAudioInputStream(new File(RUTA + name));
            audio = AudioSystem.getClip();
            audio.open(sound);
        }catch(UnsupportedAudioFileException | LineUnavailableException | IOException e){}
    }

    public void iniciar(){
        audio.setFramePosition(0);
        audio.start();
    }

    public void bucle(){
        audio.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void parar(){
        audio.stop();
    }
}