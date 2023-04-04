package com.carshop.controller.service;

import java.util.List;

import com.carshop.domain.Board;

public interface BoardService {
	boolean setNewBoard(Board board);
	List<Board> boardList();
	Board boardView(String bid);
}
