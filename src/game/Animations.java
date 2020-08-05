
package game;

/**
 *
 * @author HARSH
 */
import java.awt.image.BufferedImage;
import java.awt.Graphics;

public class Animations {
    private int speed,frames,index=0,count=0;
    private BufferedImage[] images;
    private BufferedImage img;
    
    public Animations(int speed,BufferedImage... args){
        this.speed = speed;
        images = new BufferedImage[args.length];
        for(int i=0;i<args.length;i++){
            images[i]=args[i];
        }
        frames = args.length;
    }
    public void RunAnimation(){
        index++;
        if(index>speed){
            index=0;
            nextFrame();
        }
    }
    private void nextFrame(){
        for(int i=0;i<frames;i++){
            if(count==i){
                img = images[i];
            }
        }
        count++;
        if(count>frames){
            count=0;
        }
    }
    public void drawAnimation(Graphics g,int x,int y){
        g.drawImage(img, x, y, null);
    }
    public void drawAnimation(Graphics g,int x,int y,int ScaleX,int ScaleY){
        g.drawImage(img, x, y, ScaleX, ScaleY, null);
    }
}
