package components;

import java.awt.*;
import java.awt.image.BufferedImage;

import core.TankWorld;

public class TankObject {

    public int x, y, health, speed, id, lives;
    public String playerName;
    public BufferedImage image;
    public TankWorld tankWorld;

    /**
     * Name of the tank
     */
    private String tankName;

    public static String TANK_1_NAME = "tank1";

    public static String TANK_2_NAME = "tank2";


    public TankObject(int x, int y, String imagePath, int id, String playerName, int health, int lives, int speed, TankWorld tankWorld, String tankName) {
        this.x = x;
        this.y = y;
        this.id = id;
        this.health = health;
        this.lives = lives;
        this.speed = speed;
        this.playerName = playerName;
        this.tankWorld = tankWorld;
        this.image = loadImages.loadImages(imagePath);
        this.tankName = tankName;
    }

    public String getTankName() {
        return tankName;
    }

    public void update() {


    }

    public void drawImage(Graphics g) {

    }


}


