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
		CarDTO car1 = new CarDTO("c0001", "소나타", "2500", "중형","거의 새거");
		CarDTO car2 = new CarDTO("c0002", "그랜저", "3500", "대형","아주 새거");
		CarDTO car3 = new CarDTO("c0003", "아반테", "2000", "준중형","매우 새거");
		CarDTO car4 = new CarDTO("c0004", "k5", "2600", "중형","엄청 새거");
		
		listOfCars.add(car1);
		listOfCars.add(car2);
		listOfCars.add(car3);
		listOfCars.add(car4);
	}



	@Override
	public List<CarDTO> getAllCarList() {
		return listOfCars;
	}

	@Override
	public List<CarDTO> getAllCarListByCategory(String category) {
		List<CarDTO> carsByCategory = new ArrayList<CarDTO>();
		for(int i=0;i<listOfCars.size();i++) {
			CarDTO carDTO = listOfCars.get(i);
			if(category.equalsIgnoreCase(carDTO.getCcate())) {
				carsByCategory.add(carDTO);
			}
		}
		return carsByCategory;
	}

}
