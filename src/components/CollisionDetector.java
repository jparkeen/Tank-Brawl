package components;

import commons.Globals;
import commons.MapReader;

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

    private boolean validateTankCollision(int newX, int newY, TankObject otherTank) {
        if(newX == otherTank.x && newY == otherTank.y){
            return true;
        }
        return false;
    }

    private boolean validateMapCollision(int newX, int newY){
        int mapX = newX / Globals.BLOCK_SIZE;
        int mapY = newY / Globals.BLOCK_SIZE;

        String value = map[mapY][mapX];

        if(value.equals(MapReader.WALL) || value.equals(MapReader.BREAKABLE_WALL)) {
            return true;
        }
        return false;
    }

}
