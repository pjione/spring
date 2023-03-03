package com.car.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {
	@GetMapping("/manager")
	public String manager(Model model) {
		model.addAttribute("data","manager");
		return "test";
	}
	@GetMapping("/guest")
	public String guest(Model model) {
		model.addAttribute("data","guest");
		return "test";
	}
	@GetMapping("/member")
	public String member(Model model) {
		model.addAttribute("data","member");
		return "test";
	}
}
