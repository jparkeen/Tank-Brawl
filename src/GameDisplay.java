/**
 * Created by EmEm on 7/13/2017.
 */
import javax.swing.*;
import java.awt.*;


public class GameDisplay {
    private JFrame frame;
    private String title;
    private int width, height;
    private Canvas canvas;


    public GameDisplay(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        createGameDisplay();
    }

    private void createGameDisplay() {
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close down the program properly
        frame.setResizable(false);// can't change the size of the window
        frame.setVisible(true);
        frame.setLocationRelativeTo(null); // place the window at the center of the screen

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width,height));
        canvas.setFocusable(true);
        frame.add(canvas);
        frame.pack();

    }

    public Canvas getCanvas(){
        return canvas;
    }
}
