package game;

/**
 *
 * @author HARSH
 */

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import java.awt.Rectangle;

public class Block extends GameObject{

    Texture tex = Game.getInstance();
    public Block(float x, float y, objectID id){
        super(x, y, id);
    }
    public void tick(LinkedList<GameObject> obj){
        
    }
    public void render(Graphics g){
        /*g.setColor(Color.WHITE);
        g.fillRect((int)x, (int)y, 32, 32);
 */
        g.drawImage(tex.blockImg,(int)x,(int)y, 50, 70, null);
}
    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 32, 32);
    }
}
