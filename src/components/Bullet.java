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
        Point p = getNextPosition();
        this.x = p.x;
        this.y = p.y;
    }

    public Point getNextPosition() {
        int newX = this.x;
        int newY = this.y;
        if (orientation == TankOrientation.LEFT) {
            newX -= Globals.BULLET_SPEED;
        }
        if (orientation == TankOrientation.RIGHT) {
            newX += Globals.BULLET_SPEED;
        }
        if (orientation == TankOrientation.TOP) {
            newY -= Globals.BULLET_SPEED;
        }
        if (orientation == TankOrientation.DOWN) {
            newY += Globals.BULLET_SPEED;
        }
        return new Point(newX, newY);
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
