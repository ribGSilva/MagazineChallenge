package com.gabrielsilva.magazinservice.utils;

import java.math.BigDecimal;
import java.util.Map.Entry;

import com.gabrielsilva.magazinservice.repository.entity.Ingredient;
import com.gabrielsilva.magazinservice.repository.entity.Sandwich;

public class PriceCalculatorUtils {

	public BigDecimal calculatePrice(Sandwich sandwich) {
		
		BigDecimal value = BigDecimal.ZERO;
		
		if (sandwich == null || sandwich.getIngredients() == null || sandwich.getIngredients().size() == 0) {
			return value;
		}
		
		for (Entry<Ingredient, Integer> entry : sandwich.getIngredients().entrySet()) {
			value = entry.getKey().getValue()
						.multiply(BigDecimal.valueOf(entry.getValue()))
						.add(value);
		}
		
		return value;
		
	}
	
}
