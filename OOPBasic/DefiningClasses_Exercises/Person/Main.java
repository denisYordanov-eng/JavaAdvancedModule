package DefiningClass_Exercises.Person;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) throws Exception {

        Class Person = Person.class;
        Field[] fields = Person.getDeclaredFields();

        System.out.println(fields.length);

//        Person person = new Person();
//        person.setName("Pesho");
    }
}
