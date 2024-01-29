import java.util.ArrayList;
import java.util.List;

public class VolvoWorkshop implements iCarWorkshop<Volvo240> {
    private final int maxCars = 5;
    private final List<Volvo240> carsInService = new ArrayList<>(maxCars);

    @Override
    public void takeInCar(Volvo240 car) {
        if (carsInService.size() < maxCars) {
            if (car instanceof Volvo240) {
                carsInService.add(car);
            } else {
                throw new IllegalArgumentException("Wrong car");
            }
        } else {
            throw new IllegalArgumentException("Workshop is full");
        }
    }

    @Override
    public Volvo240 returnCar(String ModelName) {
        for (int i = 0; i < carsInService.size(); i++) {
            if (carsInService.get(i).getModelName().equals(ModelName)) {
                return carsInService.get(i);
            }
        } throw new IllegalArgumentException("No car found with given modelName");
    }



}
