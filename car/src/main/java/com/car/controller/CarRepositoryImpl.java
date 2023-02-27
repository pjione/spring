package com.car.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.car.controller.CarDTO;

@Repository
public class CarRepositoryImpl implements CarRepository {
	
	private List<CarDTO> listOfCars = new ArrayList<CarDTO>();	
	
	public CarRepositoryImpl() {
		CarDTO car1 = new CarDTO("c0001", "소나타", "2500", "승용차","거의 새거");
		CarDTO car2 = new CarDTO("c0002", "그랜저", "3500", "승용차","아주 새거");
		
		listOfCars.add(car1);
		listOfCars.add(car2);
	}



	@Override
	public List<CarDTO> getAllCarList() {
		return listOfCars;
	}

}
