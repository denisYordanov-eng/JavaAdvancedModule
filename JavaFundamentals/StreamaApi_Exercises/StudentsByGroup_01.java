package StreamaApi_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class StudentsByGroup_01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> studentsGroup = new HashMap<>();

        String inputLine = br.readLine();

        while (!"END".equalsIgnoreCase(inputLine)) {
            String[] tokens = inputLine.split("\\s+");

            String name = tokens[0] + " " + tokens[1];
            int group = Integer.parseInt(tokens[2]);
            studentsGroup.put(name, group);

            inputLine = br.readLine();
        }

        studentsGroup.entrySet().stream()
                .filter(g -> g.getValue() == 2)
                .sorted(Comparator.comparing(n -> n.getKey().split("\\s+")[0]))
                .forEach(s ->
                        System.out.println(s.getKey()));
    }
}
