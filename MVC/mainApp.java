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
        cc.View.addCars(module.getCars());


        // Start the timer
    }


}
