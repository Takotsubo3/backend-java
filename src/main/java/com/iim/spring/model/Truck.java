package com.iim.spring.model;

import jakarta.persistence.Entity;

@Entity
public class Truck extends Vehicle {

	private int weight;

	public Truck() {
	}

	public Truck(String brand, String model, String year, int price, int weight) {
		super(brand, model, year, price);
		this.weight = weight;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Brand: " + getBrand() +
				", Model: " + getModel() +
				", Year: " + getYear() +
				", Price: " + getPrice() +
				", Weight: " + weight;
	}

	@Override
	public int calculatePrice(int price, int numDays) {
		return price * numDays;
	}
}