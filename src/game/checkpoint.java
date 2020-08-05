package game;

/**
 *
 * @author HARSH
 */

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import java.awt.Rectangle;

public class checkpoint extends GameObject{

    Texture tex = Game.getInstance();
    public checkpoint(float x, float y, objectID id){
        super(x, y, id);
    }
    public void tick(LinkedList<GameObject> obj){
        
    }
    public void render(Graphics g){
        /*g.setColor(Color.YELLOW);
        g.drawRect((int)x, (int)y, 32, 32);
*/
        g.drawImage(tex.chkpointimg,(int)x,(int)y-30, 50, 70, null);
        
    }
    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 32, 32);
    }
}
