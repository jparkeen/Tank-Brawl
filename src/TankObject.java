import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by EmEm on 7/15/2017.
 */
public  class TankObject {

    protected int x,y,health,speed,id;
    String playerName;
    protected BufferedImage image;
    protected TankWorld tankWorld;


    public TankObject(int x,int y,String imagePath,int id,String playerName,TankWorld tankWorld){
        this.x = x;
        this.y = y;
        this.id = id;
        this.playerName = playerName;
        this.tankWorld = tankWorld;
        this.image = loadImages.loadImages(imagePath);

    }

    public void update(){

    }

    public void drawImage(Graphics g){

    }

}
