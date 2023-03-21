package com.carshop.controller;

import java.lang.ProcessBuilder.Redirect;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.carshop.domain.User;
import com.carshop.service.UserService;

@Controller
public class MemberController {

	private UserService userService;
	
	public MemberController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/join")
	public String joinView() {return "join";}
	
	@PostMapping("/join")	
	public String join(@ModelAttribute User user) {		
		if(userService.join(user)) {
			return "redirect:/login";
		}
		return "redirect:/join";
	}
	
	@GetMapping("/login")
	public String login() {return "login";}
	
	@GetMapping("/loginFailed")
	public String logoutFailed() {return "login";}
	


}
