package com.spring.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
	@GetMapping("/create")
	public String create() {
		return "book/create";
	}
	@PostMapping("/create")
	public String create(@RequestParam Map<String, Object> map) {
		bookService.create(map);
		return "redirect:/";
	}
}
