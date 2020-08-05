
package game;

/**
 *
 * @author HARSH
 */
import java.awt.image.BufferedImage;

public class Texture {
    SpriteSheet playersheet, playerjumpsheet,Lavasheet,Trapsheet, blocksheet;
    private BufferedImage[] player_sheet = new BufferedImage[5];
    public BufferedImage[] player = new BufferedImage[5];
    public BufferedImage[] playerjump_sheet = new BufferedImage[3];
    public BufferedImage[] playerjump = new BufferedImage[3];
    public BufferedImage lavaimg,Trapimg, blockImg, Lifeimg, Cloudimg, chkpointimg, Lifeupimg;
    
    public Texture(){
        BufferedImageLoader loader = new BufferedImageLoader();
        for(int i=0;i<5;i++){
        try{
            player_sheet[i] = loader.loadimage("/f"+i+".png");
            
            if(i<3){
                playerjump_sheet[i] = loader.loadimage("/J"+(i+1)+".png");
            }
            lavaimg = loader.loadimage("/lava.png");
            Trapimg = loader.loadimage("/trap.png");
            blockImg = loader.loadimage("/GameBlock.png");
            Lifeimg = loader.loadimage("/Life.png");
            Cloudimg = loader.loadimage("/cloud.png");
            chkpointimg = loader.loadimage("/Flag.png");
            Lifeupimg = loader.loadimage("/Lifeup.png");
        }catch(Exception e){
            e.printStackTrace();
        }
        playersheet = new SpriteSheet(player_sheet[i]);
        Lavasheet = new SpriteSheet(lavaimg);
        Trapsheet = new SpriteSheet(Trapimg);
        blocksheet = new SpriteSheet(blockImg);
        
        if(i<3)
        {
            playerjumpsheet = new SpriteSheet(playerjump_sheet[i]);
        }
        getTextures(i);
        }
    }
    private void getTextures(int i){
        player[i] = playersheet.grabImage(1, 1, 46, 96);
        
        if(i<3){
        playerjump[i] = playerjumpsheet.grabImage(1, 1, 46, 96);
       }
        lavaimg = Lavasheet.grabImage(1, 1, 46, 66);
        Trapimg = Trapsheet.grabImage(1, 1, 46, 66);
        blockImg = blocksheet.grabImage(1,1,46,66);
    }
}
