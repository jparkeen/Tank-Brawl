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

    private  ArrayList<Explosion> explosions;

    public KeysControl(CollisionDetector collisionDetector, TankObject tank1, TankObject tank2,
                       ArrayList<Bullet> bullets,ArrayList<Explosion> explosions) {
        this.collision = collisionDetector;
        this.tank1 = tank1;
        this.tank2 = tank2;
        this.bullets = bullets;
        this.explosions = explosions;
    }

    public void keyPressed(KeyEvent e) {

        int keysCode = e.getKeyCode();
        int newX, newY;

        if (keysCode == KeyEvent.VK_UP) {
            newX = tank2.x;
            newY = tank2.y - Globals.BLOCK_SIZE;
            if (collision.validateCollision(newX, newY, tank1)) {
                return;
            }
            tank2.y = newY;
            tank2.orientation = TankOrientation.TOP;

        } else if (keysCode == KeyEvent.VK_DOWN) {
            newX = tank2.x;
            newY = tank2.y + Globals.BLOCK_SIZE;
            if (collision.validateCollision(newX, newY, tank1)) {
                return;
            }
            tank2.y = newY;
            tank2.orientation = TankOrientation.DOWN;

        } else if (keysCode == KeyEvent.VK_LEFT) {
            newX = tank2.x - Globals.BLOCK_SIZE;
            newY = tank2.y;
            if (collision.validateCollision(newX, newY, tank1)) {
                return;
            }
            tank2.x = newX;
            tank2.orientation = TankOrientation.LEFT;

        } else if (keysCode == KeyEvent.VK_RIGHT) {
            newX = tank2.x + Globals.BLOCK_SIZE;
            newY = tank2.y;
            if (collision.validateCollision(newX, newY, tank1)) {
                return;
            }
            tank2.x = newX;
            tank2.orientation = TankOrientation.RIGHT;

        } else if (keysCode == KeyEvent.VK_NUMPAD0) {
            bullets.add(new Bullet(tank2.x, tank2.y, tank2.orientation));

        } else if (keysCode == KeyEvent.VK_W) {
            newX = tank1.x;
            newY = tank1.y - Globals.BLOCK_SIZE;
            if (collision.validateCollision(newX, newY, tank2)) {
                return;
            }
            tank1.y = newY;
            tank1.orientation = TankOrientation.TOP;

        } else if (keysCode == KeyEvent.VK_S) {
            newX = tank1.x;
            newY = tank1.y + Globals.BLOCK_SIZE;
            if (collision.validateCollision(newX, newY, tank2)) {
                return;
            }
            tank1.y = newY;
            tank1.orientation = TankOrientation.DOWN;

        } else if (keysCode == KeyEvent.VK_A) {
            newX = tank1.x - Globals.BLOCK_SIZE;
            newY = tank1.y;
            if (collision.validateCollision(newX, newY, tank2)) {
                return;
            }
            tank1.x = newX;
            tank1.orientation = TankOrientation.LEFT;

        } else if (keysCode == KeyEvent.VK_D) {
            newX = tank1.x + Globals.BLOCK_SIZE;
            newY = tank1.y;
            if (collision.validateCollision(newX, newY, tank2)) {
                return;
            }
            tank1.x = newX;
            tank1.orientation = TankOrientation.RIGHT;

        } else if (keysCode == KeyEvent.VK_SPACE) {
            bullets.add(new Bullet(tank1.x, tank1.y, tank1.orientation));
        }

    }

    public void keyReleased(KeyEvent e) {

    }

}