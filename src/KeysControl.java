/**
 * Created by EmEm on 7/13/2017.
 */
import javax.swing.*;
import java.awt.event.*;



   public class KeysControl extends KeyAdapter {
   private int keysCode;
   public boolean up,down,left,right,UP,DOWN,LEFT,RIGHT;

       public void update(){



    }

    public void keyPressed(KeyEvent e){

        int keysCode = e.getKeyCode();
        if(keysCode == KeyEvent.VK_UP){

            TankWorld.tankOne.y -= 10;
        }
        else if(keysCode == KeyEvent.VK_DOWN) {

            TankWorld.tankOne.y += 10;

        }
        else if(keysCode == KeyEvent.VK_LEFT) {

            TankWorld.tankOne.x -= 10;

        }
        else if(keysCode == KeyEvent.VK_RIGHT){

            TankWorld.tankOne.x += 10;

        }
        else if(keysCode == KeyEvent.VK_W){

            TankWorld.tankTwo.y -= 10;
        }
        else if(keysCode == KeyEvent.VK_S){

            TankWorld.tankTwo.y += 10;
        }
        else if(keysCode == KeyEvent.VK_A){

            TankWorld.tankTwo.x -= 10;
        }
        else if(keysCode == KeyEvent.VK_D){

            TankWorld.tankTwo.x += 10;
        }

    }

    public void keyReleased(KeyEvent e) {

    }
}

