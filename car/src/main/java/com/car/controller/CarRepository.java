package com.car.controller;

import java.util.List;

import com.car.controller.CarDTO;

public interface CarRepository {
	List<CarDTO> getAllCarList();
	List<CarDTO> getAllCarListByCategory(String category);
	CarDTO getCarById(String carId);
	
	void setNewCar(CarDTO car);
	
}
