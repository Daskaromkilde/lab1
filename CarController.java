//import MVC.*;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.image.BufferedImage;
//import java.util.ArrayList;
//
///*
//* This class represents the MVC.Controller part in the MVC pattern.
//* It's responsibilities is to listen to the CView and responds in a appropriate manner by
//* modifying the model state and the updating the CView.
// */
//
//public class CarController {
//    // member fields:
//
//
//    // The delay (ms) corresponds to 20 updates a sec (hz)
//    private final int delay = 50;
//    // The timer is started with a listener (see below) that executes the statements
//    // each step between delays.
//    private Timer timer = new Timer(delay, new TimerListener());
//
//    // The frame that represents this instance CView of the MVC pattern
//    static CView frame;
//    // A list of cars, modify if needed
//    static Panel panel;
//    static ArrayList<Car> cars = new ArrayList<>();
//
//    static CarWorkshop<Volvo240> carWorkshop;
//    //static Point carWorkshopPosition;
//
//    //methods:
//
//    public static void main(String[] args) {
//        // Instance of this class
//        CarController cc = new CarController();
//
//        // Start a new CView and send a reference of self
//        cc.panel = new Panel("bonga", cc);
//        cc.frame = panel.CView;
//
//
//        cc.cars.add(new Volvo240());
//
//        Saab95 saab = new Saab95();
//        saab.setPosition(new Point(0,100));
//        cc.cars.add(saab);
//
//        Scania scania = new Scania();
//        scania.setPosition(new Point(0,200));
//        cc.cars.add(scania);
//       liftBed();
//
//       carWorkshop = new CarWorkshop(5);
//      // carWorkshopPosition = cc.frame.drawPanel.volvoWorkshopPoint;
//        frame.addCars(cars);
//
//        // Start the timer
//        cc.timer.start();
//    }
//
//    /* Each step the TimerListener moves all the cars in the list and tells the
//    * CView to update its images. Change this method to your needs.
//    * */
//    private class TimerListener implements ActionListener {
//
//
//
//        public void actionPerformed(ActionEvent e) {for (Car car : cars) {
//                int x = (int) Math.round(car.getPosition().getX());
//                int y = (int) Math.round(car.getPosition().getY());
//
//
//            if (car.getPosition().x > frame.getSize().width - car.carImage.getWidth() || car.getPosition().x < 0)
//                {
//                    car.turnRight();
//                    car.turnRight();
//
//                    eDirection ed = car.getDirection();
//                    car.move(ed);
//
//                }else
//                {
//                    car.move(car.getDirection());
//                }
//            if(car instanceof Volvo240) {
//                if (workshopDetector ((Volvo240) car,carWorkshop, frame.volvoWorkshopImage, frame.volvoWorkshopPoint))
//                {
//                    break;
//                }
//            }
//
//                moveit(x, y, car);
//                // repaint() calls the paintComponent method of the panel
//                frame.repaint();
//            }
//        }
//    }
//
//    private <T extends Car> boolean workshopDetector(T car, CarWorkshop<T> carWorkshop, BufferedImage image, Point point)
//    {
//        if (car.getPosition().x < image.getWidth() + point.x &&
//                car.getPosition().x > point.x &&
//                car.getPosition().y < image.getHeight() + point.y &&
//                car.getPosition().y >= point.y )
//        {
//            System.out.println("here");
//                carWorkshop.takeInCar(car); //hjälp
//                cars.remove(car);
//                point = new Point(-100, -100);
//                return true;
//        }
//        return false;
//    }
//
//    // Calls the gas method for each car once
//    void gas(int amount) {
//        for (Car car : cars
//                ) {
//            car.gas(amount);
//        }
//    }
//    void brake()
//    {
//        double brake = 0.7;
//        for (Car car : cars
//        ) {
//            car.brake(brake);
//        }
//    }
//     static void liftBed()
//    {
//        for(Car car : cars)
//        {
//            if(car instanceof Truck)
//            {
//                ((Truck) car).higherBed();
//            }
//        }
//    }
//    void lowerBed()
//    {
//        for(Car car : cars)
//        {
//            if(car instanceof Truck)
//            {
//                ((Truck) car).lowerBed();
//            }
//        }
//    }
//    void turnTurbo(boolean b)
//    {
//        for (Car car : cars)
//        {
//            if(car instanceof iTurbo)
//            {
//                ((iTurbo) car).setTurbo(true);
//            }
//        }
//    }
//
//    void moveit(int x, int y, Car c){
//        for (int i = 0; i < cars.size(); i++) {
//            if (cars.get(i).getPosition().equals(c)) {
//                cars.get(i).setPosition(new Point(x,y));
//            }
//        }
//
//    }
//
//
//}
