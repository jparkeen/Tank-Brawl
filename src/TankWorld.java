/**
 * Created by EmEm on 7/13/2017.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.*;


// Task: This TankWorld class will hold all the main code of the tank game
public class TankWorld implements Runnable {
    private Thread thread;
    public String title;
    public int width, height;
    private GameDisplay gameDisplay;
    private Graphics g;
    private BufferStrategy bufferStrategy;
    private Image Tank1, Tank2;



    public TankWorld(String title, int width, int height){
        this.title = title;
        this.width = width;
        this.height = height;
    }

    public void init(){

        gameDisplay = new GameDisplay(title, width, height);

    }


    public void start(){
        thread = new Thread(this);
        thread.start();
    }

    public void drawImage(){
           bufferStrategy = gameDisplay.getCanvas().getBufferStrategy();
           if(bufferStrategy == null){
               gameDisplay.getCanvas().createBufferStrategy(3);
               return;
           }

            g = bufferStrategy.getDrawGraphics();
            g.clearRect(0,0,width,height);
            g.setColor(Color.BLUE); // this is for testing will delete later
            g.fillRect(10,10,32,32); //also testing

            bufferStrategy.show();
            g.dispose();
    }

    public void update(){

    }

    public void run(){

        init();
        while(true) {
            update();
            drawImage();
        }
    }
}
