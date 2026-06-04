package models;

import contracts.Observer;

public class RoyalGuard extends AbstractMan implements Observer {

    public RoyalGuard(String name) {
        super(name);
    }

    @Override
    public void update() {
        System.out.printf("Royal Guard %s is defending!%n",super.getName());
    }
}
