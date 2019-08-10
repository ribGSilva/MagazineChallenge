package com.gabrielsilva.magazinservice.repository;

import java.util.Set;
import java.util.stream.Collectors;

import com.gabrielsilva.magazinservice.repository.entity.Promotion;
import com.gabrielsilva.magazinservice.repository.mapper.PromotionMapper;

public class PromotionDAO {
	
	private static PromotionDAO INSTANCE;

	public static synchronized PromotionDAO getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new PromotionDAO();
		}

		return INSTANCE;
	}

	private Set<Promotion> promotions;

	private PromotionDAO() {
		promotions = new PromotionMapper().mapPromotions();
	}

	public synchronized Set<Promotion> getPromotions() {
		return promotions.stream().map(promotion -> promotion.clone()).collect(Collectors.toSet());
	}
}
