import java.util.*;

public class AnyCarWorkshop<C extends Car> implements iCarWorkshop<C> {
    private final int maxCars = 10;
    private final ArrayList<C> carsInService = new ArrayList<>(maxCars);


    @Override
    public void takeInCar(C car) {
        if (carsInService.size() < 10) {
            carsInService.add(car);
        } else throw new IllegalArgumentException("Workshop is full");
    }


    @Override
    public C returnCar(int carID) {
        for (int i = 0; i < carsInService.size(); i++) {
            if (carsInService.get(i).carID == carID) {
                return carsInService.get(i);
            }
        } throw new IllegalArgumentException("No car found with given carID");
    }



}



