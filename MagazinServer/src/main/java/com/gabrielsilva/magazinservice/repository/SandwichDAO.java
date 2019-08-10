package com.gabrielsilva.magazinservice.repository;

import java.util.Set;
import java.util.stream.Collectors;

import com.gabrielsilva.magazinservice.repository.entity.Ingredient;
import com.gabrielsilva.magazinservice.repository.entity.Sandwich;
import com.gabrielsilva.magazinservice.repository.mapper.SandwichMapper;

public class SandwichDAO {
		
	private static SandwichDAO INSTANCE;
	
	public static synchronized SandwichDAO getInstance() {
		
		if (INSTANCE == null) {
			INSTANCE = new SandwichDAO(IngredientDAO.getInstance().getIngredients());
		}
		
		return INSTANCE;
	}
	
	private Set<Sandwich> sandwichs;
	
	private SandwichDAO(Set<Ingredient> ingredients) {
		sandwichs = new SandwichMapper().mapSandwichs(ingredients);
	}
	
	public synchronized Set<Sandwich> getSandwichs() {
		return sandwichs.stream().map(sandwich -> sandwich.clone()).collect(Collectors.toSet());
	}

}
