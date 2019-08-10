package com.gabrielsilva.magazinservice.services;

import java.math.BigDecimal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielsilva.magazinservice.repository.OrderDAO;
import com.gabrielsilva.magazinservice.repository.entity.Order;

@RestController
@RequestMapping("/receiveOrderService")
public class ReceiveOrderService {
	
	private OrderDAO orderDAO = OrderDAO.getInstance();
	
	@PostMapping(path = "/", consumes = "application/json")
    public ResponseEntity<?> listIngredients(@RequestBody Order order) {
		
		
		if (order == null || order.getSandwich() == null || 
				order.getSandwich().getIngredients().isEmpty() || 
				order.getCost().compareTo(BigDecimal.ZERO) <= 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		try {
			
			orderDAO.addOrder(order);
			
		} catch (Exception e) {
			e.printStackTrace();
			new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(HttpStatus.OK);
    }

}