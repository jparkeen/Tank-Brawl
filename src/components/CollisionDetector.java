package components;

import commons.Globals;
import commons.MapReader;
import commons.TankOrientation;

import static commons.TankOrientation.*;

public class CollisionDetector{

    private String[][] map;

    public CollisionDetector(String[][] map){
        this.map = map;
    }

    /**
     * Returns true if there is a collision
     * @param newX new x tank coordinate
     * @param newY new y tank coordinate
     * @return
     */
    public boolean validateCollision(int newX, int newY, TankObject otherTank) {
        return validateMapCollision(newX, newY) || validateTankCollision(newX, newY, otherTank);
    }

    public boolean validateTankCollision(int newX, int newY, TankObject otherTank) {
        if(newX == otherTank.x && newY == otherTank.y){
            return true;
        }
        return false;
    }

    public boolean validateMapCollision(int newX, int newY){
        int mapX = newX / Globals.BLOCK_SIZE;
        int mapY = newY / Globals.BLOCK_SIZE;

        String value = map[mapY][mapX];

        if(value.equals(MapReader.WALL) || value.equals(MapReader.BREAKABLE_WALL)) {
            return true;
        }
        return false;
    }

    public boolean validateBullettoWallCollision(Bullet bullet){
        Point p = bullet.getNextPosition();
        int newX = p.x;
        int newY = p.y;

        int bulletX = newX / Globals.BLOCK_SIZE;
        int bulletY = newY / Globals.BLOCK_SIZE;

        switch(bullet.getOrientation()) {
            case LEFT:
                // Do nothing
                break;
            case RIGHT:
                // The calculation: bulletX = (bulletX + Globals.BLOCK_SIZE) / Globals.BLOCK_SIZE;
                bulletX += 1;
                break;
            case TOP:
                // Do nothing
                break;
            case DOWN:
                // The calculation: bulletY = (bulletY + Globals.BLOCK_SIZE) / Globals.BLOCK_SIZE;
                bulletY += 1;
                break;
        }

        String value = map[bulletY][bulletX];

        if(value.equals(MapReader.WALL) || value.equals(MapReader.BREAKABLE_WALL)) {
            return true;
        }
        return false;
    }

}
