package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class NotificationSystem extends Observable {
    private List<MyObserver> observers = new ArrayList<>();

    public void addObserver(MyObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(MyObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String message) {
        for (MyObserver observer : observers) {
            observer.update(message);
        }
    }
}
