package equality_logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


import java.util.HashSet;
import java.util.TreeSet;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        TreeSet<Person> personThreeSet = new TreeSet<>(new PersonComparator());
       HashSet<Person> personHashSet = new HashSet<>();
        for(int i = 0; i < n; i++){
            String[] tokens = br.readLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            if(age != 0){
                Person person = new Person(name, age);
               personHashSet.add(person);
                personThreeSet.add(person);
            }
        }
        System.out.println(personThreeSet.size());
        System.out.println(personHashSet.size());
    }
}
