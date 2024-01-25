import java.util.ArrayList;

public class VolvoWorkshop1 implements iCarWorkshop1{
    private final int maxCars = 5;
    private final ArrayList<Car> carsInService = new ArrayList<>(maxCars);


    @Override
    public void takeInCar(Car car) {
        if (carsInService.size() < 5) {
            if (car instanceof Volvo240) {
                carsInService.add(car);
            } else throw new IllegalArgumentException("Wrong car");
        } throw new IllegalArgumentException("Workshop is full");
    }

    @Override
    public Volvo240 returnCar(int carID) {
        for (int i = 0; i < carsInService.size(); i++) {
            if (carsInService.get(i).carID == carID) {
                return (Volvo240) carsInService.get(i);
            }
        } throw new IllegalArgumentException("No car found with given carID");
    }


}
