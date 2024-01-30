import java.util.ArrayList;
import java.util.List;
import java.awt.*;
import java.util.Stack;


public class Cartransporter extends Car {
    protected ArrayList<Car> loadedCars = new ArrayList<>();
    //private Car car;
    private boolean carConnected;
    private boolean rampDown;
    protected final int inRangeUnit = 5;
    private final int maxLoadedCars = 5;
    private final double maxWeightPerCar = 2.5;

    public Cartransporter() {
        super(2, 125, Color.RED, "TruckTransportingCars", 5.7);
    }

    public double speedFactor() {
        return enginePower * 0.01;
    }
    @Override
    public void gas(double amount) { // only gas if ramp is up
        if(!this.rampDown) {
            super.gas(amount);
        }
    }

    public void addCar(Car c) {
        if(!rampDown || !inRange(c.getPosition())) {
            throw new IllegalArgumentException("cant add car if ramp not lowered or car not in range");
        } if (c instanceof Cartransporter) {
            throw new IllegalArgumentException("cant add a car transporter");
        } if (loadedCars.size() >= maxLoadedCars) {
            throw new IllegalArgumentException("Cant add car. Transporter is full.");
        } if (c.weight > maxWeightPerCar) {
            throw new IllegalArgumentException("Car is too heavy");
        }
        c.transporter(this);
        loadedCars.add(c);
    }

    public Car findAndRemoveSpecificCar(String ModelName) {
        int size = loadedCars.size();

        for (int i = 0; i < size; i++) {
          if (loadedCars.get(i).getModelName().equals(ModelName)) {
              Car car = loadedCars.get(i);
              car.setPosition(new Point(getPosition().x + inRangeUnit/2, getPosition().y + inRangeUnit/2));
              car.transporter(null);
              return loadedCars.remove(i);
          }
        }
        throw new IllegalArgumentException("car dosen't exists in ramp");
    }

    public Car findAndRemoveSpecificCar(String ModelName) {
        int size = loadedCars.size();

        for (int i = 0; i < size; i++) {
          if (loadedCars.get(i).getModelName().equals(ModelName)) {
              Car car = loadedCars.get(i);
              car.setPosition(new Point(getPosition().x + inRangeUnit/2, getPosition().y + inRangeUnit/2));
              car.transporter(null);
              return loadedCars.remove(i);
          }
        }
        throw new IllegalArgumentException("car dosen't exists in ramp");
    }


    public void setRampDown(boolean b) {
        if (this.getCurrentSpeed() == 0) {
            this.rampDown = b;
        }
    }

    public boolean getRampDown() {
        return this.rampDown;
    }



    public boolean inRange(Point p) {
            return Math.abs(p.x - getPosition().x) < inRangeUnit &&  Math.abs(p.y - getPosition().y) < inRangeUnit;
    }

}
