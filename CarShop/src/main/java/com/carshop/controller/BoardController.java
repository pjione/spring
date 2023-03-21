package com.carshop.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.carshop.domain.Board;
import com.carshop.service.BoardService;

@Controller
@RequestMapping(value = "/boards")
public class BoardController {

	private BoardService boardService;
	
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@GetMapping("/list")
	public String boardList(Model model) {
		List<Board> list = boardService.boardList();
		model.addAttribute("boardList", list);
		return "list";
	}
	@GetMapping("/view")
	public String boardView(@RequestParam("bid") String bid, Model model) {
		
		Board board = boardService.boardView(bid);
		
		model.addAttribute("board", board);
		
		return "view";
	}
	@GetMapping("/addBoard")
	public String requestAddBoardForm() {
		return "addBoard";
	}
	@PostMapping("/addBoard")
	public String submitAddBoardForm(Board board) {
		if(boardService.setNewBoard(board)) {
			return "redirect:/boards/list";
		}
		
		return "redirect:/boards/addBoard";
		
		
	}
	
}
