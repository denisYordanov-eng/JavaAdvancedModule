package Functional_Programing_Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FilterByAge_05 {

    public static class Person {
        String name;
        int age;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = readNumber(br);

        List<Person> personList = new ArrayList<>();

        fillList(personList, n, br);

        String condition = br.readLine();
        int targetAge = readNumber(br);
        String format = br.readLine();

        for (Person person : personList) {
            if (condition.equals("younger") && person.age >= targetAge) {
                continue;
            } else if (condition.equals("older") && person.age <= targetAge) {
                continue;
            }

            switch (format) {
                case "name age":
                    System.out.printf("%s - %d%n", person.name, person.age);
                    break;
                case "name":
                    System.out.println(person.name);
                    break;
                case "age":
                    System.out.println(person.age);
                    break;
            }
        }
    }

    private static void fillList
            (List<Person> personList, int n, BufferedReader br) throws IOException {
        for (int i = 0; i < n; i++) {
            String token = br.readLine();
            String[] tokenArr = token.split(", ");
            String name = tokenArr[0];

            Person person = new Person();
            person.name = name;
            person.age = Integer.parseInt(tokenArr[1]);

            personList.add(person);
        }
    }

    private static int readNumber(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }
}
