package MVC;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Volvo240 extends Car{
    final static double trimFactor = 1.25;
    BufferedImage im;



    public Volvo240(){
        super(4, 100, Color.black, "MVC.Volvo240", 1.9);

        try{
           im = ImageIO.read(Objects.requireNonNull(View.class.getResourceAsStream("/pics123/Volvo240.jpg")));
          //  im= ImageIO.read(new File("pics123/Volvo240.jpg"));
        }catch (IllegalArgumentException | IOException ignored)
        {
            System.out.println("bajs");
        } setCarImage(im);
    }


    @Override
    public double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }

}
