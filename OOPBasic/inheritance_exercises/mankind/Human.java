package inheritance_exercises.mankind;

public class Human {
    private String firstName;

    private String lastName;


    public Human(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
    }

    protected String getFirstName() {
        return firstName;
    }

    protected String getLastName() {
        return lastName;
    }

    private void setFirstName(String firstName) {
        if (firstName == null || !firstName.trim().isEmpty()) {
            if (!Character.isUpperCase(firstName.charAt(0))) {
                throw new IllegalArgumentException("Expected upper case letter!Argument: firstName");
            }

            if (firstName.length() < 4) {
                throw new IllegalArgumentException("Expected length at least 4 symbols!Argument: firstName");
            }
            this.firstName = firstName;
        }
    }

    protected void setLastName(String lastName) {
        if (lastName != null && !lastName.trim().isEmpty()) {
            if (!Character.isUpperCase(lastName.charAt(0))) {
                throw new IllegalArgumentException("Expected upper case letter!Argument: lastName");
            }

            if (lastName.length() < 3) {
                throw new IllegalArgumentException("Expected length at least 3 symbols!Argument: lastName");
            }
            this.lastName = lastName;
        }
    }
}
