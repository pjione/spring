package com.carshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.carshop.domain.User;
import com.carshop.mapper.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder pwEncoder;
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	

	@Override
	public boolean join(User user) {
		
		
		user.setPassword(pwEncoder.encode(user.getPassword()));
		return (userRepository.join(user) == 1) && userRepository.insertAuth(user.getUsername()) == 1
				? true : false;
	}


	@Override
	public User existUsername(String email) {
		return userRepository.existUsername(email);
	}


	
}
