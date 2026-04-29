package cards_with_power;

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

        int totalPower = rank.getPower() + suit.getPower();

        System.out.printf("Card name: %s of %s; Card power: %d",rank,suit,totalPower);
    }
}
