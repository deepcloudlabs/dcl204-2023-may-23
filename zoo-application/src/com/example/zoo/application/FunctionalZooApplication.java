package com.example.zoo.application;

import java.util.List;
import java.util.function.Consumer;

import com.example.zoo.domain.Animal;
import com.example.zoo.domain.Cat;
import com.example.zoo.domain.Fish;
import com.example.zoo.domain.Pet;
import com.example.zoo.domain.Spider;

public class FunctionalZooApplication {

	public static void main(String[] args) {
		var zooAnimals = List.of(
			new Spider(),
			new Cat(),
			new Fish("Jaws"),
			new Cat("Garfield"),
			new Spider(),
			new Cat("Free Willy"),
			new Spider()
		);
		Consumer<Animal> walk = Animal::walk; // method reference
		Consumer<Animal> eat = Animal::eat; // Method reference
		Consumer<Animal> playIfPet = animal -> { if(animal instanceof Pet pet) pet.play(); };
		zooAnimals.forEach(walk.andThen(eat).andThen(playIfPet));
	}

}
