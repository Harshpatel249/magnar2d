package game;

/**
 *
 * @author HARSH
 */

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import java.awt.Rectangle;

public class Lifeup extends GameObject{

    public static int lc=0;
   
    Texture tex = Game.getInstance();
    public Lifeup(float x, float y, objectID id){
        super(x, y, id);
    }
    public void tick(LinkedList<GameObject> obj){
        
    }
    public void render(Graphics g){
        /*g.setColor(Color.YELLOW);
        g.drawRect((int)x, (int)y, 32, 32);
*/      if(lc==0){
        
        g.drawImage(tex.Lifeupimg,(int)x,(int)y, 35, 35, null);
        }
    }
    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 32, 32);
    }
}
