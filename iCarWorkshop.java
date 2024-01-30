public interface iCarWorkshop<C extends Car> {
    void takeInCar(C car);
    C returnCar(String modelName);
}
