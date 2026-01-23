package PokemonTrainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine().trim();
        Map<String, Trainer> trainerPokemons = new LinkedHashMap<>();
        while (!input.equalsIgnoreCase("Tournament")) {
            String[] tokens = input.split("\\s+");
            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String elementName = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);

            Pokemon pokemon = new Pokemon(pokemonName, elementName, pokemonHealth);

            if (!trainerPokemons.containsKey(trainerName)) {
                trainerPokemons.put(trainerName, new Trainer(trainerName));
            }
            trainerPokemons.get(trainerName).getPokemons().add(pokemon);
            input = br.readLine().trim();
        }

        String element = br.readLine().trim();
        while (!element.equalsIgnoreCase("End")) {
            switch (element) {
                case "Fire":
                    checkForElement(trainerPokemons, element);
                    break;
                case "Water":
                    checkForElement(trainerPokemons, element);
                    break;
                case "Electricity":
                    checkForElement(trainerPokemons, element);
                    break;
            }
            element = br.readLine().trim();
        }

        trainerPokemons.entrySet().stream()
                .sorted((e1, e2) ->
                        Integer.compare(e2.getValue().getNumberOfBadges(),
                                e1.getValue().getNumberOfBadges())).forEach(e -> {
                    System.out.printf("%s %d %d%n"
                            , e.getKey(), e.getValue().getNumberOfBadges(), e.getValue().getPokemons().size());
                });
    }

    private static void checkForElement(Map<String, Trainer> trainerPokemons, String element) {
        for (Trainer trainer : trainerPokemons.values()) {
            boolean hasElement = trainer.getPokemons()
                    .stream()
                    .anyMatch(e -> e.getElement().equalsIgnoreCase(element));
            if (hasElement) {
                trainer.addBadge();
            } else {
                trainer.getPokemons()
                        .forEach(Pokemon::reduceHealth);
            }
            trainer.getPokemons().removeIf(pokemon -> pokemon.getHealth() <= 0);

        }
    }
}
