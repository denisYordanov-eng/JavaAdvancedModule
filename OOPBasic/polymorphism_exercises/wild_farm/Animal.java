package wild_farm;

public abstract class Animal {
    private String name;
    private double weight;
    private int foodEaten;

    protected Animal(String name, double weight) {
        this.name = name;
        this.weight = weight;
        this.foodEaten = 0;
    }

    protected abstract void makeSound();

    protected abstract void eat(Food food);

    public int getFoodEaten() {
        return foodEaten;
    }

    public void setFoodEaten(int foodEaten) {
        this.foodEaten = foodEaten;
    }

    protected String getName() {
        return name;
    }

    protected double getWeight() {
        return weight;
    }

}
