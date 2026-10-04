package com.iim.spring.repositories;

import com.iim.spring.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
	public interface DriverRepository extends JpaRepository<Driver, Integer> {

	}


