package com.gabrielsilva.magazinservice.repository;

import java.util.Set;
import java.util.stream.Collectors;

import com.gabrielsilva.magazinservice.repository.entity.Ingredient;
import com.gabrielsilva.magazinservice.repository.mapper.IngredientsMapper;

public class IngredientDAO {
	
	private static IngredientDAO INSTANCE = new IngredientDAO();
	
	public static synchronized IngredientDAO getInstance() {
		return INSTANCE;
	}
	
	private Set<Ingredient> ingredients;
	
	private IngredientDAO() {
		ingredients = new IngredientsMapper().mapIngredients();
	}

	public synchronized Set<Ingredient> getIngredients() {
		return ingredients.stream().map(ingredient -> ingredient.clone()).collect(Collectors.toSet());
	}

}
