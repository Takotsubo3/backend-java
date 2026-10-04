package com.iim.spring.model;

import jakarta.persistence.Entity;

@Entity
public class Car extends Vehicle {

	public Car() {
	}

	public Car(String brand, String model, String year, int price) {
		super(brand, model, year, price);
	}

	@Override
	public String toString() {
		return "Brand: " + getBrand() +
				", Model: " + getModel() +
				", Year: " + getYear() +
				", Price: " + getPrice();
	}

	@Override
	public int calculatePrice(int price, int numDays) {
		return price * numDays;
	}
}
