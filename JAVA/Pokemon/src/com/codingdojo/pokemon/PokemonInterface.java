package com.codingdojo.pokemon;

public interface PokemonInterface {

    // create Pokemon
	Pokemon createPokemon(String name, String type, int health);

    // attack Pokemon
	void attackPokemon(Pokemon pokemon);
   
    // attack Pokemon
    String pokemonInfo(Pokemon pokemon);
}
