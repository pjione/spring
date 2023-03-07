package com.car.controller;

public interface CartRepository {
	Cart create(Cart cart);
	Cart read(String cartId);
}
