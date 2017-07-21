package core;

import commons.MapReader;
import commons.TankOrientation;
import components.KeysControl;
import components.TankObject;
import components.loadImages;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@SuppressWarnings("serial")
public class TankWorld extends JComponent implements Runnable {

    public static int BLOCK_SIZE = 30;

    public static int BOARD_SIZE = 600;

    public static int MAX_NUMBER_OF_BLOCKS = 20;

    private String[][] map;

    public static String MAP1_FILENAME = "maps/map1.csv";

    public static TankObject tank1;

    public static TankObject tank2;

    private Thread thread;

//    int x = 0, y = 0,add = 0;
//    private Graphics g;
//    private BufferedImage Image,background;
//    static TankObject tankOne,tankTwo;

    private KeysControl keysControl;
    int health = 30, lives = 2;

    public TankWorld() throws IOException {
        this.map = MapReader.readMap(MAP1_FILENAME);

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


        for (int row = 0; row < MAX_NUMBER_OF_BLOCKS; row++) {
            for (int col = 0; col < MAX_NUMBER_OF_BLOCKS; col++) {
                String value = map[row][col];
                int y = row * BLOCK_SIZE;
                int x = col * BLOCK_SIZE;
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
        renderTankCurentLocation(g2);
    }

    private void renderTankCurentLocation(Graphics2D g2) {
        renderTank(g2, tank1.getTankName(), tank1.x, tank1.y);
        renderTank(g2, tank2.getTankName(), tank2.x, tank2.y);
    }

    private void renderMap(Graphics2D g2) {

        for (int row = 0; row < MAX_NUMBER_OF_BLOCKS; row++) {
            for (int col = 0; col < MAX_NUMBER_OF_BLOCKS; col++) {
                String value = map[row][col];
                int y = row * BLOCK_SIZE;
                int x = col * BLOCK_SIZE;
                if (value.equals(MapReader.WALL)) {
                    renderWall(g2, x, y);
                    continue;
                }
                if (value.equals(MapReader.SPACE)) {
                    // Do nothing
                    continue;
                }
                if (value.equals(MapReader.TANK_1)) {
                    renderTank(g2, tank1.getTankName(), x, y);
                    continue;
                }
                if (value.equals(MapReader.TANK_2)) {
                    renderTank(g2, tank2.getTankName(), x, y);
                    continue;
                }
            }
        }
    }

    private void renderTank(Graphics2D g2, String tank, int x, int y) {
        Image image = Toolkit.getDefaultToolkit().getImage("resources/tank/" + tank + "/tank_left.png");
        g2.drawImage(image, x, y, BLOCK_SIZE, BLOCK_SIZE, this);
        g2.finalize();
    }


    private void renderWall(Graphics2D g2, int x, int y) {
        Image image = Toolkit.getDefaultToolkit().getImage("resources/UnbreakableWall.png");
        g2.drawImage(image, x, y, BLOCK_SIZE, BLOCK_SIZE, this);
        g2.finalize();
    }

    public void renderBackground(Graphics2D g2) {
        Image image = Toolkit.getDefaultToolkit().getImage("resources/Background.png");
        g2.drawImage(image, 0, 0, BOARD_SIZE, BOARD_SIZE, this);
        g2.finalize();
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
