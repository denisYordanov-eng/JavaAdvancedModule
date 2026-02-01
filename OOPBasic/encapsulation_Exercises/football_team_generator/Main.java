package encapsulation_exercise.class_box.football_team_generator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Team> teams = new LinkedHashMap<>();

        String input = br.readLine();
        while (!input.equals("END")) {
            try {
                String[] tokens = input.split(";");
                String command = tokens[0];
                if (command.equalsIgnoreCase("Add")) {
                    String nameT = tokens[1];
                    String playerName = tokens[2];
                    int endurance = Integer.parseInt(tokens[3]);
                    int sprint = Integer.parseInt(tokens[4]);
                    int dribble = Integer.parseInt(tokens[5]);
                    int passing = Integer.parseInt(tokens[6]);
                    int shooting = Integer.parseInt(tokens[7]);

                    if (!teams.containsKey(nameT)) {
                        System.out.printf("Team %s does not exist.%n", nameT);
                    } else {
                        Player player = new Player(playerName, new Stat(endurance, sprint, dribble, passing, shooting));
                        teams.get(nameT).addPlayer(player);
                    }
                } else if (command.equalsIgnoreCase("Remove")) {
                    String nameT = tokens[1];
                    String playerName = tokens[2];
                    if (!teams.containsKey(nameT)) {
                        System.out.printf("Team %s does not exist.%n", nameT);
                    } else {
                        teams.get(nameT).removePlayer(playerName);
                    }
                } else if (command.equalsIgnoreCase("Rating")) {
                    String nameTeam = tokens[1];
                    if (!teams.containsKey(nameTeam)) {
                        System.out.printf("Team %s does not exist.%n", nameTeam);
                    } else {
                        System.out.println(teams.get(nameTeam).toString());
                    }
                } else if (command.equalsIgnoreCase("Team")) {
                    String teamName = tokens[1];
                    Team team = new Team(teamName);
                    teams.putIfAbsent(teamName, team);
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            input = br.readLine();
        }
    }
}
