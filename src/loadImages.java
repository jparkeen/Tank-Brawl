/**
 * Created by EmEm on 7/16/2017.
 */
import com.sun.deploy.ui.ImageLoader;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
public class loadImages {

    public static BufferedImage loadImages(String path) {
        try {
            return ImageIO.read(ImageLoader.class.getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
}

