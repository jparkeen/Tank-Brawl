package components;

import core.TankWorld;
import java.util.ArrayList;

import java.awt.*;

/**
 * Created by EmEm on 7/15/2017.
 *
 */


public class Bullet  {
    private int x,y,direction;
    protected  TankWorld tankWorld;


    public Bullet(int x, int y){

           this.x = x;
           this.y = y;
           this.direction = direction;

    }

    public void update() {
        x -= 5;
        y += 10;

    }

    public int getX(){return x;}
    public int getY(){return y;}
}
