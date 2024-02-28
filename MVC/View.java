package MVC;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

public class View extends JPanel implements iObserver{

    ArrayList<Car> carMap = new ArrayList<>();
    ArrayList<CarWorkshop> workShopMap = new ArrayList<>();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < carMap.size(); i++) {
            BufferedImage im = carMap.get(i).carImage;
            int x = carMap.get(i).getPosition().x;
            int y = carMap.get(i).getPosition().y;
            g.drawImage(im, x, y, null);
        }

        for (int i = 0; i < workShopMap.size(); i++) {
            BufferedImage im = workShopMap.get(i).getVolvoWorkshopImage();
            int x = workShopMap.get(i).getWorkshopPosition().x;
            int y = workShopMap.get(i).getWorkshopPosition().y;
            g.drawImage(im, x, y, null);
        }

    }

    public View(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block


    }

    public void addCars(ArrayList<Car> cars) {
        for (int i = 0; i < cars.size(); i++) {
            carMap.add(cars.get(i));

        }
    }

    public void removeCar() {
        carMap.remove(carMap.size()-1);
    }
    public void addWorkshops(CarWorkshop workshop)
    {
            workShopMap.add(workshop);
    }

    @Override
    public void notifyOb() {
        getSize();
        repaint();
    }
}
