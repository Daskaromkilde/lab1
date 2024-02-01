import java.awt.*;
public class Scania extends Truck{
    private final static int lowestBedAngle = 0;
    private final static int highestBedAngle = 70;

    public Scania() {
        super(2, 125, Color.BLUE, "Scania", 3.6);
        setRamp(0,lowestBedAngle);
    }



}
