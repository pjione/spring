package com.car.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;


@Service
public class CarServiceImpl implements CarService {
	
	@Autowired
	private CarRepository carRepository;
	
	@Override
	public List<CarDTO> getAllCarList() {
		return carRepository.getAllCarList();
	}
	public List<CarDTO> getAllCarListByCategory(String category){
		List<CarDTO> carsByCategory = carRepository.getAllCarListByCategory(category);
		return carsByCategory;
	}
	@Override
	public CarDTO getCarByIdService(String carId) {
		CarDTO carInfo = carRepository.getCarById(carId);
		return carInfo;
	}
	@Override
	public void setNewCar(CarDTO car) {
		carRepository.setNewCar(car);
	}
}
