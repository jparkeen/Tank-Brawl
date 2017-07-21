import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Observer;

/**
 * Created by EmEm on 7/15/2017.
 */
public  class TankObject {

    protected int x,y,health,speed,id,lives;
    String playerName;
    protected BufferedImage image;
    protected TankWorld tankWorld;


    public TankObject(int x,int y,String imagePath,int id,String playerName,int health,int lives,int speed,TankWorld tankWorld){
        this.x = x;
        this.y = y;
        this.id = id;
        this.health = health;
        this.lives = lives;
        this.speed = speed;
        this.playerName = playerName;
        this.tankWorld = tankWorld;
        this.image = loadImages.loadImages(imagePath);



    }

    public void update(){


    }

    public void drawImage(Graphics g){

    }



}


