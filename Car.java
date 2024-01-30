import java.awt.*;

public abstract class Car implements iCar, iMovable {


    private int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    //private boolean turboOn;
    private Point position;
    private eDirection direction;
    private Cartransporter cartransporter; // if null then not on transport
    protected double weight;


    public Car(int nrDoors, double enginePower, Color color, String modelName, double weight) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.weight = weight; // in tons
        this.position = new Point(0,0);  // The initial starting position of the car
        this.direction = eDirection.EAST; // The initial facing of the car
        stopEngine();
        this.setPosition(this.position);
    }


    public eDirection getDirection() {
        return direction;
    }

    public void setDirection(eDirection direction) {
        this.direction = direction;
    }


    public void transporter(Cartransporter c) {
        cartransporter = c;
    }

    public Point getPosition() {
        if (cartransporter != null) {
        return cartransporter.getPosition();
        }
        return new Point(this.position);
    }

    public void setPosition(Point position) {
        this.position = new Point(position);
    }

    public String getModelName() {
        return modelName;
    }


    public void setCurrentSpeed(double amount) {
        currentSpeed = amount;
    }
    public void setNrDoors(int amount){
        nrDoors = amount;
    }

    public void setModelName(String name) {
        modelName = name;
    }
    public int getNrDoors(){
        return nrDoors;
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



    public void incrementSpeed(double amount){
        if(getCurrentSpeed() + speedFactor() * amount <= enginePower
                && getCurrentSpeed() + speedFactor() * amount > 0
                && speedFactor() * amount >= 0) {
            setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower));
        }
    }

    public void decrementSpeed(double amount){
        if (amount * speedFactor() >= 0) {
            setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount, 0));
        }
    }

    public abstract double speedFactor();



    public void gas(double amount){
        if (amount > 0 && amount <= 1) {
            incrementSpeed(amount);
        }else {
            throw new IllegalArgumentException("invalid amount of acceleration");
        }
    }

    public void brake(double amount) {
        if (amount > 0 && amount <= 1) {
            decrementSpeed(amount);
        }else
        {
            throw new IllegalArgumentException("invalid amount of brake force");
        }
    }





    // Updates the movement in the direction the cars facing
    public void move(eDirection facing) {
        switch (facing) {
            case WEST: // GOING LEFT
                position.x -= (int) currentSpeed;
                break;
            case NORTH: // GOING UP
                position.y += (int) currentSpeed;
                break;
            case EAST: // GOING RIGHT
                position.x += (int) currentSpeed;
                break;
            case SOUTH: // GOING DOWN
                position.y -= (int) currentSpeed;
                break;
        }
    }



    public void turnLeft() {
            switch (this.direction ) {
                case WEST:
                    this.direction = eDirection.SOUTH;
                    break;
                case NORTH:
                    this.direction = eDirection.WEST;
                    break;
                case EAST:
                    this.direction = eDirection.NORTH;
                    break;
                case SOUTH:
                    this.direction = eDirection.EAST;
                    break;
            }
        }



    public void turnRight() {
        switch (this.direction) {
            case WEST:
                this.direction = eDirection.NORTH;
                break;
            case NORTH:
                this.direction = eDirection.EAST;
                break;
            case EAST:
                this.direction = eDirection.SOUTH;
                break;
            case SOUTH:
                this.direction = eDirection.WEST;
                break;
        }
    }


}