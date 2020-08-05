
package game;

/**
 *
 * @author Sanket Shah
 */
import java.util.LinkedList;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Graphics2D;
import java.time.Instant;
        
        
public class Player extends GameObject {
    private float width = 48, height = 96;
    private float gravity = 0.5f;
    private final float MAX_SPEED = 10;
    private Handler handler;
    Texture tex = Game.getInstance();
    Music mus;
   
    private Animations playerback, playerjumpleft,playerjumpright,playerjumpst;
    
    
    public Player(float x, float y,Handler handler, objectID id) {
        super(x, y, id);
        this.handler = handler;
        playerback = new Animations(8,tex.player[0],tex.player[1],tex.player[2],tex.player[3],tex.player[4]);
        playerjumpleft = new Animations(15,tex.playerjump[2]);
        playerjumpright = new Animations(15,tex.playerjump[0]);
        playerjumpst = new Animations(15,tex.playerjump[1]);
        
    }
   
    
    public void tick(LinkedList<GameObject> object)
    {
        x+=VelX;
        y+=VelY;
        
        if(falling || jumping)
        {
            VelY += gravity;
            
            if(VelY>MAX_SPEED)
                VelY=MAX_SPEED;
        }    
        collision(object);
        playerback.RunAnimation();
        playerjumpleft.RunAnimation();
        playerjumpright.RunAnimation();
        playerjumpst.RunAnimation();
        /*if(VelX!=0){
            mus.playrun();
        }
        if(VelY>0){
            mus.playjump();
        }*/
    }
     private void collision(LinkedList<GameObject> object){
         if(Input.sg){
             x = Game.initx;
             y = Game.inity;
         }
        for(int i=0;i<handler.object.size();i++){
            GameObject temp = handler.object.get(i);
            if(temp.getId() == objectID.Block){
                if(getBoundsTop().intersects(temp.getBounds())){
                    y = temp.getY()+height/3;
                    VelY = 0;
                }
                
                if(getBounds().intersects(temp.getBounds())){
                    y = temp.getY()-height;
                    VelY = 0;
                    falling = false;
                    jumping = false;
                }else{
                    falling = true;
                }
                if(getBoundsLeft().intersects(temp.getBounds())){
                    x = (float) (temp.getX() + temp.getBounds().getWidth());      
                }
                if(getBoundsRight().intersects(temp.getBounds())){
                    x = temp.getX()-width;
                }
            }
             if(temp.getId() == objectID.DeathBoundary){
                if(getBoundsTop().intersects(temp.getBounds())){
                   // mus.playdeath();
                    Game.setLife(Game.getLife()-1);
                    x = Game.InitX;
                    y = Game.InitY;            
                }
                
                if(getBounds().intersects(temp.getBounds())){
                    //mus.playdeath();
                    Game.setLife(Game.getLife()-1);
                    x = Game.InitX;
                    y = Game.InitY;  
                }
                if(getBoundsLeft().intersects(temp.getBounds())){
                   // mus.playdeath();
                    Game.setLife(Game.getLife()-1);
                    x = Game.InitX;
                    y = Game.InitY;  
                }
                if(getBoundsRight().intersects(temp.getBounds())){
                   // mus.playdeath();
                    Game.setLife(Game.getLife()-1);
                    x = Game.InitX;
                    y = Game.InitY;  
                }
            }
            if(temp.getId() == objectID.Lava){
                if(getBoundsTop().intersects(temp.getBounds())){
                   // mus.playdeath();
                    Game.setLife(Game.getLife()-1);
                    x = Game.InitX;
                    y = Game.InitY;            
                }
                
                if(getBounds().intersects(temp.getBounds())){
                    //mus.playdeath();
                    Game.setLife(Game.getLife()-1);
                    x = Game.InitX;
                    y = Game.InitY;  
                }
                if(getBoundsLeft().intersects(temp.getBounds())){
                      
                }
                if(getBoundsRight().intersects(temp.getBounds())){
                   
                }
            }
            if(temp.getId() == objectID.Trap){
                if(getBoundsTop().intersects(temp.getBounds())){
                   // mus.playdeath();
                    Game.setLife(Game.getLife()-1);
                    x = Game.InitX;
                    y = Game.InitY;
                }
                
                if(getBounds().intersects(temp.getBounds())){
                    //mus.playdeath();
                    Game.setLife(Game.getLife()-1);
                    x = Game.InitX;
                    y = Game.InitY;
                   
                }
                if(getBoundsLeft().intersects(temp.getBounds())){
                    /*Game.setLife(Game.getLife() - 1);
                    x = Game.InitX;
                    y = Game.InitY;*/

                }
                if(getBoundsRight().intersects(temp.getBounds())){
                    /*Game.setLife(Game.getLife()-1);
                    x = Game.InitX;
                    y = Game.InitY;*/
                  
                }
            }

            if(temp.getId() == objectID.checkpoint){
                if(getBoundsTop().intersects(temp.getBounds())){
                    Game.InitX = (int)temp.getX();
                    Game.InitY = (int)temp.getY()-32;
                    /*Game.NextLevel();
                    Game.setState(State.Cutscene);*/
                }
                
                if(getBounds().intersects(temp.getBounds())){
                    Game.InitX = (int)temp.getX();
                    Game.InitY = (int)temp.getY()-32;
                    /*Game.NextLevel();
                    Game.setState(State.Cutscene);*/
                    
                }
                if(getBoundsLeft().intersects(temp.getBounds())){
                    Game.InitX = (int)temp.getX();
                    Game.InitY = (int)temp.getY()-32;
                   /*Game.NextLevel();
                   Game.setState(State.Cutscene);*/
                   
                }
                if(getBoundsRight().intersects(temp.getBounds())){
                    Game.InitX = (int)temp.getX();
                    Game.InitY = (int)temp.getY()-32;
                    /*Game.NextLevel();
                    Game.setState(State.Cutscene);*/
                }
            }
            if(temp.getId() == objectID.Levelend){
                if(getBoundsTop().intersects(temp.getBounds())){
                    Game.etime = Instant.now();
                    Game.setState(State.Highscore);
                               
                }
                
                if(getBounds().intersects(temp.getBounds())){
                    Game.etime = Instant.now();
                    Game.setState(State.Highscore);  
                }
                if(getBoundsLeft().intersects(temp.getBounds())){
                    Game.etime = Instant.now();
                    Game.setState(State.Highscore);  
                }
                if(getBoundsRight().intersects(temp.getBounds())){
                    Game.etime = Instant.now();
                    Game.setState(State.Highscore);
                }
            }
            if(temp.getId() == objectID.Lifeup){
                if(getBoundsTop().intersects(temp.getBounds())){
                    if(Lifeup.lc==0){
                    //mus.playpick();
                    Game.setLife(Game.getLife()+1);
                    Lifeup.lc++;
                    }
                }
                
                if(getBounds().intersects(temp.getBounds())){
                    if(Lifeup.lc==0){
                   // mus.playpick();
                    Game.setLife(Game.getLife()+1);
                    Lifeup.lc++;
                    }
                    
                   
                }
                if(getBoundsLeft().intersects(temp.getBounds())){
                    if(Lifeup.lc==0){
                    //mus.playpick();    
                    Game.setLife(Game.getLife()+1);
                    Lifeup.lc++;
                    }
                    

                }
                if(getBoundsRight().intersects(temp.getBounds())){
                    if(Lifeup.lc==0){
                   // mus.playpick();
                    Game.setLife(Game.getLife()+1);
                    Lifeup.lc++;
                  
                  
                }
            }
        }
            if(temp.getId() == objectID.Lifeup2){
                if(getBoundsTop().intersects(temp.getBounds())){
                    if(Lifeup2.lc2==0){
                      //  mus.playpick();
                    Game.setLife(Game.getLife()+1);
                    Lifeup2.lc2++;
                    }
                }
                
                if(getBounds().intersects(temp.getBounds())){
                    if(Lifeup2.lc2==0){
                       // mus.playpick();
                    Game.setLife(Game.getLife()+1);
                    Lifeup2.lc2++;
                    }
                    
                   
                }
                if(getBoundsLeft().intersects(temp.getBounds())){
                    if(Lifeup2.lc2==0){
                        //mus.playpick();
                    Game.setLife(Game.getLife()+1);
                    Lifeup2.lc2++;
                    }
                    

                }
                if(getBoundsRight().intersects(temp.getBounds())){
                    if(Lifeup2.lc2==0){
                       // mus.playpick();
                    Game.setLife(Game.getLife()+1);
                    Lifeup2.lc2++;
                  
                  
                }
            }
        }
    }
}  
    public void render(Graphics g){
        g.setColor(Color.blue);
        
        
        if(VelX !=0){
        
         if(isJumping()){
             if(VelX<0){
           playerjumpleft.drawAnimation(g, (int)x, (int)y,46,98);
             }
             if(VelX>0){
                 playerjumpright.drawAnimation(g, (int)x, (int)y,46,98);
             }
        }else{ 
            playerback.drawAnimation(g, (int)x, (int)y,46,98);
         }
        }
        else if(isJumping() && VelX==0){
             playerjumpst.drawAnimation(g, (int)x, (int)y,46,98);
        }
        else{
            g.drawImage(tex.player[0], (int)x, (int)y, 46, 98, null);
        }
        
        
        Graphics2D g2d = (Graphics2D)g;
        
    }
    
    public Rectangle getBounds(){
        return new Rectangle((int)((int)x+(width/2)-(width/2)/2),(int)((int)y+(height/2)), (int)width/2, (int)height/2);
    }
    public Rectangle getBoundsRight(){
        return new Rectangle((int)((int)x+width-5), (int)y+5, (int)5, (int)height-10);
    }
    public Rectangle getBoundsLeft(){
        return new Rectangle((int)x, (int)y+5, (int)5, (int)height-10);
    }
    public Rectangle getBoundsTop(){
        return new Rectangle((int)((int)x+width/2-(width/2)/2), (int)y, (int)width/2, (int)height/2);
    }
    
        
 }
        

