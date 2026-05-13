package Models;

public class Person {
   private String userName;
   private Long id;

    public Person(String userName, Long id) {
        this.userName = userName;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }
}
