package encapsulation_Lab.validation_data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Person> people = new ArrayList<>();

        int counter = 0;

        readPeople(br,people, counter, n);

        double bonus = Double.parseDouble(br.readLine());

        addBonusToSalary(bonus, people);

        printOutput(people);
    }

    private static void addBonusToSalary(double bonus, List<Person> people) {
      for (Person person : people) {
          person.increaseSalary(bonus);
      }
    }

    static void readPeople(BufferedReader br, List<Person> people, int counter, int n) throws IOException {
        if(counter == n) {
           return;
        }
        String[] tokens  = br.readLine().split("\\s+");

        String firstN = tokens[0];
        String lastN = tokens[1];
        int age = Integer.parseInt(tokens[2]);
        double salary = Double.parseDouble(tokens[3]);

        try {
            Person person = new Person(firstN, lastN, age, salary);
            people.add(person);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
       counter++;
        readPeople(br,people, counter, n);
    }

    private static void printOutput(List<Person> people) {
        StringBuilder sb = new StringBuilder();
        for (Person person : people) {
            sb.append(person).append(System.lineSeparator());
        }
        System.out.println(sb.toString());
    }
}
