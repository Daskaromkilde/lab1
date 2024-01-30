import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnyCarWorkshopTest {

    @Test
    void takeInCar() {

    }

    @Test
    void cantFindCar() {
        Saab95 saab = new Saab95();
        saab.setModelName("mySaab");
        AnyCarWorkshop workshop = new AnyCarWorkshop();
        workshop.takeInCar(saab);

        try {
            workshop.returnCar("notMySaab");
        }catch (IllegalArgumentException ignored){

        }
    }
}