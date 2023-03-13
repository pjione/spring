package com.car.domain;

public interface OrderService {
	void confirmOrder(String cid, long quantity);
	Long saveOrder(Order order);
}
	