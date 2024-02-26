import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represents the animated part of the CView with the car images.
/*
public class CView extends JPanel{

    // Just a single image, TODO: Generalize

    // To keep track of a single car's position

    BufferedImage volvoWorkshopImage;
    Point volvoWorkshopPoint = new Point(300,0);
     ArrayList<MVC.Car> carMap;



    public void addCars(ArrayList<MVC.Car> cars)
    {
        for (int i = 0; i < cars.size(); i++) {
            int y = 0;
            Point p = new Point(0, y);
            carMap.add(cars.get(i));
            y += 100;

        }
    }


    // Initializes the panel and reads the images
    public CView(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {
            volvoWorkshopImage = ImageIO.read(CView.class.getResourceAsStream("pics/VolvoBrand.jpg"));
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
           BufferedImage im = carMap.get(i).carImage;
            int x = carMap.get(i).getPosition().x;
            int y = carMap.get(i).getPosition().y;
           g.drawImage(im,x,y, null );
        }

        g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null);
    }
}
