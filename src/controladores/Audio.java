package controladores;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Audio{
    private Clip clip;
    private final String PATH = "./sfx/";
    public boolean estaSonando = false;
    
    public Audio(){}
    
    public Audio(int tipo){
        elegirSonido(tipo);
    }
    
    public void elegirSonido(int tipo){
        switch(tipo){
            case 0:
                setFile("menu.wav");
                break;
            case 1:
                setFile("lluvia.wav");
                break;
            case 2:
                setFile("batalla.wav");
                break;
            case 3:
                setFile("ciudad.wav");
                break;
            case 4:
                setFile("cueva.wav");
                break;
            case 5:
                setFile("fin.wav");
                break;
            case 6:
                setFile("siniestro.wav");
                break;
            case 7:
                setFile("golpe.wav");
                break;
        }
    }
    
    private void setFile(String name){
        try{
            AudioInputStream sound = AudioSystem.getAudioInputStream(new File(PATH + name));
            clip = AudioSystem.getClip();
            clip.open(sound);
        }catch(UnsupportedAudioFileException | LineUnavailableException | IOException e){}
    }

    public void play(){
        clip.setFramePosition(0);
        clip.start();
    }

    public void loop(){
        estaSonando = true;
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop(){
        estaSonando = false;
        clip.stop();
    }
}