package com.gabrielsilva.magazinservice.utils;

import java.util.Set;

import com.gabrielsilva.magazinservice.repository.entity.Ingredient;
import com.gabrielsilva.magazinservice.repository.entity.IngredientItem;

public class IngredientUtils {

	public IngredientItem getIngredientItemByName(String name, Set<IngredientItem> ingredients) {
		if (ingredients == null || ingredients.size() == 0 || name == null || name.isEmpty()) {
			return null;
		}
		
		for (IngredientItem ing : ingredients) {
			if (ing.getIngredient().getName().equalsIgnoreCase(name)) {
				return ing;
			}
		}
		
		return null;
		
	}
	
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
