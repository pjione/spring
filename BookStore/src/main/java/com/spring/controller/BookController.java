package com.spring.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping("/")
	public String main() {
		return "index";
	}
	@GetMapping("/list")
	public String list(@RequestParam Map<String, Object> map, Model model) {
		List<Map<String, Object>> list = bookService.list(map);
		model.addAttribute("list",list);
		return "book/list";
	}
	@GetMapping("/detail")
	public String detail(@RequestParam Map<String, Object> map, Model model) {
		Map<String, Object> detailMap = bookService.detail(map);
		model.addAttribute("book", detailMap);
		
		return "book/detail";
	}
	@GetMapping("/create")
	public String create() {
		return "book/create";
	}
	@PostMapping("/create")
	public String create(@RequestParam Map<String, Object> map) {
		bookService.create(map);
		return "redirect:/";
	}
	@GetMapping("/update")
	public String update(@RequestParam Map<String, Object> map, Model model) {
		Map<String, Object> detailMap = bookService.detail(map);
		model.addAttribute("book", detailMap);
		return "book/update";
	}
	@PostMapping("/update")
	public String update(@RequestParam Map<String, Object> map) {
		if(bookService.update(map)) {
			return "redirect:/detail?bookid=" + map.get("bookid").toString();
		}
		return "redirect:/update?bookid=" + map.get("bookid").toString();
	}
	@PostMapping("/remove")
	public String remove(@RequestParam Map<String, Object> map) {
		if(bookService.remove(map)) {
			return "redirect:/list";
		}
		return "redirect:/detail?bookid=" + map.get("bookid").toString();
	}
}
