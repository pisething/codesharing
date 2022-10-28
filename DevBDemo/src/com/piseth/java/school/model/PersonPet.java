package com.piseth.java.school.model;
public class PersonPet {
		String name;
		Pet pet;

		public PersonPet(String name, Pet pet) {
			super();
			this.name = name;
			this.pet = pet;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Pet getPet() {
			return pet;
		}

		public void setPet(Pet pet) {
			this.pet = pet;
		}

	}