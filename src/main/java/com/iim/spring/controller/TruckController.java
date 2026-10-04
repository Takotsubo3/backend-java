package com.iim.spring.controller;

import com.iim.spring.model.Truck;
import com.iim.spring.model.Vehicle;
import com.iim.spring.service.TruckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/truck")
public class TruckController {

	private final TruckService truckService;

	@Autowired
	public TruckController(TruckService truckService) {
		this.truckService = truckService;
	}

	@GetMapping("/all")
	public List<Vehicle> getAllTrucks() {
		return truckService.getAll();
	}

	@GetMapping("/{id}")
	public Vehicle getTruckById(@PathVariable int id) {
		return truckService.getById(id);
	}

	@PostMapping
	public Truck createTruck(
			@RequestParam String brand,
			@RequestParam String model,
			@RequestParam String year,
			@RequestParam int price,
			@RequestParam int weight) {

		return truckService.create(
				brand,
				model,
				year,
				price,
				weight
		);
	}

	@PutMapping("/{id}")
	public Vehicle updateTruck(
			@PathVariable int id,
			@RequestParam(required = false) String brand,
			@RequestParam(required = false) String model,
			@RequestParam(required = false) String year,
			@RequestParam(required = false) Integer price,
			@RequestParam(required = false) Integer weight) {

		return truckService.update(
				id,
				brand,
				model,
				year,
				price,
				weight
		);
	}

	@DeleteMapping("/{id}")
	public String deleteTruck(@PathVariable int id) {
		truckService.delete(id);
		return "Ok";
	}
}