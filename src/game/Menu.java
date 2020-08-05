
package game;

/**
 *
 * @author HARSH
 */
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Menu{
    private BufferedImage[] menu = new BufferedImage[3];
    BufferedImageLoader loader = new BufferedImageLoader();
    private static int mscreen = 0;
    
    public static void setmscreen(int i){
        mscreen = i;
    }
    
    public static int getmscreen(){
        return mscreen;
    }
    
    public void render(Graphics g){
        if(mscreen==0){
        menu[0] = loader.loadimage("/menu1.png");
        g.drawImage(menu[0], 0, 0,1920,1080,null);
        }
        if(mscreen==1){
        menu[0] = loader.loadimage("/i1.png");
        g.drawImage(menu[0], 0, 0,1920,1060,null);
        }
        if(mscreen==2){
         menu[0] = loader.loadimage("/i2.png");
         g.drawImage(menu[0], 0, 0,1920,1060,null);
        }
    }
    
    
    
}
