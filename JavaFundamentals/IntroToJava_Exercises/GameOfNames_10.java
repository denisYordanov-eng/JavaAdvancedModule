package InroToJava_Exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GameOfNames_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            int initialScore = Integer.parseInt(scanner.nextLine());
            int finalScore = FindFinalScore(name, initialScore);
            map.put(name, finalScore);
        }

        String winner = "";
        int bestScore = Integer.MIN_VALUE;

        for (Map.Entry<String, Integer> playerScore : map.entrySet()) {
            if (playerScore.getValue() > bestScore) {
                bestScore = playerScore.getValue();
                winner = playerScore.getKey();
            }
        }

        System.out.printf("The winner is %s - %d points", winner, bestScore);
    }

    private static int FindFinalScore(String name, int initialScore) {

        for (int i = 0; i < name.length(); i++) {
            char currentCh = name.charAt(i);
            if ((int) currentCh % 2 == 0) {
                initialScore += currentCh;
            } else {
                initialScore -= currentCh;
            }
        }
        return initialScore;
    }
}

