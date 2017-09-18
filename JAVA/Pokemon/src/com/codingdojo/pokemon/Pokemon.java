package com.codingdojo.pokemon;

public class Pokemon {
	protected String name;
	protected String type;
	protected Integer health;
	protected static int count = 0;


	//instantiate class
	public Pokemon(String name, String type, Integer health) {
		this.name = name;
		this.health = health;
		this.type = type;
		count ++;
	}

	//Set name
	public void setName(String name) {
		this.name = name;
		System.out.println("Your Pokemon's name is:" + name);
	}
	
	//set health
	public void setHealth(Integer health) {
		this.health = health;
		System.out.println("Your Pokemon's health is:" + health);
	}
	
	//set type
	public void setType(String type) {
		this.type = type;
		System.out.println( "Your Pokemon's type is:" + type);
	}
	//Get name
	public String getName() {
		System.out.println("Your Pokemon's name is:" + this.name);
		return this.name;
	}
	
	//get health
	public Integer getHealth() {
		System.out.println("Your Pokemon's health is:" + health);
		return this.health;
	}
	
	//get type
	public String getType() {
		System.out.println( "Your Pokemon's type is:" + type);
		return this.type;
	}
}	