import java.awt.*;

interface Interface {

    int getNrDoors();

    double getEnginePower();

    double getCurrentSpeed();

    Color getColor();

    void setColor(Color clr);

    void startEngine();

    void stopEngine();

    void setTurboOn();

    void setTurboOff();

   void gas(double amount);

   void brake(double amount);
}
