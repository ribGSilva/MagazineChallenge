package com.gabrielsilva.magazinservice.repository.entity;

public class IngredientItem implements Cloneable {
	private Ingredient ingredient;
	private Integer quantity;

	public IngredientItem() {
	}

	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		result = prime * result + ((ingredient == null) ? 0 : ingredient.hashCode());
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
		IngredientItem other = (IngredientItem) obj;

		return other.hashCode() == this.hashCode();
	}

	@Override
	public String toString() {
		return "IngredientItem [ingredient=" + ingredient + ", quantity=" + quantity + "]";
	}

	public IngredientItem(IngredientItem other) {
		this.quantity = other.quantity;
		this.ingredient = other.ingredient.clone();
	}

	@Override
	public IngredientItem clone() {
		return new IngredientItem(this);
	}

}
