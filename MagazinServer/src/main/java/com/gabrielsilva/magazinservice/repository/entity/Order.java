package com.gabrielsilva.magazinservice.repository.entity;

import java.math.BigDecimal;

public class Order implements Cloneable {

	private Sandwich sandwich;
	private BigDecimal cost;

	public Order() {
	}
	
	public Sandwich getSandwich() {
		return sandwich;
	}

	public void setSandwich(Sandwich sandwich) {
		this.sandwich = sandwich;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cost == null) ? 0 : cost.hashCode());
		result = prime * result + ((sandwich == null) ? 0 : sandwich.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		
		return other.hashCode() == this.hashCode();
	}

	@Override
	public String toString() {
		return "Order [sandwich=" + sandwich + ", cost=" + cost + "]";
	}

	public Order(Order other) {
		this.sandwich = other.sandwich.clone();
		this.cost = other.cost;
	}
	
	@Override
	public Order clone() {
		return new Order(this);
	}
	
}
