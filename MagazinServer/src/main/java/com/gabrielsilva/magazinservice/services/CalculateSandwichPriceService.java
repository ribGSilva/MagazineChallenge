package com.gabrielsilva.magazinservice.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielsilva.magazinservice.business.PromotionRules;
import com.gabrielsilva.magazinservice.repository.entity.Order;
import com.gabrielsilva.magazinservice.repository.entity.Sandwich;
import com.gabrielsilva.magazinservice.utils.PriceCalculatorUtils;
import com.gabrielsilva.magazinservice.utils.SandwichUtils;

@RestController
@RequestMapping("/calculateSandwichPriceService")
public class CalculateSandwichPriceService {

	private PriceCalculatorUtils priceCalculatorUtils = new PriceCalculatorUtils();
	private PromotionRules promotionUtils = new PromotionRules();
	private SandwichUtils sandwichUtils = new SandwichUtils();

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(path = "/", consumes = "application/json")
	public ResponseEntity<?> calculateOrder(@RequestBody Sandwich sandwich) {

		if (sandwich == null || sandwich.getIngredients() == null || sandwich.getIngredients().isEmpty()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Order order = new Order();

		order.setSandwich(sandwich);

		try {
			sandwichUtils.cleanSandwich(order);
			priceCalculatorUtils.calculatePrice(order);
			promotionUtils.applyPromotions(order);
		} catch (Exception e) {
			e.printStackTrace();
			new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<>(order, HttpStatus.OK);
	}

}
