package com.gabrielsilva.magazinservice.repository;

import java.util.ArrayList;
import java.util.List;

import com.gabrielsilva.magazinservice.repository.entity.Order;

public class OrderDAO {

	private static OrderDAO INSTANCE;

	public static synchronized OrderDAO getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new OrderDAO();
		}

		return INSTANCE;
	}

	private List<Order> orders;

	private OrderDAO() {
		orders = new ArrayList<>();
	}

	public synchronized void addOrder(Order newOrder) {
		orders.add(newOrder);
	}
	
}
