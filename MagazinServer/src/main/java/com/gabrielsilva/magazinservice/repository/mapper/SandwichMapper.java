package com.gabrielsilva.magazinservice.repository.mapper;

import java.util.HashSet;
import java.util.Set;

import com.gabrielsilva.magazinservice.enums.IngredientNames;
import com.gabrielsilva.magazinservice.enums.SandwichNames;
import com.gabrielsilva.magazinservice.repository.entity.Ingredient;
import com.gabrielsilva.magazinservice.repository.entity.Sandwich;
import com.gabrielsilva.magazinservice.utils.IngredientUtils;

public class SandwichMapper {

	public Set<Sandwich> mapSandwichs(Set<Ingredient> ingredients) {
		Set<Sandwich> sandwichs = new HashSet<>();
		
		IngredientUtils ingUtils = new IngredientUtils();
		
		Sandwich xbacon = new Sandwich();
		xbacon.setName(SandwichNames.X_BACON);
		xbacon.getIngredients().put(ingUtils.getIngredientByName(IngredientNames.BACON, ingredients), 1);
		xbacon.getIngredients().put(ingUtils.getIngredientByName(IngredientNames.HAMBURGUER_DE_CARNE, ingredients), 1);
		xbacon.getIngredients().put(ingUtils.getIngredientByName(IngredientNames.QUEIJO, ingredients), 1);
		
		sandwichs.add(xbacon);
		

		Sandwich xburguer = new Sandwich();
		xburguer.setName(SandwichNames.X_BURGUER);
		xburguer.getIngredients().put(ingUtils.getIngredientByName(IngredientNames.HAMBURGUER_DE_CARNE, ingredients), 1);
		xburguer.getIngredients().put(ingUtils.getIngredientByName(IngredientNames.QUEIJO, ingredients), 1);
		
		sandwichs.add(xburguer);
		
		
		Sandwich xegg = new Sandwich();
		xegg.setName(SandwichNames.X_EGG);
		xegg.getIngredients().put(ingUtils.getIngredientByName(IngredientNames.OVO, ingredients), 1);
		xegg.getIngredients().put(ingUtils.getIngredientByName(IngredientNames.HAMBURGUER_DE_CARNE, ingredients), 1);
		xegg.getIngredients().put(ingUtils.getIngredientByName(IngredientNames.QUEIJO, ingredients), 1);
		
		sandwichs.add(xegg);
		
		Sandwich xeggbacon = new Sandwich();
		xeggbacon.setName(SandwichNames.X_EGG_BACON);
		xeggbacon.getIngredients().put(ingUtils.getIngredientByName(IngredientNames.OVO, ingredients), 1);
		xeggbacon.getIngredients().put(ingUtils.getIngredientByName(IngredientNames.BACON, ingredients), 1);
		xeggbacon.getIngredients().put(ingUtils.getIngredientByName(IngredientNames.HAMBURGUER_DE_CARNE, ingredients), 1);
		xeggbacon.getIngredients().put(ingUtils.getIngredientByName(IngredientNames.QUEIJO, ingredients), 1);
		
		sandwichs.add(xeggbacon);
		
		return sandwichs;
	}
	
}
