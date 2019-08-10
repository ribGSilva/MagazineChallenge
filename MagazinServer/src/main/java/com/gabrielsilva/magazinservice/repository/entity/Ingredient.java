package com.gabrielsilva.magazinservice.repository.entity;

import java.math.BigDecimal;

public class Ingredient implements Cloneable {

	private String name;
	private String image;
	private BigDecimal value;

	public Ingredient(){
		name = new String();
		value = BigDecimal.ONE;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		Ingredient other = (Ingredient) obj;
		
		return other.hashCode() == this.hashCode();
	}

	@Override
	public String toString() {
		return "Ingredient [name=" + name + ", image=" + image + ", value=" + value + "]";
	}

	public Ingredient(Ingredient other){
		this.name = other.name;
		this.image = other.image;
		this.value = other.value;
	}

	@Override
	public Ingredient clone() {
		return new Ingredient(this);
	}
}
