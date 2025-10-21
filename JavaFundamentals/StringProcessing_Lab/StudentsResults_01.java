package StringProcessing_Lab;

import java.util.Scanner;

public class StudentsResults_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //initialize the data of the table
        String nameStr = "Name";
        String javaAdvanced = "JAdv";
        String javaOopStr = "JavaOOP";
        String javaAdvancedOopStr = "AdvOOP";
        String averageStr = "Average";

        //read name
        String[] input = scanner.nextLine().split("-");
        String studentName = input[0];

        //read grades
        String[] grades = input[1].split(",\\s+");
        double javaAdv = Double.parseDouble(grades[0]);
        double javaOop = Double.parseDouble(grades[1]);
        double advOop = Double.parseDouble(grades[2]);
        //calculate average degree
        double average = calculateTheAverage(javaAdv, javaOop, advOop);

        //format  and print the heading table
        String table = String.format("%1$-10s|%2$7s|%3$7s|%4$7s|%5$7s|",
                nameStr, javaAdvanced, javaOopStr, javaAdvancedOopStr, averageStr);
        System.out.println(table);
        //format and print the student information
        String studentInformation = String.format("%1$-10s|%2$7.2f|%3$7.2f|%4$7.2f|%5$7.4f|",
                studentName, javaAdv, javaOop, advOop, average);
        System.out.println(studentInformation);
    }

    private static double calculateTheAverage(double javaAdv, double javaOop, double advOop) {
        return (javaAdv + javaOop + advOop) / 3;
    }
}
