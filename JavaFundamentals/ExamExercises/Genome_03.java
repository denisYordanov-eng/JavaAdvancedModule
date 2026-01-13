package JavaAdvancedExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Genome_03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> allCreatures = new HashMap<>();

        String regexPattern = "(?<name>[!@#\\\\$?a-z]+)(=(?<nameLength>[0-9]+))(--(?<genesCount>[0-9]+))(<<(?<organism>[a-z]+))";
        Pattern pattern = Pattern.compile(regexPattern);

        String inputLine = br.readLine();

        while (!inputLine.equals("Stop!")) {
            Matcher matcher = pattern.matcher(inputLine);
            if (matcher.matches()) {
                String name = matcher.group("name");
                int nameLength = Integer.parseInt(matcher.group("nameLength"));
                int genesCount = Integer.parseInt(matcher.group("genesCount"));
                String organism = matcher.group("organism");

                String realName = findRealName(name);
                if (realName.length() == nameLength) {
                    allCreatures.put(organism, allCreatures.getOrDefault(organism, 0) + genesCount);
                }
            }
            inputLine = br.readLine();
        }
        allCreatures.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(entry -> {
                    System.out.printf("%s has genome size of %d%n", entry.getKey(), entry.getValue());
                });
    }

    private static String findRealName(String name) {
        StringBuilder realName = new StringBuilder();
        for (char currentChar : name.toCharArray()) {
            if (Character.isLetter(currentChar)) {
                realName.append(currentChar);
            }
        }
        return realName.toString();
    }
}

