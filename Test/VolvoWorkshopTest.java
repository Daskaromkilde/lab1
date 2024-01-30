import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class VolvoWorkshopTest {
    public final int maxCars = 5;
    ArrayList<Volvo240> carsInService = new ArrayList<>(maxCars);

    @Test
    void workshopIsFullTryToAdd() {
        Volvo240 volvo = new Volvo240();
        VolvoWorkshop v = new VolvoWorkshop();
        v.takeInCar(volvo);
        v.takeInCar(volvo);
        v.takeInCar(volvo);
        v.takeInCar(volvo);
        v.takeInCar(volvo);

        try {
            v.takeInCar(volvo);
        }catch (IllegalArgumentException ignored) {
        }


    }

    @Test
    void returnCarAndCarIsVolvo() {
        Volvo240 volvo = new Volvo240();
        VolvoWorkshop v = new VolvoWorkshop();
        v.takeInCar(volvo);
        assertTrue(v.returnCar(volvo.getModelName()) instanceof Volvo240);


    }

}