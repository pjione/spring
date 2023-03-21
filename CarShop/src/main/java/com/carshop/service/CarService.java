package com.carshop.service;

import java.util.List;

import com.carshop.controller.CarDTO;

public interface CarService {
	
	List<CarDTO> getAllCarList();
	List<CarDTO> getCarListByCategory(String category);
	
	CarDTO getCarById(String carId);
	
	boolean deleteCar(String carId);
	boolean setNewCar(CarDTO car);
	void setUpdateCar(CarDTO car);

}
