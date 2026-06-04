package models;

import contracts.Observer;

import java.util.ArrayList;
import java.util.List;

public  class AbstractMan {
    private String name;
    List<Observer> observers;

    protected AbstractMan(String name) {
        this.name = name;
        observers = new ArrayList<Observer>();
    }

    public String getName() {
        return this.name;
    }
}
