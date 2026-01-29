package encapsulation_Lab.first_and_reserve_team;

class Person {
    private String name;

    private int age;

    private double salary;

    public Person(String name, int age, double salary) {
        setName(name);
        setAge(age);
        setSalary(salary);
    }

    int getAge() {
        return age;
    }

    void setName(String name) {
        this.name = name;
    }

    void setAge(int age) {
        this.age = age;
    }

    void setSalary(double salary) {
        this.salary = salary;
    }
}
