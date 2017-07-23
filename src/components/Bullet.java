package components;

import commons.Globals;
import commons.TankOrientation;

public class Bullet {

    private int x;

    private int y;

    private final TankOrientation orientation;

    public Bullet(int x, int y, TankOrientation orientation) {
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

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public TankOrientation getOrientation() {
        return orientation;
    }
}
