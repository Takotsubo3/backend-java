package com.iim.spring.service;

import com.iim.spring.model.Driver;
import com.iim.spring.model.Vehicle;
import com.iim.spring.repositories.DriverRepository;
import com.iim.spring.repositories.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class DriverService {

	private final DriverRepository driverRepository;
	private final VehicleRepository vehicleRepository;

	public DriverService(DriverRepository driverRepository, VehicleRepository vehicleRepository) {
		this.driverRepository = driverRepository;
		this.vehicleRepository = vehicleRepository;
	}

	//create
	public Driver create(String name, int age) {
		Driver driver = new Driver(name, age);
		return driverRepository.save(driver);
	}

	//read
	public List<Driver> getAll() {
		return driverRepository.findAll();
	}

	//read-1
	public Driver getById(int id) {
		return driverRepository.findById(id)
				.orElse(null);
	}

	//update
	public Driver update(int id, String name, int age) {

		Driver driver = driverRepository.findById(id)
				.orElse(null);

		if (driver == null) {
			return null;
		}

		driver.setName(name);
		driver.setAge(age);

		return driverRepository.save(driver);
	}

	//delete
	public void delete(int id) {
		driverRepository.deleteById(id);
	}


	public Driver addVehicle(int driverId, int vehicleId) {

		Driver driver = driverRepository.findById(driverId)
				.orElse(null);

		Vehicle vehicle = vehicleRepository.findById(vehicleId)
				.orElse(null);

		if (driver == null || vehicle == null) {
			return null;
		}

		driver.getVehicles().add(vehicle);

		return driverRepository.save(driver);
	}

}



