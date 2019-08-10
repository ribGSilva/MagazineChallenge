package com.gabrielsilva.magazinservice.business;

import java.math.BigDecimal;

import com.gabrielsilva.magazinservice.enums.IngredientNames;
import com.gabrielsilva.magazinservice.repository.entity.Ingredient;
import com.gabrielsilva.magazinservice.repository.entity.Sandwich;
import com.gabrielsilva.magazinservice.utils.IngredientUtils;

public class PromotionRules {
	
	public BigDecimal applyPromotions(Sandwich sandwich, BigDecimal cost) {
		
		cost = applyMuitaCarnePrommotion(sandwich, cost);
		cost = applyMuitoQueijoPrommotion(sandwich, cost);
		cost = applyLightPrommotion(sandwich, cost);
		
		return cost;
	}

	public BigDecimal applyLightPrommotion(Sandwich sandwich, BigDecimal cost) {
		if (sandwich == null || sandwich.getIngredients() == null || sandwich.getIngredients().isEmpty()) {
			return cost;
		}
		
		IngredientUtils ingUtils = new IngredientUtils();

		Ingredient alface = ingUtils.getIngredientByName(IngredientNames.ALFACE, sandwich.getIngredients().keySet());

		if (alface == null) {
			return cost;
		}

		Ingredient bacon = ingUtils.getIngredientByName(IngredientNames.BACON, sandwich.getIngredients().keySet());

		if (bacon != null) {
			return cost;
		}

		return cost.multiply(BigDecimal.valueOf(0.9));
		
	}
	
	public BigDecimal applyMuitaCarnePrommotion(Sandwich sandwich, BigDecimal cost) {
		if (sandwich == null || sandwich.getIngredients() == null || sandwich.getIngredients().isEmpty()) {
			return cost;
		}
		
		IngredientUtils ingUtils = new IngredientUtils();

		Ingredient hamburger = ingUtils.getIngredientByName(IngredientNames.HAMBURGUER_DE_CARNE, sandwich.getIngredients().keySet());
		
		Integer quantity = sandwich.getIngredients().get(hamburger);
		
		Integer unitsSale = quantity / 3;
		
		BigDecimal moneySaved = hamburger.getValue().multiply(BigDecimal.valueOf(unitsSale));

		return cost.subtract(moneySaved);
		
	}
	
	public BigDecimal applyMuitoQueijoPrommotion(Sandwich sandwich, BigDecimal cost) {
		if (sandwich == null || sandwich.getIngredients() == null || sandwich.getIngredients().isEmpty()) {
			return cost;
		}
		
		IngredientUtils ingUtils = new IngredientUtils();

		Ingredient cheese = ingUtils.getIngredientByName(IngredientNames.QUEIJO, sandwich.getIngredients().keySet());
		
		Integer quantity = sandwich.getIngredients().get(cheese);
		
		Integer unitsSale = quantity / 3;
		
		BigDecimal moneySaved = cheese.getValue().multiply(BigDecimal.valueOf(unitsSale));

		return cost.subtract(moneySaved);
		
	}
}
