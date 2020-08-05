package game;

/**
 *
 * @author HARSH
 */

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import java.awt.Rectangle;

public class Trap extends GameObject{
    
    Texture tex = Game.getInstance();
    public Trap(float x, float y, objectID id){
        super(x, y, id);
    }
    public void tick(LinkedList<GameObject> obj){
        
    }
    public void render(Graphics g){
        /*g.setColor(Color.WHITE);
        g.fillRect((int)x, (int)y, 32, 32);*/
        g.drawImage(tex.blockImg,(int)x,(int)y, 50, 70, null);
        if(trapact()){
        g.drawImage(tex.Trapimg,(int)x,(int)y-33, 35, 55, null);
        }
    }
    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 32, 32);
    }
    public boolean trapact(){
        if(Game.getP().getX()>(int)x-100){
        for(int xx=(int)x-100;xx<=(int)x+100;xx++){
            for(int yy=(int)y-100;yy<=(int)y+100;yy++){
                if((int)Game.getP().getX()==xx && (int)Game.getP().getY()==yy){
                    return true;
                }
            }
        }
      }
        return false;
    }
}