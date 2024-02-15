import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize

    // To keep track of a single car's position

    BufferedImage volvoWorkshopImage;
    Point volvoWorkshopPoint = new Point(300,0);
     ArrayList<Touple<Car,Point>> carMap = new ArrayList<>();

    // TODO: Make this general for all cars
    void moveit(int x, int y, Car c){
        for (int i = 0; i < carMap.size(); i++) {
            if (carMap.get(i).getFirst().equals(c)) {
                carMap.get(i).setSecond(new Point(x,y));
            }
        }

    }
    public void addCars(ArrayList<Car> cars)
    {
        for (int i = 0; i < cars.size(); i++) {
            int y = 0;
            Point p = new Point(0, y);
            carMap.add(new Touple<Car,Point>(cars.get(i), p));
            y += 100;

        }
    }


    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {
            volvoWorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < carMap.size(); i++) {
           BufferedImage im = carMap.get(i).getFirst().carImage;
            int x = carMap.get(i).getSecond().x;
            int y = carMap.get(i).getSecond().y;
           g.drawImage(im,x,y, null );
        }
        g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null);

/*
        g.drawImage(volvoImage, volvoPoint.x, volvoPoint.y, null); // see javadoc for more info on the parameters
        g.drawImage(saabImage, saabPoint.x, saabPoint.y, null);
        g.drawImage(scaniaImage, scaniaPoint.x, scaniaPoint.y, null);
        */
    }
}
