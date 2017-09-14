package com.codingdojo.zookeeper.partone;

public class Gorilla extends Mammal {
	public void throwThings() {
		this.energylevel -= 5;
		System.out.println("The gorilla threw things");
	}
	public void eatBananas() {
		this.energylevel += 10;
		System.out.println("The gorilla ate a banana");
	}
	public Integer climb() {
		this.energylevel -= 10;
		System.out.println("The gorilla climbed something");
		return energylevel;
	}

}
