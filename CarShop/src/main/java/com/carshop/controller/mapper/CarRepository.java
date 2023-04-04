package com.carshop.controller.mapper;

import java.util.List;


import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.carshop.controller.CarDTO;


public interface CarRepository {
	@Select("select cprice from car")
	List<CarDTO> getAllCarList();
	
	
	List<CarDTO> getCarListByCategory(String category);
	CarDTO getCarById(@Param("cid") String carId);
	
	int deleteCar(@Param("cid") String carId);
	int setNewCar(CarDTO car);
	@Update("")
	void setUpdateCar(CarDTO car);
}
	