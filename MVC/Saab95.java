package MVC;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Saab95 extends Car implements iTurbo {

    protected boolean turboOn;
    BufferedImage im;

    public Saab95(){
        super(2, 125, Color.red, "MVC.Saab95", 1.9);

        try{
            im = ImageIO.read(Objects.requireNonNull(Panel.class.getResourceAsStream("pics/Saab95.jpg")));
        }catch (IllegalArgumentException | IOException ignored)
        {

        } setCarImage(im);

    }


    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn){
            turbo = 1.3;
        }
        return enginePower * 0.01 * turbo;
    }

    @Override
    public void setTurbo(boolean b) {
        turboOn = b;
    }


}
