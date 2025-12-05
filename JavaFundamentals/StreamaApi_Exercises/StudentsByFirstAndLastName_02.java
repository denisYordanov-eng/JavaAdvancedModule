package StreamaApi_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;


public class StudentsByFirstAndLastName_02 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<String> names = new ArrayList<>();
        fillList(names,bufferedReader);
        names.stream()
                .map(n-> n.split("\\s+"))
                .filter(n-> n[0].compareTo(n[1]) < 0)
                .forEach(n -> System.out.println(n[0] + " " + n[1]));

    }

    private static void fillList(List<String> names, BufferedReader bufferedReader) throws IOException {
        String inputLine = bufferedReader.readLine().trim();

        while (!("END".equalsIgnoreCase(inputLine))){
            names.add(inputLine);

            inputLine = bufferedReader.readLine().trim();
        }
    }
}
