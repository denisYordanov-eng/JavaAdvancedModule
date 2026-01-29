package encapsulation_Lab.first_and_reserve_team;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Team team = new Team("MT team");

        int n = Integer.parseInt(reader.readLine());

        addParticipants(team, n, reader);

        printOutput(team);
    }

    private static void addParticipants(Team team, int n, BufferedReader reader) throws IOException {
        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split("\\s+");

            String name = tokens[0] + " " + tokens[1];
            int age = Integer.parseInt(tokens[2]);
            double salary = Double.parseDouble(tokens[3]);

            Person person = new Person(name, age, salary);
            team.addPlayer(person);
        }
    }

    private static void printOutput(Team team) {
        System.out.printf("First team have %d players%n", team.getPlayers().size());
        System.out.printf("Reserve team have %d players%n", team.getReservedPlayers().size());
    }
}
