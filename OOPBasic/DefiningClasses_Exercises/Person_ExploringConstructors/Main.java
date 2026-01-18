package DefiningClass_Exercises.Person;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
    InputStreamReader isr = new InputStreamReader(System.in);

    BufferedReader br = new BufferedReader(isr);

    Class personClass = Person.class;

        Constructor emptyConstructor =  personClass.getDeclaredConstructor();
        Constructor ageConstructor = personClass.getDeclaredConstructor(int.class);
        Constructor nameAgeConstructor = personClass.getDeclaredConstructor(String.class, int.class);

        String name = br.readLine();
        int age = Integer.parseInt(br.readLine());

        Person basePerson = (Person) emptyConstructor.newInstance();
        Person agePerson = (Person) ageConstructor.newInstance(age);
        Person nameAgePerson = (Person) nameAgeConstructor.newInstance(name, age);

        printPeopleFields(basePerson,agePerson,nameAgePerson);
    }

    private static void printPeopleFields(Person basePerson, Person agePerson, Person nameAgePerson) {
        System.out.printf("%s %s%n",basePerson.getName(),basePerson.getAge());
        System.out.printf("%s %s%n",agePerson.getName(),agePerson.getAge());
        System.out.printf("%s %s%n",nameAgePerson.getName(),nameAgePerson.getAge());
    }
}
