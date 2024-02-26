package MVC;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

public class View extends JPanel implements iObserver{

    BufferedImage volvoWorkshopImage;
    Point volvoWorkshopPoint = new Point(300,0);
    ArrayList<Car> carMap;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < carMap.size(); i++) {
            BufferedImage im = carMap.get(i).carImage;
            int x = carMap.get(i).getPosition().x;
            int y = carMap.get(i).getPosition().y;
            g.drawImage(im, x, y, null);
        }

        g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null);
    }

    public View(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {
            volvoWorkshopImage = ImageIO.read(View.class.getResourceAsStream("pics/VolvoBrand.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    public void addCars(ArrayList<Car> cars)
    {
        for (int i = 0; i < cars.size(); i++) {
            int y = 0;
            Point p = new Point(0, y);
            carMap.add(cars.get(i));
            y += 100;

        }
    }


    @Override
    public void notifyOb() {
        repaint();
    }
}
