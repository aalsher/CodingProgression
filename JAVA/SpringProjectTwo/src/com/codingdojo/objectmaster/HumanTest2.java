package com.codingdojo.objectmaster;

public class HumanTest2 extends Human{

	public static void main(String[] args) {
		Ninja ninjaone = new Ninja();
		Samurai samuraione = new Samurai();
		Samurai samuraitwo = new Samurai();
		Wizard wizardone = new Wizard();
		Human humanone = new Human();
		Human humantwo = new Human();
		
		ninjaone.steal(humanone);
		ninjaone.steal(humantwo);
		ninjaone.runAway();
		
		samuraione.deathBlow(humanone);
		samuraione.meditate();
		samuraitwo.meditate();
		Samurai.howMany();
		
		wizardone.heal(humanone);
		wizardone.fireball(samuraitwo);
		
		ninjaone.displayHealth();
		humanone.displayHealth();
		humantwo.displayHealth();
		samuraione.displayHealth();
		samuraitwo.displayHealth();
		wizardone.displayHealth();

	}
}
