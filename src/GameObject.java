import java.awt.*;

/**
 * Created by EmEm on 7/13/2017.
 */

public abstract class GameObject {
    protected float x, y;

    public GameObject(float x, float y){
        this.x = x;
        this.y = y;
    }

    public abstract void update();

    public abstract void drawImage(Graphics g);

}



