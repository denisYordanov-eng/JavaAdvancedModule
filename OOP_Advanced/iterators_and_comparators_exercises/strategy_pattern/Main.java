package strategy_pattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        TreeSet<Person> peopleByAge = new TreeSet<>(new CompareByAge());
        TreeSet<Person> peopleByName = new TreeSet<>(new CompareByName());
        for(int i = 0; i < n; i++){
            String[] tokens = br.readLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            Person person = new Person(name, age);
            peopleByAge.add(person);
            peopleByName.add(person);
        }

        printOutput(peopleByAge,peopleByName);
    }
    public static void  printOutput(TreeSet<Person> peopleByAge, TreeSet<Person> peopleByName){
        StringBuilder sb = new StringBuilder();
        for(Person person : peopleByName){
           sb.append(String.format("%s %d",person.getName(),person.getAge()));
           sb.append(System.lineSeparator());
        }
        for(Person person : peopleByAge){
            sb.append(String.format("%s %d",person.getName(),person.getAge()));
            sb.append(System.lineSeparator());
        }
        System.out.println(sb.toString().trim());
    }
}
