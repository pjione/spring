package com.car.study;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/study")
public class VariableController {
	
	@GetMapping("/exam1")
	public String exam1(@RequestParam String id, Model model) {
		
		model.addAttribute("data", "자동차 아이디 : " + id);
		return "/study/name";
	}
	
	@GetMapping("/name/{name}")
	public String namesMethod(Model model, @PathVariable("name") String name) {
		model.addAttribute("data", "성명 : " + name);
		return "/study/name";
	}
	
	@GetMapping("/name/{name}/{gender}")
	public String namesMethod2(Model model, @PathVariable("name") String name, @PathVariable("gender") String gender) {
		model.addAttribute("data", "성명 : " + name + "<br>성별 : " + gender);
		return "/study/name";
	}
	
	@GetMapping("/name/car/{carId}")
	public String namesMethod3(Model model,@PathVariable String carId,@MatrixVariable String cate) {
		model.addAttribute("data", "차번호 : " + carId + "<br>차종 : " + cate);
		return "/study/name";
	}
	
}
