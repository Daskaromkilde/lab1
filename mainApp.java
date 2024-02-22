import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class mainApp {

    private final int delay = 50;

    private Timer timer = new Timer(delay, new CarController.TimerListener());

    static View frame;

    static Panel panel;
    static ArrayList<Car> cars = new ArrayList<>();

    static CarWorkshop<Volvo240> carWorkshop;

    public static void main(String[] args) {
        CarController cc = new CarController();
        cc.panel = new Panel("bonga", cc);
        cc.frame = panel.view;


        cc.cars.add(new Volvo240());

        Saab95 saab = new Saab95();
        saab.setPosition(new Point(0,100));
        cc.cars.add(saab);

        Scania scania = new Scania();
        scania.setPosition(new Point(0,200));
        cc.cars.add(scania);
        liftBed();

        carWorkshop = new CarWorkshop(5);
        // carWorkshopPosition = cc.frame.drawPanel.volvoWorkshopPoint;
        frame.addCars(cars);

        // Start the timer
        cc.timer.start();
    }



    private <T extends Car> boolean workshopDetector(T car, CarWorkshop<T> carWorkshop, BufferedImage image, Point point)
    {
        if (car.getPosition().x < image.getWidth() + point.x &&
                car.getPosition().x > point.x &&
                car.getPosition().y < image.getHeight() + point.y &&
                car.getPosition().y >= point.y )
        {
            System.out.println("here");
            carWorkshop.takeInCar(car); //hjälp
            cars.remove(car);
            point = new Point(-100, -100);
            return true;
        }
        return false;
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        for (Car car : cars
        ) {
            car.gas(amount);
        }
    }
    void brake()
    {
        double brake = 0.7;
        for (Car car : cars
        ) {
            car.brake(brake);
        }
    }
    static void liftBed()
    {
        for(Car car : cars)
        {
            if(car instanceof Truck)
            {
                ((Truck) car).higherBed();
            }
        }
    }
    void lowerBed()
    {
        for(Car car : cars)
        {
            if(car instanceof Truck)
            {
                ((Truck) car).lowerBed();
            }
        }
    }
    void turnTurbo(boolean b)
    {
        for (Car car : cars)
        {
            if(car instanceof iTurbo)
            {
                ((iTurbo) car).setTurbo(true);
            }
        }
    }

    void moveit(int x, int y, Car c){
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getPosition().equals(c)) {
                cars.get(i).setPosition(new Point(x,y));
            }
        }

    }


}
