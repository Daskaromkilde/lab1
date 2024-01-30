import org.junit.jupiter.api.Test;

class CarWorkshopTest {

    @Test
    void takeInCar() {
        Saab95 saab = new Saab95();
        CarWorkshop workshop = new CarWorkshop(5,saab);
        workshop.takeInCar(saab);
        try {
            workshop.takeInCar(new Volvo240());
        }catch (IllegalArgumentException ignored)
        {

        }
        CarWorkshop anyCarWorkshop = new CarWorkshop(5, null);
        CarWorkshop volvoCarWorkshop = new CarWorkshop(3, new Volvo240());

        anyCarWorkshop.takeInCar(new Volvo240());
        anyCarWorkshop.takeInCar(new Saab95());

        volvoCarWorkshop.takeInCar(new Saab95());
    }

    @Test
    void cantFindCar() {
        Saab95 saab = new Saab95();
        saab.setModelName("mySaab");
        CarWorkshop workshop = new CarWorkshop(5,saab);
        workshop.takeInCar(saab);

        try {
            workshop.returnCar("notMySaab");
        }catch (IllegalArgumentException ignored){

        }
    }
}