package enumerations_and_annotations.cards_to_string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String rankPower = reader.readLine();
        String suitPower = reader.readLine();

        RankPowers rank = RankPowers.valueOf(rankPower.toUpperCase());
        SuitPowers suit = SuitPowers.valueOf(suitPower.toUpperCase());

        Card card = new Card(rank, suit);
        System.out.println(card);
    }
}
