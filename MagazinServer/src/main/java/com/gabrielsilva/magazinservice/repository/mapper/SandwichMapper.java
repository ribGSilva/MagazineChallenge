package com.gabrielsilva.magazinservice.repository.mapper;

import java.util.HashSet;
import java.util.Set;

import com.gabrielsilva.magazinservice.enums.IngredientNames;
import com.gabrielsilva.magazinservice.enums.SandwichNames;
import com.gabrielsilva.magazinservice.repository.entity.Ingredient;
import com.gabrielsilva.magazinservice.repository.entity.IngredientItem;
import com.gabrielsilva.magazinservice.repository.entity.Sandwich;
import com.gabrielsilva.magazinservice.utils.IngredientUtils;

public class SandwichMapper {

	public Set<Sandwich> mapSandwichs(Set<Ingredient> ingredients) {
		Set<Sandwich> sandwichs = new HashSet<>();

		IngredientUtils ingUtils = new IngredientUtils();

		Sandwich xbacon = new Sandwich();
		xbacon.setName(SandwichNames.X_BACON);
		xbacon.setImage("https://image.flaticon.com/icons/svg/648/648652.svg");
		xbacon.getIngredients()
				.add(getNewIngredientItem(ingUtils.getIngredientByName(IngredientNames.BACON, ingredients), 1));
		xbacon.getIngredients().add(getNewIngredientItem(
				ingUtils.getIngredientByName(IngredientNames.HAMBURGUER_DE_CARNE, ingredients), 1));
		xbacon.getIngredients()
				.add(getNewIngredientItem(ingUtils.getIngredientByName(IngredientNames.QUEIJO, ingredients), 1));

		sandwichs.add(xbacon);

		Sandwich xburguer = new Sandwich();
		xburguer.setName(SandwichNames.X_BURGUER);
		xburguer.setImage("https://image.flaticon.com/icons/svg/953/953078.svg");
		xburguer.getIngredients().add(getNewIngredientItem(
				ingUtils.getIngredientByName(IngredientNames.HAMBURGUER_DE_CARNE, ingredients), 1));
		xburguer.getIngredients()
				.add(getNewIngredientItem(ingUtils.getIngredientByName(IngredientNames.QUEIJO, ingredients), 1));

		sandwichs.add(xburguer);

		Sandwich xegg = new Sandwich();
		xegg.setName(SandwichNames.X_EGG);
		xegg.setImage("https://image.flaticon.com/icons/svg/135/135629.svg");
		xegg.getIngredients()
				.add(getNewIngredientItem(ingUtils.getIngredientByName(IngredientNames.OVO, ingredients), 1));
		xegg.getIngredients().add(getNewIngredientItem(
				ingUtils.getIngredientByName(IngredientNames.HAMBURGUER_DE_CARNE, ingredients), 1));
		xegg.getIngredients()
				.add(getNewIngredientItem(ingUtils.getIngredientByName(IngredientNames.QUEIJO, ingredients), 1));

		sandwichs.add(xegg);

		Sandwich xeggbacon = new Sandwich();
		xeggbacon.setName(SandwichNames.X_EGG_BACON);
		xeggbacon.setImage("https://image.flaticon.com/icons/svg/648/648653.svg");
		xeggbacon.getIngredients()
				.add(getNewIngredientItem(ingUtils.getIngredientByName(IngredientNames.OVO, ingredients), 1));
		xeggbacon.getIngredients()
				.add(getNewIngredientItem(ingUtils.getIngredientByName(IngredientNames.BACON, ingredients), 1));
		xeggbacon.getIngredients().add(getNewIngredientItem(
				ingUtils.getIngredientByName(IngredientNames.HAMBURGUER_DE_CARNE, ingredients), 1));
		xeggbacon.getIngredients()
				.add(getNewIngredientItem(ingUtils.getIngredientByName(IngredientNames.QUEIJO, ingredients), 1));

		sandwichs.add(xeggbacon);

		return sandwichs;
	}

	private IngredientItem getNewIngredientItem(Ingredient ingredient, Integer quantity) {

		IngredientItem item = new IngredientItem();

		item.setIngredient(ingredient);
		item.setQuantity(quantity);

		return item;
	}

}
