package com.carshop.controller.service;

import com.carshop.domain.User;

public interface UserService {
	boolean join(User user);

	User existUsername(String email);
	
}
