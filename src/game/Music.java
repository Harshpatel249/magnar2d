
package game;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author HARSH
 */



public class Music {
    public void playMusic(String mus){
        try{
            InputStream audioSrc = getClass().getResourceAsStream(mus);
            InputStream bufferedIn = new BufferedInputStream(audioSrc);
            AudioInputStream in = AudioSystem.getAudioInputStream(bufferedIn);
            Clip clip = AudioSystem.getClip();
            clip.open(in);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    /*public void playrun(){
        try{
            InputStream audioSrc = getClass().getResourceAsStream("/RunningSFX.wav");
            InputStream bufferedIn = new BufferedInputStream(audioSrc);
            AudioInputStream in = AudioSystem.getAudioInputStream(bufferedIn);
            Clip clip = AudioSystem.getClip();
            clip.open(in);
            clip.start();
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public void playpick(){
        try{
            InputStream audioSrc = getClass().getResourceAsStream("/PickSFX.wav");
            InputStream bufferedIn = new BufferedInputStream(audioSrc);
            AudioInputStream in = AudioSystem.getAudioInputStream(bufferedIn);
            Clip clip = AudioSystem.getClip();
            clip.open(in);
            clip.start();
            
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public void playjump(String m){
        try{
            InputStream audioSrc = getClass().getResourceAsStream(m);
            InputStream bufferedIn = new BufferedInputStream(audioSrc);
            AudioInputStream in = AudioSystem.getAudioInputStream(bufferedIn);
            Clip clip = AudioSystem.getClip();
            clip.open(in);
            clip.start();
           
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public void playdeath(){
        try{
            InputStream audioSrc = getClass().getResourceAsStream("/DeathSFX.wav");
            InputStream bufferedIn = new BufferedInputStream(audioSrc);
            AudioInputStream in = AudioSystem.getAudioInputStream(bufferedIn);
            Clip clip = AudioSystem.getClip();
            clip.open(in);
            clip.start();
            
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }*/
}
