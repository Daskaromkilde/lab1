import java.awt.*; //?? color



public abstract class Car implements Interface,Movable {


    private int nrDoors; // Number of doors on the car                           BÅDA HAR
    private double enginePower; // Engine power of the car                       BÅDA HAR
    private double currentSpeed; // The current speed of the car                 BÅDA HAR
    private Color color; // Color of the car                                     BÅDA HAR
    private String modelName; // The car model name
    private boolean turboOn;
    private Point position = new Point(0, 0);


    void performAction(Direction facing) {
        switch (facing) {
            case WEST:
                position.x -= currentSpeed;
                position.y = 0;
                break;
            case NORTH:
                position.x = 0;
                position.y += currentSpeed;
                break;
            case EAST:
                position.x += currentSpeed;
                position.y = 0;
                break;
            case SOUTH:
                position.x = 0;
                position.y -= currentSpeed;
                break;
            default:
                // FACING "NOTHING"
                System.out.println("Invalid direction");
                break;
        }
    }



    public Point getPosition() {
        return new Point(this.position);
    }

    public void setPosition(Point position) {
        this.position = new Point(position);
    }

    public String getModelName() {
        return modelName;
    }

    public boolean getTurbo(){
       return turboOn;
   }
    public void setCurrentSpeed(double amount) {
        currentSpeed = amount;
    }
    public void setNrDoors(int amount){
        nrDoors = amount;
    }
    public void setEnginePower(int amount) {
        enginePower = amount;
    }
    public void setModelName(String name) {
        modelName = name;
    }
    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr) {
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }

    public void setTurboOn(){
        turboOn = true;
    }

    public void setTurboOff(){
        turboOn = false;
    }

    public abstract void incrementSpeed(double amount);
    public abstract void decrementSpeed(double amount);


    public void gas(double amount){
        if (amount > 0 && amount <= 1) {
            incrementSpeed(amount);
        }else {
            throw new IllegalArgumentException("to much acceleration");
        }
    }

    public void brake(double amount) {
        if (amount > 0 && amount <= 1) {
            decrementSpeed(amount);
        }else
        {
            throw new IllegalArgumentException("to much brake force");
        }
    }





    public void move(Direction direction) {
        performAction(direction);
    }


    public void turnLeft() {

    }


    public void turnRight() {

    }
}