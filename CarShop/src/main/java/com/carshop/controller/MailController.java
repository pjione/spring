package com.carshop.controller;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.carshop.controller.service.MailService;


@RequestMapping("/mail")
@EnableAsync
@Controller
public class MailController {

	@Autowired
	private MailService mailService;
	
	@RequestMapping(value = "/sendmail", method = RequestMethod.GET)
	public void sendMail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		mailService.sendMail("austiny@snu.ac.kr", "subject", "body");
		out.println("메일 전송 완료");
	}
	@GetMapping("/form")
	public String mailForm() {
		return "mailForm";
	}
	@PostMapping("/form")
	public String mailForm(@RequestParam Map<String,Object> map) {
		String to = (String) map.get("to");
		String subject = (String) map.get("subject");
		String body = (String) map.get("body");
		
		mailService.sendMail(to, subject, body);
		
		return "redirect:/";
	}
}

	
	
	
	
	