import MVC.CarWorkshop;
import MVC.Saab95;
import MVC.Volvo240;
import org.junit.jupiter.api.Test;

class CarWorkshopTest {

    @Test
    void takeInCar() {
        Saab95 saab = new Saab95();
        Volvo240 volvo = new Volvo240();

        CarWorkshop<Saab95> saabworkshop = new CarWorkshop(5);
        saabworkshop.takeInCar(saab);
//        saabworkshop.takeInCar(volvo); //static

    }

    @Test
    void cantFindCar() {
        Saab95 saab = new Saab95();
        saab.setModelName("mySaab");
        CarWorkshop workshop = new CarWorkshop(5);
        workshop.takeInCar(saab);

        try {
            workshop.returnCar("notMySaab");
        }catch (IllegalArgumentException ignored){

        }
    }
}