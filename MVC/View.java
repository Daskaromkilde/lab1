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
           g.drawImage(im,x,y, null );
        }

        g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null);


    @Override
    public void notifyOb() {
        repaint();
    }
}
