package com.example.collections;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class StudyMap {

	public static void main(String[] args) {
		
		Map<String, Set<Integer>> areaCodes = new TreeMap<>((city1,city2)->city2.compareTo(city1));
		areaCodes.put("istanbul", Set.of(212,216));
		areaCodes.put("ankara", Set.of(312));
		areaCodes.put("bursa", Set.of(224));
		areaCodes.put("edirne", Set.of(284));
		areaCodes.put("samsun", Set.of(362));
		System.out.println(areaCodes.get("istanbul"));
		for (var city : areaCodes.keySet()) {
			System.out.println("%s: %s".formatted(city,areaCodes.get(city)));
		}
		for (var areaCode : areaCodes.values()) {
			System.out.println("areaCode: %s".formatted(areaCode));
		}
		for (Map.Entry<String, Set<Integer>> entry : areaCodes.entrySet()) {
			System.out.println("%s: %s".formatted(entry.getKey(),entry.getValue()));
		}
		areaCodes.forEach((city,areaCode) -> System.out.println("%s: %s".formatted(city,areaCodes.get(city))));
	}

}
