package com.codingdojo.objectmaster;

public class HumanTest {

	public static void main(String[] args) {
		Human adam = new Human();
		Human hugh = new Human();
		adam.attack(hugh);
		adam.attack(hugh);
		hugh.attack(adam);
		adam.displayHealth();
		hugh.displayHealth();
	}
}
