package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/members")
@Controller
public class MemberController {

	@GetMapping("/join")
	public String joinForm() {
		return "member/join";
	}
}
