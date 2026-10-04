package com.iim.spring.controller;

import com.iim.spring.model.Car;
import com.iim.spring.model.Driver;
import com.iim.spring.service.CarService;
import com.iim.spring.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/driver")

public class DriverController {



	private final DriverService driverService;
	private List<Driver> drivers;


	@Autowired
	public DriverController( DriverService driverService){
		this.driverService = driverService;
	}

	@PostMapping
	public Driver createDriver(
			@RequestParam String name,
			@RequestParam int age
	) {
		return driverService.create(name, age);
	}

	@GetMapping("/all")
		public List<Driver> getAllDrivers(){
			return driverService.getAll();
		}

	@GetMapping("/{id}")
	public Driver getDriverById(@PathVariable int id){
		return driverService.getById(id);
	}

	@PutMapping("/{id}")
	public Driver updateDriver(
			@PathVariable int id,
			@RequestParam String name,
			@RequestParam int age
	) {
		return driverService.update(id, name, age);
	}

	@DeleteMapping("/{id}")
	public void deleteDriver(
			@PathVariable int id
	) {
		 driverService.delete(id);
	}

	@PutMapping("/{driverId}/vehicle/{vehicleId}")
	public Driver addVehicle(
			@PathVariable int driverId,
			@PathVariable int vehicleId) {

		return driverService.addVehicle(driverId, vehicleId);
	}


	}



