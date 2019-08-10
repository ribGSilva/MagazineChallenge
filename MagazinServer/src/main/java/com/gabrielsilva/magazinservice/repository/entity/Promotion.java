package com.gabrielsilva.magazinservice.repository.entity;

public class Promotion implements Cloneable {
	private String name;
	private String description;
	
	public Promotion() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Promotion other = (Promotion) obj;
		
		return other.hashCode() == this.hashCode();
	}

	@Override
	public String toString() {
		return "Promotion [name=" + name + ", description=" + description + "]";
	}
	
	public Promotion(Promotion other) {
		this.name = other.name;
		this.description = other.description;
	}
	
	@Override
	public Promotion clone() {
		return new Promotion(this);
	}
	
}
