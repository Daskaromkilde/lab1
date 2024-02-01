import java.awt.*;

public class Truck extends Car{
    protected boolean rampDown;
    private int bedAngle;

    public Truck(int nrDoors, int enginePower, Color color, String name, double weight) {
        super(2,125, Color.RED, "Truck", 5.7);
    }

    @Override
    public double speedFactor() {
         return enginePower * 0.01;
    }

    @Override
    public void gas(double amount) {
        if(!rampDown) {
            super.gas(amount);
        }else
        {
            throw new IllegalArgumentException("Can't gas if ramp is down");
        }
    }
    public void setRamp(int i, int lowestBedAngle)
    {

        this.bedAngle = i;
        if(bedAngle != lowestBedAngle) {
            rampDown = false;
        }else {
            rampDown = true;
        }
    }

    public int getBedAngle() {
        return this.bedAngle;
    }

    public void higherBed(int highestBedAngle, int lowestBedAngle) {
        int newAngle = this.getBedAngle() + 1;
        if (newAngle <= highestBedAngle) {
            this.setRamp(newAngle, lowestBedAngle);
        }
    }
    public void higherBed() {
        rampDown = false;
    }

    public void lowerBed(int lowestBedAngle) {
        int newAngle = this.getBedAngle() - 1;
        if (newAngle >= lowestBedAngle) {
            this.setRamp(newAngle, lowestBedAngle);
        }
    }
    public void lowerBed() {
        rampDown = true;
    }

}
