import java.util.ArrayList;

public class VolvoWorkshop implements iCarWorkshop<Volvo240> {
    private final int maxCars = 5;
    private final ArrayList<Volvo240> carsInService = new ArrayList<>(maxCars);

    @Override
    public void takeInCar(Volvo240 car) {
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
                return carsInService.get(i);
            }
        } throw new IllegalArgumentException("No car found with given carID");
    }



}
