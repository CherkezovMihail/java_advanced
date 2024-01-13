package org.example.pokemonTrainer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PokemonTrainerApp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String inputInfo = scanner.nextLine();

        List<Trainer> trainers = new ArrayList<>();

        while (!inputInfo.equals("Tournament")) {

            String[] splittetInfo = inputInfo.split(" ");

            String trainerName = splittetInfo[0];
            String pokemonName = splittetInfo[1];
            String pElement = splittetInfo[2];
            int pHealth = Integer.parseInt(splittetInfo[3]);

            Pokemon pokemon =  new Pokemon(pokemonName, pElement, pHealth);
            Trainer trainer = new Trainer(trainerName);

            boolean hasTrainer = trainers.stream().anyMatch(t -> t.getName().equals(trainerName));

            if (hasTrainer) {
                Trainer currentTrainer = trainers.stream().filter(t -> t.getName().equals(trainerName)).findFirst().get();
                currentTrainer.addPokemon(pokemon);
            } else {
                trainer.addPokemon(pokemon);
                trainers.add(trainer);
            }

            inputInfo = scanner.nextLine();
        }

        String command = scanner.nextLine();

        while (!command.equals("End")) {

            switch (command) {
                case "Fire":
                    trainerHasSpecificPokem(trainers, command);
                    break;
                case "Water":
                    trainerHasSpecificPokem(trainers, command);
                    break;
                case "Electricity":
                    trainerHasSpecificPokem(trainers, command);
                    break;
            }

            command = scanner.nextLine();
        }

        trainers.stream().sorted((t1, t2) -> Integer.compare(t2.getBadges(), t1.getBadges()))
                .forEach(System.out::println);
    }

    private static void trainerHasSpecificPokem(List<Trainer> trainers, String command) {

        for (Trainer trainer : trainers) {
            List<Pokemon> trainerPokemons = trainer.getPokemons();
            boolean hasSpecificPokemon =  trainerPokemons.stream().anyMatch(p -> p.getElement().equals(command));
            if (hasSpecificPokemon) {
                trainer.addBadge();
            } else {
                for (Pokemon pokemon : trainerPokemons) {
                    pokemon.reduceHealth();
                    if (pokemon.getHealth() <= 0) {
                        trainerPokemons.remove(pokemon);
                        if (trainerPokemons.isEmpty()) {
                            break;
                        }
                    }
                }
            }
        }
    }
}
