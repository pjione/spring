package com.spring.controller;

import java.util.List;
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

	@Override
	public Map<String, Object> selectDetail(Map<String, Object> map) {
		return sqlSessionTemplate.selectOne("book.select_detail", map);
	}

	@Override
	public int update(Map<String, Object> map) {
		return sqlSessionTemplate.update("book.update", map);
	}

	@Override
	public List<Map<String, Object>> selectAll(Map<String,Object> map) {
		return sqlSessionTemplate.selectList("book.select_all", map);
	}

	@Override
	public boolean delete(Map<String, Object> map) {
		return sqlSessionTemplate.delete("book.delete", map) == 1 ? true : false;
	}
}
