package com.piseth.java.school;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.piseth.java.school.model.Gender;
import com.piseth.java.school.model.Person;
import com.piseth.java.school.model.PersonPet;
import com.piseth.java.school.model.Pet;

public class PersonApplication {

	private static final List<Person> LIST_OF_PEOPLE = List.of(new Person("Dara", Gender.MALE, 18, List.of(Pet.CAT)),
			new Person("Thida", Gender.FEMALE, 17, List.of(Pet.DOG)),
			new Person("Dalin", Gender.FEMALE, 19, List.of(Pet.DOG, Pet.CAT)),
			new Person("Veasna", Gender.MALE, 16, List.of(Pet.CAT)),
			new Person("Sopheak", Gender.FEMALE, 17, List.of(Pet.FISH)),
			new Person("Vannda", Gender.MALE, 21, List.of(Pet.BIRD)),
			new Person("Nary", Gender.FEMALE, 23, List.of(Pet.DOG, Pet.BIRD, Pet.CAT)),
			new Person("Pisey", Gender.FEMALE, 16, List.of(Pet.CAT)),
			new Person("Sovann", Gender.MALE, 18, List.of(Pet.CAT)),
			new Person("Vannary", Gender.FEMALE, 20, List.of(Pet.FISH, Pet.CAT)) // m=0.25

	);

	public static void main(String[] args) {
		// Group Person by type of pet they have
		
		//1st approach
		Map<Pet, List<String>> map = LIST_OF_PEOPLE.stream()
						.flatMap(p -> p.getPets().stream()
								.map(pet -> new PersonPet(p.getName(), pet)))
						.collect(Collectors.groupingBy(pp -> pp.getPet(), 
								Collectors.mapping(pp -> pp.getName(), Collectors.toList())));

		// 2nd approach
		
		/*
		Map<Pet, List<String>> map = LIST_OF_PEOPLE.stream()
				.flatMap(p -> p.getPets().stream().map(pet -> new AbstractMap.SimpleEntry<>(pet, p)))
				.collect(Collectors.groupingBy(p -> p.getKey(),
						Collectors.mapping(p -> p.getValue().getName(), Collectors.toList())));

		 */
		map.forEach((k, v) -> {
			System.out.println(k);
			System.out.println(v);
			System.out.println("==========");
		});

	}

}
