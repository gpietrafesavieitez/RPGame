package controladores;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sonido{
    private Clip clip;
    private final String PATH = "./sfx/";
    public boolean estaSonando = false;
    
    public Sonido(){
    }
    
    public Sonido(int tipo){
        switch(tipo){
            case 0:
                setFile("menu.wav");
                break;
            case 1:
                setFile("bosque.wav");
                break;
            case 2:
                setFile("bosque.wav");
                //setFile("elfos.wav");
                break;
            case 3:
                setFile("elfos2.wav");
                break;
            case 4:
                setFile("ciudad.wav");
                break;
            case 5:
                setFile("ciudad2.wav");
                break;
            case 6:
                setFile("bosque.wav");
                //setFile("sendero.wav");
                break;
            case 7:
                setFile("jefe.wav");
                break;
            case 8:
                setFile("hija.wav");
                break;
            case 10:
                setFile("qfasporco.wav");
            break;
        }
    }
    
    public void sfx(int tipo){
        switch(tipo){
            case 1:
                setFile("1.wav");
                break;
            case 2:
                setFile("2.wav");
                break;
            case 3:
                setFile("3.wav");
                break;
            case 4:
                setFile("4.wav");
                break;
            case 5:
                setFile("5.wav");
                break;
            case 6:
                setFile("6.wav");
                break;
            case 7:
                setFile("7.wav");
                break;
            case 8:
                setFile("8.wav");
                break;
            case 9:
                setFile("9.wav");
                break;
            case 10:
                setFile("9.wav");
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