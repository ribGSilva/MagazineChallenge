package com.gabrielsilva.magazinservice.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.gabrielsilva.magazinservice.repository.entity.Ingredient;
import com.gabrielsilva.magazinservice.repository.entity.IngredientItem;
import com.gabrielsilva.magazinservice.repository.entity.Order;
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

	public void cleanSandwich(Order order) {
		if (order.getSandwich() == null || order.getSandwich().getIngredients() == null) {
			return;
		}

		List<IngredientItem> itemsToRemove = new ArrayList<>();

		for (IngredientItem item : order.getSandwich().getIngredients()) {
			if (item.getQuantity() <= 0) {
				itemsToRemove.add(item);
			}
		}

		order.getSandwich().getIngredients().removeAll(itemsToRemove);

	}

	public boolean addIngredientQuantity(String ingredientName, Integer quantity, Sandwich sandwich) {
		IngredientUtils ingredientUtils = new IngredientUtils();

		IngredientItem ingredient = ingredientUtils.getIngredientItemByName(ingredientName, sandwich.getIngredients());

		if (ingredient == null) {
			return false;
		}

		ingredient.setQuantity(ingredient.getQuantity() + quantity);

		return true;
	}

	public boolean addIngredient(Ingredient ingredientToAdd, Integer quantity, Sandwich sandwich) {
		IngredientUtils ingredientUtils = new IngredientUtils();

		IngredientItem ingredient = ingredientUtils.getIngredientItemByName(ingredientToAdd.getName(),
				sandwich.getIngredients());

		if (ingredient != null) {
			return addIngredientQuantity(ingredientToAdd.getName(), quantity, sandwich);
		}

		ingredient = new IngredientItem();
		ingredient.setIngredient(ingredientToAdd);
		ingredient.setQuantity(quantity);

		sandwich.getIngredients().add(ingredient);

		return true;
	}

	public boolean removeIngredient(String ingredientName, Sandwich sandwich) {

		IngredientUtils ingredientUtils = new IngredientUtils();

		IngredientItem ingredient = ingredientUtils.getIngredientItemByName(ingredientName, sandwich.getIngredients());

		if (ingredient == null) {
			return false;
		}

		sandwich.getIngredients().remove(ingredient);

		return true;
	}

	public boolean removeIngredientQuantity(String ingredientName, int quantity, Sandwich sandwich) {

		IngredientUtils ingredientUtils = new IngredientUtils();

		IngredientItem ingredient = ingredientUtils.getIngredientItemByName(ingredientName, sandwich.getIngredients());

		if (ingredient == null) {
			return false;
		}

		Integer oldQuantity = ingredient.getQuantity();

		if (oldQuantity == quantity) {
			return removeIngredient(ingredientName, sandwich);
		}

		ingredient.setQuantity(ingredient.getQuantity() - quantity);

		return true;
	}

}
