package com.gabrielsilva.magazinservice.utils;

import java.util.Set;

import com.gabrielsilva.magazinservice.repository.entity.Promotion;

public class PromotionUtils {
	public Promotion getPromotionByName(String name, Set<Promotion> promotions) {
		if (promotions == null || promotions.size() == 0 || name == null || name.isEmpty()) {
			return null;
		}

		for (Promotion promotion : promotions) {
			if (promotion.getName().equalsIgnoreCase(name)) {
				return promotion;
			}
		}

		return null;

	}
}
