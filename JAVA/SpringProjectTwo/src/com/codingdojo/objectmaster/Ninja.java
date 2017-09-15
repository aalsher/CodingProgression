package com.codingdojo.objectmaster;

public class Ninja extends Human {
	protected Integer stealth = 10;
	
	public Object steal(Human otherhuman) {
		otherhuman.health -= this.stealth;
		this.health += this.stealth; 
		System.out.println("Other human's health:" + otherhuman.health);
		System.out.println("Ninja's health:" + this.health);
		return this;
	}
	
	public Object runAway() {
		this.health -= 10;
		return this;
	}

}
