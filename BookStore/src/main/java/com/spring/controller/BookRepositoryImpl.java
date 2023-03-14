package com.spring.controller;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepositoryImpl implements BookRepository {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	@Override
	public int insert(Map<String, Object> map) {
		return sqlSessionTemplate.insert("book.insert",map);
	}

}
