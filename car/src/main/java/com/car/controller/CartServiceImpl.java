package com.car.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartRepository {

	@Autowired
	private CartRepository cartRepository;
	
	@Override
	public Cart create(Cart cart) {
		return cartRepository.create(cart);
	}

	@Override
	public Cart read(String cartId) {
		return cartRepository.read(cartId);
	}

}
