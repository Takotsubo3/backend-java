package com.iim.spring.service;

import com.iim.spring.model.Truck;
import com.iim.spring.model.Vehicle;
import com.iim.spring.repositories.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TruckService {

	private final VehicleRepository truckRepository;

	public TruckService(VehicleRepository truckRepository) {
		this.truckRepository = truckRepository;
	}

	// create
	public Truck create(
			String brand,
			String model,
			String year,
			int price,
			int weight
	) {
		Truck truck = new Truck(brand, model, year, price, weight);
		return truckRepository.save(truck);
	}

	// read
	public List<Vehicle> getAll() {
		return truckRepository.findAll();
	}

	public Vehicle getById(int id) {
		return truckRepository.findById(id)
				.orElse(null);
	}

	// update
	public Vehicle update(
			int id,
			String brand,
			String model,
			String year,
			Integer price,
			Integer weight
	) {
		Vehicle vehicle = truckRepository.findById(id)
				.orElse(null);

		if (vehicle == null) {
			return null;
		}

		if (brand != null) {
			vehicle.setBrand(brand);
		}

		if (model != null) {
			vehicle.setModel(model);
		}

		if (year != null) {
			vehicle.setYear(year);
		}

		if (price != null) {
			vehicle.setPrice(price);
		}

		if (weight != null && vehicle instanceof Truck) {
			((Truck) vehicle).setWeight(weight);
		}

		return truckRepository.save(vehicle);
	}

	// delete
	public void delete(int id) {
		truckRepository.deleteById(id);
	}
}