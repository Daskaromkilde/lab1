import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    static ArrayList<Car> cars = new ArrayList<>();

    static CarWorkshop<Volvo240> carWorkshop;
    //static Point carWorkshopPosition;

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();


        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);
        cc.cars.add(new Volvo240());

        Saab95 saab = new Saab95();
        saab.setPosition(cc.frame.drawPanel.saabPoint);
        cc.cars.add(saab);

        Scania scania = new Scania();
        scania.setPosition(cc.frame.drawPanel.scaniaPoint);
        cc.cars.add(scania);

       liftBed();

       carWorkshop = new CarWorkshop(5);
      // carWorkshopPosition = cc.frame.drawPanel.volvoWorkshopPoint;

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {for (Car car : cars) {
                int x = (int) Math.round(car.getPosition().getX());
                int y = (int) Math.round(car.getPosition().getY());


            if (car.getPosition().x > frame.getSize().width- frame.drawPanel.volvoImage.getWidth() || car.getPosition().x < 0)
                {
                    car.turnRight();
                    car.turnRight();

                    eDirection ed = car.getDirection();
                    car.move(ed);

                }else
                {
                    car.move(car.getDirection());
                }

                if (car.getPosition().x < frame.drawPanel.volvoWorkshopImage.getWidth() + frame.drawPanel.volvoWorkshopPoint.x &&
                    car.getPosition().x > frame.drawPanel.volvoWorkshopPoint.x &&
                        car.getPosition().y < frame.drawPanel.volvoWorkshopImage.getHeight() + frame.drawPanel.volvoWorkshopPoint.y &&
                        car.getPosition().y > frame.drawPanel.volvoWorkshopPoint.y)
                {
//                        carWorkshop.takeInCar(car);

                }
                frame.drawPanel.moveit(x, y, car);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = amount;
        for (Car car : cars
                ) {
            car.gas(gas);
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
}
