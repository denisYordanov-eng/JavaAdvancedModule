package StreamaApi_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class FilterStudentsByPhone_06 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> namePhones = new LinkedHashMap<>();

        fillMap(namePhones, br);
        filterAndPrintMap(namePhones);
    }

    private static void filterAndPrintMap(Map<String, String> namePhones) {
     String  pattern = "+3592";
     String  patternTwo = "02";


        namePhones.entrySet().stream()
                .filter(n -> n.getValue().startsWith(pattern) || n.getValue().startsWith(patternTwo))
                .forEach(entry -> System.out.println(entry.getKey()));
    }

    private static void fillMap(Map<String, String> namePhones, BufferedReader br) throws IOException {
        String inputLine = br.readLine().trim();
        while (!"END".equalsIgnoreCase(inputLine)) {
            String[] tokens = inputLine.split("\\s+");
            String firstName = tokens[0] +  " " + tokens[1];
            String phoneNumber = tokens[2];

            namePhones.put(firstName, phoneNumber);

            inputLine = br.readLine().trim();
        }
    }
}
