package StreamaApi_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SortStudents_04 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       List<String[]> students = new ArrayList<>();

       fillList(br, students);
       sortAndPrintList(students);
    }

    private static void sortAndPrintList(List<String[]> students) {
        students.stream()
                .sorted(
                        Comparator.comparing((String[] a) -> a[1])
                               .thenComparing((String[] a) ->a[0], Comparator.reverseOrder()))
                .forEach(s -> System.out.println(s[0] + " " + s[1]));

    }

    private static void fillList(BufferedReader br, List<String[]> students) throws IOException {
            String input = br.readLine().trim();
            while (!"END".equals(input)) {
                String[] tokens = input.split("\\s+");
                String firstName = tokens[0];
                String lastName = tokens[1];
                students.add(new String[]{firstName, lastName});

                input = br.readLine().trim();
            }

    }
}
