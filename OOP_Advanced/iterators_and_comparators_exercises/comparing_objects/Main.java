package comparing_objects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        List<Person> people = new ArrayList<>();
        while (!input.equalsIgnoreCase("END")) {
            String[] tokens = input.split("\\s+");
            String name = tokens[0];
            Integer age = Integer.parseInt(tokens[1]);
            String town = tokens[2];
            if (age != null || age != 0) {
                Person person = new Person(name, age, town);
                people.add(person);
            }

            input = br.readLine();
        }
        int target = Integer.parseInt(br.readLine());
        if (target < 0 || target >= people.size()) {
            System.out.println("No matches");
            return;
        }

        Person targetPerson = people.get(target - 1);
        int matcherCount = 0;

        for (Person person : people) {
         if(person.compareTo(targetPerson) == 0) {
             matcherCount++;
         }
        }
        if (matcherCount <= 1) {
            System.out.println("No matches");
        } else {
            int notMatchedCount = people.size() - matcherCount;
            System.out.printf("%d %d %d"
                    , matcherCount, notMatchedCount, people.size());
        }
    }
}
