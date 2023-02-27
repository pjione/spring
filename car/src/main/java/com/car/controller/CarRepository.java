package com.car.controller;

import java.util.List;

import com.car.controller.CarDTO;

public interface CarRepository {
	List<CarDTO> getAllCarList();
}
