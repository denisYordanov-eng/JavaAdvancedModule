package card_game;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String playerOne = scanner.nextLine();
        String playerTwo = scanner.nextLine();
        Set<Card> playerOneCards = new HashSet<>();
        Set<Card> playerTwoCards = new HashSet<>();
        Set<Card> usedCards = new HashSet<>();


        while (scanner.hasNextLine()) {
            if (playerOneCards.size() == 5 && playerTwoCards.size() == 5) {
                break;
            }
            String[] tokes = scanner.nextLine().split("\\s+");

            try {
                Rank rank = Rank.valueOf(tokes[0]);
                Suit suit = Suit.valueOf(tokes[2]);
                Card card = new Card(rank, suit);

                if (usedCards.contains(card)) {
                    System.out.println("Card is not in the deck.");
                    continue;
                }
                if (playerOneCards.size() < 5) {
                    playerOneCards.add(card);
                    usedCards.add(card);
                } else if (playerTwoCards.size() < 5) {
                    playerTwoCards.add(card);
                    usedCards.add(card);
                }

            } catch (Exception e) {
                System.out.println("No such card exists.");
                continue;
            }
        }
        Card biggestCardPlayerOne = playerOneCards.stream()
                .max(Comparator.comparing(Card::calculatePower)).get();

        Card biggestCardPlayerTwo = playerTwoCards.stream()
                .max(Comparator.comparing(Card::calculatePower)).get();

        if (biggestCardPlayerOne.calculatePower() > biggestCardPlayerTwo.calculatePower()) {
            System.out.printf("%s wins with %s of %s.%n",
                    playerOne
                    , biggestCardPlayerOne.getRank().name()
                    , biggestCardPlayerOne.getSuit().name());
        } else {
            System.out.printf("%s wins with %s of %s.%n", playerTwo
                    , biggestCardPlayerTwo.getRank().name()
                    , biggestCardPlayerTwo.getSuit().name());

        }
    }
}

