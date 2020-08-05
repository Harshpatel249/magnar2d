package game;

/**
 *
 * @author HARSH
 */

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class BufferedImageLoader {
    private BufferedImage image;
    public BufferedImage loadimage(String path){
        try{
        image = ImageIO.read(getClass().getResource(path));
        }catch(Exception e){
            e.printStackTrace();
        }
        return image;
    }
    
}
