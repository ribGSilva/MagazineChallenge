package com.gabrielsilva.magazinservice.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielsilva.magazinservice.repository.IngredientDAO;
import com.gabrielsilva.magazinservice.repository.entity.Ingredient;

@RestController
@RequestMapping("/ingredientListService")
public class IngredientListService {

	private IngredientDAO ingredientDAO = IngredientDAO.getInstance();

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path = "/", produces = "application/json")
	public ResponseEntity<?> listIngredients() {
		Set<Ingredient> ingredients = new HashSet<>();

		try {
			ingredients.addAll(ingredientDAO.getIngredients());
		} catch (Exception e) {
			e.printStackTrace();
			new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<>(ingredients, HttpStatus.OK);
	}

}
