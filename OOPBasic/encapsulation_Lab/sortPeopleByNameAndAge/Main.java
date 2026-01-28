package encapsulation_Lab.sortPeopleByNameAndAge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Person> people = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("\\s+");
            String firstN = input[0];
            String lastN = input[1];
            int age = Integer.parseInt(input[2]);

            people.add(new Person(firstN, lastN, age));
        }

        people.sort(Comparator.comparing(Person::getFirstName)
                .thenComparing(Person::getAge));

        for (Person person : people) {
            System.out.println(person);
        }

    }
}
