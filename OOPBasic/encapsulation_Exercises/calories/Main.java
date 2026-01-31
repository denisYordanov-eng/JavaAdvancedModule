package encapsulation_exercise.class_box.pizza.calories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            String[] input = br.readLine().split("\\s+");
            String pizzaName = input[1];
            int numberOfIngredients = Integer.parseInt(input[2]);

            Pizza pizza = new Pizza(pizzaName, numberOfIngredients);
            String[] doughInfo = br.readLine().split("\\s+");
            String doughType = doughInfo[1];
            String bakingTechnique = doughInfo[2];
            double weight = Double.parseDouble(doughInfo[3]);

            pizza.setDough(new Dough(doughType, bakingTechnique, weight));

            String currentTopping = br.readLine();
            while (!currentTopping.equals("END")) {
                String[] tokens = currentTopping.split("\\s+");
                String toppingName = tokens[1];
                double toppingWeight = Double.parseDouble(tokens[2]);

                pizza.addTopping(new Topping(toppingName, toppingWeight));

                currentTopping = br.readLine();
            }
            System.out.println(pizza);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
