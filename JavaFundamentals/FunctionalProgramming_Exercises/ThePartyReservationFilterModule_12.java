package FunctionalProgramming_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ThePartyReservationFilterModule_12 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<String> names = new ArrayList<>(readNames(br));

        //initialize a map that saves predicant as value and key command type and filter type
        Map<String, Predicate<String>> filters = new LinkedHashMap<>();

        //first put and remove all filters and map then manipulate names
        String commandLine = br.readLine();
        while (!("Print").equals(commandLine)) {
            String[] commands = commandLine.split(";");
            String command = commands[0];
            String filterType = commands[1];
            String filterParam = commands[2];
            //make a key
            String key = filterType + ";" + filterParam;

            //if command is Add filter, put key and filter in the map else we remove the filter
            if (command.equals("Add filter")) {
                filters.put(key, getPredicate(filterType, filterParam));
            } else if (command.equals("Remove filter")) {
                filters.remove(key);
            }
            commandLine = br.readLine();
        }
        //initialize a new list of the names
        List<String> result = new ArrayList<>(names);

        //  check every  name  in result if it is predicant  remove it
        for (Predicate<String> filter : filters.values()) {
            result.removeIf(filter);
        }

        printOutput(result);
    }

    private static void printOutput(List<String> result) {
        System.out.println(String.join(" ", result));
    }

    private static Predicate<String> getPredicate(String commandType, String filterType) {
        switch (commandType) {
            case "Starts with":
                return name -> name.startsWith(filterType);
            case "Ends with":
                return name -> name.endsWith(filterType);
            case "Contains":
                return name -> name.contains(filterType);
            case "Length":
                return name -> name.length() == Integer.parseInt(filterType);
        }
        return name -> false;
    }

    private static List<String> readNames(BufferedReader br) throws IOException {
        return Arrays.stream(br.readLine().split("\\s+")).collect(Collectors.toList());
    }
}
