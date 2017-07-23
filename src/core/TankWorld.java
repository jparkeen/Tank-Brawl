package core;

import commons.AudioPlayer;
import commons.Globals;
import commons.MapReader;
import commons.TankOrientation;
import components.Bullet;
import components.Explosion;
import components.KeysControl;
import components.TankObject;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


@SuppressWarnings("serial")
public class TankWorld extends JComponent implements Runnable {

    private String[][] map;

    public static TankObject tank1;

    public static TankObject tank2;

    private Thread thread;

    private KeysControl keysControl;
    int health = 30, lives = 2;

    Random generator = new Random(123456789);

    static int countFrame = 0;
    static int frame = 1;

    AudioPlayer playMusic,explosionSound;

    public static ArrayList<Bullet> bullets = new ArrayList<Bullet>(1000);
    public static ArrayList<Explosion> explosions = new ArrayList<Explosion>();


    public TankWorld() throws IOException {
        this.map = MapReader.readMap(Globals.MAP1_FILENAME);

        setFocusable(true);
        playMusic = new AudioPlayer(this, "resources/backgroundTune.wav");
        playMusic.play();
        playMusic.loop();
        setInitialTankLocation();

        explosionSound = new AudioPlayer(this,"resources/snd_explosion1.wav");

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
        renderBullets(g2);
        renderExplosion(g2);
        moveBullets(tank1.orientation, tank2.orientation);
    }

    private void renderTankCurrentLocation(Graphics2D g2) {
        if(tank1 != null || tank2 != null){
            countFrame++;
        }
        if (countFrame == frame) {
            tank1.drawTank(g2);
            tank2.drawTank(g2);
            countFrame = 0;
        }
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

    public void renderBullets(Graphics2D g2) {
        for (Bullet b : bullets) {
            Image image = Toolkit.getDefaultToolkit().getImage("resources/bullets/bullets_"
                    + b.getOrientation().name().toLowerCase() + ".png");
            g2.drawImage(image, (int)b.getX(), (int)b.getY(), this);
            g2.finalize();
        }
    }

    public void moveBullets(TankOrientation tankOrientation1, TankOrientation tankOrientation2) {
        assert tankOrientation1 != null : "tank1 orientation cannot be null";
        assert tankOrientation2 != null : "tank2 orientation cannot be null";
        for (Bullet b : bullets) {
            b.moveBullet();
        }
    }

    public void renderExplosion(Graphics2D g2){
       for (Explosion exp : explosions){
            Image image = Toolkit.getDefaultToolkit().getImage("resources/explosion1_1.png");
            g2.drawImage(image,(int)exp.getX(),(int)exp.getY(),this);
            g2.finalize();
            }
        }








    public void run() {
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
        thread.setPriority(Thread.MIN_PRIORITY);
        thread.start();
    }

}
