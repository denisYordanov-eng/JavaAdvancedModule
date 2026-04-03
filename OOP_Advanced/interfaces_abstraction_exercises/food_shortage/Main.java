package food_shortage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int peopleCount = Integer.parseInt(br.readLine());

        Map<String, Buyer> people = new HashMap<>();
        for (int i = 0; i < peopleCount; i++) {
            String[] tokens = br.readLine().split("\\s+");
            switch (tokens.length) {
                case 4:
                    String name = tokens[0];
                    int age = Integer.parseInt(tokens[1]);
                    String id = tokens[2];
                    String birthday = tokens[3];
                    people.putIfAbsent(name, new Citizen(name, age, id, birthday));
                    break;
                case 3:
                    String rebelName = tokens[0];
                    int rebelAge = Integer.parseInt(tokens[1]);
                    String rebelGroup = tokens[2];
                    people.putIfAbsent(rebelName, new Rebel(rebelName, rebelAge, rebelGroup));
                    break;
            }
        }
        String buyerName = br.readLine();
        while (!buyerName.equalsIgnoreCase("End")) {
            if (people.containsKey(buyerName)) {
                Buyer buyer = people.get(buyerName);
                buyer.buyFood();
            }
            buyerName = br.readLine();
        }

        int totalFoodCount = 0;
        for (Buyer person : people.values()) {
            totalFoodCount += person.getFoodQuantity();
        }

        System.out.println(totalFoodCount);
    }
}
