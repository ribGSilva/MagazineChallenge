package com.gabrielsilva.magazinservice.utils;

import java.util.Set;

import com.gabrielsilva.magazinservice.repository.entity.Ingredient;
import com.gabrielsilva.magazinservice.repository.entity.Sandwich;

public class SandwichUtils {

	public Sandwich getSandwichByName(String name, Set<Sandwich> sandwichs) {
		if (sandwichs == null || sandwichs.size() == 0 || name == null || name.isEmpty()) {
			return null;
		}
		
		for (Sandwich sand : sandwichs) {
			if (sand.getName().equalsIgnoreCase(name)) {
				return sand;
			}
		}
		
		return null;
		
	}
	
	public boolean addIngredientQuantity(String ingredientName, Integer quantity, Sandwich sandwich) {
		IngredientUtils ingredientUtils = new IngredientUtils();
		
		Ingredient ingredient = ingredientUtils.getIngredientByName(ingredientName, sandwich.getIngredients().keySet());
		
		if (ingredient == null) {
			return false;
		}
		
		Integer oldQuantity = sandwich.getIngredients().get(ingredient);
		
		sandwich.getIngredients().put(ingredient, oldQuantity + quantity);
		
		return true;
	}

	public boolean addIngredient(Ingredient ingredientToAdd, Integer quantity, Sandwich sandwich) {
		IngredientUtils ingredientUtils = new IngredientUtils();
		
		Ingredient ingredient = ingredientUtils.getIngredientByName(ingredientToAdd.getName(), sandwich.getIngredients().keySet());
		
		if (ingredient != null) {
			return addIngredientQuantity(ingredientToAdd.getName(), quantity, sandwich);
		}
		
		sandwich.getIngredients().put(ingredientToAdd, quantity);
		
		return true;
	}

	public boolean removeIngredient(String ingredientName, Sandwich sandwich) {
		
		IngredientUtils ingredientUtils = new IngredientUtils();
		
		Ingredient ingredient = ingredientUtils.getIngredientByName(ingredientName, sandwich.getIngredients().keySet());
		
		if (ingredient == null) {
			return false;
		}
		
		sandwich.getIngredients().remove(ingredient);
		
		return true;
	}

	public boolean removeIngredientQuantity(String ingredientName, int quantity, Sandwich sandwich) {
	
		IngredientUtils ingredientUtils = new IngredientUtils();
		
		Ingredient ingredient = ingredientUtils.getIngredientByName(ingredientName, sandwich.getIngredients().keySet());
		
		if (ingredient == null) {
			return false;
		}
		
		Integer oldQuantity = sandwich.getIngredients().get(ingredient);
		
		if (oldQuantity == quantity) {
			return removeIngredient(ingredientName, sandwich);
		}
		
		sandwich.getIngredients().put(ingredient, quantity);
		
		return true;
	}
	
}
