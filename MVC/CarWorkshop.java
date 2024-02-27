package MVC;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.*;

public class CarWorkshop<C extends Car> { //need to extend car because of THIS123
    private final int maxCars;
    private BufferedImage volvoWorkshopImage;
    private Point position = new Point(300, 0);
    private final ArrayList<C> carsInService = new ArrayList<>();

    public CarWorkshop(int maxCars){
        this.maxCars = maxCars;
        try {
            volvoWorkshopImage = ImageIO.read(View.class.getResourceAsStream("/pics123/VolvoBrand.jpg"));

        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    public Point getWorkshopPosition() {
        return position;
    }

    public BufferedImage getVolvoWorkshopImage() {
        return volvoWorkshopImage;
    }

    public void takeInCar(C c) {
        if (carsInService.size() < maxCars) {
            carsInService.add(c);
        } else throw new IllegalArgumentException("Workshop is full");
    }

    public C returnCar(String ModelName) {
        for (int i = 0; i < carsInService.size(); i++) {
            if (carsInService.get(i).getModelName().equals(ModelName)) { //getModel THIS123
                return carsInService.get(i);
            }
        } throw new IllegalArgumentException("No car found with given modelName");
    }

}



