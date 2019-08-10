package com.gabrielsilva.magazinservice.test;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.gabrielsilva.magazinservice.enums.IngredientNames;
import com.gabrielsilva.magazinservice.enums.SandwichNames;
import com.gabrielsilva.magazinservice.repository.IngredientDAO;
import com.gabrielsilva.magazinservice.repository.SandwichDAO;
import com.gabrielsilva.magazinservice.repository.entity.Ingredient;
import com.gabrielsilva.magazinservice.repository.entity.Sandwich;
import com.gabrielsilva.magazinservice.utils.IngredientUtils;
import com.gabrielsilva.magazinservice.utils.PriceCalculatorUtils;
import com.gabrielsilva.magazinservice.utils.SandwichUtils;

@RunWith(SpringRunner.class)
public class CalcPricesTests {

	private Set<Ingredient> ingredients = IngredientDAO.getInstance().getIngredients();
	private Set<Sandwich> sandwichs = SandwichDAO.getInstance().getSandwichs();

	private SandwichUtils sandUtils = new SandwichUtils();
	private IngredientUtils ingUtils = new IngredientUtils();

	private PriceCalculatorUtils priceCalculator = new PriceCalculatorUtils();

	@Test
	public void xbaconAddingQuantityValueTest() {
		Sandwich sandwich = sandUtils.getSandwichByName(SandwichNames.X_BACON, sandwichs);
		sandUtils.addIngredientQuantity(IngredientNames.BACON, 2, sandwich);
		sandUtils.addIngredientQuantity(IngredientNames.QUEIJO, 1, sandwich);

		BigDecimal calculatedPrice = priceCalculator.calculatePrice(sandwich);

		BigDecimal summedValue = BigDecimal.ZERO;

		summedValue = summedValue.add(ingUtils.getIngredientByName(IngredientNames.BACON, ingredients).getValue()
				.multiply(BigDecimal.valueOf(3)));

		summedValue = summedValue
				.add(ingUtils.getIngredientByName(IngredientNames.HAMBURGUER_DE_CARNE, ingredients).getValue());
		
		summedValue = summedValue.add(ingUtils.getIngredientByName(IngredientNames.QUEIJO, ingredients).getValue()
				.multiply(BigDecimal.valueOf(2)));

		assertEquals(summedValue, calculatedPrice);
	}
	
	@Test
	public void xbaconAddingItemValueTest() {
		Sandwich sandwich = sandUtils.getSandwichByName(SandwichNames.X_BACON, sandwichs);
		sandUtils.addIngredient(ingUtils.getIngredientByName(IngredientNames.ALFACE, ingredients), 2, sandwich);

		BigDecimal calculatedPrice = priceCalculator.calculatePrice(sandwich);

		BigDecimal summedValue = BigDecimal.ZERO;

		summedValue = summedValue.add(ingUtils.getIngredientByName(IngredientNames.BACON, ingredients).getValue());

		summedValue = summedValue
				.add(ingUtils.getIngredientByName(IngredientNames.HAMBURGUER_DE_CARNE, ingredients).getValue());
		
		summedValue = summedValue.add(ingUtils.getIngredientByName(IngredientNames.QUEIJO, ingredients).getValue());
		

		summedValue = summedValue.add(ingUtils.getIngredientByName(IngredientNames.ALFACE, ingredients).getValue()
				.multiply(BigDecimal.valueOf(2)));

		assertEquals(summedValue, calculatedPrice);
	}
	
	@Test
	public void xbaconRemovingItemQuantityValueTest() {
		Sandwich sandwich = sandUtils.getSandwichByName(SandwichNames.X_BACON, sandwichs);
		sandUtils.addIngredient(ingUtils.getIngredientByName(IngredientNames.ALFACE, ingredients), 2, sandwich);
		sandUtils.removeIngredientQuantity(IngredientNames.ALFACE, 1, sandwich);

		BigDecimal calculatedPrice = priceCalculator.calculatePrice(sandwich);

		BigDecimal summedValue = BigDecimal.ZERO;

		summedValue = summedValue.add(ingUtils.getIngredientByName(IngredientNames.BACON, ingredients).getValue());

		summedValue = summedValue
				.add(ingUtils.getIngredientByName(IngredientNames.HAMBURGUER_DE_CARNE, ingredients).getValue());
		
		summedValue = summedValue.add(ingUtils.getIngredientByName(IngredientNames.QUEIJO, ingredients).getValue());
		
		summedValue = summedValue.add(ingUtils.getIngredientByName(IngredientNames.ALFACE, ingredients).getValue());

		assertEquals(summedValue, calculatedPrice);
	}
	
	@Test
	public void xbaconRemovingItemValueTest() {
		Sandwich sandwich = sandUtils.getSandwichByName(SandwichNames.X_BACON, sandwichs);
		sandUtils.addIngredient(ingUtils.getIngredientByName(IngredientNames.ALFACE, ingredients), 1, sandwich);
		sandUtils.removeIngredient(IngredientNames.QUEIJO, sandwich);

		BigDecimal calculatedPrice = priceCalculator.calculatePrice(sandwich);

		BigDecimal summedValue = BigDecimal.ZERO;

		summedValue = summedValue.add(ingUtils.getIngredientByName(IngredientNames.BACON, ingredients).getValue());

		summedValue = summedValue
				.add(ingUtils.getIngredientByName(IngredientNames.HAMBURGUER_DE_CARNE, ingredients).getValue());
		
		summedValue = summedValue.add(ingUtils.getIngredientByName(IngredientNames.ALFACE, ingredients).getValue());

		assertEquals(summedValue, calculatedPrice);
	}

}
