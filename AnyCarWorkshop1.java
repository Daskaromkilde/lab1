import java.util.ArrayList;

public class AnyCarWorkshop1 implements iCarWorkshop1{
    private final int maxCars = 10;
    private final ArrayList<Car> carsInService = new ArrayList<>(maxCars);


    @Override
    public void takeInCar(Car car) {
        if (carsInService.size() < 5) {
            carsInService.add(car);
        } else throw new IllegalArgumentException("Workshop is full");
    }


    @Override
    public Car returnCar(int carID) {
        for (int i = 0; i < carsInService.size(); i++) {
            if (carsInService.get(i).carID == carID) {
                return carsInService.get(i);
            }
        } throw new IllegalArgumentException("No car found with given carID");
    }



}
