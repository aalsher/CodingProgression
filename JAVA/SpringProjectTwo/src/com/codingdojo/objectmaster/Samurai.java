package com.codingdojo.objectmaster;

public class Samurai extends Human{
	private static int samuraiCount = 0;
	
	public Samurai() {
		samuraiCount += 1;
		health = 200;
	}
	
	public Object deathBlow(Human otherhuman) {
		otherhuman.health = 0;
		this.health = this.health/2;
		System.out.println(""+ otherhuman + "has killed by a Samurai. Health is now:"+ otherhuman.health);
		return this;
	}
	
	public Object meditate() {
		this.health += (this.health/2);
		System.out.println("Samurai has meditated. Samurai health is now:" + this.health);
		return this;
	}
	
	public static int howMany() {
		System.out.println("Number of total Samurai:"+ samuraiCount);
		return samuraiCount;
	}

}
