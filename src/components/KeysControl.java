package components;

import java.awt.event.*;

import commons.Globals;
import commons.TankOrientation;
import core.TankWorld;

public class KeysControl extends KeyAdapter {
    private int keysCode;
//    public boolean up, down, left, right, UP, DOWN, LEFT, RIGHT;
//
//    public void update() {
//
//
//    }

    public void keyPressed(KeyEvent e) {

        int keysCode = e.getKeyCode();
        if (keysCode == KeyEvent.VK_UP) {

            TankWorld.tank1.y -= Globals.BLOCK_SIZE;
            TankWorld.tank1.orientation = TankOrientation.TOP;

        } else if (keysCode == KeyEvent.VK_DOWN) {

            TankWorld.tank1.y += Globals.BLOCK_SIZE;
            TankWorld.tank1.orientation = TankOrientation.DOWN;

        } else if (keysCode == KeyEvent.VK_LEFT) {

            TankWorld.tank1.x -= Globals.BLOCK_SIZE;
            TankWorld.tank1.orientation = TankOrientation.LEFT;

        } else if (keysCode == KeyEvent.VK_RIGHT) {

            TankWorld.tank1.x += Globals.BLOCK_SIZE;
            TankWorld.tank1.orientation = TankOrientation.RIGHT;

        } else if (keysCode == KeyEvent.VK_W) {

            TankWorld.tank2.y -= Globals.BLOCK_SIZE;
            TankWorld.tank2.orientation = TankOrientation.TOP;

        } else if (keysCode == KeyEvent.VK_S) {

            TankWorld.tank2.y += Globals.BLOCK_SIZE;
            TankWorld.tank2.orientation = TankOrientation.DOWN;

        } else if (keysCode == KeyEvent.VK_A) {

            TankWorld.tank2.x -= Globals.BLOCK_SIZE;
            TankWorld.tank2.orientation = TankOrientation.LEFT;

        } else if (keysCode == KeyEvent.VK_D) {

            TankWorld.tank2.x += Globals.BLOCK_SIZE;
            TankWorld.tank2.orientation = TankOrientation.RIGHT;

        }
    }

    public void keyReleased(KeyEvent e) {

    }
}

