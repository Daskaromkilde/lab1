import java.util.*;

public class CarWorkshop<C extends Car> { //need to extend car because of THIS123
    private final int maxCars;

    private final ArrayList<C> carsInService = new ArrayList<>();

    public CarWorkshop(int maxCars){
        this.maxCars = maxCars;
    }



    public void takeInCar(C c) {
        if (carsInService.size() < maxCars) {
            carsInService.add(c);
        } else throw new IllegalArgumentException("Workshop is full");
    }

    public C returnCar(String ModelName) {
        for (int i = 0; i < carsInService.size(); i++) {
            if (carsInService.get(i).getModelName().equals(ModelName)) { //getModel THIS123
                return carsInService.get(i);
            }
        } throw new IllegalArgumentException("No car found with given modelName");
    }

}



