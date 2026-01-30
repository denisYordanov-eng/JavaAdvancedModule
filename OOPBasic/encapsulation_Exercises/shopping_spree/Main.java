package encapsulation_exercise.class_box.Problem.shopping_spree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Person> people = new LinkedHashMap<>();
        Map<String, Product> products = new LinkedHashMap<>();

        String[] inputs = bufferedReader.readLine().split(";");
        for (int i = 0; i < inputs.length; i++) {
            String[] tokens = inputs[i].split("=");
            String personName = tokens[0];
            double personMoney = Double.parseDouble(tokens[1]);
            try {
                people.putIfAbsent(personName, new Person(personName, personMoney));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        String[] inputLine = bufferedReader.readLine().split(";");
        for (int i = 0; i < inputLine.length; i++) {
            String[] tokens = inputLine[i].split("=");
            String productName = tokens[0];
            double productMoney = Double.parseDouble(tokens[1]);
            try {
                products.putIfAbsent(productName, new Product(productName, productMoney));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        String input = bufferedReader.readLine();
        while (!input.equals("END")) {

            String[] line = input.split(" ");
            String costumer = line[0];
            String productName = line[1];

            try {
                if (people.containsKey(costumer)) {
                    Person person = people.get(costumer);
                    if (products.containsKey(productName)) {
                        Product product = products.get(productName);
                        person.addProduct(product);
                    }
                }

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            input = bufferedReader.readLine();
        }
        printOutput(people);
    }

    private static void printOutput(Map<String, Person> people) {
        for (Person person : people.values()) {
            System.out.println(person);
        }
    }

    private static String[] splitInput(String[] inputs) {
        String[] result = new String[2];

        for (int i = 0; i < inputs.length; i++) {
            result[i] = inputs[i];
        }
        return result;

    }
}
