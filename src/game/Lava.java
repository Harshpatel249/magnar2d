package game;

/**
 *
 * @author HARSH
 */

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import java.awt.Rectangle;

public class Lava extends GameObject{

    Texture tex = Game.getInstance();
    public Lava(float x, float y, objectID id){
        super(x, y, id);
    }
    public void tick(LinkedList<GameObject> obj){
        
    }
    public void render(Graphics g){
        //g.setColor(Color.RED);
        //g.drawRect((int)x, (int)y, 32, 32);
        g.drawImage(tex.lavaimg,(int)x,(int)y, 46, 66, null);
    }
    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 32, 32);
    }
}
