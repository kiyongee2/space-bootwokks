package com.springboot.controller.param;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.controller.HomeController;
import com.springboot.dto.User;

@Controller
public class Ex03Controller {

	//로그인 페이지 요청
	@GetMapping("/userForm")
	public String formPage() {
		return "pages/userForm";
	}
	
	@PostMapping("/login")
	public String resultPage(@ModelAttribute User user,
			Model model) {
		System.out.println("user: " + user);
		model.addAttribute("data1", "@ModelAttribute 예제 - 결과 페이지");
		model.addAttribute("data2",
			"id: " + user.getId() + "<br>pw: " + user.getPw());
		return "pages/viewPage03";
	}
	
	//문자열 보내기 - json 데이터 전달
	//@Controller 에서 문자 반환은 @ResponseBody 사용함
	@GetMapping("/exJson")
	public @ResponseBody User httpGet() {
		User user = User.builder()
				.id("today")
				.pw("12345")
				.build();
		return user;
	}
}






