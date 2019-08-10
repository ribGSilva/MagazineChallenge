package com.gabrielsilva.magazinservice.repository.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Sandwich implements Cloneable {

	private String name;
	private Map<Ingredient, Integer> ingredients;

	public Sandwich() {
		name = new String();
		ingredients = new HashMap<Ingredient, Integer>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<Ingredient, Integer> getIngredients() {
		return ingredients;
	}

	public void setIngredients(Map<Ingredient, Integer> ingredients) {
		this.ingredients = ingredients;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ingredients == null) ? 0 : ingredients.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sandwich other = (Sandwich) obj;
		return other.hashCode() == this.hashCode();
	}

	@Override
	public String toString() {
		return "Sandwich [name=" + name + ", ingredients=" + ingredients + "]";
	}
	
	public Sandwich(Sandwich other) {
		name = other.name;
		ingredients = other.ingredients.entrySet()
				.stream().collect(Collectors.toConcurrentMap(Map.Entry::getKey, Map.Entry::getValue));
	}
	
	@Override
	public Sandwich clone() {
		return new Sandwich(this);
	}

}
