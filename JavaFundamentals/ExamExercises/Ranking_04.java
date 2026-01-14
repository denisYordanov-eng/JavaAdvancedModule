package JavaAdvancedExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Ranking_04 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        Map<String, String> contestPassword = fillMap(br);
        Map<String, Map<String, Integer>> userContestPoints = new TreeMap<>();
        String userLine = br.readLine();

        while (!userLine.equalsIgnoreCase("end of submissions")) {
            String[] contestInfo = userLine.split("=>");
            String contestName = contestInfo[0];
            String contestPass = contestInfo[1];
            String userName = contestInfo[2];
            int points = Integer.parseInt(contestInfo[3]);

            if (contestPassword.containsKey(contestName) && contestPassword.get(contestName).equals(contestPass)) {
                if (!userContestPoints.containsKey(userName)) {
                    userContestPoints.put(userName, new HashMap<>());
                }
                userContestPoints.get(userName).put(contestName,
                        Math.max(userContestPoints.get(userName).getOrDefault(contestName, 0), points));
            }
            userLine = br.readLine();
        }


        String bestCandidate = "";
        int bestScore = Integer.MIN_VALUE;

        for (Map.Entry<String, Map<String, Integer>> entry : userContestPoints.entrySet()) {
            String userName = entry.getKey();
            int currentSum = entry.getValue().values().stream().mapToInt(Integer::intValue).sum();
            if (currentSum > bestScore) {
                bestScore = currentSum;
                bestCandidate = userName;
            }
        }
        System.out.printf("Best candidate is %s with total %d points.%n", bestCandidate, bestScore);


        System.out.println("Ranking: ");

        for (Map.Entry<String, Map<String, Integer>> entry : userContestPoints.entrySet()) {
            System.out.println(entry.getKey());
            for (Map.Entry<String, Integer> pointsEntry : entry.getValue().entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toList())) {
                System.out.printf("#  %s -> %d%n", pointsEntry.getKey(), pointsEntry.getValue());
            }
        }

    }

    private static Map<String, String> fillMap(BufferedReader br) throws IOException {
        Map<String, String> contestPassword = new HashMap<>();
        String inputLine = br.readLine();
        while (!inputLine.equals("end of contests")) {
            String[] contest = inputLine.split(":");
            String contestName = contest[0];
            String password = contest[1];

            contestPassword.put(contestName, password);

            inputLine = br.readLine();
        }
        return contestPassword;
    }
}

