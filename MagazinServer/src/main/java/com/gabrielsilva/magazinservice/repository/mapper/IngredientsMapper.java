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
		
		alface.setImage("https://image.flaticon.com/icons/svg/1155/1155257.svg");
		alface.setName(IngredientNames.ALFACE);
		alface.setValue(BigDecimal.valueOf(0.4));
		
		ingredients.add(alface);
		
		Ingredient bacon = new Ingredient();
		
		bacon.setImage("https://image.flaticon.com/icons/svg/648/648652.svg");
		bacon.setName(IngredientNames.BACON);
		bacon.setValue(BigDecimal.valueOf(2.0));
		
		ingredients.add(bacon);
		
		Ingredient hamburguer = new Ingredient();
		
		hamburguer.setImage("https://image.flaticon.com/icons/svg/953/953078.svg");
		hamburguer.setName(IngredientNames.HAMBURGUER_DE_CARNE);
		hamburguer.setValue(BigDecimal.valueOf(3.0));
		
		ingredients.add(hamburguer);
		
		Ingredient ovo = new Ingredient();
		
		ovo.setImage("https://image.flaticon.com/icons/svg/135/135629.svg");
		ovo.setName(IngredientNames.OVO);
		ovo.setValue(BigDecimal.valueOf(0.8));
		
		ingredients.add(ovo);
		
		Ingredient queijo = new Ingredient();
		
		queijo.setImage("https://image.flaticon.com/icons/svg/1656/1656387.svg");
		queijo.setName(IngredientNames.QUEIJO);
		queijo.setValue(BigDecimal.valueOf(1.5));
		
		ingredients.add(queijo);
		
		return ingredients;
	}
}
