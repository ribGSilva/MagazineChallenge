package com.gabrielsilva.magazinservice.test;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.gabrielsilva.magazinservice.business.PromotionRules;
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
public class PromotionsTest {

	private Set<Ingredient> ingredients = IngredientDAO.getInstance().getIngredients();
	private Set<Sandwich> sandwichs = SandwichDAO.getInstance().getSandwichs();

	private SandwichUtils sandUtils = new SandwichUtils();
	private IngredientUtils ingUtils = new IngredientUtils();

	private PromotionRules promotionUtils = new PromotionRules();
	private PriceCalculatorUtils priceCalculator = new PriceCalculatorUtils();

	@Test
	public void xbaconWithLightTest() {
		Sandwich sandwich = sandUtils.getSandwichByName(SandwichNames.X_BACON, sandwichs);
		sandUtils.addIngredient(ingUtils.getIngredientByName(IngredientNames.ALFACE, ingredients), 2, sandwich);
		sandUtils.removeIngredient(IngredientNames.BACON, sandwich);

		BigDecimal calculatedPrice = priceCalculator.calculatePrice(sandwich);

		BigDecimal processedPrice = promotionUtils.applyLightPrommotion(sandwich, calculatedPrice);

		BigDecimal expectedValue = calculatedPrice.multiply(BigDecimal.valueOf(0.9));

		assertEquals(expectedValue, processedPrice);
	}

	@Test
	public void xbaconWithoutLightTest() {
		Sandwich sandwich = sandUtils.getSandwichByName(SandwichNames.X_BACON, sandwichs);
		sandUtils.addIngredientQuantity(IngredientNames.ALFACE, 2, sandwich);
		sandUtils.addIngredientQuantity(IngredientNames.BACON, 2, sandwich);

		BigDecimal calculatedPrice = priceCalculator.calculatePrice(sandwich);

		BigDecimal processedPrice = promotionUtils.applyLightPrommotion(sandwich, calculatedPrice);

		assertEquals(calculatedPrice, processedPrice);
	}

	@Test
	public void xbaconWithMuitaCarneTest() {
		Sandwich sandwich = sandUtils.getSandwichByName(SandwichNames.X_BACON, sandwichs);
		sandUtils.addIngredientQuantity(IngredientNames.HAMBURGUER_DE_CARNE, 2, sandwich);

		BigDecimal calculatedPrice = priceCalculator.calculatePrice(sandwich);

		BigDecimal processedPrice = promotionUtils.applyMuitaCarnePrommotion(sandwich, calculatedPrice);

		BigDecimal expectedValue = calculatedPrice
				.subtract(ingUtils.getIngredientByName(IngredientNames.HAMBURGUER_DE_CARNE, ingredients).getValue());

		assertEquals(expectedValue, processedPrice);
	}

	@Test
	public void xbaconWithTwoMuitaCarneTest() {
		Sandwich sandwich = sandUtils.getSandwichByName(SandwichNames.X_BACON, sandwichs);
		sandUtils.addIngredientQuantity(IngredientNames.HAMBURGUER_DE_CARNE, 6, sandwich);

		BigDecimal calculatedPrice = priceCalculator.calculatePrice(sandwich);

		BigDecimal processedPrice = promotionUtils.applyMuitaCarnePrommotion(sandwich, calculatedPrice);

		BigDecimal expectedValue = calculatedPrice
				.subtract(ingUtils.getIngredientByName(IngredientNames.HAMBURGUER_DE_CARNE, ingredients).getValue()
						.multiply(BigDecimal.valueOf(2)));

		assertEquals(expectedValue, processedPrice);
	}

	@Test
	public void xbaconWithoutMuitaCarneTest() {
		Sandwich sandwich = sandUtils.getSandwichByName(SandwichNames.X_BACON, sandwichs);
		sandUtils.addIngredientQuantity(IngredientNames.HAMBURGUER_DE_CARNE, 1, sandwich);

		BigDecimal calculatedPrice = priceCalculator.calculatePrice(sandwich);

		BigDecimal processedPrice = promotionUtils.applyMuitaCarnePrommotion(sandwich, calculatedPrice);

		assertEquals(calculatedPrice, processedPrice);
	}
	
	@Test
	public void xbaconWithMuitoQueijoTest() {
		Sandwich sandwich = sandUtils.getSandwichByName(SandwichNames.X_BACON, sandwichs);
		sandUtils.addIngredientQuantity(IngredientNames.QUEIJO, 2, sandwich);

		BigDecimal calculatedPrice = priceCalculator.calculatePrice(sandwich);

		BigDecimal processedPrice = promotionUtils.applyMuitoQueijoPrommotion(sandwich, calculatedPrice);

		BigDecimal expectedValue = calculatedPrice
				.subtract(ingUtils.getIngredientByName(IngredientNames.QUEIJO, ingredients).getValue());

		assertEquals(expectedValue, processedPrice);
	}

	@Test
	public void xbaconWithTwoMuitoQueijoTest() {
		Sandwich sandwich = sandUtils.getSandwichByName(SandwichNames.X_BACON, sandwichs);
		sandUtils.addIngredientQuantity(IngredientNames.QUEIJO, 6, sandwich);

		BigDecimal calculatedPrice = priceCalculator.calculatePrice(sandwich);

		BigDecimal processedPrice = promotionUtils.applyMuitoQueijoPrommotion(sandwich, calculatedPrice);

		BigDecimal expectedValue = calculatedPrice
				.subtract(ingUtils.getIngredientByName(IngredientNames.QUEIJO, ingredients).getValue()
						.multiply(BigDecimal.valueOf(2)));

		assertEquals(expectedValue, processedPrice);
	}

	@Test
	public void xbaconWithoutMuitoQueijoTest() {
		Sandwich sandwich = sandUtils.getSandwichByName(SandwichNames.X_BACON, sandwichs);
		sandUtils.addIngredientQuantity(IngredientNames.QUEIJO, 1, sandwich);

		BigDecimal calculatedPrice = priceCalculator.calculatePrice(sandwich);

		BigDecimal processedPrice = promotionUtils.applyMuitoQueijoPrommotion(sandwich, calculatedPrice);

		assertEquals(calculatedPrice, processedPrice);
	}
	
	@Test
	public void xbaconWithAllPromotionsTest() {
		Sandwich sandwich = sandUtils.getSandwichByName(SandwichNames.X_BACON, sandwichs);
		sandUtils.addIngredient(ingUtils.getIngredientByName(IngredientNames.ALFACE, ingredients), 2, sandwich);
		sandUtils.addIngredientQuantity(IngredientNames.HAMBURGUER_DE_CARNE, 2, sandwich);
		sandUtils.addIngredientQuantity(IngredientNames.QUEIJO, 3, sandwich);
		sandUtils.removeIngredient(IngredientNames.BACON, sandwich);

		BigDecimal calculatedPrice = priceCalculator.calculatePrice(sandwich);

		BigDecimal processedPrice = promotionUtils.applyPromotions(sandwich, calculatedPrice);
		
		BigDecimal expectedValue = calculatedPrice
				.subtract(ingUtils.getIngredientByName(IngredientNames.QUEIJO, ingredients).getValue());
		
		expectedValue = expectedValue
				.subtract(ingUtils.getIngredientByName(IngredientNames.HAMBURGUER_DE_CARNE, ingredients).getValue());
		
		expectedValue = expectedValue.multiply(BigDecimal.valueOf(0.9));

		assertEquals(expectedValue, processedPrice);
	}
	
	@Test
	public void xbaconWithTwoOfAllPromotionsTest() {
		Sandwich sandwich = sandUtils.getSandwichByName(SandwichNames.X_BACON, sandwichs);
		sandUtils.addIngredient(ingUtils.getIngredientByName(IngredientNames.ALFACE, ingredients), 2, sandwich);
		sandUtils.addIngredientQuantity(IngredientNames.HAMBURGUER_DE_CARNE, 6, sandwich);
		sandUtils.addIngredientQuantity(IngredientNames.QUEIJO, 7, sandwich);
		sandUtils.removeIngredient(IngredientNames.BACON, sandwich);

		BigDecimal calculatedPrice = priceCalculator.calculatePrice(sandwich);

		BigDecimal processedPrice = promotionUtils.applyPromotions(sandwich, calculatedPrice);
		
		BigDecimal expectedValue = calculatedPrice
				.subtract(ingUtils.getIngredientByName(IngredientNames.QUEIJO, ingredients).getValue()
						.multiply(BigDecimal.valueOf(2)));
		
		expectedValue = expectedValue
				.subtract(ingUtils.getIngredientByName(IngredientNames.HAMBURGUER_DE_CARNE, ingredients).getValue()
						.multiply(BigDecimal.valueOf(2)));
		
		expectedValue = expectedValue.multiply(BigDecimal.valueOf(0.9));

		assertEquals(expectedValue, processedPrice);
	}
	
	@Test
	public void xbaconWithMuitaCarneAndLightTest() {
		Sandwich sandwich = sandUtils.getSandwichByName(SandwichNames.X_BACON, sandwichs);
		sandUtils.addIngredient(ingUtils.getIngredientByName(IngredientNames.ALFACE, ingredients), 2, sandwich);
		sandUtils.addIngredientQuantity(IngredientNames.HAMBURGUER_DE_CARNE, 6, sandwich);
		sandUtils.removeIngredient(IngredientNames.BACON, sandwich);

		BigDecimal calculatedPrice = priceCalculator.calculatePrice(sandwich);

		BigDecimal processedPrice = promotionUtils.applyPromotions(sandwich, calculatedPrice);
		
		BigDecimal expectedValue = calculatedPrice
				.subtract(ingUtils.getIngredientByName(IngredientNames.HAMBURGUER_DE_CARNE, ingredients).getValue()
						.multiply(BigDecimal.valueOf(2)));
		
		expectedValue = expectedValue.multiply(BigDecimal.valueOf(0.9));

		assertEquals(expectedValue, processedPrice);
	}
	
	@Test
	public void xbaconWithTwoOfMuchsTest() {
		Sandwich sandwich = sandUtils.getSandwichByName(SandwichNames.X_BACON, sandwichs);
		sandUtils.addIngredientQuantity(IngredientNames.HAMBURGUER_DE_CARNE, 6, sandwich);
		sandUtils.addIngredientQuantity(IngredientNames.QUEIJO, 7, sandwich);

		BigDecimal calculatedPrice = priceCalculator.calculatePrice(sandwich);

		BigDecimal processedPrice = promotionUtils.applyPromotions(sandwich, calculatedPrice);
		
		BigDecimal expectedValue = calculatedPrice
				.subtract(ingUtils.getIngredientByName(IngredientNames.QUEIJO, ingredients).getValue()
						.multiply(BigDecimal.valueOf(2)));
		
		expectedValue = expectedValue
				.subtract(ingUtils.getIngredientByName(IngredientNames.HAMBURGUER_DE_CARNE, ingredients).getValue()
						.multiply(BigDecimal.valueOf(2)));

		assertEquals(expectedValue, processedPrice);
	}
}
