package com.gabrielsilva.magazinservice.services;

import java.math.BigDecimal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielsilva.magazinservice.business.PromotionRules;
import com.gabrielsilva.magazinservice.repository.entity.Sandwich;
import com.gabrielsilva.magazinservice.utils.PriceCalculatorUtils;

@RestController
@RequestMapping("/calculateSandwichPriceService")
public class CalculateSandwichPriceService {
	
	private PriceCalculatorUtils priceCalculatorUtils = new PriceCalculatorUtils();
	private PromotionRules promotionUtils = new PromotionRules();
	
	@PostMapping(path = "/", consumes = "application/json")
    public ResponseEntity<?> listIngredients(@RequestBody Sandwich sandwich) {
		
		BigDecimal value = null;
		
		if (sandwich == null || sandwich.getIngredients() == null || sandwich.getIngredients().isEmpty() ) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		try {
			value = priceCalculatorUtils.calculatePrice(sandwich);
			value = promotionUtils.applyPromotions(sandwich, value);
		} catch (Exception e) {
			e.printStackTrace();
			new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(value, HttpStatus.OK);
    }

}
