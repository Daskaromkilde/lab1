import java.awt.*;
public class Scania extends Car{
    private final static int lowestBedAngle = 0;
    private final static int highestBedAngle = 70;
    private int bedAngle;

    public Scania() {
        super(2, 125, Color.BLUE, "Scania");
        setBedAngle(lowestBedAngle);
    }


    public void gas(double amount, Scania truck){
        if(bedAngle == 0 && isTruckBedAngleValid(truck)) {
            gas(amount);
        }
    }



    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01;
    }

    public void setBedAngle(int angle) {
        this.bedAngle = angle;
    }

    public int getBedAngle() {
        return this.bedAngle;
    }


    public boolean isTruckBedAngleValid(Scania truck) {
        return truck != null && lowestBedAngle <= truck.getBedAngle() && truck.getBedAngle() <= highestBedAngle;
    }



}
