package com.car.board;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class BoardRepositoryImpl implements BoardRepository {
	
	private List<BoardDTO> listOfBoards = new ArrayList<BoardDTO>();	
	
	public BoardRepositoryImpl() {
		BoardDTO board1 = new BoardDTO("게시판1", "하하하하", "kim", "2023-02-28");
		BoardDTO board2 = new BoardDTO("게시판2", "하하하하하", "kim2", "2023-02-28");
		BoardDTO board3 = new BoardDTO("게시판3", "하하하하하하", "kim3", "2023-02-28");
		BoardDTO board4 = new BoardDTO("게시판4", "하하하하하하하하", "kim4", "2023-02-27");
		
		listOfBoards.add(board1);
		listOfBoards.add(board2);
		listOfBoards.add(board3);
		listOfBoards.add(board4);
	}

	@Override
	public List<BoardDTO> getAllBoardList() {
		return listOfBoards;
	}

}
