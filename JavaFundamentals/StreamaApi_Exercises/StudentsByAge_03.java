package StreamaApi_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public class StudentsByAge_03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String,Integer> students = new LinkedHashMap<>();

        fillMap(br, students);

        filterAndPrintStudents(students);
    }

    private static void filterAndPrintStudents(Map<String, Integer> students) {
        students.entrySet().stream()
                .filter(n -> n.getValue() >= 18 && n.getValue() <= 24)
                .forEach(n ->
                        System.out.println(n.getKey() + " " +  n.getValue()));
    }

    private static void fillMap(BufferedReader br, Map<String, Integer> students) throws IOException {
        String inputLine = br.readLine().trim();

        while (!"END".equalsIgnoreCase(inputLine)) {
            String[] tokens = inputLine.split("\\s+");
            String name = tokens[0] + " " +  tokens[1];
            int age = Integer.parseInt(tokens[2]);
            students.put(name, age);

            inputLine = br.readLine().trim();
        }
    }
}
