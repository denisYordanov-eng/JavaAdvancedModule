package inheritance_exercises.person_and_child_p01;

public class Child extends Person {

    public Child(String name, int age) {
        super(name, age);
    }

    @Override
    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age must be positive!");
        }
        if (age > 15) {
            throw new IllegalArgumentException("Child's age must be lesser than 15!");
        }
        super.setAge(age);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
