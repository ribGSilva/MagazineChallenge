package com.gabrielsilva.magazinservice.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielsilva.magazinservice.repository.SandwichDAO;
import com.gabrielsilva.magazinservice.repository.entity.Sandwich;

@RestController
@RequestMapping("/sandwichList")
public class SandwichListService {
	
	private SandwichDAO sandwichDAO = SandwichDAO.getInstance();
	
	@GetMapping(path = "/", produces = "application/json")
    public ResponseEntity<?> listIngredients() {

		Set<Sandwich> sandwiches = new HashSet<>();
		
		try {
			sandwiches.addAll(sandwichDAO.getSandwichs());
		} catch (Exception e) {
			e.printStackTrace();
			new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(sandwiches, HttpStatus.OK);
    }
	
}
