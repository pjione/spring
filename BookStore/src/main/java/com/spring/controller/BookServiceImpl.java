package com.spring.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	BookRepository bookrepository;

	@Override
	public String create(Map<String, Object> map) {
		int affectRowCount = bookrepository.insert(map);
		if(affectRowCount == 1) {
				return map.get("bookid").toString();
			}
		return null;
	}
	
}


