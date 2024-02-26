package MVC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Module {

    private final int delay = 50;

    private Timer timer = new Timer(delay, new TimerListener());

    View frame; // ersätt med observers

     private ArrayList<Car> cars = new ArrayList<>();

     private CarWorkshop<Volvo240> carWorkshop;

    private Observable observable = new Observable();



    public Module()
    {
        addCars(new Volvo240());
        Saab95 saab = new Saab95();
        saab.setPosition(new Point(0,100));
        addCars(saab);
        Scania scania = new Scania();
        scania.setPosition(new Point(0,200));
        addCars(scania);

        liftBed();

        carWorkshop = new CarWorkshop(5);
        addWorkshops(carWorkshop);

        timer.start();
    }
    public void addCars(Car c)
    {
        cars.add(c);
        observable.notifyObservers();
    }
    public ArrayList<Car> getCars()
    {
        return cars;
    }
    public void addWorkshops(CarWorkshop<Volvo240> workshop)
    {
        carWorkshop = workshop;
    }

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : cars) {
                int x = (int) Math.round(car.getPosition().getX());
                int y = (int) Math.round(car.getPosition().getY());


                if (car.getPosition().x > frame.getSize().width - car.carImage.getWidth() || car.getPosition().x < 0) {
                    car.turnRight();
                    car.turnRight();

                    eDirection ed = car.getDirection();
                    car.move(ed);

                } else {
                    car.move(car.getDirection());
                }
                if (car instanceof Volvo240) {
                    if (workshopDetector((Volvo240) car, carWorkshop, frame.volvoWorkshopImage, frame.volvoWorkshopPoint)) {
                        break;
                    }
                }

                moveit(x, y, car);
                // repaint() calls the paintComponent method of the panel
                frame.repaint();
            }
        }

        private <T extends Car> boolean workshopDetector(T car, CarWorkshop<T> carWorkshop, BufferedImage image, Point point) {
            if (car.getPosition().x < image.getWidth() + point.x &&
                    car.getPosition().x > point.x &&
                    car.getPosition().y < image.getHeight() + point.y &&
                    car.getPosition().y >= point.y) {
                System.out.println("here");
                carWorkshop.takeInCar(car); //hjälp
                cars.remove(car);
                point = new Point(-100, -100);
                return true;
            }
            return false;
        }

    }// Calls the gas method for each car once
    public void gas(int amount) {
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
    void liftBed()
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
