package FunctionalProgramming_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty_11 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> names = readGuests(br);

        getCommands(br, names);

        printGuestsOutput(names);

    }

    private static void printGuestsOutput(List<String> names) {
        if (names.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            String guestList = String.join(", ", names);
            System.out.printf("%s are going to the party!%n", guestList);
        }

    }

    private static void getCommands(BufferedReader br, List<String> names) throws IOException {


        String commandLine = br.readLine();

        while (!commandLine.equals("Party!")) {
            String[] command = commandLine.split("\\s+");
            String action = command[0];
            String condition = command[1];
            String criteria = command[2];

            Predicate<String> predicate = getPredicate(condition, criteria);

            switch (action) {
                case "Remove":
                    names.removeIf(predicate);
                    break;

                case "Double":
                    for (int i = 0; i < names.size(); i++) {
                        String person = names.get(i);
                        if (predicate.test(person)) {
                            names.add(i + 1, person);
                            i++;
                        }
                    }
                    break;
            }
            commandLine = br.readLine();
        }
    }

    private static List<String> readGuests(BufferedReader br) throws IOException {
        return Arrays.stream(br.readLine().split("\\s+"))
                .collect(Collectors.toList());
    }

    private static Predicate<String> getPredicate(String condition, String criteria) {
        switch (condition) {
            case "StartsWith":
                return name -> name.startsWith(criteria);
            case "EndsWith":
                return name -> name.endsWith(criteria);
            case "Length":
                return name -> name.length() == Integer.parseInt(criteria);
        }
        return name -> false;
    }
}
