package com.gabrielsilva.magazinservice.repository.mapper;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import com.gabrielsilva.magazinservice.enums.IngredientNames;
import com.gabrielsilva.magazinservice.repository.entity.Ingredient;

public class IngredientsMapper {
	public Set<Ingredient> mapIngredients() {
		Set<Ingredient> ingredients = new HashSet<>();
		
		Ingredient alface = new Ingredient();
		
		alface.setName(IngredientNames.ALFACE);
		alface.setValue(BigDecimal.valueOf(0.4));
		
		ingredients.add(alface);
		
		Ingredient bacon = new Ingredient();
		
		bacon.setName(IngredientNames.BACON);
		bacon.setValue(BigDecimal.valueOf(2.0));
		
		ingredients.add(bacon);
		
		Ingredient hamburguer = new Ingredient();
		
		hamburguer.setName(IngredientNames.HAMBURGUER_DE_CARNE);
		hamburguer.setValue(BigDecimal.valueOf(3.0));
		
		ingredients.add(hamburguer);
		
		Ingredient ovo = new Ingredient();
		
		ovo.setName(IngredientNames.OVO);
		ovo.setValue(BigDecimal.valueOf(0.8));
		
		ingredients.add(ovo);
		
		Ingredient quejo = new Ingredient();
		
		quejo.setName(IngredientNames.QUEIJO);
		quejo.setValue(BigDecimal.valueOf(1.5));
		
		ingredients.add(quejo);
		
		return ingredients;
	}
}
