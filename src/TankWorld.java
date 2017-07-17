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



// Task: This TankWorld class will hold all the main code of the tank game
public class TankWorld extends JPanel implements Runnable {
    private Thread thread;
    int x = 0, y = 0;
    public String title;
    public int width, height;
    private Graphics g;
    private BufferedImage Image;
    private KeysControl keysControl;


    /*public TankWorld(String title, int width, int height){
        this.title = title;
        this.width = width;
        this.height = height;
        keysControl = new KeysControl();

    }*/

    public void init() {

        Image = loadImages.loadImages("/resources/Tank_blue_basic_strip60-0-9.png");




    }

    public KeysControl getKeysControl() {
        return keysControl;
    }


    public void start() {
        thread = new Thread(this);
        thread.start();
    }

    public void paint(Graphics g) {
        x++;
        y++;

        g.setColor(Color.black);
        g.fillRect(x, y, 32, 32);
        g.drawImage(Image,32,32,null);


    }

    private void update() {
        keysControl.update();
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
       // f.setLocationByPlatform(true);
        f.setVisible(true);
        //f.setLocationRelativeTo(null);
        mainPanel.start();

    }
}