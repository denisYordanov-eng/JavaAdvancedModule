package StreamaApi_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentsJoinedToSpecialties_11 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<StudentSpecialties> studentSpecialties = new ArrayList<>();
        fillStudentSpecialties(br, studentSpecialties);

        List<Students> students = new ArrayList<>();
        fillStudentsList(students, br);

        joinStudentsAndSpecialities(studentSpecialties, students);
    }

    private static void joinStudentsAndSpecialities(List<StudentSpecialties> studentSpecialties, List<Students> students) {
        students.stream()
                .sorted(Comparator.comparing(Students::getStudentName))
                .forEach(student ->
                        studentSpecialties.stream()
                                .filter(specialty -> specialty.facultNumber.equals(student.facultNumber))
                                .forEach(specialty ->
                                        System.out.printf("%s %s %s%n"
                                                , student.getStudentName()
                                                , specialty.getFacultNumber(), specialty.specialtyName)));
    }

    private static void fillStudentsList(List<Students> students, BufferedReader br) throws IOException {
        String input = br.readLine().trim();

        while (!("END").equalsIgnoreCase(input)) {
            String[] inputArr = input.split("\\s+");
            String facultyNumber = inputArr[0];
            String name = inputArr[1] + " " + inputArr[2];

            Students student = new Students();
            student.setStudentName(name);
            student.setFacultNumber(facultyNumber);

            students.add(student);

            input = br.readLine().trim();
        }
    }

    private static void fillStudentSpecialties(BufferedReader br, List<StudentSpecialties> studentSpecialties) throws IOException {
        String inputLine = br.readLine().trim();
        while (!inputLine.equalsIgnoreCase("Students:")) {
            String[] tokens = inputLine.split("\\s+");
            String specialtyName = tokens[0] + " " + tokens[1];
            String facNumber = tokens[2];

            StudentSpecialties subject = new StudentSpecialties();
            subject.setSpecialtyName(specialtyName);
            subject.setFacultNumber(facNumber);

            studentSpecialties.add(subject);

            inputLine = br.readLine().trim();
        }
    }

    static class StudentSpecialties {
        private String specialtyName;
        private String facultNumber;

        public String getSpecialtyName() {
            return specialtyName;
        }

        public void setSpecialtyName(String specialtyName) {
            this.specialtyName = specialtyName;
        }

        public String getFacultNumber() {
            return facultNumber;
        }

        public void setFacultNumber(String facultNumber) {
            this.facultNumber = facultNumber;
        }
    }

    static class Students {
        private String studentName;
        private String facultNumber;
        private List<StudentSpecialties> studentSpecialties;

        public String getStudentName() {
            return studentName;
        }

        public void setStudentName(String studentName) {
            this.studentName = studentName;
        }

        public String getFacultNumber() {
            return facultNumber;
        }

        public void setFacultNumber(String facultNumber) {
            this.facultNumber = facultNumber;
        }

        public List<StudentSpecialties> getStudentSpecialties() {
            return studentSpecialties;
        }

        public void setStudentSpecialties(List<StudentSpecialties> studentSpecialties) {
            this.studentSpecialties = studentSpecialties;
        }
    }
}
