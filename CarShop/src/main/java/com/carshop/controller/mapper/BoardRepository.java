package com.carshop.controller.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.carshop.domain.Board;


public interface BoardRepository {
	int insertBoard(Board board);
	List<Board> selectBoardAll();
	Board selectBoard(@Param("bid") String bid);
}
