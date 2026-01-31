package encapsulation_exercise.class_box.pizza.calories;

public class Dough {
    private String flourType;

    private String bakingTechnique;

    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    public void setFlourType(String flourType) {
        switch (flourType.trim()) {
            case "White":
                this.flourType = flourType;
                break;
            case "Wholegrain":
                this.flourType = flourType;
                break;
            default:
                throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    public void setBakingTechnique(String bakingTechnique) {
        switch (bakingTechnique.trim()) {
            case "Crispy":
                this.bakingTechnique = bakingTechnique;
                break;
            case "Chewy":
                this.bakingTechnique = bakingTechnique;
                break;
            case "Homemade":
                this.bakingTechnique = bakingTechnique;
                break;
            default:
                throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    public void setWeight(double weight) {
        if (weight <= 0 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        double flourModifier = getTheModifier();
        double bakingModifier = getTheBakingModifier();

        return (2 * this.weight) * flourModifier * bakingModifier;
    }

    private double getTheBakingModifier() {
        switch (this.bakingTechnique) {
            case "Crispy":
                return 0.9;
            case "Chewy":
                return 1.1;
            case "Homemade":
                return 1.0;
        }
        return 0;
    }

    private double getTheModifier() {
        switch (this.flourType) {
            case "White":
                return 1.5;
            case "Wholegrain":
                return 1.0;
        }
        return 0;
    }
}
