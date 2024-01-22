import java.awt.*;

public class Volvo240 extends Car{
    final static double trimFactor = 1.25;

    public Volvo240(){
        super(4, 100, Color.black, "Volvo240");
    }
    @Override
    public void incrementSpeed(double amount){
        if(getCurrentSpeed() + speedFactor() * amount <= getEnginePower()
                && getCurrentSpeed() + speedFactor() * amount > 0
                && speedFactor() * amount >= 0) {
            setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()));
        }
    }
    @Override
    public void decrementSpeed(double amount){
        if (amount * speedFactor() >= 0) {
            setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount, 0));
        }
    }
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }

}
