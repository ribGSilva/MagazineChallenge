package com.gabrielsilva.magazinservice.utils;

import java.math.BigDecimal;

import com.gabrielsilva.magazinservice.repository.entity.IngredientItem;
import com.gabrielsilva.magazinservice.repository.entity.Order;
import com.gabrielsilva.magazinservice.repository.entity.Sandwich;

public class PriceCalculatorUtils {

	public BigDecimal calculatePrice(Sandwich sandwich) {

		BigDecimal value = BigDecimal.ZERO;

		if (sandwich == null || sandwich.getIngredients() == null || sandwich.getIngredients().size() == 0) {
			return value;
		}

		for (IngredientItem item : sandwich.getIngredients()) {
			value = item.getIngredient().getValue().multiply(BigDecimal.valueOf(item.getQuantity())).add(value);
		}

		return value;

	}

	public void calculatePrice(Order order) {

		order.setCost(calculatePrice(order.getSandwich()));

	}

}
