package com.codingdojo.objectmaster;

public class Human {
	protected Integer strength = 3;
	protected Integer intelligence = 3;
	protected Integer stealth = 3;
	protected Integer health = 100;
	
	public Integer attack(Human otherhuman) {
		otherhuman.health -= this.health;
		return otherhuman.health;
	}
	public Integer displayHealth() {
		System.out.println("Health total is:" + health);
		return health;
	}
}
