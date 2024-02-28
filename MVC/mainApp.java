package MVC;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class mainApp {

    private final int delay = 50;



    public static void main(String[] args) {
        Module module = new Module();
        Controller cc = new Controller("bonga", module);
       // cc.View.addCars(module.getCars());
        for (int i = 0; i < module.getCars().size(); i++) {
            cc.View.addCars(module.getCars().get(i));
        }

        for (int i = 0; i < module.getCarWorkshops().size(); i++) {
            cc.View.addWorkshops(module.getCarWorkshops().get(i));
        }
        module.getObservable().addObservers(cc.View);


        // Start the timer
    }


}
