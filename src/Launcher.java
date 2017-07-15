/**
 * Created by EmEm on 7/13/2017.
 */

//@ Task: start the game
public class Launcher {
    public static void main(String[] args){
       TankWorld tankWorld = new TankWorld("Tank War",600,600);
        tankWorld.start();
    }
}
