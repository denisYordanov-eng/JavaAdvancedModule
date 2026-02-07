package fragileBaseClass;

import java.util.ArrayList;

public class Predator extends Animal {
    private int health;

    public Predator() {
        super(new ArrayList<>());
        this.health = 0;
    }


    public void feed(Food food){
        super.eat(food);
        this.health++;
    }

    public int getHealth() {
        return health;
    }
}
