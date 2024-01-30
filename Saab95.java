import java.awt.*;

public class Saab95 extends Car implements iTurbo {

    protected boolean turboOn;

    public Saab95(){
        super(2, 125, Color.red, "Saab95", 1.9);
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
