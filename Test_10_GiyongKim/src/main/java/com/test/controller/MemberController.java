package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.dto.MemberDTO;

import jakarta.validation.Valid;

@RequestMapping("/members")
@Controller
public class MemberController {

	@GetMapping("/signup")
	public String signUpForm(MemberDTO memberDTO) {
		return "member/signup";
	}
	
	@PostMapping("/signup")
	public String signUp(@Valid MemberDTO memberDTO,
			BindingResult bindingResult) {
		if(bindingResult.hasErrors())
			return "member/signup";
		return "redirect:/";
	}
}
