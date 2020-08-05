package game;

import java.util.LinkedList;
import java.awt.Graphics;
import java.awt.Rectangle;
/**
 *
 * @author HARSH
 */
public abstract class GameObject {
    protected float x,y;
    protected objectID id;
    protected float VelX=0,VelY=0;
    protected boolean falling = true;
    protected boolean jumping  = false;
    
    public GameObject(float x, float y, objectID id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }
    public abstract void tick(LinkedList<GameObject> obj);
    public abstract void render(Graphics g);
    public abstract Rectangle getBounds();

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public objectID getId() {
        return id;
    }

    public void setId(objectID id) {
        this.id = id;
    }

    public float getVelX() {
        return VelX;
    }

    public void setVelX(float VelX) {
        this.VelX = VelX;
    }

    public float getVelY() {
        return VelY;
    }

    public void setVelY(float VelY) {
        this.VelY = VelY;
    }

    public boolean isFalling() {
        return falling;
    }

    public void setFalling(boolean falling) {
        this.falling = falling;
    }

    public boolean isJumping() {
        return jumping;
    }

    public void setJumping(boolean jumping) {
        this.jumping = jumping;
    }
    
    
}
