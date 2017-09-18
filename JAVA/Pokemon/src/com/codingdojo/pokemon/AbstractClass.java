package com.codingdojo.pokemon;

public abstract class AbstractClass implements PokemonInterface {

	@Override
	public Pokemon createPokemon(String name, String type, int health) {
		// TODO Auto-generated method stub
		return new Pokemon(name,type,health);
	}

	@Override
	public void attackPokemon(Pokemon pokemon) {
		pokemon.setHealth(pokemon.health-10);
	}

}
