
package game;

/**
 *
 * @author HARSH
 */
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Cutscene {
    private BufferedImage cs1;
    BufferedImageLoader loader = new BufferedImageLoader();
    
    public void render(Graphics g){
        if(Game.levelcount==1){
        cs1 = loader.loadimage("/l1scene.png");
        g.drawImage(cs1, 0, 0,1920,1080,null);
        }
        if(Game.levelcount==2){
        //cs1 = loader.loadimage("/l1scene.png");
        //g.drawImage(cs1, 0, 0,1920,1080,null);
        Game.setState(State.Ingame);
        
        }
    }
    
    
    
}
