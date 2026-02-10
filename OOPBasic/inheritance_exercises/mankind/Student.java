package inheritance_exercises.mankind;

public class Student extends Human {
    private String facultyNumber;

    public Student(String firstName, String lastName, String facultyNumber) {
        super(firstName, lastName);
        setFacultyNumber(facultyNumber);
    }

    private void setFacultyNumber(String facultyNumber) {
        if (facultyNumber != null && !facultyNumber.trim().isEmpty()) {
            if (facultyNumber.length() < 5 || facultyNumber.length() > 10) {
                throw new IllegalArgumentException("Invalid faculty number!");
            }
            this.facultyNumber = facultyNumber;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("First Name: %s", super.getFirstName()));
        builder.append(System.lineSeparator());
        builder.append(String.format("Last Name: %s", super.getLastName()));
        builder.append(System.lineSeparator());
        builder.append(String.format("Faculty number: %s", facultyNumber));
        return builder.toString();
    }
}


