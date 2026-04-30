package enumerations_and_annotations.deck_of_cards;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        if (input.equalsIgnoreCase("Card Deck")) {
            StringBuilder sb = new StringBuilder();
            for (Suit suit : Suit.values()) {
                for (Rank rank : Rank.values()) {
                    sb.append(rank.name());
                    sb.append(" of ");
                    sb.append(suit.name());
                    sb.append(System.lineSeparator());
                }
            }
            System.out.println(sb.toString().trim());
        }

    }
}
