package DefiningClass_Exercises.Google;

import java.awt.image.ImageProducer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Person> people = new HashMap<String, Person>();

        String inputLine = br.readLine().trim();

        while (!inputLine.equals("End")) {
            String[] tokens = inputLine.split("\\s+");
            String name = tokens[0];
            people.putIfAbsent(name, new Person(name));
            String category = tokens[1];

            switch (category) {
                case "company":
                    String companyName = tokens[2];
                    String departmentName = tokens[3];
                    double salary = Double.parseDouble(tokens[4]);
                    Company company = new Company(companyName, departmentName, salary);
                    people.get(name).setCompany(company);
                    break;
                case "car":
                    String carModer = tokens[2];
                    int carSpeed = Integer.parseInt(tokens[3]);
                    Car car = new Car(carModer, carSpeed);
                    people.get(name).setCar(car);
                    break;
                case "children":
                    String childName = tokens[2];
                    String childBday = tokens[3];
                    Child child = new Child(childName, childBday);
                    people.get(name).getChildren().add(child);
                    break;
                case "pokemon":
                    String pokemonName = tokens[2];
                    String pokemonType = tokens[3];
                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                    people.get(name).getPokemons().add(pokemon);
                    break;
                case "parents":
                    String parentName = tokens[2];
                    String parentBirthday = tokens[3];
                    Parents parent = new Parents(parentName, parentBirthday);
                    people.get(name).getParents().add(parent);
                    break;
            }
            inputLine = br.readLine().trim();
        }
        String targetName = br.readLine().trim();
        printOutput(targetName, people);

    }

    private static void printOutput(String targetName, Map<String, Person> people) {
        StringBuilder sb = new StringBuilder();

        Person targetPerson = people.get(targetName);

        sb.append(targetName).append(System.lineSeparator());

        sb.append("Company:").append(System.lineSeparator());
        if (targetPerson.getCompany() != null) {
            sb.append(targetPerson.getCompany().toString());
        }
        sb.append("Car:").append(System.lineSeparator());
        if (targetPerson.getCar() != null) {
            sb.append(targetPerson.getCar().toString());
        }
        sb.append("Pokemon:").append(System.lineSeparator());
        if (targetPerson.getPokemons() != null) {
            for (Pokemon pokemon : targetPerson.getPokemons()) {
                sb.append(pokemon.toString());
            }
        }
        sb.append("Parents:").append(System.lineSeparator());
        if (targetPerson.getParents() != null) {
            for (Parents parents : targetPerson.getParents()) {
                sb.append(parents.toString());
            }
        }
        sb.append("Children:").append(System.lineSeparator());
        if (targetPerson.getChildren() != null) {
            for (Child child : targetPerson.getChildren()) {
                sb.append(child.toString());
            }
        }
        System.out.println(sb.toString());

    }
}
