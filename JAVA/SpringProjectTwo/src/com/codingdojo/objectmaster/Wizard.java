package com.codingdojo.objectmaster;

public class Wizard extends Human {
	public Wizard() {
		health = 50;
		intelligence = 8;
	}
	
	public Integer heal(Human otherhuman) {
		otherhuman.health += this.intelligence;
		System.out.println("The wizard has healed you. Health is now:"+ otherhuman.health);
		return otherhuman.health;
	}
	
	public Integer fireball(Human otherhuman) {
		otherhuman.health -= (this.intelligence *3);
		System.out.println("The wizard has fireballed you. Health is now:"+ otherhuman.health);
		return otherhuman.health;
	}

}
