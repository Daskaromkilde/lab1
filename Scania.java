import java.awt.*;
public class Scania extends Car{
    private final static int lowestBedAngle = 0;
    private final static int highestBedAngle = 70;
    private int bedAngle;

    public Scania() {
        super(2, 125, Color.BLUE, "Scania");
        setBedAngle(lowestBedAngle);
    }


    private void setBedAngle(int angle) {
        if (this.getCurrentSpeed() == 0 && isBedAngleValid(angle))
            this.bedAngle = angle;
    }

    @Override
    public double speedFactor() {
        return enginePower * 0.01;
    }

    public void gas(double amount) {
        if(this.bedAngle == lowestBedAngle) {
            super.gas(amount);
        }
    }


    public int getBedAngle() {
        return this.bedAngle;
    }

    public void higherBed() {
        int newAngle = this.getBedAngle() + 1;
        if (newAngle <= highestBedAngle) {
            this.setBedAngle(newAngle);
        }
    }

    public void lowerBed() {
        int newAngle = this.getBedAngle() - 1;
        if (newAngle >= lowestBedAngle) {
            this.setBedAngle(newAngle);
        }
    }

    private boolean isBedAngleValid(int angle) {
        return angle >= lowestBedAngle && angle <= highestBedAngle;
    }

}
