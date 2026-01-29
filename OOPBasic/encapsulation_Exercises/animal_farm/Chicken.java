package encapsulation_exercise.class_box.animal_farm;

import java.util.Formatter;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        setName(name);
        setAge(age);
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    public void setAge(int age) {
        if (age < 0 || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    private String calculateProductPerDay() {
        //•	First 6 years it produces 2 eggs per day [0 - 5]
        //•	Next 6 years it produces 1 egg per day [6 - 11]
        //•	And after that it produces 0.75 eggs per day
        if (this.age <= 5) {
            return "2";
        } else if (this.age <= 11) {
            return "1";
        } else {
            return "0.75";
        }
    }

    @Override
    public String toString() {
        return String.format("Chicken %s (age %d) can produce %s eggs per day.",
                this.name, this.age, this.calculateProductPerDay());
    }
}
