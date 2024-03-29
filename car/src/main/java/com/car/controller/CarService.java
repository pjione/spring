package com.car.controller;

import java.util.List;

public interface CarService {
	
	List<CarDTO> getAllCarList();
	List<CarDTO> getAllCarListByCategory(String category);
	CarDTO getCarByIdService(String carId);
	void setNewCar(CarDTO car);
}
