package components;

import java.awt.*;
import java.awt.image.BufferedImage;

import commons.CommonAPIs;
import commons.Globals;
import commons.TankOrientation;
import core.TankWorld;

public class TankObject {
    public int x,y;
    public int  health, speed, id, lives;
    public String playerName;
    public BufferedImage image;
    public TankWorld tankWorld;
    public TankOrientation orientation;

    /**
     * Name of the tank
     */
    private String tankName;

    public static String TANK_1_NAME = "tank1";

    public static String TANK_2_NAME = "tank2";


    public TankObject(int x, int y, String imagePath, int id, String playerName, int health, int lives, int speed,
                      TankWorld tankWorld, String tankName) {
        this.x = x;
        this.y = y;
        this.id = id;
        this.health = health;
        this.lives = lives;
        this.speed = speed;
        this.playerName = playerName;
        this.tankWorld = tankWorld;
        this.image = CommonAPIs.loadImages(imagePath);
        this.tankName = tankName;
        this.orientation = TankOrientation.LEFT;
    }

/*    public String getTankName() {
        return tankName;
    }d
*/
    public void update() {


    }

    public void drawTank(Graphics2D g2) {
        Image image = Toolkit.getDefaultToolkit().getImage("resources/tank/" + tankName +
                "/tank_" + orientation.name().toLowerCase() + ".png");
        g2.drawImage(image, x, y, Globals.BLOCK_SIZE, Globals.BLOCK_SIZE, tankWorld);
        g2.finalize();

        Image health_image = Toolkit.getDefaultToolkit().getImage("resources/health16.png");
        g2.drawImage(health_image, x, y-20, 60, 16, tankWorld);
        g2.finalize();
        
        Image live_image = Toolkit.getDefaultToolkit().getImage("resources/tank/" + tankName +
                "/tank_left.png");
        g2.drawImage(live_image, x, y - 33,  12  , 12 , tankWorld);
        g2.finalize();

    }

}


