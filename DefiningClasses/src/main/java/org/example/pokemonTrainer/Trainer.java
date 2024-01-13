package org.example.pokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private int badges;
    private List<Pokemon> pokemons;

    public Trainer(String name) {
        this.name = name;
        this.pokemons = new ArrayList<>();
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public String getName() {
        return name;
    }

    public int getBadges() {
        return badges;
    }

    public void addPokemon(Pokemon pokemon) {
        getPokemons().add(pokemon);
    }

    public void addBadge() {
        badges += 1;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", this.getName(), this.getBadges(), this.getPokemons().size());
    }
}
