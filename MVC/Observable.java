package MVC;

import java.util.ArrayList;

public class Observable {

    private ArrayList<Observer> observers = new ArrayList<>();

    public void addObservers(Observer observer){
        observer.add(observer);
    }
    public void removeObservers(iObserver observer){

    }
    public void notifyObservers() {

    }

}
