import java.awt.*;

public class Volvo240 extends Car{
    final static double trimFactor = 1.25;

    public Volvo240(){
        setNrDoors(4);
        setColor(Color.black);
        setEnginePower(100);
        setModelName("Volvo240");
        stopEngine();
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
