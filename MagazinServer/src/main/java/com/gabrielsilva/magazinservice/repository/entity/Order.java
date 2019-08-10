package com.gabrielsilva.magazinservice.repository.entity;

import java.math.BigDecimal;
import java.util.Set;
import java.util.stream.Collectors;

public class Order implements Cloneable {

	private Sandwich sandwich;
	private BigDecimal cost;
	private Set<Promotion> promotions;

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

	public Set<Promotion> getPromotions() {
		return promotions;
	}

	public void setPromotions(Set<Promotion> promotions) {
		this.promotions = promotions;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cost == null) ? 0 : cost.hashCode());
		result = prime * result + ((sandwich == null) ? 0 : sandwich.hashCode());
		result = prime * result + ((promotions == null) ? 0 : promotions.hashCode());
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
		return "Order [sandwich=" + sandwich + ", cost=" + cost + ", promotions=" + promotions + "]";
	}

	public Order(Order other) {
		this.sandwich = other.sandwich.clone();
		this.cost = other.cost;
		this.promotions = other.promotions.stream().map(Promotion::clone).collect(Collectors.toSet());
	}

	@Override
	public Order clone() {
		return new Order(this);
	}

}
