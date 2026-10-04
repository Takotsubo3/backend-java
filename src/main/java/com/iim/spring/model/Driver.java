	package com.iim.spring.model;

	import jakarta.persistence.*;
	import java.util.HashSet;
	import java.util.Set;

	@Entity
	@Table(name = "driver")
	public class Driver {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		private String name;
		private int age;

		@ManyToMany
		@JoinTable(
				name = "driver_car",
				joinColumns = @JoinColumn(name = "driver_id"),
				inverseJoinColumns = @JoinColumn(name = "vehicle_id")
		)
		private Set<Vehicle> vehicles = new HashSet<>();

		public Driver( String name, int age) {
			this.name = name;
			this.age = age;
		}

		public Driver() {

		}


	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

public int getAge(){
		return age;
}

public void setAge(int age){
		this.age = age;
}


	public Set<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(Set<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

}
