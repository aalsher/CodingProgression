package com.codingdojo.zookeeper.partone;

public class DragonTest {

	public static void main(String[] args) {
		Dragon humphrey = new Dragon();
		humphrey.attackTown();
		humphrey.attackTown();
		humphrey.attackTown();
		
		humphrey.eatHumans();
		humphrey.eatHumans();
		
		humphrey.fly();
		humphrey.fly();
		
		humphrey.displayEnergy();
	}

}
