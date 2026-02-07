package fragileBaseClass;

import java.util.ArrayList;

public class Animal {
    protected ArrayList<Food> foodEaten;

    public Animal(ArrayList<Food> foodEaten) {
        this.foodEaten = new ArrayList<>();
    }

    public final void eat(Food food){
        foodEaten.add(food);
    }

    public void eatAll(Food[] foods, Food[] foods1){
        for (Food food : foods) {
            eat(food);
        }
    }
}
