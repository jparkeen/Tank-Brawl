package core;

import commons.AudioPlayer;
import commons.Globals;
import commons.MapReader;
import commons.TankOrientation;
import components.Bullet;
import components.Explosion;
import components.KeysControl;
import components.TankObject;
import components.CollisionDetector;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Iterator;


@SuppressWarnings("serial")
public class TankWorld extends JComponent implements Runnable {

    private String[][] map;

    private TankObject tank1;

    private TankObject tank2;

    private Thread thread;

    private KeysControl keysControl;

    int health = 16, lives = 2;

    private AudioPlayer playMusic,explosionSound;

    private CollisionDetector collision;

    private ArrayList<Bullet> bullets;


   public ArrayList<Explosion> explosions ;


    public TankWorld() throws IOException {
        this.map = MapReader.readMap(Globals.MAP1_FILENAME);
        this.bullets = new ArrayList<Bullet>(1000);
        this.explosions = new ArrayList<Explosion>(1000);

        setFocusable(true);
        playMusic = new AudioPlayer(this, "resources/backgroundTune.wav");
        playMusic.play();
        playMusic.loop();

        setInitialTankLocation();

        explosionSound = new AudioPlayer(this,"resources/snd_explosion1.wav");

        collision = new CollisionDetector(map);
        this.keysControl = new KeysControl(collision,this.tank1,this.tank2,bullets,explosions);
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
                    this.tank1 = new TankObject(x, y, tank1_file, 1, "Player 1",health,lives,10,this, TankObject.TANK_1_NAME);
                    map[row][col] = MapReader.SPACE;
                    continue;
                }
                if (value.equals(MapReader.TANK_2)) {
                    this.tank2 = new TankObject(x, y, tank1_file, 2, "Player 2",health,lives,10,this, TankObject.TANK_2_NAME);
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
        moveBullets(tank1.orientation, tank2.orientation);
        renderExplosion(g2);

        if(collision.isGameOver()) {
            renderGameOver(g2);
        }
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

    public void renderGameOver(Graphics2D g2) {
        Image image = Toolkit.getDefaultToolkit().getImage("resources/gameover/gameover_" + collision.getTankWon().tankName +".png");
        int low = Globals.BOARD_SIZE/4;
        int high = 2 * low;
        g2.drawImage(image, low, low, high, high, this);
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
        Iterator<Bullet> iter = bullets.iterator();

        while (iter.hasNext()) {
            Bullet bullet = iter.next();
            if (collision.validateBullettoWallCollision(bullet) ||
                    collision.validateBullettoTankCollision(bullet, tank1, tank2)) {
                Explosion explosion = new Explosion(bullet.getX(),bullet.getY());
                explosions.add(explosion);
                explosionSound.play();
                iter.remove();
            } else {
                bullet.moveBullet();
            }
        }
    }

    public void renderExplosion(Graphics2D g2){
        for(int i = 0; i < explosions.size();i++) {
            Explosion exp = explosions.get(i);
            Image image = exp.nextImageOrNull();
            if (image == null) {
                explosions.remove(exp);
                exp = null;
            } else {
                g2.drawImage(image,(int) exp.getX(),(int) exp.getY(), this);
                g2.finalize();
            }
        }
        }


    public void run() {
        Thread me = Thread.currentThread();
        while (thread == me) {
            repaint();
            try {
                thread.sleep(15);
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
