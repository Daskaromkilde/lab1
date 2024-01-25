import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScaniaTest {

    static Scania scania = new Scania();

    @BeforeAll
    public static void init() {
        scania = new Scania();
    }

    @Test
    void gasWhenBedNotDown() {
        scania.higherBed();
        scania.gas(0.7);
        assertNotEquals(0.875, scania.getCurrentSpeed());
    }

    @Test
    void speedFactor() {
    }

    @Test
    void setBedAngle() {
    }

    @Test
    void getBedAngle() {
    }

    @Test
    void isTruckBedAngleValid() {
    }
}