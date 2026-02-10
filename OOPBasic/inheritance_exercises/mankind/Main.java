package inheritance_exercises.mankind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 2; i++) {
            String[] input = reader.readLine().split("\\s+");

            switch (input.length) {
                case 3:
                    String firstName = input[0];
                    String lastName = input[1];
                    String facultyNumber = input[2];
                    try {
                        Student student = new Student(firstName, lastName, facultyNumber);
                        System.out.println(student);
                    } catch (IllegalArgumentException iae) {
                        System.out.println(iae.getMessage());
                        return;
                    }
                    break;
                case 4:
                    String fName = input[0];
                    String lName = input[1];
                    double weekSalary = Double.parseDouble(input[2]);
                    double hoursWorked = Double.parseDouble(input[3]);

                    try {
                        Worker worker = new Worker(fName, lName, weekSalary, hoursWorked);
                        System.out.println(worker);
                    } catch (IllegalArgumentException iae) {
                        System.out.println(iae.getMessage());
                        return;
                    }
                    break;
            }
        }
    }
}
