package wild_farm;

import java.text.DecimalFormat;

public class Mammal extends Animal {
    private String livingRegion;

    public Mammal(String name, double weight,String livingRegion) {
        super(name, weight);
        this.livingRegion = livingRegion;
    }

    @Override
    protected void makeSound() {
    }

    protected String getLivingRegion() {
        return livingRegion;
    }

    @Override
    protected void eat(Food food) {
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %d]", getClass().getSimpleName()
                , super.getName(), df.format(super.getWeight())
                , this.livingRegion, super.getFoodEaten());
    }
}
