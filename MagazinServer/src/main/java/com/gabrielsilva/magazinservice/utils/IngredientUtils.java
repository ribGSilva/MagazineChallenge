package com.gabrielsilva.magazinservice.utils;

import java.util.Set;

import com.gabrielsilva.magazinservice.repository.entity.Ingredient;

public class IngredientUtils {

	public Ingredient getIngredientByName(String name, Set<Ingredient> ingredients) {
		if (ingredients == null || ingredients.size() == 0 || name == null || name.isEmpty()) {
			return null;
		}
		
		for (Ingredient ing : ingredients) {
			if (ing.getName().equalsIgnoreCase(name)) {
				return ing;
			}
		}
		
		return null;
		
	}
}
