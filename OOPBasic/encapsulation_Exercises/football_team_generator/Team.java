package encapsulation_exercise.class_box.football_team_generator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;

    List<Player> players;

    public Team(String name) {
        setName(name);
        this.players = new ArrayList<Player>();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public void removePlayer(String playerName) {
        boolean removed = this.players.removeIf(p -> p.getName().equals(playerName));

        if (!removed) {
            throw new IllegalArgumentException(String.format("Player %s is not in %s team."
                    , playerName, this.name));
        }
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    private double rateTeam() {
        double rate = 0;
        for (Player player : players) {
            rate += player.overallRating();
        }
        return rate / players.size();
    }

    @Override
    public String toString() {
        if (this.players.isEmpty()) {
            return String.format("%s - 0", this.name);
        }
        long rate = Math.round(this.rateTeam());
        return String.format("%s - %d", this.name, rate);
    }
}

