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
public class SandwichValuesTests {

	private Set<Ingredient> ingredients = IngredientDAO.getInstance().getIngredients();
	private Set<Sandwich> sandwichs = SandwichDAO.getInstance().getSandwichs();

	private SandwichUtils sandUtils = new SandwichUtils();
	private IngredientUtils ingUtils = new IngredientUtils();

	private PriceCalculatorUtils priceCalculator = new PriceCalculatorUtils();

	@Test
	public void xbaconValueTest() {
		BigDecimal calculatedPrice = priceCalculator
				.calculatePrice(sandUtils.getSandwichByName(SandwichNames.X_BACON, sandwichs));

		BigDecimal summedValue = BigDecimal.ZERO;
		summedValue = summedValue.add(ingUtils.getIngredientByName(IngredientNames.BACON, ingredients).getValue());
		summedValue = summedValue
				.add(ingUtils.getIngredientByName(IngredientNames.HAMBURGUER_DE_CARNE, ingredients).getValue());
		summedValue = summedValue.add(ingUtils.getIngredientByName(IngredientNames.QUEIJO, ingredients).getValue());

		assertEquals(summedValue, calculatedPrice);
	}

	@Test
	public void xburgerValueTest() {
		BigDecimal calculatedPrice = priceCalculator
				.calculatePrice(sandUtils.getSandwichByName(SandwichNames.X_BURGUER, sandwichs));

		BigDecimal summedValue = BigDecimal.ZERO;
		summedValue = summedValue
				.add(ingUtils.getIngredientByName(IngredientNames.HAMBURGUER_DE_CARNE, ingredients).getValue());
		summedValue = summedValue.add(ingUtils.getIngredientByName(IngredientNames.QUEIJO, ingredients).getValue());

		assertEquals(summedValue, calculatedPrice);
	}

	@Test
	public void xeggValueTest() {
		BigDecimal calculatedPrice = priceCalculator
				.calculatePrice(sandUtils.getSandwichByName(SandwichNames.X_EGG, sandwichs));

		BigDecimal summedValue = BigDecimal.ZERO;
		summedValue = summedValue.add(ingUtils.getIngredientByName(IngredientNames.OVO, ingredients).getValue());
		summedValue = summedValue
				.add(ingUtils.getIngredientByName(IngredientNames.HAMBURGUER_DE_CARNE, ingredients).getValue());
		summedValue = summedValue.add(ingUtils.getIngredientByName(IngredientNames.QUEIJO, ingredients).getValue());

		assertEquals(summedValue, calculatedPrice);
	}

	@Test
	public void xeggbaconValueTest() {
		BigDecimal calculatedPrice = priceCalculator
				.calculatePrice(sandUtils.getSandwichByName(SandwichNames.X_EGG_BACON, sandwichs));

		BigDecimal summedValue = BigDecimal.ZERO;
		summedValue = summedValue.add(ingUtils.getIngredientByName(IngredientNames.BACON, ingredients).getValue());
		summedValue = summedValue.add(ingUtils.getIngredientByName(IngredientNames.OVO, ingredients).getValue());
		summedValue = summedValue
				.add(ingUtils.getIngredientByName(IngredientNames.HAMBURGUER_DE_CARNE, ingredients).getValue());
		summedValue = summedValue.add(ingUtils.getIngredientByName(IngredientNames.QUEIJO, ingredients).getValue());

		assertEquals(summedValue, calculatedPrice);
	}
}
