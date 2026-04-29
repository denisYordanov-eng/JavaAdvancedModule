package card_rank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        if(input.equalsIgnoreCase("Card Ranks")){
            System.out.println("Card Ranks:");

            for (CardRank rank : CardRank.values()) {
                System.out.printf("Ordinal value: %d; Name value: %s%n", rank.ordinal(), rank.name());
            }
        }

    }
}
