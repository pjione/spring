package com.carshop.controller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carshop.controller.CarDTO;
import com.carshop.controller.mapper.CarRepository;

@Service
public class CarServiceImpl implements CarService {
	
	private CarRepository carRepository;
	
	public CarServiceImpl(CarRepository carRepository) {
		this.carRepository = carRepository;
	}

	@Override
	public List<CarDTO> getAllCarList() {
		// TODO Auto-generated method stub
		return carRepository.getAllCarList();
	}
	
	public List<CarDTO> getCarListByCategory(String category) {
		List<CarDTO> carsByCategory = carRepository.getCarListByCategory(category);
		return carsByCategory;
	}
	
	public CarDTO getCarById(String carId) {
		return carRepository.getCarById(carId);
		
	}
	
	public boolean setNewCar(CarDTO car) {
		return carRepository.setNewCar(car) == 1 ? true : false;
	}

	@Override
	public boolean deleteCar(String carId) {
		return carRepository.deleteCar(carId) == 1 ? true : false;
		
	}

	@Override
	public void setUpdateCar(CarDTO car) {
		carRepository.setUpdateCar(car);
		
	}

}
