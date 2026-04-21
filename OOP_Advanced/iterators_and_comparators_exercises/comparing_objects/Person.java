package comparing_objects;

public class Person implements Comparable<Person> {
    private String name;
    private Integer age;
    private String town;

    public Person(String name, Integer age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    @Override
    public int compareTo(Person personTwo) {
        int result = this.name.compareTo(personTwo.name);
        if (result == 0) {
            result = this.age.compareTo(personTwo.age);
        }
        if (result == 0) {
            result = this.town.compareTo(personTwo.town);
        }
        return result;
    }
}
