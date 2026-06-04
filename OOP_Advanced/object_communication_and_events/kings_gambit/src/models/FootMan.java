package models;

import contracts.Observer;

public class FootMan extends AbstractMan implements Observer {

    public FootMan(String name) {
        super(name);
    }

    @Override
    public void update() {
        System.out.printf("Footman %s is panicking!%n", super.getName());
    }
}
