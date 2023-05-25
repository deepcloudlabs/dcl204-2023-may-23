package com.example.zoo.application;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.util.List;
import java.util.Map;

import com.example.zoo.domain.Cat;
import com.example.zoo.domain.Fish;
import com.example.zoo.domain.Spider;

public class Exercise4 {

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
		var animalTypeMap = Map.of(
				Cat.class, "Pet",
				Fish.class, "Pet",
				Spider.class, "Wild"
		);
		// filter/map/reduce
		var animalCountsGroupByType =
		zooAnimals.stream()
		          .map(Object::getClass)
		          .map(animalTypeMap::get)
		          .collect(groupingBy(identity(),counting()));
		System.out.println(animalCountsGroupByType);
	}

}
