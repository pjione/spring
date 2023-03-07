package com.car.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class CartRepositoryImpl implements CartRepository {
	
	private Map<String, Cart> listOfCarts;
	
	public CartRepositoryImpl() {
		listOfCarts = new HashMap<String, Cart>();
	}
	
	@Override
	public Cart create(Cart cart) {
		if(listOfCarts.keySet().contains(cart.getCartId())) {
			throw new IllegalArgumentException(String.format("장바구니를 생성할 수 없습니다."));
		}
		listOfCarts.put(cart.getCartId(), cart);
		
		return cart;
	}

	@Override
	public Cart read(String cartId) {
		
		return listOfCarts.get(cartId);
	}

}
