package MVC;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Module {

    private final int delay = 50;

    private Timer timer = new Timer(delay, new TimerListener());

   // View frame; // ersätt med observers

     private ArrayList<Car> cars = new ArrayList<>();

     private ArrayList<CarWorkshop> carWorkshops = new ArrayList<>();

    private Observable observable = new Observable();


    public Observable getObservable() {
       return observable;
    }

    public Module() {
        addCars(new Volvo240());
        Saab95 saab = new Saab95();
        saab.setPosition(new Point(0,100));
        addCars(saab);
        Scania scania = new Scania();
        scania.setPosition(new Point(0,200));
        addCars(scania);

        liftBed();
        CarWorkshop carWS = new CarWorkshop(5);

        carWorkshops.add(carWS);

        timer.start();
        observable.notifyObservers();
    }


    public void addListener (iObserver o) {
        observable.addObservers(o);
    }

    public ArrayList<CarWorkshop> getCarWorkshops() {
        return carWorkshops;
    }

    public void addCars(Car c) {
        cars.add(c);

        observable.notifyObservers();
        System.out.println(cars.size());
    }
    public ArrayList<Car> getCars() {
        return cars;
    }

    public Car randomCar() {
        ArrayList<Car> allCars = new ArrayList<>();
        allCars.add(new Volvo240());
        allCars.add(new Saab95());
        allCars.add(new Scania());
        int random = (int) (Math.random() * allCars.size());

       return allCars.get(random);
    }

    public void removeCars() {
        cars.remove(cars.size()-1);
        observable.notifyObservers();
    }


    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            CarWorkshop carWorkshop = carWorkshops.get(0);
            for (Car car : cars) {
                int x = (int) Math.round(car.getPosition().getX());
                int y = (int) Math.round(car.getPosition().getY());


                if (car.getPosition().x > 800 - car.carImage.getWidth() || car.getPosition().x < 0) { //frame.getSize().width
                    car.turnRight();
                    car.turnRight();

                    eDirection ed = car.getDirection();
                    car.move(ed);

                } else {
                    car.move(car.getDirection());
                }
                if (car instanceof Volvo240) {
                    if (workshopDetector((Volvo240) car, carWorkshop, carWorkshop.getVolvoWorkshopImage(), carWorkshop.getWorkshopPosition())) {
                        break;
                    }
                }

                moveit(x, y, car);
                // repaint() calls the paintComponent method of the panel
                //frame.repaint();

                observable.notifyObservers();
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
