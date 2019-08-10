package com.gabrielsilva.magazinservice.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielsilva.magazinservice.repository.PromotionDAO;
import com.gabrielsilva.magazinservice.repository.entity.Promotion;


@RestController
@RequestMapping("/promotionListService")
public class PromotionListService {
		
		private PromotionDAO promotionDAO = PromotionDAO.getInstance();
		
		@GetMapping(path = "/", produces = "application/json")
	    public ResponseEntity<?> listIngredients() {
			Set<Promotion> promotions = new HashSet<>();
			
			try {
				promotions.addAll(promotionDAO.getPromotions());
			} catch (Exception e) {
				e.printStackTrace();
				new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			return new ResponseEntity<>(promotions, HttpStatus.OK);
	    }
		
}
