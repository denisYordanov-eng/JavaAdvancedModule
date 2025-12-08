package StreamaApi_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByGroup_10 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Person> people = new ArrayList<>();

        readAndFillList(people, br);

        filterAndPrintList(people);
    }

    static void filterAndPrintList(List<Person> people) {
        Map<Integer, List<Person>> mapPeople = people.stream()
                .collect(Collectors.groupingBy(Person::getGroup));

        mapPeople.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> {
                    String names = entry.getValue().stream().map(Person::getName)
                            .collect(Collectors.joining(", "));
                    System.out.printf("%d - %s%n", entry.getKey(), names);
                });
    }

    static void readAndFillList(List<Person> people, BufferedReader br) throws IOException {
        String input = br.readLine().trim();
        while (!"END".equalsIgnoreCase(input)) {
            String[] tokens = input.split("\\s+");
            String name = tokens[0] + " " + tokens[1];
            int group = Integer.parseInt(tokens[2]);

            Person person = new Person();
            person.setName(name);
            person.setGroup(group);

            people.add(person);
            input = br.readLine().trim();
        }
    }

    static class Person {
        private String name;
        private int group;

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getGroup() {
            return this.group;
        }

        public void setGroup(int group) {
            this.group = group;
        }
    }
}
