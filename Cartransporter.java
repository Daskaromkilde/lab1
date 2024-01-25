import java.util.ArrayList;
import java.util.List;
import java.awt.*;
import java.util.Stack;


public class Cartransporter extends Car implements iTruckBed{
    protected Stack<Car> loadedCars = new Stack<>();
    private Car car;
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
        loadedCars.push(c);
    }

    public Car findCar(String ModelName) {
        int size = loadedCars.size();

        for (int i = 0; i < size; i++) {
          if (loadedCars.get(i).getModelName().equals(ModelName)) {
              return loadedCars.get(i);
          }
        }
        throw new IllegalArgumentException("car dosen't exists in ramp");
    }

    public void removeCar(Car c) {
        if(!rampDown) {
            throw new IllegalArgumentException("cant add car if ramp not lowered");
        }

        Stack<Car> carpoped = new Stack<>();
        int size = loadedCars.size();

        for (int i = 0; i < size; i++) {
          Car pop = loadedCars.pop();
          if (pop.equals(c)) {
              pop.setPosition(new Point(getPosition().x + inRangeUnit/2, getPosition().y + inRangeUnit/2));
              break;
          }
          carpoped.push(pop);
        }
        for (int i = 0; i < carpoped.size(); i++) {
            loadedCars.push(carpoped.pop());
        }
    }


    public void setRampDown(boolean b) {
        if (this.getCurrentSpeed() == 0) {
            this.rampDown = b;
        }
    }

    public boolean getRampDown() {
        return this.rampDown;
    }



    public boolean inRange(Point p)
    {
            return Math.abs(p.x - position.x) > inRangeUnit &&  Math.abs(p.y - position.y) > inRangeUnit;
    }

}
