import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void performAction() {
    }

    @Test
    void getPosition() {
    }

    @Test
    void setPosition() {
    }

    @Test
    void getModelName() {
    }

    @Test
    void getTurbo() {
    }

    @Test
    void setCurrentSpeed() {
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
    }

    @Test
    void getEnginePower() {
    }

    @Test
    void getCurrentSpeed() {
    }

    @Test
    void getColor() {
    }

    @Test
    void setColor() {
    }

    @Test
    void startEngine() {
    }

    @Test
    void stopEngine() {
    }

    @Test
    void setTurboOn() {
    }

    @Test
    void setTurboOff() {
    }

    @Test
    void incrementSpeed() {
    }

    @Test
    void decrementSpeed() {
    }

    @Test
    void gas() {
        Volvo240 v = new Volvo240();
        double c = v.getCurrentSpeed();
        v.gas(0.25);
        assertTrue(c < v.getCurrentSpeed());

    }

    @Test
    void brake() {
        Volvo240 v = new Volvo240();
        v.gas(0.25);
        double c = v.getCurrentSpeed();
        v.brake(0.25);
        assertTrue(c > v.getCurrentSpeed());
    }

    @Test
    void move() {
    }

    @Test
    void turnLeft() {
        Volvo240 car = new Volvo240();
        car.setDirection(eDirection.WEST);

        car.turnLeft();

        assertEquals(eDirection.SOUTH, car.getDirection(), "When west, result==south");


    }

    @Test
    void turnRight() {
        Saab95 car = new Saab95();
        car.setDirection(eDirection.NORTH);
        car.turnRight();
        assertEquals(eDirection.EAST, car.getDirection(), "When north, result==east");
    }
}