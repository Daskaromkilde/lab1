/*
import MVC.Saab95;
import MVC.Volvo240;
import MVC.eDirection;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    static Saab95 saab = new Saab95();

    static Volvo240 volvo = new Volvo240();
    @BeforeAll
    public static void init() {
        saab = new Saab95();
        volvo = new Volvo240();

    }


    @Test //
    void getPosition() {
        Point pos = new Point(50,100);
        saab.setPosition(pos);
        assertEquals(new Point(50,100), saab.getPosition());

    }

    @Test //
    void setPosition() {
        Point pos = new Point(550,100);
        Point newPost = new Point(100, -50);
        saab.setPosition(pos);
        assertEquals(new Point(550,100), saab.getPosition());
        saab.setPosition(newPost);
        assertEquals(new Point(100, -50), saab.getPosition());
    }

    @Test //
    void getModelName() {
        volvo.setModelName("MinFinaVolvo");
        assertEquals("MinFinaVolvo", volvo.getModelName());
        String volvoFul = "MinFulaVolvo";
        String volvoFin = volvo.getModelName();
        assertNotSame(volvoFul, volvoFin);
    }

    @Test
    void getTurbo() {
        saab.setTurbo(false);
        assertFalse(saab.turboOn,  "Turbo should be off by default");

        saab.setTurbo(true);
        assertTrue(saab.turboOn, "Turbo should be on after setting it on");

        saab.setTurbo(false);
        assertFalse(saab.turboOn, "Turbo should be off after setting it off");
    }

    @Test
    void setCurrentSpeed() {
        volvo.setCurrentSpeed(50);
        assertEquals(50, volvo.getCurrentSpeed(), "Current speed should be updated correctly");
    }

    @Test
    void setNrDoors() {
    }

    @Test
    void setEnginePower() {
    }

    @Test
    void setModelName() {
    }

    @Test
    void getNrDoors() {
        volvo.setNrDoors(2);
        assertEquals(2, volvo.getNrDoors());
        volvo.setNrDoors(4);
        assertEquals(4, volvo.getNrDoors());
    }

    @Test
    void getEnginePower() {
        volvo.enginePower = 200;
        assertEquals(200, volvo.enginePower, "Engine power should be updated correctly");

        volvo.enginePower = 100;
        assertEquals(100, volvo.enginePower, "Engine power should be updated correctly");
    }

    @Test
    void getCurrentSpeed() {
        volvo.setCurrentSpeed(50.0);
        assertEquals(50.0, volvo.getCurrentSpeed());
    }

    @Test
    void getColor() {
        volvo.setColor(Color.BLUE);
        assertEquals(Color.BLUE, volvo.getColor(), "Color should be updated correctly");

    }

    @Test
    void setColor() {
    }

    @Test
    void startEngine() {
        saab.startEngine();
        assertEquals(0.1, saab.getCurrentSpeed(), "Current speed should be set correctly when starting engine");
    }

    @Test
    void stopEngine() {
        volvo.stopEngine();
        assertEquals(0.0, volvo.getCurrentSpeed(), "Current speed should be 0 when stopping engine");
    }

    @Test
    void setTurboOn() {
        saab.setTurbo(true);
        assertTrue(saab.turboOn, "Turbo should be on");

    }

    @Test
    void setTurboOff() {
        saab.setTurbo(false);
        assertFalse(saab.turboOn, "Turbo should be off");
    }

    @Test
    void incrementSpeed() {
        saab.setTurbo(true);
        saab.setCurrentSpeed(45.0);
        saab.incrementSpeed(5.0);
        assertEquals(53.125, saab.getCurrentSpeed());

        volvo.setCurrentSpeed(32.0);
        volvo.incrementSpeed(7.0);
        assertEquals(40.75, volvo.getCurrentSpeed());

    }




    @Test
    void decrementSpeed() {
        saab.setTurbo(false);
        saab.setCurrentSpeed(40.0);
        saab.decrementSpeed(8.0);
        assertEquals(30.0, saab.getCurrentSpeed());

        volvo.setCurrentSpeed(60.0);
        volvo.decrementSpeed(9.0);
        assertEquals(48.75, volvo.getCurrentSpeed());
    }

    @Test
    void gas() {
        volvo.setCurrentSpeed(50);
        volvo.gas(0.7);
        assertEquals(50.875, volvo.getCurrentSpeed());

        try {
            volvo.gas(1.1);
            fail(" This didnt throw an IllegalArgumentException ");
        } catch (IllegalArgumentException ignored) {
        }

        volvo.setCurrentSpeed(99);
        volvo.gas(1);
        assertTrue(volvo.getCurrentSpeed() <= volvo.enginePower);


    }






    @Test
    void brake() {
        saab.setTurbo(true);
        saab.setCurrentSpeed(47);
        saab.brake(0.8);
        assertEquals(45.7, saab.getCurrentSpeed());

        try {
            saab.brake(-0.9);
            fail(" This didnt throw an IllegalArgumentException ");
        } catch (IllegalArgumentException ignored) { //swap ignored with "e"
        // enables to do System.out.println(e.getMessage);
            // which evaluetes to "too much brake force"
            }

    }

    @Test
    void move() {
        volvo.setCurrentSpeed(50);
        volvo.setDirection(eDirection.SOUTH);
        volvo.setPosition(new Point(100,50));
        volvo.move(volvo.getDirection());
        assertEquals(new Point(100,0), volvo.getPosition());
    }

    @Test
    void turnLeft() {
        volvo.setDirection(eDirection.WEST);

        volvo.turnLeft();

        assertEquals(eDirection.SOUTH, volvo.getDirection(), "When west, result==south");


    }

    @Test
    void turnRight() {
        saab.setDirection(eDirection.NORTH);
        saab.turnRight();
        assertEquals(eDirection.EAST, saab.getDirection(), "When north, result==east");
    }
}*/
