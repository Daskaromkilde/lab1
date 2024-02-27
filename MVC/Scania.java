package MVC;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Scania extends Truck{
    private final static int lowestBedAngle = 0;
    private final static int highestBedAngle = 70;
    BufferedImage im;


    public Scania() {
        super(2, 125, Color.BLUE, "MVC.Scania", 3.6);
        setRamp(0,lowestBedAngle);
        try
        {
            im = ImageIO.read(Objects.requireNonNull(View.class.getResourceAsStream("/pics123/Scania.jpg")));

        }catch (IllegalArgumentException | IOException ignored){

        }
        setCarImage(im);
    }



}
