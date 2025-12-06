package StreamaApi_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class FilterStudentsByEmailDomain_05 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> nameEmails =  new LinkedHashMap<>();

        fillMap(br, nameEmails);
        filterAndPrintMap(nameEmails);
    }

    private static void filterAndPrintMap(Map<String, String> nameEmails) {
        String pattern = "@gmail.com";

        nameEmails.entrySet().stream()
                .filter(
                        e -> e.getValue().contains(pattern)
                ).forEach(e -> System.out.println(e.getKey()));
    }

    private static void fillMap(BufferedReader br, Map<String, String> nameEmails) throws IOException {
        String inputLine = br.readLine().trim();
        while (!"END".equalsIgnoreCase(inputLine)) {
        String[] tokens = inputLine.split("\\s+");
        String firstName = tokens[0] + " " + tokens[1];
        String email = tokens[2];
        nameEmails.put(firstName, email);

            inputLine = br.readLine().trim();
        }
    }
}
