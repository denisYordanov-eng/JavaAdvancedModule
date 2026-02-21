package wild_farm;

import java.text.DecimalFormat;

public class Cat extends Felime {

    private String breed;

    public Cat(String name, double weight, String livingRegion, String breed) {
        super(name, weight, livingRegion);
        this.breed = breed;
    }

    @Override
    public void eat(Food food) {
        int quantity = super.getFoodEaten();
        super.setFoodEaten(quantity += food.getQuantity());
    }
    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        return String.format("Cat[%s, %s, %s, %s, %d]"
                ,super.getName(),this.breed,df.format(super.getWeight()),super.getLivingRegion(),super.getFoodEaten());

    }
}
