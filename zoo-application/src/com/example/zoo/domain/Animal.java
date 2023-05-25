package com.example.zoo.domain;

public abstract class Animal {
	protected int legs;

	public Animal(int legs) {
		this.legs = legs;
	}

	public int getLegs() {
		return legs;
	}
	
	public void walk() { // concrete method
		System.out.println("Animal with %d legs is walking now...".formatted(legs));
	}
	
	public abstract void eat(); // abstract method
}
