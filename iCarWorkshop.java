public interface iCarWorkshop<C extends Car> {
    void takeInCar(C car);
    C returnCar(int x);
}
