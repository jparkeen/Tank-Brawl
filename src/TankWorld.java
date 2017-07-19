/**
 * Created by EmEm on 7/13/2017.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.image.*;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.imageio.ImageIO;



// Task: This TankWorld class will hold all the main code of the tank game
public class TankWorld extends JPanel implements Runnable {
    private Thread thread;
    int x = 0, y = 0,add = 0;
    public String title;
    public int width, height;
    private Graphics g;
    private BufferedImage Image,background;
    static TankObject tankOne,tankTwo;
   // static GameEvent gameEvent;

    //private KeysControl keysControl;


    /*public TankWorld(String title, int width, int height){
        this.title = title;
        this.width = width;
        this.height = height;
        keysControl = new KeysControl();

    }*/

    public void init() {
        setFocusable(true);
        background = loadImages.loadImages("/resources/Background.png");

        this.tankOne = new TankObject(100, 50, "/resources/Tank_blue_basic_strip60-0-30.png", 1, "Tank 1",this);
        this.tankTwo = new TankObject(150, 150, "/resources/Tank_blue_basic_strip60-0-9.png", 2, "Tank 2",this);

       // gameEvent = new GameEvent();
        //keysControl = new KeysControl();




    }




    public void start() {
        thread = new Thread(this);
        thread.start();
    }

    public void paint(Graphics g) {
        //this is for testing
        if(this.tankOne.x == 100)
            this.add = -1;
        if(this.tankOne.x ==0)
            this.add = 1;
        this.tankOne.x += add;
        this.tankTwo.y += add;
        g.clearRect(0, 0, 600, 600);
        g.drawImage(background, 0, 0, this);
        g.drawImage(this.tankOne.image, this.tankOne.x, this.tankOne.y, this);
        g.drawImage(this.tankTwo.image, this.tankTwo.x, this.tankTwo.y, this);


    }

    private void update() {
        //keysControl.update();
    }

    public void run() { // took from air stirke project. Temporary code

        init();
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


    public static void main(String[] args) {

        TankWorld mainPanel = new TankWorld();
        JFrame f = new JFrame("Tank War!!!");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(mainPanel);
        f.pack();
        f.setSize(600, 600);
        f.setResizable(false);
        f.setLocationByPlatform(true);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
        mainPanel.start();

    }
}