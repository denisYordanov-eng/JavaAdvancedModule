package models;

import contracts.Kingable;
import contracts.Observer;

public class King extends AbstractMan implements Kingable {

    public King(String name) {
        super(name);
    }


    @Override
    public void update() {
        System.out.printf("King %s is under attack!%n", super.getName());
    }

    @Override
    public void attack() {
        this.notifyObservers();
    }

    @Override
    public void notifyObservers() {
        for(Observer observerInstance : this.observers){
            observerInstance.update();
        }
    }

    @Override
    public void attachObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void detachObserver(Observer observer) {
        if (this.observers.contains(observer)) {
            this.observers.remove(observer);
        }
    }


}
