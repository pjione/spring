package com.carshop.controller.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.carshop.domain.Board;
import com.carshop.controller.mapper.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {
	
	private BoardRepository boardRepository;
	
	public BoardServiceImpl(BoardRepository boardRepository) {
		this.boardRepository = boardRepository;
	}
	
	
	@Override
	public boolean setNewBoard(Board board) {
		return boardRepository.insertBoard(board) == 1? true : false;
	}


	@Override
	public List<Board> boardList() {
		return boardRepository.selectBoardAll();
	}


	@Override
	public Board boardView(String bid) {
		return boardRepository.selectBoard(bid);
	}

}
