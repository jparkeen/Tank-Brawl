package components;

import java.awt.event.*;
import java.util.ArrayList;

import commons.Globals;
import commons.TankOrientation;
import core.TankWorld;


public class KeysControl extends KeyAdapter {

    private CollisionDetector collision;

    private TankObject tank1;

    private TankObject tank2;

    private ArrayList<Bullet> bullets;


    public KeysControl(CollisionDetector collisionDetector, TankObject tank1, TankObject tank2,
                       ArrayList<Bullet> bullets) {
        this.collision = collisionDetector;
        this.tank1 = tank1;
        this.tank2 = tank2;
        this.bullets = bullets;
    }
    public void keyPressed(KeyEvent e) {

        if(collision.isGameOver()) {
            return;
        }

        int keysCode = e.getKeyCode();
        //int newX, newY;

        if (keysCode == KeyEvent.VK_UP) {
            TankWorld.tank2movingup = true;

        }if (keysCode == KeyEvent.VK_DOWN) {
            TankWorld.tank2movingdown = true;

        }if (keysCode == KeyEvent.VK_LEFT) {
            TankWorld.tank2movingleft = true;

        }if (keysCode == KeyEvent.VK_RIGHT) {
            TankWorld.tank2movingright = true;

        }if (keysCode == KeyEvent.VK_NUMPAD0) {
            bullets.add(new Bullet(tank2.x, tank2.y, tank2.orientation));

        }if (keysCode == KeyEvent.VK_W) {
            TankWorld.tank1movingup = true;

        }if (keysCode == KeyEvent.VK_S) {
            TankWorld.tank1movingdown = true;

        }if (keysCode == KeyEvent.VK_A) {
            TankWorld.tank1movingleft = true;

        }if (keysCode == KeyEvent.VK_D) {
            TankWorld.tank1movingright = true;

        }if (keysCode == KeyEvent.VK_SPACE) {
            bullets.add(new Bullet(tank1.x, tank1.y, tank1.orientation));
        }
    }

    public void keyReleased(KeyEvent e) {

        int keysCode = e.getKeyCode();

        if (keysCode == KeyEvent.VK_UP) {
            TankWorld.tank2movingup = false;

        }if (keysCode == KeyEvent.VK_DOWN) {
            TankWorld.tank2movingdown = false;

        }if (keysCode == KeyEvent.VK_LEFT) {
            TankWorld.tank2movingleft = false;

        }if (keysCode == KeyEvent.VK_RIGHT) {
            TankWorld.tank2movingright = false;

        }if (keysCode == KeyEvent.VK_W) {
            TankWorld.tank1movingup = false;

        }if (keysCode == KeyEvent.VK_S) {
            TankWorld.tank1movingdown = false;

        }if (keysCode == KeyEvent.VK_A) {
            TankWorld.tank1movingleft = false;

        }if (keysCode == KeyEvent.VK_D) {
            TankWorld.tank1movingright = false;

        }
    }
}