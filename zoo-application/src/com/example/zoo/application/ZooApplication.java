package com.example.zoo.application;

import com.example.zoo.domain.Animal;
import com.example.zoo.domain.Cat;
import com.example.zoo.domain.Fish;
import com.example.zoo.domain.Pet;
import com.example.zoo.domain.Spider;

public class ZooApplication {

	public static void main(String[] args) {
		Animal []zooAnimals = {
			new Spider(),
			new Cat(),
			new Fish("Jaws"),
			new Cat("Garfield"),
			new Spider(),
			new Cat("Free Willy"),
			new Spider()
		};
		for (Animal animal : zooAnimals) {
			animal.walk();
			animal.eat();
			if (animal instanceof Pet pet) {
				// Pet pet = (Pet) animal;
				pet.play();
			}
		}
	}

}
