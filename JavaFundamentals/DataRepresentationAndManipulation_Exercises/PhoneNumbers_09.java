package DataRepresentationAndManipulation_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumbers_09 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = readInput(br);
        Pattern pattern = Pattern.compile("(?<name>[A-Z][A-Za-z]*)[^a-zA-Z+]*?(?<number>\\+?\\d[\\d\\s()./\\-]*\\d)");
        Map<String, String> phoneNumbers = new LinkedHashMap<>();
        putMatchesInMap(input, pattern, phoneNumbers);
        printOutput(phoneNumbers);
    }

    private static void printOutput(Map<String, String> phoneNumbers) {
        if (phoneNumbers.isEmpty()) {
            System.out.println("<p>No matches!</p>");
            return;
        }
            System.out.print("<ol>");
            for (Map.Entry<String, String> entry : phoneNumbers.entrySet()) {
                System.out.printf("<li><b>%s:</b> %s</li>", entry.getKey(), entry.getValue());
            }
            System.out.println("</ol>");

    }

    private static void putMatchesInMap(String input, Pattern pattern, Map<String, String> phoneNumbers) {
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            String name = matcher.group("name");
            String number = matcher.group("number");
            number = number.replaceAll("[^\\d+]", "");
            phoneNumbers.putIfAbsent(name, number);
        }
    }

    private static String readInput(BufferedReader br) throws IOException {
        StringBuilder sb = new StringBuilder();
        String inputLine = br.readLine();
        while (!inputLine.equals("END")) {
            sb.append(inputLine);
            inputLine = br.readLine();
        }
        return sb.toString();
    }
}
