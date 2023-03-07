package com.car.controller;

public interface CartService {
	Cart create(Cart cart);
	Cart read(String cartId);
}
