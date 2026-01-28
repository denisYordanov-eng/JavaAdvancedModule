package encapsulation_Lab.sortPeopleByNameAndAge;

 class Person {
    private String firstName;

    private String lastName;

    private int age;

     Person(String firstName, String lastName, int age) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
    }

     String getFirstName() {
        return this.firstName;
    }

     String getLastName() {
        return this.lastName;
    }
     int getAge() {
        return this.age;
    }

    void setFirstName(String firstName) {
        this.firstName = firstName;
    }

     void setLastName(String lastName) {
        this.lastName = lastName;
    }

     void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%s %s is %d years old.",this.firstName, this.lastName, this.age);
    }
}
