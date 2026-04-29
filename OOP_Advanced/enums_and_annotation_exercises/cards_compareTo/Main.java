package enumerations_and_annotations.cards_compareTo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Card cardOne = createCart(reader);

        Card cardTwo = createCart(reader);

        Card winner = cardOne.compareTo(cardTwo) <= 0 ? cardOne : cardTwo;
        System.out.println(winner.toString());
    }

    public static Card createCart(BufferedReader reader) throws IOException {
        String rankPower = reader.readLine();
        String suitPower = reader.readLine();

        RankPowers rank = RankPowers.valueOf(rankPower.toUpperCase());
        SuitPowers suit = SuitPowers.valueOf(suitPower.toUpperCase());
        return new Card(rank, suit);
    }
}
