package com.gabrielsilva.magazinservice.repository.entity;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Sandwich implements Cloneable {

	private String name;
	private String image;
	private Set<IngredientItem> ingredients;

	public Sandwich() {
		name = new String();
		ingredients = new HashSet<IngredientItem>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<IngredientItem> getIngredients() {
		return ingredients;
	}

	public void setIngredients(Set<IngredientItem> ingredients) {
		this.ingredients = ingredients;
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ingredients == null) ? 0 : ingredients.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
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
		return "Sandwich [name=" + name + ", image=" + image + ", ingredients=" + ingredients + "]";
	}

	public Sandwich(Sandwich other) {
		name = other.name;
		image = other.image;
		ingredients = other.ingredients.stream().map(IngredientItem::clone).collect(Collectors.toSet());
	}
	
	@Override
	public Sandwich clone() {
		return new Sandwich(this);
	}

}
