package equality_logic;

public class Person {
    private String name;
    private Integer age;

    public Person(String name, int age) {
        this.name = name;
        this.age = Integer.valueOf(age);
    }

    public String getName() {
        return this.name;
    }

    public Integer getAge() {
        return this.age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Person person = (Person) o;
        return age.equals(person.age) && name.equals(person.name);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (age != null ? age.hashCode() : 0);
        return result;
    }
}
