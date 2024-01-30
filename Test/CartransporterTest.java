import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class CartransporterTest {



    @Test
    void addCar() {
        Cartransporter t = new Cartransporter();
        Volvo240 v = new Volvo240();
        v.setPosition(new Point(0,0));
        t.setPosition(new Point(0,0));
        Saab95 s = new Saab95();
        s.setPosition(new Point(0,0));
        t.lowerBed();
        t.addCar(v);
        t.addCar(s);
        try
        {
            assertTrue(t.loadedCars.size() == 2);
            assertEquals(t.findAndRemoveSpecificCar(v.getModelName()), v);
            assertEquals(t.findAndRemoveSpecificCar(s.getModelName()), s);
        } catch (IllegalArgumentException ignored)
        {
            assertTrue(false);
        }

        try{
            for (int i = 0; i < 10; i++) {
               t.addCar(s);
            }
            assertTrue(false);

        }catch (IllegalArgumentException ignored){
            assertTrue(true);
        }
        try
        {
            Scania sc = new Scania();
            t.addCar(sc);
            assertTrue(false);

        }catch (IllegalArgumentException ignored)
        {
            assertTrue(true);
        }
        try
        {
            Cartransporter ct = new Cartransporter();
            t.addCar(ct);
            assertTrue(false);
        }catch (IllegalArgumentException ignored)
        {
            assertTrue(true);
        }
    }

    @Test
    void findAndRemoveCar() {
        Cartransporter t = new Cartransporter();
        Volvo240 v = new Volvo240();
        Saab95 s = new Saab95();
        t.lowerBed();

        t.addCar(v);
        t.addCar(s);

        assertEquals(t.findAndRemoveSpecificCar(v.getModelName()), v);
        assertEquals(t.findAndRemoveSpecificCar(s.getModelName()), s);


        try {
            t.findAndRemoveSpecificCar(v.getModelName());
            t.findAndRemoveSpecificCar(s.getModelName());
        } catch (IllegalArgumentException ignored) {
            assertTrue(true);
        }
    }

    @Test
    void samePosition () {
        Cartransporter t = new Cartransporter();
        Volvo240 v = new Volvo240();
        t.lowerBed();
        v.setPosition(new Point(96,200));
        t.setPosition(new Point(100,200));
        v.transporter(t);
        t.addCar(v);

        Point x = t.getPosition();
        Point y = v.getPosition();
        assertEquals(x, y);

        t.findAndRemoveSpecificCar(v.getModelName());
        System.out.println(v.getPosition());

    }

    @Test
    void removeCar() {
        Cartransporter t = new Cartransporter();
        Volvo240 v = new Volvo240();
        Saab95 s = new Saab95();
        t.lowerBed();

        t.addCar(v);
        t.addCar(s);
        t.removeLastCar();
        t.removeLastCar();

        assertTrue(t.loadedCars.size() == 0);
        assertTrue(t.inRange(v.getPosition()));
        assertTrue(t.inRange(s.getPosition()));
    }


    @Test
    void inRange() {
        Cartransporter t = new Cartransporter();
        Volvo240 v = new Volvo240();
        t.lowerBed();

        t.setPosition(new Point(0,0));
        v.setPosition(new Point(0,0));

        assertTrue(t.inRange(v.getPosition()));
        v.setPosition(new Point(t.getPosition().x+t.inRangeUnit * 2,t.getPosition().x+t.inRangeUnit * 2));
        assertFalse(t.inRange(v.getPosition()));
    }
}