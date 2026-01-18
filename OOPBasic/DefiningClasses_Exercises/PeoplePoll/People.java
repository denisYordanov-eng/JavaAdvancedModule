package DefiningClass_Exercises.PeoplePoll;

public class People {
    private String firstName;

    private int age;

    public People() {
    }

    public  People(String firstName, int age) {
        this.firstName = firstName;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
