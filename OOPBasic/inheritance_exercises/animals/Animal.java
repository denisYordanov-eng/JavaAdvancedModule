package animals;

public class Animal {
    private String name;

    private int age;

    private String gender;

    public Animal(String name, int age, String gender) {
        setName(name);
        setAge(age);
        setGender(gender);
    }

    public void produceSound() {
        System.out.println("Not implemented!");
    }

    private void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.name = name;
    }

    private void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.age = age;
    }

    public void setGender(String gender) {
        if (gender == null || gender.isEmpty()) {
                throw new IllegalArgumentException("Invalid input!");
            }
        if (!gender.equalsIgnoreCase("Male")
                && !gender.equalsIgnoreCase("Female")) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.gender = gender;
    }
    @Override
    public String toString(){
        return String.format("%s %d %s" ,this.name, this.age, this.gender);
    }
}
