package com.codingdojo.zookeeper.partone;

public class Dragon extends Mammal {
	protected Integer energylevel = 300;

	public Integer displayEnergy() {
		System.out.println(energylevel);
		return energylevel;
	}
	public void fly() {
		System.out.println("VVvvvrrrmmmm");
		this.energylevel -= 50;
	}
	public void eatHumans() {
		System.out.println("Aaaaaahhhhhhhhh");
		this.energylevel += 25;
	}
	public void attackTown() {
		System.out.println("Crackling fire sounds and people screaming");
		this.energylevel -=100;
	}

}
