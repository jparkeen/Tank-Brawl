package core;

import commons.Globals;
import commons.MapReader;
import components.Bullet;
import components.KeysControl;
import components.TankObject;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;



@SuppressWarnings("serial")
public class TankWorld extends JComponent implements Runnable {

    private String[][] map;

    public static TankObject tank1;

    public static TankObject tank2;

    private Thread thread;

    //public static Bullet b;

    private int frameTarget = 1;

    private int countFrame = 0;

    private KeysControl keysControl;
    int health = 30, lives = 2;

    public static ArrayList<Bullet> b = new ArrayList<Bullet>(1000);

    public TankWorld() throws IOException {
        this.map = MapReader.readMap(Globals.MAP1_FILENAME);

        setFocusable(true);

        setInitialTankLocation();

        this.keysControl = new KeysControl();
        addKeyListener(keysControl);
    }

    private void setInitialTankLocation() {

        // TODO: Correct this later
        String tank1_file = System.getProperty("user.dir") +
                File.separator + "resources" +
                File.separator + "tank" +
                File.separator + "tank1" +
                File.separator + "tank_left.png";


        for (int row = 0; row < Globals.MAX_NUMBER_OF_BLOCKS; row++) {
            for (int col = 0; col < Globals.MAX_NUMBER_OF_BLOCKS; col++) {
                String value = map[row][col];
                int y = row * Globals.BLOCK_SIZE;
                int x = col * Globals.BLOCK_SIZE;
                if (value.equals(MapReader.TANK_1)) {
                    this.tank1 = new TankObject(x, y, tank1_file, 1, "Tank 1",health,lives,10,this, TankObject.TANK_1_NAME);
                    map[row][col] = MapReader.SPACE;
                    continue;
                }
                if (value.equals(MapReader.TANK_2)) {
                    this.tank2 = new TankObject(x, y, tank1_file, 2, "Tank 2",health,lives,10,this, TankObject.TANK_2_NAME);
                    map[row][col] = MapReader.SPACE;
                    continue;
                }
            }
        }
    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        renderBackground(g2);
        renderMap(g2);
        renderTankCurrentLocation(g2);
        renderBullet(g2);
        moveBullet();
    }

    private void renderTankCurrentLocation(Graphics2D g2) {
        tank1.drawTank(g2);
        tank2.drawTank(g2);
    }

    private void renderMap(Graphics2D g2) {

        for (int row = 0; row < Globals.MAX_NUMBER_OF_BLOCKS; row++) {
            for (int col = 0; col < Globals.MAX_NUMBER_OF_BLOCKS; col++) {
                String value = map[row][col];
                int y = row * Globals.BLOCK_SIZE;
                int x = col * Globals.BLOCK_SIZE;
                if (value.equals(MapReader.WALL)) {
                    renderUnBreakableWall(g2, x, y);
                    continue;
                }
                if (value.equals(MapReader.BREAKABLE_WALL)) {
                    renderBreakableWall(g2, x, y);
                    continue;
                }
                if (value.equals(MapReader.SPACE)) {
                    // Do nothing
                    continue;
                }
                if (value.equals(MapReader.TANK_1)) {
                    tank1.drawTank(g2);
                    continue;
                }
                if (value.equals(MapReader.TANK_2)) {
                    tank2.drawTank(g2);
                    continue;
                }
            }
        }
    }

    private void renderUnBreakableWall(Graphics2D g2, int x, int y) {
        Image image = Toolkit.getDefaultToolkit().getImage("resources/UnbreakableWall.png");
        g2.drawImage(image, x, y, Globals.BLOCK_SIZE, Globals.BLOCK_SIZE, this);
        g2.finalize();
    }
    private void renderBreakableWall(Graphics2D g2, int x, int y) {
        Image image = Toolkit.getDefaultToolkit().getImage("resources/BreakableWall.png");
        g2.drawImage(image, x, y, Globals.BLOCK_SIZE, Globals.BLOCK_SIZE, this);
        g2.finalize();
    }

    public void renderBackground(Graphics2D g2) {
        Image image = Toolkit.getDefaultToolkit().getImage("resources/Background.png");
        g2.drawImage(image, 0, 0, Globals.BOARD_SIZE, Globals.BOARD_SIZE, this);
        g2.finalize();
    }

    public void renderBullet(Graphics2D g2){

        if(!b.isEmpty()) {
            Image image = Toolkit.getDefaultToolkit().getImage("resources/Shell_basic_strip60-0-0.png");
            for (int i = 0;i < b.size();i++){
            g2.drawImage(image, b.get(i).getX(), b.get(i).getY(), this);
            g2.finalize();
        }
        }
    }

    public void moveBullet(){
        if(!b.isEmpty()) {
            countFrame++;
            for (int i = 0; i < b.size();i++) {
                if (countFrame == frameTarget) {
                    b.get(i).update();

                }
            }
            countFrame = 0;
        }
    }


    public void run() { // took from air stirke project. Temporary code

        Thread me = Thread.currentThread();
        while (thread == me) {
            repaint();
            try {
                thread.sleep(25);
            } catch (InterruptedException e) {
                break;
            }

        }
    }

    public void start() {
        thread = new Thread(this);
        thread.start();
    }

}
