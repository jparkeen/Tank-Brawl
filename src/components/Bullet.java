package components;

import core.TankWorld;
import java.util.ArrayList;

import java.awt.*;

public class Bullet  {
    static Direction directionUp = new Direction(0,-1);
    static Direction directionDown = new Direction(0,1);
    static Direction directionLeft = new Direction(-1,0);
    static Direction directionRight = new Direction(1,0);

    private int x,y;
    private Direction direction;


    public Bullet(int x, int y,Direction direction){

           this.x = x;
           this.y = y;
           this.direction = direction;



    }

    public void update() {
        x += this.direction.x;
        y += this.direction.y;



    }

    public int getX(){return x;}
    public int getY(){return y;}
    public Direction getDirection(){
        return direction;
    }
}
