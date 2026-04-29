package card_suit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        if(input.equalsIgnoreCase("Card Suits")){
            System.out.println("Card Suits:");
            for (CardSuit suit : CardSuit.values()) {
                System.out.printf("Ordinal value: %d; Name value: %s%n", suit.ordinal(), suit.name());
            }
        }
    }
}
