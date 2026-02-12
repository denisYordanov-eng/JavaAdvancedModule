package animals;

public class Kitten extends Cat {
        public Kitten(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public void produceSound(){
        System.out.println("Miau");
    }

    @Override
    public void setGender(String gender) {
        if (gender == null || gender.isEmpty()) {
            throw new IllegalArgumentException("Invalid input!");
        }
        if (!gender.equalsIgnoreCase("Female")) {
            throw new IllegalArgumentException("Invalid input!");
        }
        super.setGender("Female");
    }

    @Override
    public String toString(){
            return super.toString();
    }
}
