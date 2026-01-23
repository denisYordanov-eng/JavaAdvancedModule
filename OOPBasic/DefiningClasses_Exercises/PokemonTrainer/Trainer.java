package PokemonTrainer;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

public class Trainer {
    private static final int INITIAL_NUMBER_OF_BADGETS = 0;

    private String name;

    private int numberOfBadges;

    private List<Pokemon> pokemons;


    public Trainer(String name) {
        this.name = name;
        this.numberOfBadges = INITIAL_NUMBER_OF_BADGETS;
        this.pokemons = new ArrayList<>();
    }


    public String getName() {
        return name;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public int getNumberOfBadges() {
        return numberOfBadges;
    }

    public void setNumberOfBadges(int numberOfBadges) {
        this.numberOfBadges = numberOfBadges;
    }

    public void addBadge() {
        this.numberOfBadges++;
    }

}

