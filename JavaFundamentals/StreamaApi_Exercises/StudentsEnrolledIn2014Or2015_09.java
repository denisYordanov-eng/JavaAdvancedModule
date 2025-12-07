package StreamaApi_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class StudentsEnrolledIn2014Or2015_09 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> idMarks = new LinkedHashMap<>();
        fillMap(bufferedReader, idMarks);

        filterAndPrintMap(idMarks);
    }

    private static void filterAndPrintMap(Map<String, String> idMarks) {
        idMarks.entrySet().stream()
                .filter(entry -> entry.getKey().endsWith("14") || entry.getKey().endsWith("15"))
                .forEach(entry -> System.out.println(entry.getValue()));
    }

    private static void fillMap(BufferedReader bufferedReader, Map<String, String> idMarks) throws IOException {
        String input = bufferedReader.readLine().trim();

        while (!"END".equalsIgnoreCase(input)) {

            String studentId = input.substring(0, input.indexOf(" "));
            String marks = input.substring(input.indexOf(" "), input.length());
            idMarks.put(studentId, marks);

            input = bufferedReader.readLine().trim();

        }
    }
}
