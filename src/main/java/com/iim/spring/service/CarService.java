package com.iim.spring.service;

import com.iim.spring.model.Car;
import com.iim.spring.model.Vehicle;
import com.iim.spring.repositories.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

	private final VehicleRepository carRepository;

	public CarService(VehicleRepository carRepository) {
		this.carRepository = carRepository;
	}

	//create
	public Car create(String brand, String model, String year, int price) {
		Car car = new Car(brand, model, year, price);
		return carRepository.save(car);
	}

	//read
	public List<Vehicle> getAll() {
		return carRepository.findAll();
	}


	public Vehicle getById(int id) {
		return carRepository.findById(id)
				.orElse(null);
	}

	//update
	public Vehicle update(
			int id,
			String brand,
			String model,
			String year,
			Integer price
	) {
		Vehicle car = carRepository.findById(id)
				.orElse(null);

		if (car == null) {
			return null;
		}

		if (brand != null) {
			car.setBrand(brand);
		}

		if (model != null) {
			car.setModel(model);
		}

		if (year != null) {
			car.setYear(year);
		}

		if (price != null) {
			car.setPrice(price);
		}

		return carRepository.save(car);
	}

	//delete
	public void delete(int id) {
		carRepository.deleteById(id);
	}
}
