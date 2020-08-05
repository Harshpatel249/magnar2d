package game;

/**
 *
 * @author HARSH
 */

import java.awt.Canvas;
import java.awt.image.BufferStrategy;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D; 
import java.awt.image.BufferedImage;
import java.time.Instant;
import java.time.Duration;


public class Game extends Canvas implements Runnable{
    private boolean running = false;
    private Thread thread;
    public static int WIDTH,HEIGHT;
    public static int InitX,InitY,initx,inity;
    public static int levelcount=1;
    public static int Life=1; 
    public static Instant stime,etime,mtime;
    public static Duration Mtime;
    private int[] showscore;
    private String[] showname;
   
    String life;
    Color c = new Color(63,226,226);
    
    private BufferedImage level= null;
    
    Camera camera;
    Handler handler;
    static Texture tex;
    static Player p;
    Cutscene cs;
    Menu menu;
    Highscore sc,sc1;
    
    public static State state = State.Menu;
    
    public static State getState(){
        return state;
    }
    
    public static void setState(State st){
        state = st;
    }
    public boolean CheckLife(){
        if(Life==0){
            return true;
        }else{
            return false;
        }
    }
    
    private void init(){
        WIDTH = getWidth();
        HEIGHT = getHeight();
        tex = new Texture();
        
        BufferedImageLoader loader = new BufferedImageLoader();
        level = loader.loadimage("/level"+levelcount+".png");
        
        handler = new Handler();
        camera = new Camera(0,0);
       
        Font f = new Font("Arial",Font.BOLD,26);
        setFont(f);
        LoadImageLevel(level);
       // handler.addObject(new Player(100, 100,handler, objectID.Player));
        //handler.makelevel();
        
        this.addKeyListener(new Input(handler));
    }
    
    public synchronized void start(){
        if(running){
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    public void run(){
        this.requestFocus();
        init();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int updates = 0;
        int frames = 0;
        while(running){
	     long now = System.nanoTime();
	    delta += (now - lastTime) / ns;
	    lastTime = now;
	    while(delta >= 1){
		tick();
		updates++;
		delta--;
	}
	render();
	frames++;
        
	if(System.currentTimeMillis() - timer > 1000){
		timer += 1000;
		System.out.println("FPS: " + frames + " TICKS: " + updates);
		frames = 0;
		updates = 0;
	}
      }
    }
    private void tick(){
        if(state == State.Ingame || state == State.Death){
        handler.tick();
        for(int i=0;i<handler.object.size();i++){
            if(handler.object.get(i).getId() == objectID.Player){
               camera.tick(handler.object.get(i));
            }
        }
      }
    }
    private void render(){
        BufferStrategy bf = this.getBufferStrategy();
        if(bf == null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bf.getDrawGraphics();
        Graphics2D g2d = (Graphics2D)g;
        life = " X "+getLife();
        if(state == State.Ingame){
        mtime = Instant.now();
        Mtime = Duration.between(stime, mtime);
        }
        g.setColor(c);
        g.fillRect(0,0,getWidth(),getHeight());
        if(CheckLife()){
            Menu.setmscreen(0);
            setState(State.Menu);
            Life=1;
        }
        
        if(state == State.Ingame||state == State.Death){
        g2d.translate(camera.getX(), camera.getY());
        handler.render(g);
        
        g.drawImage(tex.Lifeimg, (int)p.getX()-980, 20, 150, 70, null);
        g.setColor(Color.WHITE);
        g.drawString(life, (int)p.getX()-880, 65);
        g.drawString(Integer.toString((int)Mtime.toMillis()/1000)+" seconds", (int)p.getX()+770, 65);
        
        g2d.translate(-camera.getX(), -camera.getY());
        }
        if(state == State.Cutscene){
            cs = new Cutscene();
            cs.render(g);
        }
        if(state == State.viewHighscore){
            sc1 = new Highscore();
            sc1.viewscore(g);
            /*showscore = sc1.db.getVscore();
            showname = sc1.db.getvName();
            
            g.drawString("Name : "+showname[0]+"Score : "+showscore[0]+"seconds", 400, 400);
            g.drawString("Name : "+showname[1]+"Score : "+showscore[1]+"seconds", 400, 450);
            g.drawString("Name : "+showname[2]+"Score : "+showscore[2]+"seconds", 400, 500);*/
        }
        if(state == State.Menu){
            menu = new Menu();
            menu.render(g);
        }
        if(state == State.Highscore){
            sc = new Highscore();
            sc.getscore();
        }
        g.dispose();
        bf.show();
    }
    public void LoadImageLevel(BufferedImage image){
        int w  = image.getWidth();
        int h = image.getHeight();
        
        for(int xx=0;xx<h;xx++){
            for(int yy=0;yy<w;yy++){
                int pixel = image.getRGB(xx, yy);
                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue = (pixel) & 0xff;
                
                if(red==255 && green==255 && blue==255){
                    handler.addObject(new Block(xx*32,yy*32,objectID.Block));
                }
                if(red==0 && green==0 && blue==255){
                    p = new Player(xx*32,yy*32,handler,objectID.Player);
                    handler.addObject(p);
                    InitX = xx*32;
                    InitY = yy*32;
                    initx = xx*32;
                    inity = yy*32;
                }
                if(red==0 && green==100 && blue==100){
                    handler.addObject(new Cloud(xx*32,yy*32,objectID.Cloud));
                }
                if(red==255 && green==0 && blue==0){
                    handler.addObject(new DeathBoundary(xx*32,yy*32,objectID.DeathBoundary));
                }
                if(red==255 && green==255 && blue==0){
                    handler.addObject(new Lava(xx*32,yy*32,objectID.Lava));
                }
                if(red==0 && green==255 && blue==0){
                    handler.addObject(new Trap(xx*32,yy*32,objectID.Trap));
                }
                if(red==200 && green==0 && blue==200){
                    handler.addObject(new checkpoint(xx*32,yy*32,objectID.checkpoint));
                }
                if(red==0 && green==255 && blue==255){
                    handler.addObject(new Levelend(xx*32,yy*32,objectID.Levelend));
                }
                if(red==200 && green==0 && blue==0){
                    handler.addObject(new Lifeup(xx*32,yy*32,objectID.Lifeup));
                }
                if(red==222 && green==0 && blue==0){
                    handler.addObject(new Lifeup2(xx*32,yy*32,objectID.Lifeup2));
                }
            }
        }
    }
    
    public static Texture getInstance(){
        return tex;
    }
    public static Player getP(){
        return p;
    }
    public static int getLevel(){
        return levelcount;
    }
    public static void NextLevel(){
        levelcount++;
    }
    public static void setLife(int i){
        Life = i;
    }
    public static int getLife(){
        return Life;
    }
  
    public static void main(String[] args) {
       new Window(1920,1080,"Magnar",new Game());
       Music mus = new Music();
       mus.playMusic("/BackGroundMusic.wav");
    }
    
}
