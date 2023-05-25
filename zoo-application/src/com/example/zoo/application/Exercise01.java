package com.example.zoo.application;

import java.util.List;

import com.example.zoo.domain.Animal;
import com.example.zoo.domain.Cat;
import com.example.zoo.domain.Fish;
import com.example.zoo.domain.Spider;

public class Exercise01 {

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
		var totalLegs = 0;
		for (var animal: zooAnimals) {
			totalLegs += animal.getLegs();
			// totalLegs = totalLegs + animal.getLegs();
		}
		System.out.println("total legs: %d".formatted(totalLegs));
		totalLegs = zooAnimals.stream()
				              .parallel()
				              .mapToInt(Animal::getLegs)
				              .sum();
		System.out.println("total legs: %d".formatted(totalLegs));
	}

}
