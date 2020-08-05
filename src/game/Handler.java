
package game;

import java.awt.Graphics;
import java.util.LinkedList;
 

public class Handler 
{
    
    public LinkedList<GameObject> object = new LinkedList<GameObject>();
    private GameObject tempObject;
    private static int i=0;
    
    public static int geti(){
        return i;
    }
    
    public void tick(){
        
        for(int i=0;i<object.size();i++)
        {
            tempObject = object.get(i);
            tempObject.tick(object);
    }
}
    public void render (Graphics g)
    {
        for (int i=0;i<object.size();i++)
        {
            tempObject = object.get(i);
            tempObject.render(g);
            
        }
        
    }
    public void clearLevel(){
        this.object.clear();
    }
    public void addObject(GameObject object)
    {
        this.object.add(object);
        i++;
    }
    
    public void removeObject(GameObject object)
    {
        this.object.remove(object);
    }
    public void makelevel(){
        for(int x=0;x < Game.WIDTH+32;x+=32){
            addObject(new Block(x,Game.HEIGHT-32, objectID.Block));
        }
    }
}
