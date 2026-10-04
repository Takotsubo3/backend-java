package com.iim.spring.controller;

import com.iim.spring.model.Car;
import com.iim.spring.model.Vehicle;
import com.iim.spring.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/car")

public class CarController {



	private final CarService carService;
	private List<Car> cars;


	@Autowired
	public CarController( CarService carService){
		this.carService = carService;
	}

	@PostMapping
	public Car createCar(
			@RequestParam String brand,
			@RequestParam String model,
			@RequestParam String year,
			@RequestParam int price
	) {
		return carService.create(brand, model, year, price);
	}

	@GetMapping("/all")
	public List<Vehicle> getAllCars(){
		return carService.getAll();
	}

	@GetMapping("/{id}")
	public Vehicle getCarById(@PathVariable int id){
		return carService.getById(id);
	}

	@PutMapping("/{id}")
	public Vehicle updateCar(
			@PathVariable int id,
			@RequestParam String brand,
			@RequestParam String model,
			@RequestParam String year,
			@RequestParam int price
	) {
		return carService.update(id, brand, model, year, price);
	}

	@DeleteMapping("/{id}")
	public void deleteDriver(
			@PathVariable int id
	) {
		carService.delete(id);
	}


}