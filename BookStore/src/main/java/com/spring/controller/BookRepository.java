package com.spring.controller;

import java.util.List;
import java.util.Map;

public interface BookRepository {
	int insert(Map<String, Object> map);
	Map<String,Object> selectDetail(Map<String,Object> map);
	int update(Map<String, Object> map);
	List<Map<String,Object>> selectAll(Map<String,Object> map);
	boolean delete(Map<String, Object> map);
	
}
