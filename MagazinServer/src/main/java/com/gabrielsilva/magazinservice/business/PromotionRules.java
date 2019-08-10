package com.gabrielsilva.magazinservice.business;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import com.gabrielsilva.magazinservice.enums.IngredientNames;
import com.gabrielsilva.magazinservice.enums.PromotionNames;
import com.gabrielsilva.magazinservice.repository.PromotionDAO;
import com.gabrielsilva.magazinservice.repository.entity.IngredientItem;
import com.gabrielsilva.magazinservice.repository.entity.Order;
import com.gabrielsilva.magazinservice.repository.entity.Promotion;
import com.gabrielsilva.magazinservice.repository.entity.Sandwich;
import com.gabrielsilva.magazinservice.utils.IngredientUtils;
import com.gabrielsilva.magazinservice.utils.PromotionUtils;

public class PromotionRules {
	
	private Set<Promotion> promotions = PromotionDAO.getInstance().getPromotions();
	private PromotionUtils promotionUtils = new PromotionUtils();

	public BigDecimal applyPromotions(Sandwich sandwich, BigDecimal cost) {

		cost = applyMuitaCarnePrommotion(sandwich, cost);
		cost = applyMuitoQueijoPrommotion(sandwich, cost);
		cost = applyLightPrommotion(sandwich, cost);

		return cost;
	}

	public void applyPromotions(Order order) {
		BigDecimal back = order.getCost(); 
		BigDecimal newValue = order.getCost();
		order.setPromotions(new HashSet<>());
		
		newValue = applyMuitaCarnePrommotion(order.getSandwich(), back);
		if (!newValue.equals(back)) {
			order.getPromotions().add(promotionUtils.getPromotionByName(PromotionNames.MUITA_CARNE, promotions));
		}
		back = newValue;
		
		newValue = applyMuitoQueijoPrommotion(order.getSandwich(), back);
		if (!newValue.equals(back)) {
			order.getPromotions().add(promotionUtils.getPromotionByName(PromotionNames.MUITO_QUEIJO, promotions));
		}
		back = newValue;
		
		newValue = applyLightPrommotion(order.getSandwich(), back);
		if (!newValue.equals(back)) {
			order.getPromotions().add(promotionUtils.getPromotionByName(PromotionNames.LIGHT, promotions));
		}
		back = newValue;

		order.setCost(newValue);
	}

	public BigDecimal applyLightPrommotion(Sandwich sandwich, BigDecimal cost) {
		if (sandwich == null || sandwich.getIngredients() == null || sandwich.getIngredients().isEmpty()) {
			return cost;
		}

		IngredientUtils ingUtils = new IngredientUtils();

		IngredientItem alface = ingUtils.getIngredientItemByName(IngredientNames.ALFACE, sandwich.getIngredients());

		if (alface == null) {
			return cost;
		}

		IngredientItem bacon = ingUtils.getIngredientItemByName(IngredientNames.BACON, sandwich.getIngredients());

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

		IngredientItem hamburger = ingUtils.getIngredientItemByName(IngredientNames.HAMBURGUER_DE_CARNE,
				sandwich.getIngredients());

		if (hamburger == null) {
			return cost;
		}

		Integer quantity = hamburger.getQuantity();

		Integer unitsSale = quantity / 3;

		BigDecimal moneySaved = hamburger.getIngredient().getValue().multiply(BigDecimal.valueOf(unitsSale));

		return cost.subtract(moneySaved);

	}

	public BigDecimal applyMuitoQueijoPrommotion(Sandwich sandwich, BigDecimal cost) {
		if (sandwich == null || sandwich.getIngredients() == null || sandwich.getIngredients().isEmpty()) {
			return cost;
		}

		IngredientUtils ingUtils = new IngredientUtils();

		IngredientItem cheese = ingUtils.getIngredientItemByName(IngredientNames.QUEIJO, sandwich.getIngredients());

		if (cheese == null) {
			return cost;
		}

		Integer quantity = cheese.getQuantity();

		Integer unitsSale = quantity / 3;

		BigDecimal moneySaved = cheese.getIngredient().getValue().multiply(BigDecimal.valueOf(unitsSale));

		return cost.subtract(moneySaved);

	}
}
