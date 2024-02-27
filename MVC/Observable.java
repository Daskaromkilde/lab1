package MVC;

import java.util.ArrayList;
import java.util.Observer;

public class Observable {

    private ArrayList<iObserver> observers = new ArrayList<>();

    public void addObservers(iObserver observer){
        observers.add(observer);
    }
    public void removeObservers(iObserver observer){
        observers.remove(observer);

    }
    public void notifyObservers() {
        //System.out.println(observers.size());
        for (iObserver observer : observers)
            observer.notifyOb();
    }

}
