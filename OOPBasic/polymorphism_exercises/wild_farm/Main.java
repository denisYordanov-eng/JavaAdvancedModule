package wild_farm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();

        List<Animal> animals = new ArrayList<>();

        while (!line.equalsIgnoreCase("End")) {

            String[] tokens = line.split("\\s+");
            String animalType = tokens[0];
            String animalName = tokens[1];
            double animalWeight = Double.parseDouble(tokens[2]);
            String livingRegion = tokens[3];
            Animal animal = null;
            if (animalType.equals("Cat")) {
                String breed = tokens[4];
                animal = new Cat(animalName, animalWeight, livingRegion, breed);
            } else {
                if (animalType.equalsIgnoreCase("Zebra")) {
                    animal = new Zebra(animalName, animalWeight, livingRegion);

                } else if (animalType.equalsIgnoreCase("Mouse")) {
                    animal = new Mouse(animalName, animalWeight, livingRegion);

                } else if (animalType.equalsIgnoreCase("Tiger")) {
                    animal = new Tiger(animalName, animalWeight, livingRegion);
                }
            }
            String[] foodTokens = br.readLine().split("\\s+");
            String foodType = foodTokens[0];
            int foodQuantity = Integer.parseInt(foodTokens[1]);
            Food food = null;
            switch (foodType) {
                case "Meat":
                    food = new Meat(foodQuantity);
                    break;
                case "Vegetable":
                    food = new Vegetable(foodQuantity);
                    break;
            }
            try {
                if (animal != null) {
                    animals.add(animal);
                    animal.makeSound();
                    animal.eat(food);
                }
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
            line = br.readLine();
        }
        printAnimals(animals);
    }

    private static void printAnimals(List<Animal> animals) {
        for (Animal a : animals) {
            if (a != null) {
                System.out.println(a);
            }
        }
    }

}

