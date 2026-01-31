package encapsulation_exercise.class_box.pizza.calories;

public class Topping {
    private String name;

    private double weight;

    public Topping(String name, double weight) {
        setName(name);
        setWeight(weight);
    }

    public void setName(String name) {
        switch (name.trim()) {
            case "Meat":
                this.name = name;
                break;
            case "Veggies":
                this.name = name;
                break;
            case "Cheese":
                this.name = name;
                break;
            case "Sauce":
                this.name = name;
                break;
            default:
                throw new IllegalArgumentException(String.format
                        ("Cannot place %s on top of your pizza.", name)
                );
        }
    }

    public void setWeight(double weight) {

        if (weight <= 0 || weight > 50) {
            throw new IllegalArgumentException(
                    String.format("%s weight should be in the range [1..50].", this.name)
            );
        }
        this.weight = weight;
    }

    public double calculateToppingCalories() {
        double toppingModifier = getModifier();
        return (2 * this.weight) * toppingModifier;
    }

    private double getModifier() {
        switch (this.name) {
            case "Meat":
                return 1.2;
            case "Veggies":
                return 0.8;
            case "Cheese":
                return 1.1;
            case "Sauce":
                return 0.9;
        }
        return 0;
    }
}
