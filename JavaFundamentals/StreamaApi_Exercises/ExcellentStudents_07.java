package StreamaApi_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExcellentStudents_07 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<String>> studentsMarks = new LinkedHashMap<>();
        fillMap(br, studentsMarks);
        filterAndPrintMap(studentsMarks);

    }

    private static void filterAndPrintMap(Map<String, List<String>> studentsMarks) {
        studentsMarks.entrySet().stream()
                .filter(e -> e.getValue().contains("6"))
                .forEach(e -> {
                    System.out.println(e.getKey());
                });

    }

    private static void fillMap(BufferedReader br, Map<String, List<String>> studentsMarks) throws IOException {
        String inputLine = br.readLine().trim();
        while (!"END".equalsIgnoreCase(inputLine)) {
            String[] tokens = inputLine.split("\\s+");
            String Name = tokens[0] + " " + tokens[1];
            List<String> marks = new ArrayList<>();
            for (int i = 2; i < tokens.length; i++) {
                marks.add(tokens[i]);
            }

            studentsMarks.put(Name, new ArrayList<>(marks));
            inputLine = br.readLine().trim();
        }
    }
}
