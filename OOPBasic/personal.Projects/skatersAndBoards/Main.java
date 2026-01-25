package DefiningClass_Exercises.skatersAndBoards;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Skater> skaters = new HashMap<>();
        String input = br.readLine();

        while (!input.equals("End")) {

            String[] tokens = input.split("\\s+");
            switch (tokens.length) {
                case 8:
                    String name = tokens[0];
                    skaters.putIfAbsent(name, new Skater(name));
                    String deck = tokens[1];
                    double deckSize = Double.parseDouble(tokens[2]);

                    String truckBrand = tokens[3];
                    int truckSize = Integer.parseInt(tokens[4]);

                    String wheelsBrand = tokens[5];
                    int wheelsSize = Integer.parseInt(tokens[6]);

                    String bearings = tokens[7];
                    Skateboard skateboard = new Skateboard(deck, deckSize, truckBrand, truckSize, wheelsBrand, wheelsSize, bearings);
                    skaters.get(name).setSkateboard(skateboard);
                    break;
                case 2:
                    String targetName = tokens[0];
                    String activity = tokens[1];

                    if (activity.equals("breakBoard")) {
                        skaters.get(targetName).getSkateboard().breakDeck();
                    }
                    break;
                case 4:
                    String skaterName = tokens[0];
                    String action = tokens[1];
                    String deckName = tokens[2];
                    double size = Double.parseDouble(tokens[3]);
                    if (action.equals("buyBoard")) {
                        skaters.get(skaterName).getSkateboard().buyDeck(deckName, size);
                    }
                    break;
            }
            input = br.readLine();
        }
        printOutput(skaters);
    }

    private static void printOutput(Map<String, Skater> skaters) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Skater> entry : skaters.entrySet()) {
            String currentName = entry.getKey();
            if (entry.getValue() != null &&
                    entry.getValue().getSkateboard().getDeckBrand() != null
                    && entry.getValue().getSkateboard().getDeckSize() > 0) {
                sb.append(currentName).append(":").append(System.lineSeparator());
                sb.append(entry.getValue().getSkateboard().toString());
            } else {
                sb.append(currentName).append(" you are not skater anymore!").append(System.lineSeparator());
            }
        }
        System.out.println(sb.toString());
    }
}
