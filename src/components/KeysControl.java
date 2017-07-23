package components;

import java.awt.event.*;
import commons.Globals;
import commons.TankOrientation;
import core.TankWorld;

public class KeysControl extends KeyAdapter {

    public CollisionDetector collision = new CollisionDetector();

    public void keyPressed(KeyEvent e) {

        int keysCode = e.getKeyCode();
        if (keysCode == KeyEvent.VK_UP) {
            if(TankWorld.tank2.y == Globals.BLOCK_SIZE) {
                return;
            }
            TankWorld.tank2.y -= Globals.BLOCK_SIZE;
            TankWorld.tank2.orientation = TankOrientation.TOP;

        } else if (keysCode == KeyEvent.VK_DOWN) {
            if(TankWorld.tank2.y + Globals.BLOCK_SIZE == Globals.BOARD_SIZE -  Globals.BLOCK_SIZE) {
                return;
            }
            TankWorld.tank2.y += Globals.BLOCK_SIZE;
            TankWorld.tank2.orientation = TankOrientation.DOWN;

        } else if (keysCode == KeyEvent.VK_LEFT) {
            if(TankWorld.tank2.x == Globals.BLOCK_SIZE) {
                return;
            }
            TankWorld.tank2.x -= Globals.BLOCK_SIZE;
            TankWorld.tank2.orientation = TankOrientation.LEFT;

        } else if (keysCode == KeyEvent.VK_RIGHT) {
            if(TankWorld.tank2.x + Globals.BLOCK_SIZE == Globals.BOARD_SIZE - Globals.BLOCK_SIZE) {
                return;
            }
            TankWorld.tank2.x += Globals.BLOCK_SIZE;
            TankWorld.tank2.orientation = TankOrientation.RIGHT;

        } else if(keysCode == KeyEvent.VK_NUMPAD0){

            TankWorld.bullets.add(new Bullet(TankWorld.tank2.x,TankWorld.tank2.y, TankWorld.tank2.orientation ));

        } else if (keysCode == KeyEvent.VK_W) {
            if(TankWorld.tank1.y == Globals.BLOCK_SIZE) {
                return;
            }
            TankWorld.tank1.y -= Globals.BLOCK_SIZE;
            TankWorld.tank1.orientation = TankOrientation.TOP;

        } else if (keysCode == KeyEvent.VK_S) {
            if(TankWorld.tank1.y + Globals.BLOCK_SIZE == Globals.BOARD_SIZE -  Globals.BLOCK_SIZE) {
                return;
            }
            TankWorld.tank1.y += Globals.BLOCK_SIZE;
            TankWorld.tank1.orientation = TankOrientation.DOWN;

        } else if (keysCode == KeyEvent.VK_A) {
            if(TankWorld.tank1.x == Globals.BLOCK_SIZE) {
                return;
            }
            TankWorld.tank1.x -= Globals.BLOCK_SIZE;
            TankWorld.tank1.orientation = TankOrientation.LEFT;

        } else if (keysCode == KeyEvent.VK_D) {
            if(TankWorld.tank1.x + Globals.BLOCK_SIZE == Globals.BOARD_SIZE -  Globals.BLOCK_SIZE) {
                return;
            }
            TankWorld.tank1.x += Globals.BLOCK_SIZE;
            TankWorld.tank1.orientation = TankOrientation.RIGHT;

        } else if(keysCode == KeyEvent.VK_SPACE){
            TankWorld.bullets.add(new Bullet(TankWorld.tank1.x,TankWorld.tank1.y, TankWorld.tank1.orientation ));
        }
        else if (keysCode == KeyEvent.VK_NUMPAD1){
            TankWorld.explosions.add(new Explosion(Explosion.x,Explosion.y));
        }
    }

    public void keyReleased(KeyEvent e) {

    }

}