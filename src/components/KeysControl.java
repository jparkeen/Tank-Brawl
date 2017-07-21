package components;

import java.awt.event.*;

import core.TankWorld;

public class KeysControl extends KeyAdapter {
    private int keysCode;
    public boolean up, down, left, right, UP, DOWN, LEFT, RIGHT;

    public void update() {


    }

    public void keyPressed(KeyEvent e) {

        int keysCode = e.getKeyCode();
        if (keysCode == KeyEvent.VK_UP) {

            TankWorld.tank1.y -= TankWorld.BLOCK_SIZE;
        } else if (keysCode == KeyEvent.VK_DOWN) {

            TankWorld.tank1.y += TankWorld.BLOCK_SIZE;

        } else if (keysCode == KeyEvent.VK_LEFT) {

            TankWorld.tank1.x -= TankWorld.BLOCK_SIZE;

        } else if (keysCode == KeyEvent.VK_RIGHT) {

            TankWorld.tank1.x += TankWorld.BLOCK_SIZE;

        } else if (keysCode == KeyEvent.VK_W) {

            TankWorld.tank2.y -= TankWorld.BLOCK_SIZE;
        } else if (keysCode == KeyEvent.VK_S) {

            TankWorld.tank2.y += TankWorld.BLOCK_SIZE;
        } else if (keysCode == KeyEvent.VK_A) {

            TankWorld.tank2.x -= TankWorld.BLOCK_SIZE;
        } else if (keysCode == KeyEvent.VK_D) {

            TankWorld.tank2.x += TankWorld.BLOCK_SIZE;
        }

    }

    public void keyReleased(KeyEvent e) {

    }
}

