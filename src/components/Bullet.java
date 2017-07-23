package components;

import commons.Globals;
import commons.TankOrientation;

public class Bullet {

    private float x;

    private float y;

    private final TankOrientation orientation;

    public Bullet(float x, float y, TankOrientation orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    public void moveBullet() {
        if (orientation == TankOrientation.LEFT) {
            x -= Globals.BULLET_SPEED;
        }
        if (orientation == TankOrientation.RIGHT) {
            x += Globals.BULLET_SPEED;
        }
        if (orientation == TankOrientation.TOP) {
            y -= Globals.BULLET_SPEED;
        }
        if (orientation == TankOrientation.DOWN) {
            y += Globals.BULLET_SPEED;
        }
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public TankOrientation getOrientation() {
        return orientation;
    }
}
