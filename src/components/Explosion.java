package components;

import java.awt.*;
import javax.imageio.ImageIO;

/**
 * Created by EmEm on 7/15/2017.
 */
public class Explosion {

  public   int x;
  public   int y;
  private  int index;
  Image [] expImage;

    public Explosion(int x,int y){
        this.x = x;
        this.y = y;
        this.index = 0;
        this.expImage = new Image[6];
         expImage[0] = Toolkit.getDefaultToolkit().getImage("resources/explosion1_1.png");
         expImage[1] = Toolkit.getDefaultToolkit().getImage("resources/explosion1_2.png");
         expImage[2] = Toolkit.getDefaultToolkit().getImage("resources/explosion1_3.png");
         expImage[3] = Toolkit.getDefaultToolkit().getImage("resources/explosion1_4.png");
         expImage[4] = Toolkit.getDefaultToolkit().getImage("resources/explosion1_5.png");
         expImage[5] = Toolkit.getDefaultToolkit().getImage("resources/explosion1_6.png");


    }

    public Image nextImageOrNull(){

        if(index >= expImage.length ) {
            return null;

        }
            Image returnImage = expImage[index];
            index++;


        return returnImage;
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
}
