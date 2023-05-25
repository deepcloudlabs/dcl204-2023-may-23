package com.example.zoo.application;

import java.util.List;
import java.util.function.Predicate;

import com.example.zoo.domain.Animal;
import com.example.zoo.domain.Cat;
import com.example.zoo.domain.Fish;
import com.example.zoo.domain.Pet;
import com.example.zoo.domain.Spider;

public class Exercise2 {

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
		// filter/map/reduce
		var totalPets = zooAnimals.stream().filter(Pet.class::isInstance).count();
				                  //.filter(animal -> Pet.class.isInstance(animal))
		Predicate<Animal> isPet = Pet.class::isInstance;
		Predicate<Animal> isWild = isPet.negate();
		var pets = zooAnimals.stream().filter(isPet).toList();
		var wilds = zooAnimals.stream().filter(isWild).toList();
		System.out.println("Pets:");
		pets.forEach(System.out::println);
		System.out.println("Wild Animals:");
		wilds.forEach(System.out::println);
		System.out.println("total number of pets: %d".formatted(totalPets));
	}

}
