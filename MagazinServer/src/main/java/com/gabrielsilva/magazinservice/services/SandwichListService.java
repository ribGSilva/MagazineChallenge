package com.gabrielsilva.magazinservice.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielsilva.magazinservice.repository.SandwichDAO;
import com.gabrielsilva.magazinservice.repository.entity.Sandwich;

@RestController
@RequestMapping("/sandwichListService")
public class SandwichListService {
	
	private SandwichDAO sandwichDAO = SandwichDAO.getInstance();
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path = "/", produces = "application/json")
    public ResponseEntity<?> listSandwichs() {

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
