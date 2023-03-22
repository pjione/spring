package com.carshop.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@PostMapping("/kakao")
	public String loginCheckKakao(HttpServletRequest req, @RequestParam Map<String, Object> auth) {
		System.out.println("1");
		String email = (String)auth.get("email");
		System.out.println("2");
		User user = this.userService.existUsername(email);
		System.out.println("3");
		if (user != null) {
			System.out.println("디비에 회원정보 있음 즉 이미 회원임");
			//디비에 있는 사용자이므로 로그인 세션처리
			//독자적인 처리가 아니라 스프링 시큐리티 규격에 맞게 세션처리
			List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
			list.add(new SimpleGrantedAuthority("ROLE_USER"));
			
			SecurityContext sc = SecurityContextHolder.getContext();
			
			sc.setAuthentication(new UsernamePasswordAuthenticationToken(user, null, list));
			// user 회원정보 객체, null 패스워드 , list 권한 설정
			
			HttpSession session = req.getSession(true);
			
			session.setAttribute(
					HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, sc);
			
			return "/login";
		} else {
			System.out.println("디비에 회원정보 없음 즉 회원이 아님");
			return "";
		}
		
		

	}
	
	
	@GetMapping("/joinkakao")
	public String joinkakaoForm(User user) {
		return "/joinkakao";
	}
	
	@PostMapping("/joinkakao")
	public String submitkakaoForm(User user) {
		if(userService.join(user)) {
			return "redirect:/login";
		}
		return "redirect:/join";
	}
	
	

}
