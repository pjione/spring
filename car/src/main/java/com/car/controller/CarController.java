package com.car.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CarController {
	@Autowired
	private CarService carService;
	
	@Autowired
	private HttpServletRequest request;
	
	@RequestMapping("/cars")
	public void CarList(Model model) {
		List<CarDTO> list = carService.getAllCarList();
		model.addAttribute("carList",list);

	}
	@GetMapping("/cars/view")
	public String requestCarsByCategory(@RequestParam String ccate, Model model) {
		List<CarDTO> carsByCategory = carService.getAllCarListByCategory(ccate);
		model.addAttribute("carList", carsByCategory);
		return "cars";
	}
	@GetMapping("/car")
	public void carInfo(Model model, @RequestParam("id") String carId) {
		CarDTO carInfo = carService.getCarByIdService(carId);
		model.addAttribute("car",carInfo);
	}
	@GetMapping("/add")
	public String requestAddCarForm() {return "addCar";}
	
	@PostMapping("/add")
	public String submitAddNewCar(@ModelAttribute("carss") CarDTO car) {
		
		MultipartFile carimage = car.getFile();
		
		String saveName = carimage.getOriginalFilename();
		
		String realPath = request.getSession().getServletContext().getRealPath("/resources/img");
		
		File saveFile = new File(realPath, saveName);
		
		if(carimage != null && !carimage.isEmpty()) {
			try {
				carimage.transferTo(saveFile);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
		carService.setNewCar(car);
		
		return "redirect:/cars";
	}
	@ModelAttribute
	public void addAttributes(Model model) {
		model.addAttribute("addTitle", "신규 차량 등록");
	}
	@GetMapping("/login")
	public String login() {return "login";}
	
	@GetMapping("/loginFailed")
	public String logoutFailed() {return "login";}
	
	
	
	
	
}
