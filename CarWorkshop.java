import java.util.*;

public class CarWorkshop<C> implements iCarWorkshop {
    private final int maxCars;
    private final C carType;
    private final ArrayList<Car> carsInService = new ArrayList<>();

    public CarWorkshop(int maxCars, C c){

        this.maxCars = maxCars;

        this.carType = c;
    }




    @Override
    public void takeInCar(Car car) {
        if (carsInService.size() < maxCars) {
            carsInService.add(car);
        } else throw new IllegalArgumentException("Workshop is full");
    }

    @Override
    public Car returnCar(String ModelName) {
        for (int i = 0; i < carsInService.size(); i++) {
            if (carsInService.get(i).getModelName().equals(ModelName)) {
                return carsInService.get(i);
            }
        } throw new IllegalArgumentException("No car found with given modelName");
    }

}



