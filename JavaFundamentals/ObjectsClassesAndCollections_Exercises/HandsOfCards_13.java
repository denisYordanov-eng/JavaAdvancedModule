package ObjectsClassesAndCollections_Exercises;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class HandsOfCards_13 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Map<String, Set<String>> playerHands = new LinkedHashMap<>();
        while (!input.equals("JOKER")) {
            String[] inputArr = input.split(": ");
            String name = inputArr[0];
            String allCardsStr = inputArr[1].trim();

            String[] cards = allCardsStr.split("\\s*,\\s*");

            Set<String> cardSet = playerHands.getOrDefault(name, new HashSet<>());

            cardSet.addAll(Arrays.asList(cards));

            playerHands.put(name, cardSet);

            input = br.readLine();
        }

        Map<String, Long> playerFinalResult = new LinkedHashMap<>();

        for (Map.Entry<String, Set<String>> entry : playerHands.entrySet()) {
            String name = entry.getKey();
            Set<String> cards = entry.getValue();

            long totalValue = calculateResult(cards);

            playerFinalResult.put(name, totalValue);
        }
        printOutput(playerFinalResult);
    }

    private static void printOutput(Map<String, Long> playerResult) {
        for (Map.Entry<String, Long> entry : playerResult.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private static long getCardPower(String power) {
        long cardPower = 0;
        switch (power) {
            case "S":
                cardPower = 4;
                break;
            case "H":
                cardPower = 3;
                break;
            case "D":
                cardPower = 2;
                break;
            case "C":
                cardPower = 1;
                break;
        }
        return cardPower;
    }

    private static long getCardValue(String value) {
        long cardValue = 0;
        switch (value) {
            case "J":
                cardValue = 11;
                break;
            case "Q":
                cardValue = 12;
                break;
            case "K":
                cardValue = 13;
                break;
            case "A":
                cardValue = 14;
                break;
            default:
                cardValue = Long.parseLong(value);
                break;
        }
        return cardValue;
    }

    private static long calculateResult(Set<String> cardSet) {
        long result = 0L;

        for (String card : cardSet) {

            String cardValue = " ";
            String cardType = " ";

            if (card.length() == 3) {
                cardValue = "10";
                cardType = card.substring(2);
            } else {
                cardValue = card.charAt(0) + "";
                cardType = card.charAt(1) + "";
            }

            long value = getCardValue(cardValue);
            long power = getCardPower(cardType);

            result += power * value;
        }
        return result;
    }
}
