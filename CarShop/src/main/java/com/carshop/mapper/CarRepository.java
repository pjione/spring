package com.carshop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.carshop.controller.CarDTO;

public interface CarRepository {
	
	List<CarDTO> getAllCarList();
	List<CarDTO> getCarListByCategory(String category);
	CarDTO getCarById(@Param("cid") String carId);
	
	int deleteCar(@Param("cid") String carId);
	int setNewCar(CarDTO car);
	void setUpdateCar(CarDTO car);
}
	