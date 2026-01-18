package DefiningClass_Exercises.PeoplePoll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<People> people = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());


        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("\\s+");
            String name = input[0];
            int age = Integer.parseInt(input[1]);

            People person = new People();
            person.setFirstName(name);
            person.setAge(age);

            people.add(person);
        }

        people.stream()
                .filter(ageChecker)
                .sorted((e1, e2) -> e1.getFirstName().compareToIgnoreCase(e2.getFirstName()))
                .forEach(p -> {
                    System.out.printf("%s - %d\n", p.getFirstName(),p.getAge());
                });
    }
    private static Predicate<People> ageChecker = (p) -> p.getAge() > 30;


}
