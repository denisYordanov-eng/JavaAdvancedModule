package coffee_machine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        while (!input.equalsIgnoreCase("END")) {
            String[] tokens = input.split("\\s+");
            if (tokens.length == 1) {
                String coin = tokens[0].toUpperCase();
                coffeeMachine.insertCoin(coin);
            } else {
                String type = tokens[0].toUpperCase();
                String size = tokens[1].toUpperCase();
                coffeeMachine.buyCoffee(type, size);
            }
            input = br.readLine();
        }

        for (Coffee coffee : coffeeMachine.coffeesSold()) {
            System.out.println(coffee);
        }
    }
}
