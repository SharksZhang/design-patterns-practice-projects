package model;

import java.util.LinkedList;

public class Subject {
    private LinkedList<Observer> observers;

    public Subject() {
        this.observers = new LinkedList<>();
    }

    public void addObserver(Observer o){
        if(!observers.contains(o)){
            observers.add(o);
        }
    }

    public void notifyObservers(Subject Observable, double bid){
        for (Observer o : observers){
            o.update(this, bid);
        }
    }
}
