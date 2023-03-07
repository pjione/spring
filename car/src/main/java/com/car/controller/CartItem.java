package com.car.controller;

public class CartItem {
	private CarDTO car;
	private int quantity;
	private int totalPrice;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((car == null) ? 0 : car.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartItem other = (CartItem) obj;
		if (car == null) {
			if (other.car != null)
				return false;
		} else if (!car.equals(other.car))
			return false;
		return true;
	}
	
	public void updateTotalPrice() {
		totalPrice = car.getCprice() * quantity;
	}
	
	public CartItem() {
		super();
	}
	public CartItem(CarDTO car, int quantity, int totalPrice) {
		super();
		this.car = car;
		this.quantity = quantity;
		this.totalPrice = car.getCprice();
	}
	public CarDTO getCar() {
		return car;
	}
	public void setCar(CarDTO car) {
		this.car = car;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
}
