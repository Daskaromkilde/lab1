import java.util.ArrayList;
import java.util.List;
import java.awt.*;


public class Trailer extends Scania{
    private List<Car> lowerDec = new ArrayList<>();
    private List<Car> upperDec = new ArrayList<>();

    private Car car;
    private boolean carConnected;
    private Point position;


    private boolean rampDown;
    private int inRangeUnit = 5;


    public Trailer()
    {

    }
    public void setRampDown(boolean b)
    {
        this.rampDown = b;
    }
    public boolean getRampDown()
    {
        return rampDown;
    }

    public void setCar(Car c) //
    {
        if(c != null) {
            car = c;
            carConnected = true;
        }else
        {
            car = null;
            carConnected = false;
        }

    }
    public Point getPosition()
    {
        if (carConnected)
        {
            return car.getPosition();
        }
        return position;
    }

    public boolean inRange(Point p)
    {
            return Math.abs(p.x - position.x) > inRangeUnit &&  Math.abs(p.y - position.y) > inRangeUnit;
    }
    //Bilar kan endast lastas om rampen är nere, och de befinner sig rimligt nära biltransporten
    // (gör ett eget antagande, de exakta detaljerna är inte viktiga).
    //Bilar kan endast lossas om rampen är nere. De bör då hamna rimligt nära biltransporten.
    //Bilar kan endast lossas i omvänd ordning från hur de lastades, dvs den sista bilen som lastades måste vara först att lossas (first-in-last-out).
    //Biltransporten ska inte kunna lasta på en annan biltransport.
    //Under det att en bil är lastad på biltransporten ska dess position i världen alltid vara densamma som biltransportens position.

}
