package com.car.study;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/study")
public class ImageController {
	
	@GetMapping("/form")
	public String requestForm() {
		return "/study/imageexam";
	}
	@PostMapping("/form")
	public String submitForm(@RequestParam("name") String name, @RequestParam("fileImage") MultipartFile fileImage) {
		
		String filename = fileImage.getOriginalFilename();
		File f = new File("/resources/images/" + name + "_" + filename);
		
		try {
			fileImage.transferTo(f);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "/study/imagesuccess";
	}
	

}
