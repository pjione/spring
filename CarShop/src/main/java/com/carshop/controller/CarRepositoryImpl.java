package com.carshop.controller;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CarRepositoryImpl implements CarRepository {

	private List<CarDTO> listOfCars = new ArrayList<CarDTO>();
	
	public CarRepositoryImpl() {
		
		/*
		 * CarDTO car1 = new CarDTO("c0001","소나타","2500","중형","▶본 차량상태..<br>" +
		 * "- 정식출고<br>" + "- 무사고 운행<br>" + "- 풀 체인지 신형<br>" + "- 21,000km 실주행<br>" +
		 * "- 카리스마 넘치는 블랙 바디<br>" + "- 깔끔하게 관리된 내/외관 보유<br>" +
		 * "- 웅장함이 돋보이는 아메리칸 대형 SUV<br>" +
		 * "- 옵션으로 네비/후방캠/파노라마/HUD/어라운드뷰/열선.전동.메모리시트 등.."); CarDTO car2 = new
		 * CarDTO("c0002","그랜저","3500","대형","▶본 차량상태..<br>" + "- 운용리스<br>" +
		 * "- 정식출고<br>" + "- 전체 PPF<br>" + "- 완전 무사고<br>" + "- 12,000km 실주행<br>" +
		 * "- 신차가 4억 8,000만원<br>" + "- 720마력 V8 터보 슈퍼카<br>" + "- 깔끔하게 관리된 실내/외관 유지<br>"
		 * + "- 매력적인 블루 코르사 바디&아이보리 시트<br>" + "- 다수의 카본 인테리어, 엔진룸 글라스 옵션"); CarDTO car3
		 * = new CarDTO("c0003","아반테","2000","준중형","▶본 차량상태..<br>" + "- 정식출고<br>" +
		 * "- 무사고 운행<br>" + "- 10,000km 실주행<br>" + "- 짧은주행 및 신차급<br>" +
		 * "- LED 헤드라이트 적용<br>" + "- 선호도 높은 화이트 바디<br>" + "- 깔끔하게 관리된 내/외관 보유<br>" +
		 * "- 204마력 4기통 터보, 브랜드 인기 컴팩트 세단<br>" +
		 * "- 옵션으로 내비/썬루프/후방캠/패들쉬프트/열선,전동,메모리 시트 등..");
		 */
		/*
		 * listOfCars.add(car1); listOfCars.add(car2); listOfCars.add(car3);
		 */
		
	}
	
	/*
	 * @Override public List<CarDTO> getAllCarList() {
	 * 
	 * return listOfCars; }
	 */
	
	@Override	
	public List<CarDTO> getCarListByCategory(String category) {
		List<CarDTO> carsByCategory = new ArrayList<CarDTO>();
		for (int i = 0; i < listOfCars.size(); i++) {
			CarDTO carDTO = listOfCars.get(i);
			if (category.equalsIgnoreCase(carDTO.getCcate()))
				carsByCategory.add(carDTO);
		}
		return carsByCategory;
	}
	

	/*
	 * public CarDTO getCarById(String carId) {
	 * 
	 * CarDTO carInfo = null;
	 * 
	 * for (int i = 0 ; i < listOfCars.size() ; i++) { CarDTO carDTO =
	 * listOfCars.get(i); if(carDTO != null && carDTO.getCid() != null &&
	 * carDTO.getCid().equals(carId)) { carInfo = carDTO; } }
	 * 
	 * if (carInfo == null) { throw new IllegalArgumentException("자동차 ID 가 " + carId
	 * + "인 자동차는 없습니다. "); }
	 * 
	 * return carInfo; }
	 */
	/*
	 * public void setNewCar(CarDTO car) { listOfCars.add(car); }
	 */
	private JdbcTemplate template;
	
	@Autowired
	public void setJdbcTemplate(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}

	@Override
	public List<CarDTO> getAllCarList() {
		String sql = "SELECT * FROM car";
		List<CarDTO> listOfCars = template.query(sql, new CarRowMapper());
		
		return listOfCars;
	}
	
	public CarDTO getCarById(String carId) {
		
		CarDTO carInfo = null;
		
		String sql = "SELECT count(*) FROM car WHERE cid = ?";
		
		int rowCount = template.queryForObject(sql, Integer.class, carId);
		if(rowCount != 0) {
			sql = "SELECT * FROM car WHERE cid = ?";
			carInfo = template.queryForObject(sql, new Object[] {carId}, new CarRowMapper());
		}
		
		if (carInfo == null) {
			throw new IllegalArgumentException("자동차 ID 가 " + carId + "인 자동차는 없습니다. ");
		}
		
		return carInfo;
	}

	public void setNewCar(CarDTO car) {
		
		String sql = "INSERT INTO car VALUES(?,?,?,?,?,?)";
		template.update(sql, car.getCid(),car.getCname(),car.getCprice(),car.getCcate(),
				car.getCdesc(),car.getCfilename());
	}

	@Override
	public void deleteCar(String carId) {
		String sql = "DELETE FROM car WHERE cid = ?";
		template.update(sql, carId);
		
	}
}
