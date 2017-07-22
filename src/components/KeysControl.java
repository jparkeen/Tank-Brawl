package components;

import java.awt.event.*;
import commons.Globals;
import core.TankWorld;

public class KeysControl extends KeyAdapter {
    private int keysCode;
    public boolean up, down, left, right, UP, DOWN, LEFT, RIGHT;

    public void update() {


    }

    public void keyPressed(KeyEvent e) {

        int keysCode = e.getKeyCode();
        if (keysCode == KeyEvent.VK_UP) {

            TankWorld.tank1.y -= Globals.BLOCK_SIZE;
        } else if (keysCode == KeyEvent.VK_DOWN) {

            TankWorld.tank1.y += Globals.BLOCK_SIZE;

        } else if (keysCode == KeyEvent.VK_LEFT) {

            TankWorld.tank1.x -= Globals.BLOCK_SIZE;

        } else if (keysCode == KeyEvent.VK_RIGHT) {

            TankWorld.tank1.x += Globals.BLOCK_SIZE;

        } else if(keysCode == KeyEvent.VK_SPACE){
            TankWorld.b = new Bullet(TankWorld.tank1.x,TankWorld.tank1.y);
        }

        else if (keysCode == KeyEvent.VK_W) {

            TankWorld.tank2.y -= Globals.BLOCK_SIZE;
        } else if (keysCode == KeyEvent.VK_S) {

            TankWorld.tank2.y += Globals.BLOCK_SIZE;
        } else if (keysCode == KeyEvent.VK_A) {

            TankWorld.tank2.x -= Globals.BLOCK_SIZE;
        } else if (keysCode == KeyEvent.VK_D) {

            TankWorld.tank2.x += Globals.BLOCK_SIZE;
        }

    }

    public void keyReleased(KeyEvent e) {

    }
}

