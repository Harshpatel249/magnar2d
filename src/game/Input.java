package game;

/**
 *
 * @author HARSH
 */


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.Instant;

public class Input extends KeyAdapter{
    Handler handler;
    Music mus;
    public static boolean sg = false;
    
    public Input(Handler handler){
        this.handler = handler;
    }
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_ESCAPE || key == KeyEvent.VK_4){
            System.exit(1);
        }
        if(Game.getState()==State.Ingame){
            sg=false;
        for(int i=0;i<handler.object.size();i++){
            GameObject tempObject = handler.object.get(i);
            
            if(tempObject.getId() == objectID.Player){
                if(key == KeyEvent.VK_D){ 
                    tempObject.setVelX(5);
                    
                }
                if(key == KeyEvent.VK_A){
                    tempObject.setVelX(-5);
                    
                }
                if((key == KeyEvent.VK_SPACE || key == KeyEvent.VK_W) && !tempObject.isJumping()){
                    
                    tempObject.setJumping(true);
                    tempObject.setVelY(-10);
                }
            }
        }
      }
        
        if(Game.getState()==State.Menu && Menu.getmscreen()==0){
            if(key == KeyEvent.VK_1){
                Game.setLife(10);
                sg = true;
                Game.InitX = Game.initx;
                Game.InitY = Game.inity;
                Game.stime = Instant.now();
                Lifeup.lc=0;
                Lifeup2.lc2=0;
                Game.setState(State.Ingame);
            }
            else{
                sg=false;
            }
            if(key == KeyEvent.VK_2){
                Menu.setmscreen(1);
            }
            if(key == KeyEvent.VK_3){
                Game.setState(State.viewHighscore);
            }
            key = KeyEvent.VK_0;
        }
        if(Game.getState()==State.Menu && Menu.getmscreen()==1){
            if(key == KeyEvent.VK_SPACE){
                Menu.setmscreen(2);
            }
            key = KeyEvent.VK_0;
        }
        if(Game.getState()==State.Menu && Menu.getmscreen()==2){
            if(key == KeyEvent.VK_SPACE){
                Menu.setmscreen(0);
            }
            key = KeyEvent.VK_0;
        }
        
    }
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
    if(Game.getState()==State.Ingame){
        for(int i=0;i<handler.object.size();i++){
            GameObject tempObject = handler.object.get(i);
            
            if(tempObject.getId() == objectID.Player){
                
                if(key == KeyEvent.VK_D && tempObject.getVelX()>0){
                    tempObject.setVelX(0);
                }
                if(key == KeyEvent.VK_A && tempObject.getVelX()<0){
                    tempObject.setVelX(0);
                }
            }
        }
    }
  }
}
