package StreamaApi_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class WeakStudents_08 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<Integer>> studentsMarks = new LinkedHashMap<>();

        fillMap(br, studentsMarks);

        filterAndPrintMap(studentsMarks);
    }

    private static void filterAndPrintMap(Map<String, List<Integer>> studentsMarks) {
        studentsMarks.entrySet().stream()
                .filter(entry -> entry.getValue()
                        .stream()
                        .filter(m -> m <= 3)
                        .count() >= 2)
                .forEach(entry -> System.out.println(entry.getKey()));
    }

    private static void fillMap(BufferedReader br, Map<String, List<Integer>> studentsMarks) throws IOException {
        String input = br.readLine().trim();
        while (!"END".equals(input)) {
            String[] tokens = input.split("\\s+");
            String name = tokens[0] + " " + tokens[1];
            List<Integer> marks = new ArrayList<>();

            for (int i = 2; i < tokens.length; i++) {
                marks.add(Integer.parseInt(tokens[i]));
            }

            studentsMarks.put(name, new ArrayList<>(marks));
            input = br.readLine().trim();
        }
    }
}
