package com.spring.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	BookRepository bookRepository;

	@Override
	public String create(Map<String, Object> map) {
		int affectRowCount = bookRepository.insert(map);
		if(affectRowCount == 1) {
				return map.get("bookid").toString();
			}
		return null;
	}

	@Override
	public Map<String, Object> detail(Map<String, Object> map) {
		return bookRepository.selectDetail(map);
	}

	@Override
	public boolean update(Map<String, Object> map) {
		return bookRepository.update(map) == 1? true : false;
	}

	@Override
	public List<Map<String, Object>> list(Map<String,Object> map) {
		return bookRepository.selectAll(map);
	}

	@Override
	public boolean remove(Map<String, Object> map) {
		return bookRepository.delete(map);
	}
	
}


